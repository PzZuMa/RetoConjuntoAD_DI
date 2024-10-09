package org.example.dao;

import org.example.models.Copia;

import java.util.List;

public interface DAO<T> {

    public List<T> findAll();
    public List<T> findByID(Integer id);

//    public void searchByID();
//    public void insert();
//    public void update();
//    public void deleteByID();
//    public void deleteAll();
}
