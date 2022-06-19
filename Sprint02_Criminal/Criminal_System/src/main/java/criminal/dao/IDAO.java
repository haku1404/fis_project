package criminal.dao;

import criminal.model.CriminalCase;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    //CREATE
    void save(T t);

    //READ | RETRIEVE
    T getById(long id);

    List<T> getAll();

    //UPDATE
    void update(T t);

    //DELETE
    void delete(long id);
}
