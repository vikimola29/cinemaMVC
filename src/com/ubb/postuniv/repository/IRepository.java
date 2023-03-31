package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {
    public void create(T entity) throws Exception;

    public List<T> readAll();

    T read(int id);

    public void update(T entity) throws Exception;

    public void delete(int id) throws Exception;
}
