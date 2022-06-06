package dao.TrackEntry;

import core.model.TrackEntry;

import java.util.ArrayList;

public interface ITrackEntryDAO {

    //Create Functions C
    public void add(TrackEntry trackEntry) throws Exception;

    //Retrieve Functions R
    public TrackEntry findById(long id) throws Exception;
    public ArrayList<TrackEntry> getAll();

    //Update Functions U
    public TrackEntry update(TrackEntry trackEntry) throws Exception;

    //Delete Functions D
    public void remove(long id) throws Exception;
}
