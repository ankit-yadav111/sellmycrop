package Newpass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	
	private String dbUrl ="jdbc:mysql://localhost:3306/login";
	private String dbUname ="root";
	private String dbPassword ="Password@959988";
	private String dbDriver ="com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void newpassword(String id,String pass) throws SQLException {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String sql = "update signup set password=? where Email_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, pass);
		ps.setString(1, id);
		ps.executeUpdate();
	}
	public void verify(String id) throws SQLException {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String sql="update signup set verify=true where Email_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
	}
	
}
