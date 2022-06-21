package criminal.model.entity;

import criminal.model.enums.CaseStatus;
import criminal.model.enums.CaseType;
import lombok.*;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "criminal_case")

public class CriminalCase {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "version")
    private int version;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "modifiedAt")
    private LocalDateTime modifiedAt;
    @Column(name = "number")
    private String number;
    @Column(name = "shortDescription")
    private String shortDescription;
    @Column(name = "detailedDescription")
    private String detailedDescription;
    @Column(name = "notes")
    private String notes;
    @Column(name = "type")
    private CaseType type;
    @Column(name = "status")
    private CaseStatus status;
    //private Set<Evidence> evidenceSet;
    //private Detective leadInvestigator;
    //private Set<Detective> assigned;


    public CriminalCase(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String number,
                        String shortDescription, String detailedDescription, String notes, CaseType type, CaseStatus status) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.number = number;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.notes = notes;
        this.type = type;
        this.status = status;
    }

    public CriminalCase() {
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "id=" + id +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", number='" + number + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", notes='" + notes + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o)     {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriminalCase that = (CriminalCase) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(that.modifiedAt) : that.modifiedAt != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (detailedDescription != null ? !detailedDescription.equals(that.detailedDescription) : that.detailedDescription != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (type != that.type) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + version;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (detailedDescription != null ? detailedDescription.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
