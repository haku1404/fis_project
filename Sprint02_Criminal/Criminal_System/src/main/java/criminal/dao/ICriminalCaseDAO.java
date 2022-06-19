package criminal.dao;

import criminal.model.CriminalCase;

import java.util.ArrayList;

public interface ICriminalCaseDAO extends IDAO<CriminalCase> {

    public ArrayList<CriminalCase> search(int version);


}
