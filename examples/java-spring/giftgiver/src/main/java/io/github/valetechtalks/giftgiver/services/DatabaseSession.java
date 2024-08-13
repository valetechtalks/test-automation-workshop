package io.github.valetechtalks.giftgiver.services;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabaseSession {
    private Session session;
    private Transaction transaction;

    public void open() {
        this.configureSession();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        if(session != null) {
            this.session.close();
        }
    }

    private void configureSession() throws HibernateException {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(Attendee.class);
        conf.configure();

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sessionFactory = conf.buildSessionFactory(registry);
        this.session = sessionFactory.openSession();
    }

    public void beginTransaction() {
        this.transaction = this.session.beginTransaction();
    }

    public void commitTransaction() {
        this.session.flush();
        this.transaction.commit();
    }

    public void rollbackTransaction() {
        this.transaction.rollback();
    }
}
