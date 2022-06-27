package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.exception.InvalidException;
import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.enums.CaseStatus;
import fis.criminal.criminalevidence.model.enums.CaseType;
import fis.criminal.criminalevidence.repository.CriminalCaseRepo;
import fis.criminal.criminalevidence.repository.DetectiveRepo;
import fis.criminal.criminalevidence.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
    private final CriminalCaseRepo criminalCaseRepo;

    private final DetectiveRepo detectiveRepo;


    @Autowired
    public CriminalCaseServiceImpl(CriminalCaseRepo criminalCaseRepo, DetectiveRepo detectiveRepo) {
        this.criminalCaseRepo = criminalCaseRepo;
        this.detectiveRepo = detectiveRepo;
    }

    @Override
    public CriminalCase create(CriminalCase criminalCase) {
        if (criminalCase == null) throw new InvalidException("Please Insert All Criminal Case's Information!");
        if (checkDuplicated(criminalCase.getId())) throw new InvalidException("Duplicated Criminal Case!");
        return criminalCaseRepo.save(criminalCase);
    }

    public boolean checkDuplicated(Long id) {
        List<CriminalCase> criminalCaseList = criminalCaseRepo.findAll();
        for (CriminalCase criminalCase : criminalCaseList) {
            if (criminalCase.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        Detective detective = detectiveRepo.findById(criminalCase.getLeadInvestigator().getId()).get();
        if (detective == null) throw new InvalidException("Update Failed! Lead Investigator Is Missing!");

        if (criminalCase.getId() == null) throw new InvalidException("Criminal Case Not Found!");
        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        if (criminalCase == null) throw new InvalidException("Criminal Case Not Found!");
        criminalCaseRepo.delete(criminalCase);
    }

    @Override
    public void deleteById(Long id) {
        CriminalCase criminalCase = criminalCaseRepo.findById(id).get();
        if (criminalCase.getId() == null) throw new InvalidException("Criminal Case Doesn't Exist!");
        criminalCaseRepo.deleteById(id);
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        return criminalCaseRepo.findById(id);
    }

    @Override
    public List<CriminalCase> findAll() {
        return criminalCaseRepo.findAll();
    }

    @Override
    public List<CriminalCase> findByStatus(CaseStatus status) {
        return criminalCaseRepo.findAll().stream()
                .filter(c -> status.equals(c.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CriminalCase> findByType(CaseType type) {
        return criminalCaseRepo.findAll().stream()
                .filter(c -> type.equals(c.getType()))
                .collect(Collectors.toList());
    }
}
