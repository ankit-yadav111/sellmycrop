package Mycrop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mycrop.bean.signupbean;

public class signupdao {
	
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
	
	public void insert(signupbean sbean) {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String sql ="insert into signup values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, sbean.getName());
			ps.setString(2, sbean.getId());
			ps.setString(3, sbean.getState());
			ps.setString(4, sbean.getAddress());
			ps.setInt(5, sbean.getPin());
			ps.setString(6, sbean.getPass());
			ps.setBoolean(7, false);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean validate(signupbean sbean) {
		loadDriver(dbDriver);
		Connection con=getConnection();
		boolean status= false;
		String sql ="select Email_ID from signup where Email_ID=?";
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,sbean.getId());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
}
