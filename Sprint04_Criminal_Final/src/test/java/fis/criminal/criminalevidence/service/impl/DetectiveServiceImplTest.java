package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.enums.EmploymentStatus;
import fis.criminal.criminalevidence.repository.DetectiveRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class DetectiveServiceImplTest {

    @Autowired
    private DetectiveServiceImpl detectiveService;

    @Autowired
    private DetectiveRepo detectiveRepo;

    @Test
    void create() {
        Detective detective = new Detective(3L,2, null, null, null, null,
                null, null, null, null, null, null, null, null, null);
        detectiveService.create(detective);
    }

    @Test
    void update() {
        Detective detective = detectiveRepo.findById(3L).get();
        detective.setCreatedAt(LocalDateTime.now());
        detective.setArmed(true);
        detectiveService.update(detective);
    }

    @Test
    void delete() {
        Detective detective = detectiveRepo.findById(3L).get();
        detectiveService.delete(detective);
    }

    @Test
    void deleteById() {
        detectiveService.deleteById(3L);
    }

    @Test
    void findById() {
        Detective detective = detectiveService.findById(2L).get();
        System.out.println(detective);
    }

    @Test
    void findAll() {
        List<Detective> detectiveList = detectiveService.findAll();
        System.out.println(detectiveList);
    }

    @Test
    void findByStatus() {
        List<Detective> detectiveList = detectiveService.findByStatus(EmploymentStatus.RETIRED);
        System.out.println(detectiveList);
    }

    @Test
    void findByBadge() {
        List<Detective> detectiveList = detectiveService.findByBadge("1");
        System.out.println(detectiveList);
    }

    @Test
    void addCriminalCase() {
    }

    @Test
    void removeCriminalCase() {
    }
}