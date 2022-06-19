package criminal.repository;


import criminal.model.CriminalCase;
import criminal.model.Evidence;
import criminal.model.Storage;

import java.util.Optional;
import java.util.Set;

public interface EvidenceRepo extends AbstractRepo<Evidence> {
    Set<Evidence> findByCriminalCase(CriminalCase criminalCase);
    Optional<Evidence> findByNumber(String evidenceNumber);
    boolean isInStorage(Storage storage);
}
