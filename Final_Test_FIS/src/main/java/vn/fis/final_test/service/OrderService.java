package vn.fis.final_test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fis.final_test.dto.*;
import vn.fis.final_test.model.Order;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);

    OrderDTO findById(Long orderId);

    Order create(CreateOrderDTO createOrderItemDTO);

    void delete(Long orderId);

    Order addOrderItem(AddOrderItemDTO addOrderItemDTO);

    Order removeOrderItem(RemoveItemDTO removeItemDTO);

    Order paid(Long orderId);

    Order cancel(Long orderId);



}
