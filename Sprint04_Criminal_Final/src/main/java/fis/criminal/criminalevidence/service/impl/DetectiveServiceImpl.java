package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.exception.InvalidException;
import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.enums.EmploymentStatus;
import fis.criminal.criminalevidence.repository.CriminalCaseRepo;
import fis.criminal.criminalevidence.repository.DetectiveRepo;
import fis.criminal.criminalevidence.service.DetectiveService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetectiveServiceImpl implements DetectiveService {

    private final DetectiveRepo detectiveRepo;

    private final CriminalCaseRepo criminalCaseRepo;

    public DetectiveServiceImpl(DetectiveRepo detectiveRepo, CriminalCaseRepo criminalCaseRepo) {
        this.detectiveRepo = detectiveRepo;
        this.criminalCaseRepo = criminalCaseRepo;
    }
    @Override
    public Detective create(Detective detective) {
        if (detective == null) throw new InvalidException("Please Insert All Detective's Information!");
        if (checkDuplicated(detective.getId())) throw new InvalidException("Duplicated Detective!");
        return detectiveRepo.save(detective);
    }

    public boolean checkDuplicated(Long id) {
        List<Detective> detectiveList = detectiveRepo.findAll();
        for (Detective detective : detectiveList) {
            if (detective.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Detective update(Detective detective) {
        if(detective == null) throw new InvalidException("Detective Not Found!!!");
        return detectiveRepo.save(detective);
    }

    @Override
    public void delete(Detective detective) {
        if(detective == null) throw new InvalidException("Detective Not Found!");
        detectiveRepo.delete(detective);

    }

    @Override
    public void deleteById(Long id) {
        Detective detective = detectiveRepo.findById(id).get();
        if(detective == null) throw new InvalidException("Detective Not Found!");
        detectiveRepo.deleteById(id);
    }

    @Override
    public Optional<Detective> findById(Long id) {
        return detectiveRepo.findById(id);
    }

    @Override
    public List<Detective> findAll() {
        return detectiveRepo.findAll();
    }

    @Override
    public List<Detective> findByStatus(EmploymentStatus status) {
        return detectiveRepo.findAll().stream()
                .filter(d -> status.equals(d.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Detective> findByBadge(String badge) {
        return detectiveRepo.findAll().stream()
                .filter(d -> badge.equals(d.getBadgeNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public Detective addCriminalCase(Long detectiveId, Long criminalCaseId) {
        Detective detective = detectiveRepo.findById(detectiveId)
                .orElseThrow(()->new InvalidException("Add Failed! Detective Not Found!"));
        CriminalCase criminalCase = criminalCaseRepo.findById(criminalCaseId)
                .orElseThrow(()->new InvalidException("Add Failed! Criminal Case Not Found!"));
        detective.getCriminalCases().add(criminalCase);
        return detectiveRepo.save(detective);
    }

    @Override
    public Detective removeCriminalCase(Long detectiveId, Long criminalCaseId) {
        Detective detective = detectiveRepo.findById(detectiveId)
                .orElseThrow(()->new InvalidException("Add Failed! Detective Not Found!"));
        CriminalCase criminalCase = criminalCaseRepo.findById(criminalCaseId)
                .orElseThrow(()->new InvalidException("Add Failed! Criminal Case Not Found!"));
        detective.getCriminalCases().remove(criminalCase);
        return detectiveRepo.save(detective);
    }
}
