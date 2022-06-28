package fis.test.FIS_Final_Test.service.impl;

import fis.test.FIS_Final_Test.dto.CreateCustomerDTO;
import fis.test.FIS_Final_Test.dto.CustomerDTO;
import fis.test.FIS_Final_Test.model.Customer;
import fis.test.FIS_Final_Test.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
