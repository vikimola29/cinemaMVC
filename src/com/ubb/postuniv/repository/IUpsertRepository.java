package com.ubb.postuniv.repository;
import com.ubb.postuniv.domain.Entity;

import java.util.List;

public interface IUpsertRepository<T extends Entity>{
    void upsert(T entity);

    List<T> readAll();
    T read(int id);

    void delete(int id) throws Exception;
}
