package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.*;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderRepository orderRepository;

    OrderServiceImpl orderService = new OrderServiceImpl();

    @Autowired
    ProductRepository productRepository;
    CustomerRepository customerRepository;

    @Test
    void createOrder() {
        Customer customer = customerRepository.findById(2l).get();
        orderRepository.save(new Order(2L, LocalDateTime.now(), OrderStatus.CANCELLED, 100000.0, customer));
        System.out.println(orderRepository.findById(2L));
    }

    @Test
    void addOrderItem() {
        Order order = orderRepository.findById(1L).get();
        Product product = productRepository.findById(3L).get();
        order.getOrderItems().add(new OrderItem(4L, 60000.0, 3, order, product ));

    }

    @Test
    void removeOrderItem() {
    }

    @Test
    void updateOrderStatus() {
    }

    @Test
    void findOrdersBetween() {
//        LocalDateTime time = LocalDateTime.now();
//        LocalDateTime time1 = LocalDateTime.of(2022 ,06, 17, 17,17, 17, 000000);
//        List<Order> orderList = orderService.findOrdersBetween(time1, time);
//        System.out.println(orderList);
    }

    @Test
    void findWaitingApprovalOrders() {
    }

    @Test
    void findOrdersByOrderStatus() {
    }

    @Test
    void findOrdersByCustomer() {
    }

    @Test
    void findById() {
        Order order = orderRepository.findById(1L).get()    ;
        System.out.println(order);
    }
}