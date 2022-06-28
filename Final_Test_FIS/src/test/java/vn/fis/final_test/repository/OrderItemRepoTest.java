package vn.fis.final_test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import vn.fis.final_test.model.Customer;
import vn.fis.final_test.model.Order;
import vn.fis.final_test.model.enums.OrderStatus;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderItemRepoTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void countOrders() {
        Customer customer1 = Customer.builder()
                .name("c1")
                .mobile("0967587291")
                .address("ABC")
                .build();
        entityManager.persist(customer1);
        Order order1 = Order.builder()
                .customer(customer1)
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .totalAmount(10000.0)
                .build();
        entityManager.persist(order1);
        Order order2 = Order.builder()
                .customer(customer1)
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .totalAmount(20000.0)
                .build();
        entityManager.persist(order2);
        Iterable orders = orderRepo.findAll();
        assertThat(orders).hasSize(4).contains(order1,order2);
    }
}