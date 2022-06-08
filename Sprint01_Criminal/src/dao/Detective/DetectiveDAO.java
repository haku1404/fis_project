package dao.Detective;

import core.model.Detective;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDAO implements IDetectiveDAO {
    private ArrayList<Detective> listDetective = new ArrayList<>();

    private DetectiveDAO(){

    }

    //Apply Singleton Pattern for DAO class
    private static DetectiveDAO instance = new DetectiveDAO();

    public static DetectiveDAO getInstance(){
        return instance;
    }

    @Override
    public void add(Detective detective) throws Exception {
        checkExisted(detective);
        listDetective.add(detective);
    }

    private void checkExisted(Detective detective) throws Exception {
        for(Detective detective1 : listDetective){
            if(detective.getId() == detective1.getId()){
                throw new Exception("Detective with ID: " +detective.getId()+ "is already existed!");
            }
        }
    }

    @Override
    public Detective findById(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Find!");
        }
        for(int i = 0; i < listDetective.size(); i++ ){
            if(listDetective.get(i).getId() == id){
                return listDetective.get(i);
            }
        }
        throw new Exception("Can't Find Detective With ID: " +id);
    }

    private boolean isEmpty(long id) {
        if(String.valueOf(id).length() == 0 ){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Detective> getAll() {
        return listDetective;
    }

    @Override
    public Detective update(Detective detective) throws Exception {
        findById(detective.getId());
        return update(detective);

    }

    @Override
    public void remove(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Delete!");
        }
        Detective detective = findById(id);
        listDetective.remove(detective);
    }
}
