package criminal.dao.memory;

import criminal.dao.IEvidenceDAO;
import criminal.model.Evidence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvidenceDAO implements IEvidenceDAO {
    List<Evidence> listEvidence = new ArrayList<>();

    @Override
    public void save(Evidence evidence) {

    }

    @Override
    public Evidence getById(long id) {
        return null;
    }

    @Override
    public List<Evidence> getAll() {
        return null;
    }

    @Override
    public void update(Evidence evidence) {

    }

    @Override
    public void delete(Evidence evidence) {

    }
}
