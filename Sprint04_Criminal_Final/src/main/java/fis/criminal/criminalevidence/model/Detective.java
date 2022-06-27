package fis.criminal.criminalevidence.model;

import fis.criminal.criminalevidence.model.enums.EmploymentStatus;
import fis.criminal.criminalevidence.model.enums.Rank;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Table(name = "tbl_detective")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Detective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "version")
    private int version;

    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @Column(name = "modified_At")
    private LocalDateTime modifiedAt;

    @Column(name = "username")
    private String username;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "hiring_Date")
    private LocalDateTime hiringDate;

    @Column(name = "badge_Number")
    private String badgeNumber;

    @Column(name = "dec_rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    @Column(name = "armed")
    private Boolean armed;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;

    @OneToMany(mappedBy = "detective")
    @Transient
    private Set<CriminalCase> criminalCases;

    @OneToMany(mappedBy = "detective", cascade = CascadeType.ALL)
    @Transient
    private Set<TrackEntry> trackEntries;
}
