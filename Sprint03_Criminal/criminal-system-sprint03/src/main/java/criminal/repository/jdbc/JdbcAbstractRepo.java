package criminal.repository.jdbc;

import criminal.repository.AbstractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class JdbcAbstractRepo<T> implements AbstractRepo<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public JdbcAbstractRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(T entity) {
    }

    @Override
    public T update(T entity) {

        return entity;
    }


    @Override
    public void delete(T entity) {

    }

    @Override
    public int deleteById(Long entityId) {

        return 0;
    }

    @Override
    public Optional<T> findById(Long entityId) {

        return null;
    }
}
