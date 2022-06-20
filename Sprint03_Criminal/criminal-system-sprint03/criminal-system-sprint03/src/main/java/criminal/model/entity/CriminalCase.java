package criminal.model.entity;

import criminal.model.enums.CaseStatus;
import criminal.model.enums.CaseType;

import java.time.LocalDateTime;
import java.util.Set;

public class CriminalCase {
    private long id;
    private int version;
    private LocalDateTime createdAt, modifiedAt;
    private String number, shortDescription, detailedDescription, notes;
    private CaseType type;
    private CaseStatus status;
    private Set<Evidence> evidenceSet;
    private Detective leadInvestigator;
    private Set<Detective> assigned;

    public CriminalCase() {
    }

    public CriminalCase(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String number,
                        String shortDescription, String detailedDescription, String notes, CaseType type,
                        CaseStatus status, Set<Evidence> evidenceSet,
                        Detective leadInvestigator, Set<Detective> assigned) {
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
        this.evidenceSet = evidenceSet;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
    }

    public CriminalCase(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, String number,
                        String shortDescription, String detailedDescription, String notes) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.number = number;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.notes = notes;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-35s %-35s %-15s %-25s %-45s %-15s %-15s %-15s %-15s %-20s %-15s",
                id, version, createdAt, modifiedAt, number, shortDescription, detailedDescription, notes, type, status,
                evidenceSet, leadInvestigator.getId(), assigned);
    }

    @Override
    public boolean equals(Object o) {
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
        if (status != that.status) return false;
        if (evidenceSet != null ? !evidenceSet.equals(that.evidenceSet) : that.evidenceSet != null) return false;
        if (leadInvestigator != null ? !leadInvestigator.equals(that.leadInvestigator) : that.leadInvestigator != null)
            return false;
        return assigned != null ? assigned.equals(that.assigned) : that.assigned == null;
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
        result = 31 * result + (evidenceSet != null ? evidenceSet.hashCode() : 0);
        result = 31 * result + (leadInvestigator != null ? leadInvestigator.hashCode() : 0);
        result = 31 * result + (assigned != null ? assigned.hashCode() : 0);
        return result;
    }
}
