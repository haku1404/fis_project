package fis.criminal.criminalevidence.repository;

import fis.criminal.criminalevidence.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Long> {
}
