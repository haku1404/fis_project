package vn.fis.final_test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.final_test.dto.*;
import vn.fis.final_test.model.Order;
import vn.fis.final_test.service.OrderService;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO findById(Long orderId) {
        return null;
    }

    @Override
    public Order create(CreateOrderDTO createOrderItemDTO) {
        return null;
    }

    @Override
    public void delete(Long orderId){
    }

    @Override
    public Order addOrderItem(AddOrderItemDTO addOrderItemDTO) {
        return null;
    }

    @Override
    public Order removeOrderItem(RemoveItemDTO removeItemDTO) {
        return null;
    }

    @Override
    public Order paid(Long orderId) {
        return null;
    }

    @Override
    public Order cancel(Long orderId) {
        return null;
    }
}
