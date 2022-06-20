package criminal.repository;


import java.util.Optional;

public interface AbstractRepo<T> {
    void save(T entity);
    void delete(T entity);
    T update(T entity);
    int deleteById(Long entityId);
    Optional<T> findById(Long entityId);
}
