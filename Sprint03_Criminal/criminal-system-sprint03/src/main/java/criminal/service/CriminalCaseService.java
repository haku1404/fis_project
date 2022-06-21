package criminal.service;

import criminal.model.entity.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    CriminalCase save(CriminalCase criminalCase);

    List<CriminalCase> getAll();

    CriminalCase update(CriminalCase criminalCase);

    void deleteById(Long id);

    CriminalCase findById(Long id);

    CriminalCase findByNumber(String number);
}
