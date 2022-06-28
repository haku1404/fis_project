package fis.test.FIS_Final_Test.repository;

import fis.test.FIS_Final_Test.model.Customer;
import fis.test.FIS_Final_Test.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByMobileNumber(String mobile);

    List<Customer> findByStatus(OrderStatus status);
}
