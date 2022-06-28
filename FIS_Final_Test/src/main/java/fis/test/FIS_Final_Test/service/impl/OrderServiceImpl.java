package fis.test.FIS_Final_Test.service.impl;

import fis.test.FIS_Final_Test.dto.AddOrderItemDTO;
import fis.test.FIS_Final_Test.dto.CreateOrderDTO;
import fis.test.FIS_Final_Test.dto.OrderDTO;
import fis.test.FIS_Final_Test.dto.RemoveItemDTO;
import fis.test.FIS_Final_Test.model.Order;
import fis.test.FIS_Final_Test.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void delete(Long orderId) {

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
