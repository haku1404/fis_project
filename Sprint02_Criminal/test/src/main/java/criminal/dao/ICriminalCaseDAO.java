package criminal.dao;

import criminal.model.CriminalCase;

public interface ICriminalCaseDAO extends IDAO<CriminalCase> {
    public void delete(long id);
}
