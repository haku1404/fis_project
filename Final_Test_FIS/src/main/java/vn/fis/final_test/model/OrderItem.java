package vn.fis.final_test.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "amount", nullable = false)
    private Double amount;
}
