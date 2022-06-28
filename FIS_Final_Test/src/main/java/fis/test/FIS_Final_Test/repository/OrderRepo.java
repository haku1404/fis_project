package fis.test.FIS_Final_Test.repository;

import fis.test.FIS_Final_Test.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
