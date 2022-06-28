package vn.fis.final_test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.final_test.dto.*;
import vn.fis.final_test.exception.CustomerNotFoundException;
import vn.fis.final_test.exception.OrderItemNotFoundException;
import vn.fis.final_test.exception.OrderNotFoundException;
import vn.fis.final_test.model.Customer;
import vn.fis.final_test.model.Order;
import vn.fis.final_test.model.OrderItem;
import vn.fis.final_test.model.Product;
import vn.fis.final_test.model.enums.OrderStatus;
import vn.fis.final_test.repository.CustomerRepo;
import vn.fis.final_test.repository.OrderItemRepo;
import vn.fis.final_test.repository.OrderRepo;
import vn.fis.final_test.repository.ProductRepo;
import vn.fis.final_test.service.OrderService;
import vn.fis.final_test.service.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final OrderItemRepo orderItemRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, CustomerRepo customerRepo,
                            ProductRepo productRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.orderItemRepo = orderItemRepo;
    }
    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query All Order: PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderRepo.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public Order findById(Long orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(()
                -> new OrderNotFoundException("Order Not Found!"));
        return order;
    }

    @Override
    public Order create(CreateOrderDTO createOrderDTO) {
        Customer customer = customerRepo.findById(createOrderDTO.getCustomerId()).get();
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .customer(customer)
                .build();
        orderRepo.save(order);
        return order;
    }

    @Override
    public void delete(Long orderId){
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found!"));
        orderRepo.delete(order);
    }

    @Override
    public Order addOrderItem(AddOrderItemDTO addOrderItemDTO) {
        Order order = orderService.findById(addOrderItemDTO.getOrderId());
        Product product = productRepo.findById(addOrderItemDTO.getProductId()).get();
        OrderItem newOrderItem = OrderItem.builder()
                .amount(product.getPrice() * addOrderItemDTO.getQuantity())
                .quantity(addOrderItemDTO.getQuantity())
                .order(order)
                .product(product)
                .build();
        order.setTotalAmount(order.getTotalAmount() + newOrderItem.getAmount());
        order.getOrderItems().add(newOrderItem);
        orderRepo.save(order);
        product.setAvailable(product.getAvailable() - addOrderItemDTO.getQuantity());
        productService.update(product);
        return findById(addOrderItemDTO.getOrderId());
    }

    @Override
    public Order removeOrderItem(RemoveItemDTO removeItemDTO) {
        Order order = orderRepo.findById(removeItemDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found!"));

        OrderItem orderItem = orderItemRepo.findById(removeItemDTO.getOrderItemId())
                .orElseThrow(() -> new OrderItemNotFoundException("Order Item Not Found!"));
        order.getOrderItems().remove(orderItem);
        order.setTotalAmount(order.getOrderItems().stream().mapToDouble(item ->item.getAmount()).sum());
        return findById(removeItemDTO.getOrderId());
    }

    @Override
    public OrderDTO paid(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found!"));
        order.setStatus(OrderStatus.PAID);
        return OrderDTO.Mapper.fromEntity(orderRepo.save(order));
    }

    @Override
    public OrderDTO cancel(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found!"));
        order.setStatus(OrderStatus.CANCELLED);
        return OrderDTO.Mapper.fromEntity(orderRepo.save(order));
    }
}
