package fis.criminal.criminalevidence.service;

import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.enums.EmploymentStatus;

import java.util.List;

public interface DetectiveService extends AbstractService<Detective> {
    List<Detective> findByStatus(EmploymentStatus status);
    List<Detective> findByBadge(String badge);
    Detective addCriminalCase(Long detectiveId, Long criminalCaseId);
    Detective removeCriminalCase(Long detectiveId, Long criminalCaseId);
}
