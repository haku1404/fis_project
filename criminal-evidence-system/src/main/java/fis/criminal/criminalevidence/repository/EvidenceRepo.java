package fis.criminal.criminalevidence.repository;

import fis.criminal.criminalevidence.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepo extends JpaRepository<Evidence, Long> {
}
