package criminal.dao.jdbc;

import criminal.dao.ICriminalCaseDAO;
import criminal.model.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalCaseDAO implements ICriminalCaseDAO  {
    public final static String URL = "jdbc:mysql://localhost:3306/evidencedb";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "haku1404";

    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public void delete(long id) {

    }

    @Override
    public void save(CriminalCase criminalCase) {
//        try (Connection con = DatabaseUtility.getConnection();
//             PreparedStatement stm = con.prepareStatement("INSERT INTO criminal_case\n" +
//                     "           (id\n" +
//                     "           ,version\n" +
//                     "           ,shortDescription\n" +
//                     "           ,detailedDescription\n" +
//                     "     VALUES\n" +
//                     "           (?\n" +
//                     "           ,?\n" +
//                     "           ,?\n" +
//                     "           ,?)");
//
//             stm.setLong(1, criminalCase.getId());
//             stm.setInt(2, criminalCase.getVersion());
//             stm.setString(3, criminalCase.getShortDescription());
//             stm.setString(4, criminalCase.getDetailedDescription());
//             stm.executeUpdate();
//        } catch (SQLException ex){
//        logger.error(ex.toString());
//        }
    }



    @Override
    public Optional<CriminalCase> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM criminal_case");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CriminalCase criminalCase = DatabaseMapper.get(rs);
                if (criminalCase != null) criminalCases.add(criminalCase);
            } // end of while
//        } catch (SQLException e) {
//            logger.error(e.toString());
        } // end of try-with-resources
        catch (Exception ex) {
            logger.error(ex.toString());
        }
        return criminalCases;
    }

    @Override
    public void update(CriminalCase criminalCase) {

    }

    @Override
    public void delete(CriminalCase criminalCase) {

    }
}
