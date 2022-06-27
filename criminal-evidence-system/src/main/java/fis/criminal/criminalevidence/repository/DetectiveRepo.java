package fis.criminal.criminalevidence.repository;

import fis.criminal.criminalevidence.model.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepo extends JpaRepository<Detective, Long> {
}
