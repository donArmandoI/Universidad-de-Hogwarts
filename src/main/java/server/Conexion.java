package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Conexion {

	private Connection conn;
	private Statement state;
	private ResultSet rs;

	public Conexion() {
	}

	public void startConnection(String driver, String url, String bd, String usu, String pass) {
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url + bd, usu, pass);
			state = conn.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int setExecuteUpdate(String sql) {
		try {

			return state.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void setResultSet(String sql) {
		try {
			this.rs = state.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public Statement getState() {
		return state;
	}

	public ResultSet getRs() {
		return rs;
	}

}
