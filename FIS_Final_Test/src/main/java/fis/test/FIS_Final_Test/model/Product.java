package fis.test.FIS_Final_Test.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "tbl_product")
@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "available", nullable = false)
    private Long available;
}
