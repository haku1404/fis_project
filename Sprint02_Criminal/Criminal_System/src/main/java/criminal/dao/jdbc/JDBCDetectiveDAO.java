package criminal.dao.jdbc;

import criminal.dao.IDetectiveDAO;
import criminal.model.CriminalCase;
import criminal.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO extends DBContext implements IDetectiveDAO {

    public static Connection connection;

    static {
        try {
            connection = DBContext.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public void save(Detective detective) {
        try {
            String sql = "INSERT INTO detective\n" +
                    "           (id\n" +
                    "           ,version\n" +
                    "           ,createdAt\n" +
                    "           ,modifiedAt\n" +
                    "           ,hiringDate\n" +
                    "           ,username\n" +
                    "           ,firstName\n" +
                    "           ,lastName\n" +
                    "           ,password\n" +
                    "           ,badgeNumber\n" +
                    "           ,armed)\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, detective.getId());
            stm.setInt(2, detective.getVersion());
            stm.setString(3, detective.getCreatedAt().toString());
            stm.setString(4, detective.getModifiedAt().toString());
            stm.setString(5, detective.getHiringDate().toString());
            stm.setString(6, detective.getUsername());
            stm.setString(7, detective.getFirstName());
            stm.setString(8, detective.getLastName());
            stm.setString(9, detective.getPassword());
            stm.setString(10, detective.getBadgeNumber());
            stm.setBoolean(11, detective.getArmed());
            stm.executeUpdate();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public Detective getById(long id) {
        try {
            String sql = "SELECT id, version, createdAt, modifiedAt, hiringDate, username, firstName, lastName," +
                    "password, badgeNumber, armed from detective WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Detective d = new Detective();
                d.setId(rs.getLong("id"));
                d.setVersion(rs.getInt("version"));
                d.setCreatedAt(LocalDateTime.now());
                d.setModifiedAt(LocalDateTime.now());
                d.setHiringDate(LocalDateTime.now());
                d.setUsername(rs.getString("username"));
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setPassword(rs.getString("password"));
                d.setBadgeNumber(rs.getString("badgeNumber"));
                d.setArmed(rs.getBoolean("armed"));
                return d;
            }

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public List<Detective> getAll() {
        List<Detective> detectives = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detective";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Detective detective  = new Detective();
                detective.setId(rs.getLong("id"));
                detective.setVersion(rs.getInt("version"));
                detective.setUsername(rs.getString("username"));
                detective.setFirstName(rs.getString("firstName"));
                detective.setLastName(rs.getString("lastName"));
                detective.setBadgeNumber(rs.getString("badgeNumber"));
                detective.setArmed(rs.getBoolean("armed"));
                detectives.add(detective);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return detectives;
    }

    @Override
    public void update(Detective detective) {
        try {
            String sql = "UPDATE criminal_case\n"
                    + "   SET version = ?\n"
                    + "      ,createdAt = ?\n"
                    + "      ,modifiedAt = ?\n"
                    + "      ,hiringDate = ?\n"
                    + "      ,username = ?\n"
                    + "      ,firstName = ?\n"
                    + "      ,lastName = ?\n"
                    + "      ,password = ?\n"
                    + "      ,badgeNumber = ?\n"
                    + "      ,armed = ?\n"
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(11, detective.getId());
            stm.setInt(1, detective.getVersion());
            stm.setString(2, detective.getCreatedAt().toString());
            stm.setString(3, detective.getModifiedAt().toString());
            stm.setString(4, detective.getHiringDate().toString());
            stm.setString(5, detective.getUsername());
            stm.setString(6, detective.getFirstName());
            stm.setString(7, detective.getLastName());
            stm.setString(8, detective.getPassword());
            stm.setString(9, detective.getBadgeNumber());
            stm.setBoolean(10, detective.getArmed());
            stm.executeUpdate();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

    }

    @Override
    public void delete(long id) {
        try {
            String sql = "DELETE FROM detective where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

    }

}
