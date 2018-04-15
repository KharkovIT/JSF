package dao;

import java.util.List;

public interface GenericDAO<T> {

    void update(T entity);

    T findById(int id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
