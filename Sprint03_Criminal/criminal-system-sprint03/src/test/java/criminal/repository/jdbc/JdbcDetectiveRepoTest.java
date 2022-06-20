package criminal.repository.jdbc;

import criminal.model.entity.CriminalCase;
import criminal.model.entity.Detective;
import criminal.model.entity.TrackEntry;
import criminal.model.enums.EmploymentStatus;
import criminal.model.enums.Rank;
import criminal.repository.DetectiveRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcDetectiveRepoTest {

    @Autowired
    DetectiveRepo detectiveRepo;
    @Test
    void findById() {
        System.out.println(detectiveRepo.findById(1L));
    }

    @Test
    void findByBadgeNumber() {
        Detective detective = detectiveRepo.findByBadgeNumber("B02").get();
        System.out.println(detective);
    }

    @Test
    void save() {
//        Set<CriminalCase> criminalCaseSet = new HashSet<>();
//        Set<TrackEntry> trackEntrySet = new HashSet<>();
        Detective detective = new Detective(2L, 2, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(),
                "dec02", "Anne", "Shirley", "654321", "B02", null,
                true,  null,
                null, null);
        detectiveRepo.save(detective);
    }

    @Test
    void findAll() {
        Set<Detective> detectiveSet;
        detectiveSet = detectiveRepo.findAll();
        for(Detective detective : detectiveSet){
            System.out.println(detective);
        }
    }

    @Test
    void findbyRank() {
        Set<Detective> detectiveSet;
        detectiveSet = detectiveRepo.findbyRank("TRAINEE");
        for(Detective detective : detectiveSet){
            System.out.println(detective);
        }
    }

    @Test
    void delete() {
        detectiveRepo.delete(detectiveRepo.findById(2L).get());
    }

    @Test
    void deleteById() {
        detectiveRepo.deleteById(1L);
    }
}