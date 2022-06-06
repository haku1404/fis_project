package dao.Evidence;

import core.model.Detective;
import core.model.Evidence;

import java.util.ArrayList;

public class EvidenceDAO implements IEvidenceDAO{

    ArrayList<Evidence> listEvidence = new ArrayList<>();

    @Override
    public void add(Evidence evidence) throws Exception {
        checkExisted(evidence);
        listEvidence.add(evidence);
    }

    private void checkExisted(Evidence evidence) throws Exception {
        for(Evidence evidence1 : listEvidence){
            if(evidence.getId() == evidence.getId()){
                throw new Exception("Evidence with ID: " +evidence.getId()+ "is already existed!");
            }
        }
    }

    @Override
    public Evidence findById(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Find!");
        }
        for(int i = 0; i < listEvidence.size(); i++ ){
            if(listEvidence.get(i).getId() == id){
                return listEvidence.get(i);
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
    public ArrayList<Evidence> getAll() {
        return listEvidence;
    }

    @Override
    public Evidence update(Evidence evidence) throws Exception {
        findById(evidence.getId());
        return update(evidence);
    }

    @Override
    public void remove(long id) throws Exception {
        if(isEmpty(id)){
            throw new Exception("Please Enter An Id To Delete!");
        }
        Evidence evidence = findById(id);
        listEvidence.remove(evidence);

    }
}
