package io.github.valetechtalks.giftgiver.repositories;

import io.github.valetechtalks.giftgiver.services.DatabaseSession;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

public abstract class Repository {
    private DatabaseSession db;

    public Repository(DatabaseSession db) {
        this.db = db;
    }

    protected <T> T find(Class<T> type, int id) {
        return this.getSession().find(type, id);
    }

    protected <T> T findBy(Class<T> type, String field, Object value) {
        Query query = this.buildQuery(type, field, value, "createdAt", "asc");
        T data = (T) query.uniqueResult();
        return data;
    }

    protected <T> List<T> findAll(Class<T> type) {
        return this.findAll(type, "createdAt", "asc");
    }

    protected <T> List<T> findAll(Class<T> type, String orderBy, String direction) {
        Query query = this.buildQuery(type, null, null, orderBy, direction);
        List<T> data = query.getResultList();
        return data;
    }

    public void save(Object object) {
        this.getSession().save(object);
    }

    private <T> Query buildQuery(Class<T> type, String field, Object value, String orderBy, String direction) {
        CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        Root<T> root = criteria.from(type);

        if (field != null) {
            criteria.where(builder.equal(root.get(field), value));
        }

        if (direction == "desc") {
            criteria.orderBy(builder.desc(root.get(orderBy)));
        } else {
            criteria.orderBy(builder.asc(root.get(orderBy)));
        }

        return this.getSession().createQuery(criteria);
    }

    private Session getSession() {
        return this.db.getSession();
    }
}
