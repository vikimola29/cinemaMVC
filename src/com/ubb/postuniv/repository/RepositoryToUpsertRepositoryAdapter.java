package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class RepositoryToUpsertRepositoryAdapter<T extends Entity> implements IUpsertRepository<T> {

    private IRepository<T> repository;

    public RepositoryToUpsertRepositoryAdapter(IRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void upsert(T entity) {
        try{
            if (this.repository.read(entity.getId())==null){
                this.repository.create(entity);
            }else{
                this.repository.update(entity);
            }


        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<T> readAll() {
        return this.repository.readAll();
    }

    @Override
    public T read(int id) {
        return this.repository.read(id);
    }

    @Override
    public void delete(int id) throws Exception {
        this.repository.delete(id);
    }
}
