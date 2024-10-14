package org.example.dao;

import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {

    ArrayList<T> findAll();
    T findByID(Integer id);
    void insert(T t);
    void update(Integer id);
    void deleteByID(Integer id);

}
