package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements IRepository<T>{

    private Map<Integer, T> storage;

    public InMemoryRepository() {

        this.storage = new HashMap<>();
    }


    @Override
    public void create(T entity) throws Exception {
        if (this.storage.containsKey(entity.getId())){
            throw new Exception("Entity already exists :(");
        }
        this.storage.put(entity.getId(), entity);
    }

    @Override
    public List readAll() {
        return new ArrayList<>(this.storage.values());
    }

    @Override
    public T read(int id) {
        return this.storage.get(id);
    }

    @Override
    public void update(T entity) throws Exception{
        if(!this.storage.containsKey(entity.getId())){
            throw new Exception("Entity doesnt exist :(");
        }
        this.storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) throws Exception{
    if (!this.storage.containsKey(id)){
        throw new Exception("Entity doesnt exist :(");
    }
    this.storage.remove(id);
    }
}
