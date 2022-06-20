package criminal.model.mapper;

import criminal.model.entity.CriminalCase;
import criminal.model.entity.Detective;
import criminal.model.enums.CaseStatus;
import criminal.model.enums.CaseType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CriminalCaseRowMapper implements RowMapper<CriminalCase> {

    @Override
    public CriminalCase mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("ID");
        int version = rs.getInt("VERSION");
        Date created_at = rs.getDate("CREATED_AT");
        Date modified_at = rs.getDate("MODIFIED_AT");
        String number = rs.getString("NUMBER");
        String type = rs.getString("CASE_TYPE");
        String shortDescription = rs.getString("SHORT_DESCRIPTION");
        String detailedDescription = rs.getString("DETAILED_DESCRIPTION");
        String status = rs.getString("CASE_STATUS");
        String notes = rs.getString("NOTES");
        int detectiveId =  rs.getInt("DETECTIVE_ID");

        CriminalCase cc = new CriminalCase();
        cc.setId(id);
        cc.setVersion(version);
        cc.setCreatedAt(LocalDateTime.now());
        cc.setModifiedAt(LocalDateTime.now());
        cc.setNumber(number);
        cc.setType(CaseType.valueOf(type));
        cc.setShortDescription(shortDescription);
        cc.setDetailedDescription(detailedDescription);
        cc.setStatus(CaseStatus.valueOf(status));
        cc.setNotes(notes);

        Detective detective = new Detective();
        detective.setId(detectiveId);
        cc.setLeadInvestigator(detective);
        return cc;
    }
}
