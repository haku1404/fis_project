package criminal.dao.jdbc;

import criminal.dao.ICriminalCaseDAO;
import criminal.dao.IDetectiveDAO;
import criminal.model.CriminalCase;
import criminal.model.Detective;
import jdk.nashorn.internal.scripts.JD;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class JDBCDetectiveDAOTest {

    @Test
    void save() {
        JDBCDetectiveDAO detectiveDAO = new JDBCDetectiveDAO();
        List<Detective> detectiveList = detectiveDAO.getAll();


        Detective detective = new Detective();
        detective.setId(3);
        detective.setVersion(3);
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setHiringDate(LocalDateTime.now());
        detective.setUsername("dec02");
        detective.setFirstName("John");
        detective.setLastName("Lennon");
        detective.setPassword("123");
        detective.setBadgeNumber("B02");
        detective.setArmed(false);

        detectiveDAO.save(detective);

        assertEquals(2, detectiveList.size());
    }

    @Test
    void getById() {
        JDBCDetectiveDAO detectiveDAO = new JDBCDetectiveDAO();

        Detective d = detectiveDAO.getById(2);

        assertEquals(2, d.getId());
        System.out.format("%-15s %-15s %-25s %-25s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "id", "version","createdAt", "modifiedAt", "hiringDate", "username", "firstName", "lastName",
                "password", "badgeNumber", "rank", "armed", "status", "criminalCases", "trackEntries");
        System.out.println(d);
    }

    @Test
    void getAll() {
        JDBCDetectiveDAO detectiveDAO = new JDBCDetectiveDAO();

        List<Detective> detectiveList = detectiveDAO.getAll();

        System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "id", "version","createdAt", "modifiedAt", "hiringDate", "username", "firstName", "lastName",
                "password", "badgeNumber", "rank", "armed", "status", "criminalCases", "trackEntries");
        for(Detective detective : detectiveList){
            System.out.println(detective);
        }
    }

    @Test
    void update() {
        JDBCDetectiveDAO detectiveDAO = new JDBCDetectiveDAO();

        Detective detective = detectiveDAO.getById(2);

        detective.setVersion(3);

        detectiveDAO.update(detective);
    }

    @Test
    void delete() {
        JDBCDetectiveDAO detectiveDAO = new JDBCDetectiveDAO();

        detectiveDAO.delete(3);



    }

    @Test
    void test() throws Exception {
        try{
            System.out.println("1");
        }catch (Exception ex){
            System.out.println(ex);
        }finally{
            System.out.println("2");
        }
    }
}