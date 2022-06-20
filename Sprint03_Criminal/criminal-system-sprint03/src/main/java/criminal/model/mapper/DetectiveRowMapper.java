package criminal.model.mapper;

import criminal.model.entity.CriminalCase;
import criminal.model.entity.Detective;
import criminal.model.entity.TrackEntry;
import criminal.model.enums.EmploymentStatus;
import criminal.model.enums.Rank;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DetectiveRowMapper implements RowMapper<Detective> {
    @Override
    public Detective mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("ID");
        int version = rs.getInt("VERSION");
        Date createdAt = rs.getDate("CREATED_AT");
        Date modifiedAt = rs.getDate("MODIFIED_AT");
        Date hiringDate = rs.getDate("HIRING_DATE");
        String username = rs.getString("USERNAME");
        String firstname = rs.getString("FIRST_NAME");
        String lastname = rs.getString("LAST_NAME");
        String password = rs.getString("PASSWORD");
        String rank = rs.getString("RANK1");
        String badgeNumber = rs.getString("BADGE_NUMBER");
        boolean armed = rs.getBoolean("ARMED");
        String status = rs.getString("STATUS");
        int criminal_case_id = rs.getInt("CRIMINAL_CASE_ID");
        int track_entry_id = rs.getInt("TRACK_ENTRY_ID");

        Set<CriminalCase> criminalCase = new HashSet<>();
        for(CriminalCase criminalCase1 : criminalCase){
            criminalCase1.setId(criminal_case_id);
        }

        Set<TrackEntry> trackEntry = new HashSet<>();
        for(TrackEntry trackEntry1 : trackEntry) {
            trackEntry1.setId(track_entry_id);
        }

        Detective detective = new Detective();
        detective.setId(id);
        detective.setVersion(version);
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setHiringDate(LocalDateTime.now());
        detective.setUsername(username);
        detective.setFirstName(firstname);
        detective.setLastName(lastname);
        detective.setPassword(password);
        detective.setRank(Rank.valueOf(rank));
        detective.setBadgeNumber(badgeNumber);
        detective.setArmed(armed);
        detective.setStatus(EmploymentStatus.valueOf(status));
        detective.setCriminalCases(criminalCase);
        detective.setTrackEntries(trackEntry);

        return detective;
    }
}
