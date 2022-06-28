package fis.test.FIS_Final_Test.repository;

import fis.test.FIS_Final_Test.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
