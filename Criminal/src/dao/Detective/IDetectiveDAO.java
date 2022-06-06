package dao.Detective;

import core.model.Detective;

import java.util.ArrayList;
import java.util.List;

public interface IDetectiveDAO {
    //Create Functions C
    public void add(Detective detective) throws Exception;

    //Retrieve Functions R
    public Detective findById(long id) throws Exception;
    public ArrayList<Detective> getAll();

    //Update Functions U
    public Detective update(Detective detective) throws Exception;

    //Delete Functions D
    public void remove(long id) throws Exception;

    //Other Functions
}
