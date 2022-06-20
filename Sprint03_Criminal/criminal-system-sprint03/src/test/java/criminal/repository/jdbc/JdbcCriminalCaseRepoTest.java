package criminal.repository.jdbc;

import criminal.model.entity.Detective;
import criminal.repository.CriminalCaseRepo;
import criminal.repository.DetectiveRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcCriminalCaseRepoTest {

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;
    private DetectiveRepo detectiveRepo;
    @Test
    void findById() {
        printHeader();
        System.out.println(criminalCaseRepo.findByIdd(1L));
    }

    void printHeader(){
        System.out.format("%-15s %-15s %-35s %-35s %-15s %-25s %-45s %-15s %-15s %-15s %-15s %-20s %-15s\n",
                "Id", "Version", "Created At", "Modified At", "Case Number", "Short Description",
                "Detailed Description", "Notes", "Type", "Status", "Evidence Set", "Detective Id", "Assigned");
    }

    @Test
    void findByLeadInvestigator() {
        Detective detective = detectiveRepo.findById(3L).get();
        System.out.println(criminalCaseRepo.findByLeadInvestigator(detective));
    }

    @Test
    void findByNumber() {
        System.out.println(criminalCaseRepo.findByNumber("01"));
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByStatus() {
    }

    @Test
    void findByType() {
    }
}