package vn.fis.final_test.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import vn.fis.final_test.model.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepoTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepo customerRepo;
    @Test
    void findByMobile() {
        Customer customer1 = Customer.builder()
                .name("c1")
                .mobile("0967587296")
                .address("Trung Quoc")
                .build();
        entityManager.persist(customer1);
        Customer customer2 = Customer.builder()
                .name("c2")
                .mobile("0637172172")
                .address("Hoa Lac")
                .build();
        entityManager.persist(customer2);
        Customer customerFind = customerRepo.findByMobile("0637172172").get();
        assertEquals("0967587296", customer2.getMobile());

    }
}