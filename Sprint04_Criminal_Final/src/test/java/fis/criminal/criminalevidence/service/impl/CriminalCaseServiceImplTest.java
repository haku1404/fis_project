package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.enums.CaseStatus;
import fis.criminal.criminalevidence.model.enums.CaseType;
import fis.criminal.criminalevidence.repository.CriminalCaseRepo;
import fis.criminal.criminalevidence.repository.DetectiveRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CriminalCaseServiceImplTest {

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;
    @Autowired
    private CriminalCaseServiceImpl criminalCaseService;

    @Autowired
    private DetectiveRepo detectiveRepo;
    @Test
    void create() throws Exception {
        Detective detective = detectiveRepo.findById(1L).get();
        CriminalCase criminalCase = new CriminalCase(2L,1,null,null,null,null,
                null,null,null,null,null,detective,null);
        criminalCaseService.create(criminalCase);
    }

    @Test
    void update() {
        CriminalCase criminalCase = criminalCaseRepo.findById(3L).get();
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCaseService.update(criminalCase);
    }

    @Test
    void delete() {
        CriminalCase criminalCase = criminalCaseRepo.findById(5L).get();
        criminalCaseService.delete(criminalCase);
    }

    @Test
    void deleteById() {
        criminalCaseService.deleteById(4L);
    }

    @Test
    void findById() {
        CriminalCase criminalCase = criminalCaseService.findById(1L).get();
        System.out.println(criminalCase);
    }

    @Test
    void findAll() {
        List<CriminalCase> criminalCaseList = criminalCaseService.findAll();
        System.out.println(criminalCaseList);
    }

    @Test
    void findByStatus() {
        List<CriminalCase> criminalCaseList = criminalCaseService.findByStatus(CaseStatus.CLOSED);
        System.out.println(criminalCaseList);
    }

    @Test
    void findByType() {
        List<CriminalCase> criminalCaseList = criminalCaseService.findByType(CaseType.FELONY);
        System.out.println(criminalCaseList);
    }
}