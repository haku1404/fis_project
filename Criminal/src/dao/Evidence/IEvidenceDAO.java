package dao.Evidence;

import core.model.Evidence;

import java.util.ArrayList;

public interface IEvidenceDAO {
    //Create Functions C
    public void add(Evidence evidence) throws Exception;

    //Retrieve Functions R
    public Evidence findById(long id) throws Exception;
    public ArrayList<Evidence> getAll();

    //Update Functions U
    public Evidence update(Evidence evidence) throws Exception;

    //Delete Functions D
    public void remove(long id) throws Exception;
}
