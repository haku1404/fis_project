package criminal.dao;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    //CREATE
    void save(T t);

    //READ | RETRIEVE
    Optional<T> get(long id);

    List<T> getAll();

    //UPDATE
    void update(T t);

    //DELETE
    void delete(T t);
}
