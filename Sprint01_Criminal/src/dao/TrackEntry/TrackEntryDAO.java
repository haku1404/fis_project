package dao.TrackEntry;

import core.model.Detective;
import core.model.TrackEntry;

import javax.sound.midi.Track;
import java.util.ArrayList;

public class TrackEntryDAO implements ITrackEntryDAO {

    ArrayList<TrackEntry> listTrackEntry = new ArrayList<>();
    @Override
    public void add(TrackEntry trackEntry) throws Exception {
        checkExisted(trackEntry);
        listTrackEntry.add(trackEntry);
    }

    private void checkExisted(TrackEntry trackEntry) throws Exception {
        for(TrackEntry trackEntry1 : listTrackEntry){
            if(trackEntry.getId() == trackEntry1.getId()){
                throw new Exception("Track Entry with ID: " +trackEntry.getId()+ "is already existed!");
            }
        }
    }

    @Override
    public TrackEntry findById(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Find!");
        }
        for(int i = 0; i < listTrackEntry.size(); i++ ){
            if(listTrackEntry.get(i).getId() == id){
                return listTrackEntry.get(i);
            }
        }
        throw new Exception("Can't Find Track Entry With ID: " +id);
    }

    private boolean isEmpty(long id) {
        if(String.valueOf(id).length() == 0 ){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<TrackEntry> getAll() {
        return listTrackEntry;
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry) throws Exception {
        findById(trackEntry.getId());
        return update(trackEntry);
    }

    @Override
    public void remove(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Delete!");
        }
        TrackEntry trackEntry = findById(id);
        listTrackEntry.remove(trackEntry);

    }
}
