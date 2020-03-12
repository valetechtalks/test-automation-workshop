package io.github.valetechtalks.giftgiver.repositories;

import java.util.List;

public interface IRepository {
    public <T> T find(int id);

    public <T> T findBy(String field, Long value);

    public <T> List<T> findAll();
}
