package vn.fis.final_test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.final_test.dto.AddOrderItemDTO;
import vn.fis.final_test.dto.CreateOrderDTO;
import vn.fis.final_test.dto.OrderDTO;
import vn.fis.final_test.dto.RemoveItemDTO;
import vn.fis.final_test.model.Order;
import vn.fis.final_test.service.OrderService;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable("pageNumber") Integer pageNumber,
                                  @PathVariable("pageSize") Integer pageSize) {
        log.info("Response All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("orderId") Long orderId) {
        Order order = orderService.findById(orderId);
        OrderDTO orderDTO = OrderDTO.Mapper.fromEntity(order);
        log.info("DetailOrder with id {}: {}", orderId, orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderDTO createOrderDTO) {
        log.info("CreateOrderDTO: {}", createOrderDTO);
        Order savedOrder = orderService.create(createOrderDTO);
        OrderDTO detailOrderDTO = OrderDTO.Mapper.fromEntity(savedOrder);
        log.info("Saved Detail Order: {}", detailOrderDTO);
        return new ResponseEntity<>(detailOrderDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> delete(@PathVariable("orderId") Long orderId) {
        orderService.delete(orderId);
        return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
    }

    @PostMapping("/addOrderItem")
    public OrderDTO addOrderItem(@RequestBody AddOrderItemDTO addOrderItemDTO) {
        log.info("Order Item: {}", addOrderItemDTO);
        Order order = orderService.addOrderItem(addOrderItemDTO);
        log.info("Order (Added new OrderItem): {}", order);
        return OrderDTO.Mapper.fromEntity(order);
    }

    @PostMapping("/removeOrderItem")
    public OrderDTO removeOrderItem(@RequestBody RemoveItemDTO removeItemDTO) {
        log.info("Remove Item: {}", removeItemDTO);
        Order order = orderService.removeOrderItem(removeItemDTO);
        log.info("Order (Removed): {}", order);
        return OrderDTO.Mapper.fromEntity(order);
    }

    @PostMapping("/paid/{orderId}")
    public OrderDTO paid(@PathVariable("orderId") Long orderId) {
        log.info("Update Status To Paid of Order With Id :{}",orderId);
        return orderService.paid(orderId);
    }

    @PostMapping("/cancel/{orderId}")
    public OrderDTO cancel(@PathVariable("orderId") Long orderId) {
        log.info("Update Status To Canceled of Order With Id :{}",orderId);
        return orderService.cancel(orderId);
    }
}
