package io.github.valetechtalks.giftgiver.services;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

public class DatabaseSession {
    private Session session;
    private Transaction transaction;

    public void open() {
        this.configureSession();
    }

    public void close() {
        if(session != null) {
            this.session.close();
        }
    }

    public <T> T find(Class<T> type, int id) {
        return this.session.find(type, id);
    }

    public <T> T findBy(Class<T> type, String field, Long value) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        Root<T> root = criteria.from(type);
        criteria.where(builder.equal(root.get(field), value));
        T data = this.session.createQuery(criteria).uniqueResult();
        return data;
    }

    public <T> List<T> findAll(Class<T> type) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = this.session.createQuery(criteria).getResultList();
        return data;
    }

    public void save(Object object) {
        this.session.save(object);
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

    private void configureSession() throws HibernateException {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(Attendee.class);
        conf.configure();

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sessionFactory = conf.buildSessionFactory(registry);
        this.session = sessionFactory.openSession();
    }
}
