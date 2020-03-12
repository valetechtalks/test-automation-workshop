package io.github.valetechtalks.giftgiver.controllers.controllers;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.services.MeetupConsumer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RefreshController {
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/refresh")
    public void Index() {
        Session session = configureSession();
        Transaction transaction = session.beginTransaction();

        JSONArray results = new MeetupConsumer().getRSVPs();

        try {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                JSONObject member = item.getJSONObject("member");

                Attendee attendee = new Attendee();
                attendee.setVendorUserId(member.getLong("id"));
                attendee.setName(member.getString("name"));
                attendee.setAwarded(false);

                session.save(attendee);
            }

            session.flush();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            transaction.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
    }

    private Session configureSession() throws HibernateException {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(Attendee.class);
        conf.configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sessionFactory = conf.buildSessionFactory(registry);

        Session session = sessionFactory.openSession();
        return session;
    }
}
