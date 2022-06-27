package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.Evidence;
import fis.criminal.criminalevidence.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    @Override
    public Evidence create(Evidence entity) {
        return null;
    }

    @Override
    public Evidence update(Evidence entity) {
        return null;
    }

    @Override
    public void delete(Evidence entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Evidence> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Evidence> findAll() {
        return null;
    }
}
