package vn.fis.training.ordermanagement.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_datetime")
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "total_amount")
    private Double totalAmount;

    /**
     * Bao gom cac trang thai duoc dinh nghia trong OrderStatus Class
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, LocalDateTime orderDateTime, OrderStatus status,
                 Double totalAmount, Customer customerId) {
        this.id = id;
        this.orderDateTime = orderDateTime;
        this.status = status;
        this.totalAmount = totalAmount;
        this.customer = customerId;

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDateTime=" + orderDateTime +
                ", status=" + status +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (orderDateTime != null ? !orderDateTime.equals(order.orderDateTime) : order.orderDateTime != null)
            return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (orderItems != null ? !orderItems.equals(order.orderItems) : order.orderItems != null) return false;
        if (totalAmount != null ? !totalAmount.equals(order.totalAmount) : order.totalAmount != null) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderDateTime != null ? orderDateTime.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
