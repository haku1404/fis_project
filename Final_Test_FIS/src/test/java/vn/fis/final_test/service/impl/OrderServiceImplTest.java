package vn.fis.final_test.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fis.final_test.dto.AddOrderItemDTO;
import vn.fis.final_test.dto.CreateOrderDTO;
import vn.fis.final_test.dto.OrderDTO;
import vn.fis.final_test.dto.ProductInfoDTO;
import vn.fis.final_test.model.Order;
import vn.fis.final_test.model.OrderItem;
import vn.fis.final_test.model.enums.OrderStatus;
import vn.fis.final_test.repository.OrderItemRepo;
import vn.fis.final_test.repository.OrderRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Test
    void findAll() {
        Page<OrderDTO> orderPage = orderService.findAll(Pageable.ofSize(2));
        for(OrderDTO orderDTO : orderPage){
            System.out.println(orderDTO);
        }
    }

    @Test
    void findById() {
        Order order = orderService.findById(2L);
        assertEquals(2, order.getId());
    }

    @Test
    void create() {
        ProductInfoDTO productInfoDTO = new ProductInfoDTO(1L, 2L);
        ArrayList<ProductInfoDTO> orderItemList = new ArrayList<>();
        orderItemList.add(productInfoDTO);
        CreateOrderDTO createOrderDTO = new CreateOrderDTO(2L, orderItemList);
        orderService.create(createOrderDTO);
    }

    @Test
    void delete() {
        orderService.delete(3L);
        Order order = orderService.findById(3L);
        assertNull(order);
    }

    @Test
    void addOrderItem() {
        AddOrderItemDTO addOrderItemDTO = new AddOrderItemDTO(1L, 1L, 1L);
        orderService.addOrderItem(addOrderItemDTO);
    }

    @Test
    void removeOrderItem() {
    }

    @Test
    void paid() {
        orderService.paid(1L);
        Order order = orderService.findById(1L);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void cancel() {
        orderService.cancel(2L);
        Order order = orderService.findById(2L);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }
}