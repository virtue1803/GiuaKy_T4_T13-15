package org.spring.testspring.services;

import java.util.List;
import java.util.Optional;

public interface IServices<T, ID>{
    boolean save(T entity);
    boolean delete(T entity);
    boolean deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}
