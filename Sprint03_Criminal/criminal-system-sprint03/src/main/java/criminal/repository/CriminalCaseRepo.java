package criminal.repository;

import criminal.model.entity.CriminalCase;
import criminal.model.entity.Detective;
import criminal.model.enums.CaseStatus;
import criminal.model.enums.CaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface CriminalCaseRepo extends JpaRepository<CriminalCase, Long> {
    Optional<CriminalCase> findByNumber(String caseNumber);
    Set<CriminalCase> findByStatus(CaseStatus status);
    Set<CriminalCase> findByType(CaseType type);

}
