package criminal.repository.jdbc;


import criminal.model.entity.Detective;
import criminal.model.enums.Rank;
import criminal.model.mapper.DetectiveRowMapper;
import criminal.repository.DetectiveRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


//@Transactional
@Repository
public class JdbcDetectiveRepo extends JdbcAbstractRepo<Detective>
        implements DetectiveRepo {

    private RowMapper<Detective> rowMapper = new DetectiveRowMapper();

    public JdbcDetectiveRepo(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<Detective> findById(Long id) {
        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, HIRING_DATE, USERNAME, FIRST_NAME, LAST_NAME," +
                " PASSWORD, RANK1, BADGE_NUMBER, ARMED, STATUS, CRIMINAL_CASE_ID, TRACK_ENTRY_ID from DETECTIVE" +
                " where ID= ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, HIRING_DATE, USERNAME, FIRST_NAME, LAST_NAME," +
                " PASSWORD, RANK1, BADGE_NUMBER, ARMED, STATUS, CRIMINAL_CASE_ID, TRACK_ENTRY_ID from DETECTIVE" +
                " where BADGE_NUMBER like '%?1%'";
        Detective detective = jdbcTemplate.queryForObject(sql, rowMapper, badgeNumber);
        return Optional.of(detective);
    }

    @Override
    public void save(Detective detective) {
        jdbcTemplate.update(
                "insert into DETECTIVE(ID, VERSION, CREATED_AT, MODIFIED_AT, HIRING_DATE, USERNAME, FIRST_NAME," +
                        " LAST_NAME, PASSWORD, BADGE_NUMBER, ARMED, STATUS, CRIMINAL_CASE_ID, TRACK_ENTRY_ID)" +
                        " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                detective.getId(), detective.getVersion(), detective.getCreatedAt(), detective.getModifiedAt(),
                detective.getHiringDate(), detective.getUsername(), detective.getFirstName(),
                detective.getLastName(), detective.getPassword(), detective.getBadgeNumber(),
                detective.getArmed(), detective.getStatus(), detective.getCriminalCases(), detective.getTrackEntries()
        );
    }

    @Override
    public Set<Detective> findAll() {
//        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, HIRING_DATE, USERNAME, FIRST_NAME, LAST_NAME," +
//                " PASSWORD, RANK1, BADGE_NUMBER, ARMED, STATUS, CRIMINAL_CASE_ID, TRACK_ENTRY_ID from DETECTIVE";
        String sql = "select * from detective";
        return new HashSet<>(jdbcTemplate.query(sql, rowMapper));
    }

    @Override
    public Set<Detective> findbyRank(String rank) {
        String sql = "select ID, VERSION, CREATED_AT, MODIFIED_AT, HIRING_DATE, USERNAME, FIRST_NAME, LAST_NAME, " +
                "PASSWORD, RANK1, BADGE_NUMBER, ARMED, STATUS, CRIMINAL_CASE_ID, TRACK_ENTRY_ID from DETECTIVE " +
                "where RANK1 like '%?1%'";
        return new HashSet<>(jdbcTemplate.query(sql, rowMapper, rank));
    }

    @Override
    public void delete(Detective entity) {
        jdbcTemplate.update("delete from DETECTIVE where ID =? ", entity.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from DETECTIVE where ID =? ", id);
    }
}
