package fis.criminal.criminalevidence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.criminal.criminalevidence.model.enums.TrackAction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "tbl_trackEntry")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class TrackEntry {
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

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    @JsonBackReference
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    @JsonBackReference
    private Detective detective;

    @Column(name = "action")
    @Enumerated(EnumType.STRING)
    private TrackAction action;

    @Column(name = "reason")
    private String reason;
}
