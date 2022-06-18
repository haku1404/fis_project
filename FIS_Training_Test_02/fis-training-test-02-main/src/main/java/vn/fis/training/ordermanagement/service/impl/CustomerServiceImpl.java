package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> findAll() {
        List customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;

    }

    @Override
    public Customer findByMobileNumber(String mobileNumber) {
        Optional<Customer> customer = customerRepository.findAll().stream().filter(customer1 -> customer1.getMobile()
                .equals(mobileNumber)).findFirst();
        return customer.get();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }
}
