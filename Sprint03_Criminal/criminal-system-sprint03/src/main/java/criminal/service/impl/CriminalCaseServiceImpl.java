package criminal.service.impl;

import criminal.model.entity.CriminalCase;
import criminal.repository.CriminalCaseRepo;
import criminal.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class CriminalCaseServiceImpl implements CriminalCaseService {

    @Autowired
    CriminalCaseRepo criminalCaseRepo;

    @Override
    public CriminalCase save(CriminalCase criminalCase) {
        criminalCaseRepo.save(criminalCase);
        return criminalCase;
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCaseList = new ArrayList<>();
        criminalCaseRepo.findAll().forEach(criminalCase -> criminalCaseList.add(criminalCase));
        return criminalCaseList;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        criminalCaseRepo.save(criminalCase);
        return criminalCase;
    }

    @Override
    public void deleteById(Long id) {
        criminalCaseRepo.deleteById(id);
    }

    @Override
    public CriminalCase findById(Long id) {
        return criminalCaseRepo.findById(id).get();
    }

    @Override
    public CriminalCase findByNumber(String number) {
        Optional<CriminalCase> criminalCase = criminalCaseRepo.findAll().stream()
                .filter(criminalCase1 -> criminalCase1.getNumber().equals(number)).findFirst();
        return criminalCase.get();
    }
}
