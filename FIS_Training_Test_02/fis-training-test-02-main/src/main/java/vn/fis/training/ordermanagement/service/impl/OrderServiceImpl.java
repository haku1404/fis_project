package vn.fis.training.ordermanagement.service.impl;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addOrderItem(Long OrderId, OrderItem orderItem) {
        Order order =  findById(OrderId);
        order.getOrderItems().add(orderItem);

        order.setTotalAmount(order.getOrderItems().stream().mapToDouble(order1 -> order1.getAmount()).sum());

        orderRepository.save(order);
        return order;
    }

    @Override
    public Order removeOrderItem(Long OrderId, OrderItem orderItem) {
        Optional<Order> order = orderRepository.findById(OrderId);
        order.get().getOrderItems().remove(orderItem);

        double amount = order.get().getTotalAmount() - (orderItem.getQuantity() * orderItem.getProduct().getPrice());
        order.get().setTotalAmount(amount);

        orderRepository.save(order.get());
        return order.get();
    }

    @Override
    public Order updateOrderStatus(Order order, OrderStatus orderStatus) {
        order.setStatus(orderStatus);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
            List<Order> orderList = findAllOrders();

        return orderList.stream().filter(order -> order.getOrderDateTime().isAfter(fromDateTime)
                && order.getOrderDateTime().isBefore(toDateTime)).collect(Collectors.toList());
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {
        List<Order> orderList = findAllOrders().stream().filter(order -> order.getStatus().equals(
                OrderStatus.WAITING_APPROVAL)).collect(Collectors.toList());
        return orderList;
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        List<Order> orderList = findAllOrders().stream().filter(order -> order.getStatus().equals(orderStatus))
                .collect(Collectors.toList());
        return orderList;
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        List<Order> orderList = orderRepository.findAll().stream().filter(order -> order.getCustomer().equals(customer))
                .collect(Collectors.toList());
        return orderList;
    }

    @Override
    public Order findById(Long OrderId) {
        return orderRepository.findById(OrderId).get();
    }

    @Override
    public List<Order> findAllOrders() {
        List orders = new ArrayList<>();
        orderRepository.findAll().forEach(order -> orders.add(order));
        return orders;
    }
}
