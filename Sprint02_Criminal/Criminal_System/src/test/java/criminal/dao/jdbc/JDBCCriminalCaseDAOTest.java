package criminal.dao.jdbc;

import criminal.dao.ICriminalCaseDAO;
import criminal.dao.memory.CriminalCaseDAO;
import criminal.model.CriminalCase;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseDAOTest {

    @Test
    void getAll() {
        //A1
        ICriminalCaseDAO criminalCaseDAO = new JDBCCriminalCaseDAO();

        //A2
        List<CriminalCase> criminalCaseList = criminalCaseDAO.getAll();

        //A3: Assert
       printHeader();
        for(CriminalCase criminalCase : criminalCaseList){
            System.out.println(criminalCase);
        }

    }

    public void printHeader(){
        System.out.format("%-15s %-15s %-15s %-15s %-15s %-45s %-85s %-15s %-15s %-15s %-15s %-20s %-15s\n",
                "id", "version", "createdAt", "modifiedAt", "number", "shortDescription", "detailedDescription",
                "notes", "type", "status", "evidenceSet", "leadInvestigator", "assigned");
    }

    @Test
    void save(){
        ICriminalCaseDAO criminalCaseDAO = new JDBCCriminalCaseDAO();
        List<CriminalCase> criminalCaseList = criminalCaseDAO.getAll();


        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(5);
        criminalCase.setVersion(5);
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setNumber("case03");
        criminalCase.setShortDescription("a butterfly won't hurt anyone");
        criminalCase.setDetailedDescription("but butterflies in your stomach won't let you do anything");
        criminalCase.setNotes("so be careful!");

       // criminalCaseDAO.save(criminalCase);

        assertEquals(4, criminalCaseList.size());


    }

    @Test

    void getById(){
        ICriminalCaseDAO criminalCaseDAO = new JDBCCriminalCaseDAO();

        CriminalCase criminalCase = criminalCaseDAO.getById(5);

        assertEquals(5, criminalCase.getId());
    }

    @Test
    void delete(){
        ICriminalCaseDAO criminalCaseDAO = new JDBCCriminalCaseDAO();
        List<CriminalCase> criminalCaseList = criminalCaseDAO.getAll();
        int before = criminalCaseList.size();
        System.out.println(before);

        criminalCaseDAO.delete(4);


        System.out.println(criminalCaseList.size());
    }

    @Test
    void update(){
        ICriminalCaseDAO criminalCaseDAO = new JDBCCriminalCaseDAO();
        CriminalCase criminalCase = criminalCaseDAO.getById(5);

        criminalCase.setVersion(4);

    }

    @Test
    void search(){
        ICriminalCaseDAO criminalCaseDAO = new JDBCCriminalCaseDAO();

        List<CriminalCase> criminalCaseList = criminalCaseDAO.search(3);

        printHeader();
        for(CriminalCase criminalCase : criminalCaseList){
            System.out.println(criminalCase);
        };


    }
}