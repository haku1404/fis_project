package fis.criminal.criminalevidence.repository;

import fis.criminal.criminalevidence.model.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackEntryRepo extends JpaRepository<TrackEntry, Long> {
}
