package vn.fis.training.ordermanagement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.fis.training.ordermanagement.domain.*;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;
import vn.fis.training.ordermanagement.service.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class OrderManagementApplication {
    private static final Logger log = LoggerFactory.getLogger(OrderManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }


    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Welcome to spring application. Pls write test method in here to run for testing only");
                log.info("Total order with wating status : {} order(s)", orderService.findOrdersByOrderStatus(OrderStatus.WAITING_APPROVAL).size());

//				Customer customer = new Customer(4L, "Han", "0972615212", "Ngu Cau");
//				customerService.createCustomer(customer);

//				System.out.println(customerService.findAll());

//				customerService.deleteCustomerById(4L);

//				Product product = new Product(6L, "Cheese", 20000.0);
//				productService.addProduct(product);
//				productService.deleteProductById(3L);
//				System.out.println(productService.findAll());
//				System.out.println(productService.findById(2L));
//				Customer customer = customerService.getCustomerById(1L);
//
//                Order order = new Order(1L, LocalDateTime.now(), OrderStatus.WAITING_APPROVAL, 100000.0, customer);
//				  orderService.createOrder(order);

//                Order order = orderService.findById(1L);
//                Product product = productService.findById(3L);
//                OrderItem item = new OrderItem(3L, 60000.0, 4, order, product);
//                orderService.addOrderItem(1L, item);

//                LocalDateTime time = LocalDateTime.now();
//                LocalDateTime time1 = LocalDateTime.of(2022, 06, 17, 17, 17, 17, 000000);
//                List<Order> orderList = orderService.findOrdersBetween(time1, time);
//                System.out.println(orderList);

//                Order order = orderService.findById(1L);
//                Product product = productService.findById(3L);
//                OrderItem item = new OrderItem(4L, 60000.0, 3, order, product);
//                orderService.addOrderItem(1L, item);


//                  Order order = orderService.findById(1L);
//                  OrderItem item = new OrderItem(4L, 60000.0, 3, order, product);
//                  orderService.removeOrderItem(1l, item);

            }
        };
    }
}
