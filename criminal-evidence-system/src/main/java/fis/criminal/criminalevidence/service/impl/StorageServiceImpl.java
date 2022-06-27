package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.Storage;
import fis.criminal.criminalevidence.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public Storage create(Storage entity) {
        return null;
    }

    @Override
    public Storage update(Storage entity) {
        return null;
    }

    @Override
    public void delete(Storage entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Storage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Storage> findAll() {
        return null;
    }
}
