package vn.fis.final_test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.final_test.dto.CreateCustomerDTO;
import vn.fis.final_test.dto.CustomerDTO;
import vn.fis.final_test.model.Customer;
import vn.fis.final_test.service.CustomerService;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(Long customerId) {
        return null;
    }

    @Override
    public Page<CustomerDTO> create(CreateCustomerDTO customerDTO, Pageable pageable) {
        return null;
    }

    @Override
    public CustomerDTO update(Long customerId, CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void delete(Long customerId) {

    }
}
