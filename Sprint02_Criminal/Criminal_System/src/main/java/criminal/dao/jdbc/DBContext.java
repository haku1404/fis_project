package criminal.dao.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DBContext {
    public static ComboPooledDataSource getDataSource()
            throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/evidencedb");
        cpds.setUser("root");
        cpds.setPassword("haku1404");

        // Optional Settings
        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);

        return cpds;
    }

    public static Connection getConnection() throws Exception {

        // C3P0 Connection Pool
        Connection connection = getDataSource().getConnection();

        return connection;
    }
}
