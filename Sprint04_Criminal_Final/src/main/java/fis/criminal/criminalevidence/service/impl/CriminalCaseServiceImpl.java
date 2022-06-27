package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.repository.CriminalCaseRepo;
import fis.criminal.criminalevidence.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
    private final CriminalCaseRepo criminalCaseRepo;

    @Autowired
    public CriminalCaseServiceImpl(CriminalCaseRepo criminalCaseRepo) {
        this.criminalCaseRepo = criminalCaseRepo;
    }

    @Override
    public CriminalCase create(CriminalCase criminalCase) {
        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        return null;
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        criminalCaseRepo.delete(criminalCase);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CriminalCase> findAll() {
        return null;
    }
}
