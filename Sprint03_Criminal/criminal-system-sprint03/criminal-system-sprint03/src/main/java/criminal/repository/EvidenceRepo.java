package criminal.repository;

import criminal.model.entity.CriminalCase;
import criminal.model.entity.Evidence;
import criminal.model.entity.Storage;

import java.util.Optional;
import java.util.Set;

public interface EvidenceRepo extends AbstractRepo<Evidence> {
    Set<Evidence> findByCriminalCase(CriminalCase criminalCase);
    Optional<Evidence> findByNumber(String evidenceNumber);
    boolean isInStorage(Storage storage);
}
