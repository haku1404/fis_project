package criminal.dao.memory;

import criminal.dao.IDetectiveDAO;
import criminal.model.Detective;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDAO implements IDetectiveDAO {

    List<Detective> listDetective = new ArrayList<>();

    @Override
    public void save(Detective detective) {

    }

    @Override
    public Detective getById(long id) {
        return null;
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public void update(Detective detective) {

    }

    @Override
    public void delete(Detective detective) {

    }
}
