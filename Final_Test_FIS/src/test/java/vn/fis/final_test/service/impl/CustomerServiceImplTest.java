package vn.fis.final_test.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fis.final_test.dto.CreateCustomerDTO;
import vn.fis.final_test.dto.CustomerDTO;
import vn.fis.final_test.model.Customer;
import vn.fis.final_test.repository.CustomerRepo;
import vn.fis.final_test.service.CustomerService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerServiceImpl customerService;

    private Pageable pageable;

    @Test
    void findAll() {
        Page<CustomerDTO> customerList = customerService.findAll(Pageable.ofSize(2));
        for (CustomerDTO customer : customerList) {
            System.out.println(customer);
        }

    }

    @Test
    void findById() {
        Customer customer = customerService.findById(1L);
        assertEquals(1, customer.getId());
    }

    @Test
    void create() {
        CreateCustomerDTO createCustomerDTO = new CreateCustomerDTO("Minh", "0938831312", "Hoang Cau");
        customerService.create(createCustomerDTO, Pageable.ofSize(1));
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
        customerService.delete(3L);
    }
}