package fis.criminal.criminalevidence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "tbl_evidence")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
public class Evidence {
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

    @ManyToOne
    @JoinColumn(name = "criminalCase_id", nullable = false)
    @JsonBackReference
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    @JsonBackReference
    private Storage storage;

    @Column(name = "number")
    private String number;

    @Column(name = "item_Name")
    private String itemName;

    @Column(name = "notes")
    private String notes;

    @Column(name = "archived")
    private Boolean archived;

    @OneToMany(mappedBy = "evidence")
    private Set<TrackEntry> trackEntries;
}
