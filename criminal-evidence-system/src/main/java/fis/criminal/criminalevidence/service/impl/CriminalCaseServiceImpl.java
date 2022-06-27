package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.service.CriminalCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
    @Override
    public CriminalCase create(CriminalCase entity) {
        return null;
    }

    @Override
    public CriminalCase update(CriminalCase entity) {
        return null;
    }

    @Override
    public void delete(CriminalCase entity) {

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
