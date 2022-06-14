package criminal.dao.jdbc;

import criminal.dao.ICriminalCaseDAO;
import criminal.model.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.Date;

public class JDBCCriminalCaseDAO extends DBContext implements ICriminalCaseDAO {
    public static Connection connection;

    static {
        try {
            connection = DBContext.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public void delete(long id) {
        try {
            String sql = "DELETE FROM criminal_case where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public void save(CriminalCase criminalCase) {
        try {
            String sql = "INSERT INTO criminal_case\n" +
                    "           (id\n" +
                    "           ,version\n" +
                    "           ,createdAt\n" +
                    "           ,modifiedAt\n" +
                    "           ,number\n" +
                    "           ,shortDescription\n" +
                    "           ,detailedDescription\n" +
                    "           ,notes)\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, criminalCase.getId());
            stm.setInt(2, criminalCase.getVersion());
            stm.setString(3, criminalCase.getCreatedAt().toString());
            stm.setString(4, criminalCase.getCreatedAt().toString());
            stm.setString(5, criminalCase.getNumber());
            stm.setString(6, criminalCase.getShortDescription());
            stm.setString(7, criminalCase.getDetailedDescription());
            stm.setString(8, criminalCase.getNotes());
            stm.executeUpdate();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }


    @Override
    public CriminalCase getById(long id) {
        try {
            String sql = "SELECT id, version, createdAt, modifiedAt, number, shortDescription, detailedDescription," +
                    "notes from criminal_case WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CriminalCase c = new CriminalCase();
                c.setId(rs.getLong("id"));
                c.setVersion(rs.getInt("version"));
                c.setCreatedAt(LocalDateTime.now());
                c.setModifiedAt(LocalDateTime.now());
                c.setShortDescription(rs.getString("shortDescription"));
                c.setDetailedDescription(rs.getString("detailedDescription"));
                c.setNotes(rs.getString("notes"));
                return c;
            }

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        try {
            String sql = "SELECT * FROM criminal_case";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(rs.getLong("id"));
                criminalCase.setVersion(rs.getInt("version"));
                criminalCase.setNumber(rs.getString("number"));
                criminalCase.setShortDescription(rs.getString("shortDescription"));
                criminalCase.setDetailedDescription(rs.getString("detailedDescription"));
                criminalCase.setNotes(rs.getString("notes"));
                criminalCases.add(criminalCase);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return criminalCases;
    }

    @Override
    public void update(CriminalCase criminalCase) {
        try {
            String sql = "UPDATE criminal_case\n"
                    + "   SET version = ?\n"
                    + "      ,createdAt = ?\n"
                    + "      ,modifiedAt = ?\n"
                    + "      ,number = ?\n"
                    + "      ,shortDescription = ?\n"
                    + "      ,longDescription = ?\n"
                    + "      ,notes = ?\n"
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(7, criminalCase.getId());
            stm.setInt(1, criminalCase.getVersion());
            stm.setString(2, criminalCase.getCreatedAt().toString());
            stm.setString(3, criminalCase.getModifiedAt().toString());
            stm.setString(4, criminalCase.getNumber());
            stm.setString(5, criminalCase.getShortDescription());
            stm.setString(6, criminalCase.getDetailedDescription());
            stm.setString(7, criminalCase.getNotes());
            stm.executeUpdate();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

    }

    @Override
    public ArrayList<CriminalCase> search(int version) {
        ArrayList<CriminalCase> criminalCases = new ArrayList<>();
        try {
            String sql = "SELECT criminal_case.id, criminal_case.version, criminal_case.number, " +
                    "criminal_case.shortDescription, criminal_case.detailedDescription,\n" +
                    "criminal_case.notes FROM criminal_case WHERE (1=1) ";

            HashMap<Integer, Object[]> params = new HashMap<>();
            int paramIndex = 0;

            if (version != -1) {
                sql += "AND criminal_case.id = ?";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = version;
                params.put(paramIndex, param);
            }


            PreparedStatement stm = connection.prepareStatement(sql);

            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Integer.class.getName())) {
                    stm.setInt(index, Integer.parseInt(value[1].toString()));
                } else if (type.equals(String.class.getName())) {
                    stm.setString(index, value[1].toString());
                } else if (type.equals(Date.class.getName())) {
                    stm.setDate(index, (Date) value[1]);
                } else if (type.equals(Boolean.class.getName())) {
                    stm.setBoolean(index, (Boolean) value[1]);
                }
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(rs.getLong("id"));
                criminalCase.setVersion(rs.getInt("version"));
                criminalCase.setNumber(rs.getString("number"));
                criminalCase.setShortDescription(rs.getString("shortDescription"));
                criminalCase.setDetailedDescription(rs.getString("detailedDescription"));
                criminalCase.setNotes(rs.getString("notes"));
                criminalCases.add(criminalCase);
            }

        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return criminalCases;
    }
}
