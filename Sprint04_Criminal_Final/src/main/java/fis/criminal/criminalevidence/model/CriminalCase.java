package fis.criminal.criminalevidence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fis.criminal.criminalevidence.model.enums.CaseStatus;
import fis.criminal.criminalevidence.model.enums.CaseType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tbl_criminalCase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CriminalCase {
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

    @Column(name = "number")
    private String number;

    @Column(name = "case_type")
    @Enumerated(EnumType.STRING)
    private CaseType type;

    @Column(name = "short_Description")
    private String shortDescription;

    @Column(name = "detailed_Description")
    private String detailedDescription;

    @Column(name = "case_status")
    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL)
    @Transient
    private Set<Evidence> evidenceSet;

    @OneToOne
    @JoinColumn(name = "leadInvestigator_id", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany
    @JoinTable(name = "Current_Case", joinColumns = @JoinColumn(name = "criminal_case_id"),
            inverseJoinColumns = @JoinColumn(name = "detective_id"))
    @Transient
    private Set<Detective> assigned;
}
