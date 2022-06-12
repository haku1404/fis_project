package criminal.dao.memory;

import criminal.dao.ICriminalCaseDAO;
import criminal.model.CriminalCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriminalCaseDAOTest {

    @Test
    void save() {
        //A1: Arrange
        CriminalCase criminalCase = new CriminalCase();
        List<CriminalCase> listCriminalCase = new ArrayList<>();
        // init data
        // ...
        //A2: Action
        int before = listCriminalCase.size();
        ICriminalCaseDAO iCriminalCaseDAO = new CriminalCaseDAO();
        iCriminalCaseDAO.save(criminalCase);
        //A3: Assert
        assertEquals(before, listCriminalCase.size());
    }
}