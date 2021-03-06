package fis.criminal.criminalevidence.repository;

import fis.criminal.criminalevidence.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriminalCaseRepo extends JpaRepository<CriminalCase, Long> {
}
