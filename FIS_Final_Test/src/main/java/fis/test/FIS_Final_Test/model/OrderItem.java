package fis.test.FIS_Final_Test.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "tbl_orderItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

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
