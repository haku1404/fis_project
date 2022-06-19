package criminal.dao.memory;

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
    public CriminalCase getById(long id) {
        return null;
    }

    @Override
    public List<CriminalCase> getAll() {
        return listCriminalCase;
    }

    @Override
    public void update(CriminalCase criminalCase) {

    }

    @Override
    public ArrayList<CriminalCase> search(int version) {
        return null;
    }
}
