package fis.criminal.criminalevidence.service.impl;

import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.repository.CriminalCaseRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CriminalCaseServiceImplTest {

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;
    @Autowired
    private CriminalCaseServiceImpl criminalCaseService;
    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        CriminalCase criminalCase = criminalCaseRepo.findById(2L).get();
        criminalCaseService.delete(criminalCase);
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}