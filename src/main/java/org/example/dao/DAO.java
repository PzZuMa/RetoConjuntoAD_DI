package org.example.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {

    ArrayList<T> findAll();
    T findByID(Integer id);
    void insert(T t);
    void deleteByID(Integer id);

}
