package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {
	
public Connection dbcon() throws SQLException {
	
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","username","password");
		
		return con;
		
	}
}
