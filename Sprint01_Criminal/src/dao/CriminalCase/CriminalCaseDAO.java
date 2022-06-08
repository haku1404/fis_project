package dao.CriminalCase;

import core.model.CriminalCase;
import core.model.Detective;

import java.util.ArrayList;

public class CriminalCaseDAO implements ICriminalCaseDAO{

    ArrayList<CriminalCase> listCriminalCase = new ArrayList<>();
    @Override
    public void add(CriminalCase criminalCase) throws Exception {
        checkExisted(criminalCase);
        listCriminalCase.add(criminalCase);
    }

    private void checkExisted(CriminalCase criminalCase) throws Exception {
        for(CriminalCase criminalCase1 : listCriminalCase){
            if(criminalCase.getId() == criminalCase1.getId()){
                throw new Exception("Criminal Case with ID: " +criminalCase.getId()+ "is already existed!");
            }
        }
    }

    @Override
    public CriminalCase findById(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Find!");
        }
        for(int i = 0; i < listCriminalCase.size(); i++ ){
            if(listCriminalCase.get(i).getId() == id){
                return listCriminalCase.get(i);
            }
        }
        throw new Exception("Can't Find Criminal Case With ID: " +id);
    }

    private boolean isEmpty(long id) {
        if(String.valueOf(id).length() == 0 ){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<CriminalCase> getAll() {
        return listCriminalCase;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) throws Exception {
        findById(criminalCase.getId());
        return update(criminalCase);

    }

    @Override
    public void remove(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Delete!");
        }
        findById(id);
        listCriminalCase.remove(id);
    }
}
