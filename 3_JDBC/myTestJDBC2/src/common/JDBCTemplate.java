package common;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn == null) {
			try {
				Properties prop = new Properties();
				prop.load(new FileReader("driver.properties"));
				Class.forName(prop.getProperty("driver"));

				conn = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("user"), prop.getProperty("password"));
				
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void rollBack(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}