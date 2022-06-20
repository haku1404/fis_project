package criminal.model.entity;

import criminal.model.enums.EmploymentStatus;
import criminal.model.enums.Rank;

import java.time.LocalDateTime;
import java.util.Set;

public class Detective {
    private long id;
    private int version;
    private LocalDateTime createdAt, modifiedAt, hiringDate;

    private String username, firstName, lastName, password, badgeNumber;

    private Rank rank;
    private Boolean armed;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCases;
    private Set<TrackEntry> trackEntries;

    public Detective() {
    }

    public Detective(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime hiringDate,
                     String username, String firstName, String lastName, String password, String badgeNumber,
                     Rank rank, Boolean armed, EmploymentStatus status, Set<CriminalCase> criminalCases,
                     Set<TrackEntry> trackEntries) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.hiringDate = hiringDate;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
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

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public void setCriminalCases(Set<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    @Override
    public String toString() {
        return "Detective{" +
                "id=" + id +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", hiringDate=" + hiringDate +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", armed=" + armed +
                ", status=" + status +
                ", criminalCases=" + criminalCases +
                ", trackEntries=" + trackEntries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detective detective = (Detective) o;

        if (id != detective.id) return false;
        if (version != detective.version) return false;
        if (createdAt != null ? !createdAt.equals(detective.createdAt) : detective.createdAt != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(detective.modifiedAt) : detective.modifiedAt != null) return false;
        if (hiringDate != null ? !hiringDate.equals(detective.hiringDate) : detective.hiringDate != null) return false;
        if (username != null ? !username.equals(detective.username) : detective.username != null) return false;
        if (firstName != null ? !firstName.equals(detective.firstName) : detective.firstName != null) return false;
        if (lastName != null ? !lastName.equals(detective.lastName) : detective.lastName != null) return false;
        if (password != null ? !password.equals(detective.password) : detective.password != null) return false;
        if (badgeNumber != null ? !badgeNumber.equals(detective.badgeNumber) : detective.badgeNumber != null)
            return false;
        if (rank != detective.rank) return false;
        if (armed != null ? !armed.equals(detective.armed) : detective.armed != null) return false;
        if (status != detective.status) return false;
        if (criminalCases != null ? !criminalCases.equals(detective.criminalCases) : detective.criminalCases != null)
            return false;
        return trackEntries != null ? trackEntries.equals(detective.trackEntries) : detective.trackEntries == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + version;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (hiringDate != null ? hiringDate.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (badgeNumber != null ? badgeNumber.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (armed != null ? armed.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (criminalCases != null ? criminalCases.hashCode() : 0);
        result = 31 * result + (trackEntries != null ? trackEntries.hashCode() : 0);
        return result;
    }
}
