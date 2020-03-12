package io.github.valetechtalks.giftgiver.repositories;

import io.github.valetechtalks.giftgiver.services.DatabaseSession;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class Repository {
    private DatabaseSession db;

    public Repository(DatabaseSession db) {
        this.db = db;
    }

    protected <T> T find(Class<T> type, int id) {
        return this.getSession().find(type, id);
    }

    protected <T> T findBy(Class<T> type, String field, Long value) {
        CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        Root<T> root = criteria.from(type);
        criteria.where(builder.equal(root.get(field), value));
        T data = this.getSession().createQuery(criteria).uniqueResult();
        return data;
    }

    protected <T> List<T> findAll(Class<T> type) {
        CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = this.getSession().createQuery(criteria).getResultList();
        return data;
    }

    public void save(Object object) {
        this.getSession().save(object);
    }

    private Session getSession() {
        return this.db.getSession();
    }
}
