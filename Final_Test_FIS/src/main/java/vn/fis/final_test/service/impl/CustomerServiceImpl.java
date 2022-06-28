package vn.fis.final_test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.final_test.dto.CreateCustomerDTO;
import vn.fis.final_test.dto.CustomerDTO;
import vn.fis.final_test.exception.CustomerNotFoundException;
import vn.fis.final_test.exception.OrderNotFoundException;
import vn.fis.final_test.model.Customer;
import vn.fis.final_test.model.Order;
import vn.fis.final_test.repository.CustomerRepo;
import vn.fis.final_test.service.CustomerService;

import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        log.info("Query All Customer. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return customerRepo.findAll(pageable).map(CustomerDTO.Mapper::fromEntity);
    }

    @Override
    public Customer findById(Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(()
                -> new OrderNotFoundException("Order Not Found!"));
        return customer;
    }

    @Override
    public Page<CustomerDTO> create(CreateCustomerDTO createCustomerDTO, Pageable pageable) {
        Customer customer = Customer.builder()
                .name(createCustomerDTO.getName())
                .mobile(createCustomerDTO.getMobile())
                .address(createCustomerDTO.getAddress())
                .build();
        customerRepo.save(customer);
        return findAll(pageable);
    }

    @Override
    public CustomerDTO update(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> customer= customerRepo.findById(customerId);
        if(customer.isPresent())
        {
            customer.get().setAddress(customerDTO.getAddress());
            customer.get().setMobile(customerDTO.getMobile());
            customer.get().setName(customerDTO.getName());
            customerRepo.save(customer.get());
        }
        try {
            throw new CustomerNotFoundException("Customer Not Found!");
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long customerId) {
        Customer customer = null;
        try {
            customer = customerRepo.findById(customerId)
                    .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found!"));
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
        customerRepo.delete(customer);
    }
}
