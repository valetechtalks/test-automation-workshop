package io.github.valetechtalks.giftgiver.repositories;

import javax.persistence.criteria.Expression;
import java.util.List;

public interface IRepository {
    public <T> T find(int id);

    public <T> T findBy(String field, Object value);

    public <T> T findBy(String field, Object value, String orderBy, String direction);

    public <T> List<T> findAll();

    public <T> List<T> findAllBy(String field, Object value, String orderBy, String direction);
}
