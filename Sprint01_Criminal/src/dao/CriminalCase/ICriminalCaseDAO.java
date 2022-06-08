package dao.CriminalCase;

import core.model.CriminalCase;
import java.util.ArrayList;


public interface ICriminalCaseDAO {
    //Create Functions C
    public void add(CriminalCase criminalCase) throws Exception;

    //Retrieve Functions R
    public CriminalCase findById(long id) throws Exception;
    public ArrayList<CriminalCase> getAll();

    //Update Functions U
    public CriminalCase update(CriminalCase criminalCase) throws Exception;

    //Delete Functions D
    public void remove(long id) throws Exception;
}
