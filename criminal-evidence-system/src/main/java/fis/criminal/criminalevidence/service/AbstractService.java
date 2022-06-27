package fis.criminal.criminalevidence.service;

import java.util.List;
import java.util.Optional;

public interface AbstractService<T> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    Optional<T> findById(Long id);

    List<T> findAll();
}
