package criminal.dao.mem;

import criminal.dao.ICriminalCaseDAO;
import criminal.model.CriminalCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CriminalCaseDAO implements ICriminalCaseDAO {

    List<CriminalCase> listCriminalCase = new ArrayList<>();

    @Override
    public void delete(long id) {

    }

    @Override
    public void save(CriminalCase criminalCase) {
        listCriminalCase.add(criminalCase);
    }

    @Override
    public Optional<CriminalCase> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<CriminalCase> getAll() {
        return listCriminalCase;
    }

    @Override
    public void update(CriminalCase criminalCase) {

    }

    @Override
    public void delete(CriminalCase criminalCase) {

    }
}
