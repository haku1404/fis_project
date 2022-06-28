package vn.fis.final_test.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "tbl_customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "mobile", nullable = false, length = 10, unique = true)
    private String mobile;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Order> orders;
}
