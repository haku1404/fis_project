package fis.test.FIS_Final_Test.service;


import fis.test.FIS_Final_Test.dto.CreateCustomerDTO;
import fis.test.FIS_Final_Test.dto.CustomerDTO;
import fis.test.FIS_Final_Test.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<CustomerDTO> findAll(Pageable pageable);

    Customer findById(Long customerId);

    Page<CustomerDTO> create(CreateCustomerDTO customerDTO, Pageable pageable);

    CustomerDTO update(Long customerId, CustomerDTO customerDTO);

    void delete(Long customerId);
}
