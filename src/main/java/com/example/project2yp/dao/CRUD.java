package com.example.project2yp.dao;

import java.util.List;

public interface CRUD<T> {
    List<T> index();

    T show(int id);

    void save(T entity);

    void update(int id, T entity);

    void delete(int id);

}
