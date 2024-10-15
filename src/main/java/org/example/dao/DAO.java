package org.example.dao;

import java.util.ArrayList;

/**
 * Interfaz que define los métodos que deben implementar las clases DAO
 * @param <T> Tipo de objeto que manejará la clase DAO
 */
public interface DAO<T> {

    ArrayList<T> findAll();
    T findByID(Integer id);
    void insert(T t);
    void deleteByID(Integer id);

}
