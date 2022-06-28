package vn.fis.final_test.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "available", nullable = false)
    private Long available;

}
