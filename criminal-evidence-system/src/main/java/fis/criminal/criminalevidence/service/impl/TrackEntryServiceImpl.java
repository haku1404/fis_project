package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.TrackEntry;
import fis.criminal.criminalevidence.service.TrackEntryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackEntryServiceImpl implements TrackEntryService {
    @Override
    public TrackEntry create(TrackEntry entity) {
        return null;
    }

    @Override
    public TrackEntry update(TrackEntry entity) {
        return null;
    }

    @Override
    public void delete(TrackEntry entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<TrackEntry> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TrackEntry> findAll() {
        return null;
    }
}
