package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectionConfiguration {
	
    String dbURL = "jdbc:mysql://192.185.4.105:3306/rigarcia_proyecto";
	String username = "rigarcia_proyect";
	String password = "proyecto";
 
    public static Connection getConnection() {
		Connection conn = null;
        try{
			conn = DriverManager.getConnection(dbURL, username, password)
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return conn;
    }
 
}