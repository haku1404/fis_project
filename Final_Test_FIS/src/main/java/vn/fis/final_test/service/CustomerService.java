package vn.fis.final_test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fis.final_test.dto.CreateCustomerDTO;
import vn.fis.final_test.dto.CustomerDTO;
import vn.fis.final_test.model.Customer;

public interface CustomerService {
    Page<CustomerDTO> findAll(Pageable pageable);

    Customer findById(Long customerId);

    Page<CustomerDTO> create(CreateCustomerDTO customerDTO, Pageable pageable);

    CustomerDTO update(Long customerId, CustomerDTO customerDTO);

    void delete(Long customerId);
}
