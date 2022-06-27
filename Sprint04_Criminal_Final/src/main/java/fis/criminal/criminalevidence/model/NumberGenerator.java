package fis.criminal.criminalevidence.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Random;


@Table(name = "tbl_numberGenerator")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NumberGenerator {

    @Column(name = "rand")
    private Random RAND;

    @Column(name = "upper")
    private String UPPER;

    @Column(name = "digits")
    private String DIGITS;
}
