package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.exception.InvalidException;
import fis.criminal.criminalevidence.model.Evidence;
import fis.criminal.criminalevidence.repository.EvidenceRepo;
import fis.criminal.criminalevidence.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepo evidenceRepo;

    public EvidenceServiceImpl(EvidenceRepo evidenceRepo) {
        this.evidenceRepo = evidenceRepo;
    }

    @Override
    public Evidence create(Evidence evidence) {
        if (evidence == null) throw new InvalidException("Please Insert All Evidence's Information!");
        if (checkDuplicated(evidence.getId())) throw new InvalidException("Duplicated Evidence!");
        return evidenceRepo.save(evidence);
    }

    public boolean checkDuplicated(Long id) {
        List<Evidence> evidenceList = evidenceRepo.findAll();
        for (Evidence evidence : evidenceList) {
            if (evidence.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Evidence update(Evidence evidence) {
        if(evidence == null) throw new InvalidException("Evidence Not Found!!!");
        return evidenceRepo.save(evidence);
    }

    @Override
    public void delete(Evidence evidence) {
        if(evidence == null) throw new InvalidException("Evidence Not Found!!!");
        evidenceRepo.delete(evidence);
    }

    @Override
    public void deleteById(Long id) {
        Evidence evidence = evidenceRepo.findById(id).get();
        if(evidence == null) throw new InvalidException("Evidence Not Found!");
        evidenceRepo.deleteById(id);
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        return evidenceRepo.findById(id);
    }

    @Override
    public List<Evidence> findAll() {
        return evidenceRepo.findAll();
    }
}
