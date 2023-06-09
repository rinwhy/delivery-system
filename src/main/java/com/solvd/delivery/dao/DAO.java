package com.solvd.delivery.dao;

import java.util.List;

public interface DAO<T> {

    T getByID(int id);

    List<T> getAll();

    void insert(T t);

    void update(T t, int id);

    void deleteByID(int id);
}
