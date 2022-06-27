package fis.criminal.criminalevidence.service;

import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.model.enums.CaseStatus;
import fis.criminal.criminalevidence.model.enums.CaseType;

import java.util.List;

public interface CriminalCaseService extends AbstractService<CriminalCase> {
    List<CriminalCase> findByStatus(CaseStatus status);

    List<CriminalCase> findByType(CaseType type);
}
