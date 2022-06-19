package criminal.repository;


import criminal.core.CaseStatus;
import criminal.core.CaseType;
import criminal.model.CriminalCase;
import criminal.model.Detective;

import java.util.Optional;
import java.util.Set;

public interface CriminalCaseRepo extends  AbstractRepo<CriminalCase>  {
    Set<CriminalCase> findByLeadInvestigator(Detective detective);
    Optional<CriminalCase> findByNumber(String caseNumber);
    Set<CriminalCase> findByStatus(CaseStatus status);
    Set<CriminalCase> findByType(CaseType type);
}
