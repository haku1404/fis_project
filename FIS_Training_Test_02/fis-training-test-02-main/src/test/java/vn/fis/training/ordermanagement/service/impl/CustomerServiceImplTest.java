package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    CustomerRepository customerRepository;

    CustomerService customerService = new CustomerServiceImpl();

    @Test
    void createCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void findAll() {
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Test
    void findByMobileNumber() {
        Customer customer = customerService.findByMobileNumber("0982738192");
        System.out.println(customer);
    }

    @Test
    void findById() {
        Customer customer = customerRepository.findById(1L).get();
        System.out.println(customer);
    }
}