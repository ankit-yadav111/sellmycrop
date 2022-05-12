package Mycrop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mycrop.bean.Loginbean;

public class LoginDoa {
	
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
			loadDriver(dbDriver);
			con=DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validate(Loginbean lbean) {
		Connection con=getConnection();
		boolean status= false;
		String sql ="select Email_ID,Password from signup where Email_ID=? and Password=?";
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,lbean.getId());
			ps.setString(2, lbean.getPass());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	

	public boolean verification(String id) throws SQLException {
		Connection con=getConnection();
		boolean status= false;
		String sql ="select * from signup where Email_ID=? and Verify=?";
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setBoolean(2, true);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
}
