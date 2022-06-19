package criminal.model;

import java.util.HashSet;
import java.util.Set;

public class Storage extends AbstractEntity {
    private String name;

    private String location;

    private Set<Evidence> evidenceSet = new HashSet<>();

    public Storage() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSetArg) {
        evidenceSetArg.forEach(this::addEvidence);
    }

    public boolean addEvidence(Evidence evidence) {
        evidence.setStorage(this);
        return evidenceSet.add(evidence);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", evidenceSet=" + evidenceSet +
                ", id=" + id +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}