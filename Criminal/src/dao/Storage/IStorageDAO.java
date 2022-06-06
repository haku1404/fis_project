package dao.Storage;

import core.model.Storage;

import java.util.ArrayList;

public interface IStorageDAO {
    //Create Functions C
    public void add(Storage storage) throws Exception;

    //Retrieve Functions R
    public Storage findById(long id) throws Exception;
    public ArrayList<Storage> getAll();

    //Update Functions U
    public Storage update(Storage storage) throws Exception;

    //Delete Functions D
    public void remove(long id) throws Exception;
}
