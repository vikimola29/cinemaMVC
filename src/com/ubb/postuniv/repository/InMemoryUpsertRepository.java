package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUpsertRepository<T extends Entity> implements IUpsertRepository<T>{

    Map<Integer, T> storage;

    public InMemoryUpsertRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public void upsert(T entity) {
        this.storage.put(entity.getId(), entity);
    }

    @Override
    public List readAll() {
        return new ArrayList<T>(this.storage.values());
    }

    @Override
    public T read(int id) {
        return storage.get(id);
    }

    @Override
    public void delete(int id) {
        if (!this.storage.containsKey(id)){
            throw new RuntimeException("Entity doesn't exist :(");
        }
        this.storage.remove(id);
    }
}
