package fis.test.FIS_Final_Test.service;

import fis.test.FIS_Final_Test.dto.AddOrderItemDTO;
import fis.test.FIS_Final_Test.dto.CreateOrderDTO;
import fis.test.FIS_Final_Test.dto.OrderDTO;
import fis.test.FIS_Final_Test.dto.RemoveItemDTO;
import fis.test.FIS_Final_Test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
