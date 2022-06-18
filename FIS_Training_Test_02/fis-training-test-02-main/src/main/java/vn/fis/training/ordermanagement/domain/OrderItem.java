package vn.fis.training.ordermanagement.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tbl_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private Double amount;

    public OrderItem() {
    }

    public OrderItem(Long id, Double amount, Integer quantity, Order order, Product product) {
        this.id = id;
        this.amount = amount;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (id != null ? !id.equals(orderItem.id) : orderItem.id != null) return false;
        if (order != null ? !order.equals(orderItem.order) : orderItem.order != null) return false;
        if (product != null ? !product.equals(orderItem.product) : orderItem.product != null) return false;
        if (quantity != null ? !quantity.equals(orderItem.quantity) : orderItem.quantity != null) return false;
        return amount != null ? amount.equals(orderItem.amount) : orderItem.amount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
