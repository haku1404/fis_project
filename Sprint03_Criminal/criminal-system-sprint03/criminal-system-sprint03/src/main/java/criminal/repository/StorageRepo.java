package criminal.repository;

import criminal.model.entity.Storage;

import java.util.Optional;

public interface StorageRepo extends AbstractRepo<Storage> {

    Optional<Storage> findByName(String name);

    Optional<Storage> findByLocation(String location);
}
