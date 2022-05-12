package Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class dao {
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
	
	public void insert(beans sbean) {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String sql;
		if(sbean.getCrop().equals("Rice")) {
		 sql ="insert into Rice values (?,?,?,?,?,?)";
		}
		else {
			 sql="insert into Wheat values (?,?,?,?,?,?)";
		}
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, sbean.getEmail());
			ps.setString(2, sbean.getCrop());
			ps.setInt(3, sbean.getPrice());
			ps.setString(4, sbean.getAddress());
			ps.setInt(5, sbean.getPincode());
			ps.setString(6, sbean.getContact());
			ps.execute();
			
			ps.close();
            con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean validate(beans sbean) {
		loadDriver(dbDriver);
		Connection con=getConnection();
		boolean status= false;
		String sql;
		
		if(sbean.getCrop().equals("Rice")) {
			   sql ="select Email_ID from rice where Email_ID=?";
			}
			else {
				sql ="select Email_ID from wheat where Email_ID=?";
			}
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,sbean.getEmail());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			ps.close();
            con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	

	public void update(beans sbean) {
		
		loadDriver(dbDriver);
		Connection con=getConnection();
		String sql;
		if(sbean.getCrop().equals("Rice")) {
			   sql ="UPDATE Rice SET Price=?, Address=?, Pincode=?,Contact=? WHERE Email_ID=?";
			}
			else {
				sql ="UPDATE Wheat SET Price=?, Address=?, Pincode=?,Contact=? WHERE Email_ID=?";
			}
		
		
		try {
			PreparedStatement ps;
			ps=con.prepareStatement(sql);
			ps.setInt(1, sbean.getPrice());
			ps.setString(2, sbean.getAddress());
			ps.setInt(3, sbean.getPincode());
			ps.setString(4, sbean.getContact());
			ps.setString(5,sbean.getEmail());
			
			ps.executeUpdate();
			
			ps.close();
            con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
