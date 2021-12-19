package server;

public class Datos {

	private String driver_JDBC;
	private String url_JDBC;
	private String usu_JDBC;
	private String pass_JDBC;
	private String db_DJBC;

	public Datos(String db) {
		driver_JDBC = "com.mysql.cj.jdbc.Driver";
		url_JDBC = "jdbc:mysql://localhost/";
		usu_JDBC = "root";
		pass_JDBC = "";
		db_DJBC = db;
	}

	/* GETTERS & SETTERS */

	public String getDriver_JDBC() {
		return driver_JDBC;
	}

	public String getUrl_JDBC() {
		return url_JDBC;
	}

	public String getUsu_JDBC() {
		return usu_JDBC;
	}

	public String getPass_JDBC() {
		return pass_JDBC;
	}

	public String getDb_DJBC() {
		return db_DJBC;
	}

}
