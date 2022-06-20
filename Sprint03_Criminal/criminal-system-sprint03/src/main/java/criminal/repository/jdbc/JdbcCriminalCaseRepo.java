package criminal.repository.jdbc;

import criminal.model.entity.CriminalCase;
import criminal.model.entity.Detective;
import criminal.model.enums.CaseStatus;
import criminal.model.enums.CaseType;
import criminal.model.mapper.CriminalCaseRowMapper;
import criminal.repository.CriminalCaseRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class JdbcCriminalCaseRepo  extends JdbcAbstractRepo<CriminalCase>
        implements CriminalCaseRepo {
    private RowMapper<CriminalCase> rowMapper = new CriminalCaseRowMapper();

    public JdbcCriminalCaseRepo(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, NUMBER, CASE_TYPE, SHORT_DESCRIPTION," +
                "DETAILED_DESCRIPTION, CASE_STATUS, NOTES, DETECTIVE_ID from CRIMINAL_CASE where ID= ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public Set<CriminalCase> findByLeadInvestigator(Detective detective) {
        String sql =  "select ID, VERSION, CREATED_AT, MODIFIED_AT, NUMBER, CASE_TYPE, SHORT_DESCRIPTION," +
                "DETAILED_DESCRIPTION, CASE_STATUS, NOTES, DETECTIVE_ID from CRIMINAL_CASE c," +
                " DETECTIVE d where c.DETECTIVE =d.ID and d.ID= ?";
        return new HashSet<>(jdbcTemplate.query(sql, new Object[]{detective.getId()}, rowMapper));
    }

    @Override
    public Optional<CriminalCase> findByNumber(String caseNumber) {
        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, NUMBER, CASE_TYPE, SHORT_DESCRIPTION," +
                        "DETAILED_DESCRIPTION, CASE_STATUS, NOTES, DETECTIVE_ID from CRIMINAL_CASE where NUMBER = ?";
        CriminalCase result = jdbcTemplate.queryForObject(sql, rowMapper, caseNumber);
        return result == null ? Optional.empty() :  Optional.of(result);
    }

    @Override
    public void save(CriminalCase cc) {
        jdbcTemplate.update(
                "insert into CRIMINAL_CASE(ID, CASE_NUMBER, CASE_TYPE, STATUS, SHORT_DESCRIPTION, LEAD_INVESTIGATOR ) values(?,?,?,?,?,?,?)",
                cc.getId(), cc.getNumber(), cc.getType(), cc.getStatus(), cc.getShortDescription(), cc.getLeadInvestigator().getId()
        );
    }

    @Override
    public void delete(CriminalCase entity) {
        jdbcTemplate.update("delete from CRIMINAL_CASE where ID =? ", entity.getId());
    }

    @Override
    public int deleteById(Long entityId) {
        return jdbcTemplate.update("delete from CRIMINAL_CASE where ID =? ", entityId);
    }

    @Override
    public Set<CriminalCase> findByStatus(CaseStatus status) {
        return null;
    }

    @Override
    public Set<CriminalCase> findByType(CaseType type) {
        return null;
    }

    @Override
    public CriminalCase findByIdd(Long id) {
        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, NUMBER, CASE_TYPE, SHORT_DESCRIPTION," +
                "DETAILED_DESCRIPTION, CASE_STATUS, NOTES, DETECTIVE_ID from CRIMINAL_CASE where ID= ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
