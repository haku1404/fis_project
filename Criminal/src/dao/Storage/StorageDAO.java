package dao.Storage;

import core.model.Detective;
import core.model.Storage;

import java.util.ArrayList;

public class StorageDAO implements IStorageDAO{

    ArrayList<Storage> listStorage = new ArrayList<>();

    @Override
    public void add(Storage storage) throws Exception {
        checkExisted(storage);
        listStorage.add(storage);
    }

    private void checkExisted(Storage storage) throws Exception {
        for(Storage storage1 : listStorage){
            if(storage.getId() == storage1.getId()){
                throw new Exception("Detective with ID: " +storage.getId()+ "is already existed!");
            }
        }
    }

    @Override
    public Storage findById(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Find!");
        }
        for(int i = 0; i < listStorage.size(); i++ ){
            if(listStorage.get(i).getId() == id){
                return listStorage.get(i);
            }
        }
        throw new Exception("Can't Find Storage With ID: " +id);
    }

    private boolean isEmpty(long id) {
        if(String.valueOf(id).length() == 0 ){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Storage> getAll() {
        return listStorage;
    }

    @Override
    public Storage update(Storage storage) throws Exception {
        findById(storage.getId());
        return update(storage);
    }

    @Override
    public void remove(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Delete!");
        }
        Storage storage = findById(id);
        listStorage.remove(storage);

    }
}
