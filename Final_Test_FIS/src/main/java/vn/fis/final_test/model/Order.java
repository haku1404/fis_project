package vn.fis.final_test.model;

import lombok.*;
import vn.fis.final_test.model.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_datetime", nullable = false)
    private LocalDateTime orderDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderItem> orderItems;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
