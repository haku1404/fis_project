package criminal.model.mapper;

import criminal.model.entity.Detective;
import criminal.model.enums.EmploymentStatus;
import criminal.model.enums.Rank;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetectiveRowMapper implements RowMapper<Detective> {
    @Override
    public Detective mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("ID");
        String badgeNumber = rs.getString("BADGE_NUMBER");
        String rank = rs.getString("RANK");
        boolean armed = rs.getBoolean("ARMED");
        String status = rs.getString("STATUS");
        long personId = rs.getLong("PERSON_ID");
        Detective detective = new Detective();

        detective.setId(personId);
        detective.setUsername(rs.getString("USERNAME"));
        detective.setFirstName(rs.getString("FIRSTNAME"));
        detective.setLastName(rs.getString("LASTNAME"));
        detective.setHiringDate(rs.getTimestamp("HIRINGDATE").toLocalDateTime());

        detective.setId(id);
        detective.setBadgeNumber(badgeNumber);
        detective.setRank(Rank.valueOf(rank));
        detective.setArmed(armed);
        detective.setStatus(EmploymentStatus.valueOf(status));

        return detective;
    }
}
