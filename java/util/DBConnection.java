package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	public static Connection getConnection(String connectionString) throws SQLException {
		if(conn==null || conn.isClosed()) {
			conn=DriverManager.getConnection(connectionString);
		}
		return conn;
	}
}
