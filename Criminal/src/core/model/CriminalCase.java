package core.model;

import core.model.enums.CaseStatus;
import core.model.enums.CaseType;

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
                ", evidenceSet=" + evidenceSet +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + assigned +
                '}';
    }
}

