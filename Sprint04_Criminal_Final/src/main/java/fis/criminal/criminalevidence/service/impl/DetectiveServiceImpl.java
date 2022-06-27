package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.service.DetectiveService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Override
    public Detective create(Detective entity) {
        return null;
    }

    @Override
    public Detective update(Detective entity) {
        return null;
    }

    @Override
    public void delete(Detective entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Detective> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Detective> findAll() {
        return null;
    }
}
