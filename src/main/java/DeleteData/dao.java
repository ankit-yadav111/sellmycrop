package DeleteData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
		public void delete(String crop, String email) throws SQLException {
			
			loadDriver(dbDriver);
			Connection con=getConnection();
			String sql;
			if(crop.equals("Rice")) {
			 sql ="delete from rice where Email_ID=?";
			}
			else {
				 sql="delete from wheat where Email_ID=?";
			}
			
			PreparedStatement ps;
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			ps.execute();
			
			ps.close();
            con.close();
			
		}
}
