package cisproject.OnlineTextBasedRPG;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	public static void server() throws Exception {
		DataBase db = connectDataBase();
		// stuff in?
		ServerSocket ss;
		System.out.println("Server is running...");
		ss = new ServerSocket(6666);
		
		Socket s = ss.accept();
		s.close();
		
		ss.close();
		closeDataBase(db);
	}
	
	public static class DataBase {
		Connection conn;
		Statement stmt;

		public DataBase(Connection conn, Statement stmt) {
			this.conn = conn;
			this.stmt = stmt;
		}
	}

	public static DataBase connectDataBase() { //modified example from internet, not really understand yet
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			System.out.println("Creating database...");
			String sql = "CREATE DATABASE STUDENTS";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DataBase db = new DataBase(conn, stmt);
		return db;
	}

	public static void closeDataBase(DataBase db) {
		Connection conn = db.conn;
		Statement stmt = db.stmt;
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
