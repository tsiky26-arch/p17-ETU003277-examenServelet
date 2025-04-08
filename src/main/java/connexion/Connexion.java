package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static final String URL = "jdbc:mysql://172.80.237.53/db_s2_ETU003277";
    private static final String USER = "ETU003277";
    private static final String PASSWORD = "GqQcXYbt";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD); 
    }

    public static void disconnect(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close(); 
        }
    }
}