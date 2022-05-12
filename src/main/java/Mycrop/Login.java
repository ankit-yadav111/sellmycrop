package Mycrop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Mycrop.bean.Loginbean;
import Mycrop.database.LoginDoa;
import verification.OtpGen;
import verification.SendEmail;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("Name");
		String pass=req.getParameter("Password");
		
		Loginbean lbean=new Loginbean();
		lbean.setId(id);
		lbean.setPass(Security.encode(pass));
		
		LoginDoa ldao =new LoginDoa();
		
		if(ldao.validate(lbean)) {
			try {
				if(ldao.verification(id)) {
				HttpSession session=req.getSession();
				session.setAttribute("email", id);
				res.sendRedirect("buyer.jsp");
}
				else {
					OtpGen otp= new OtpGen();
					String onetimepassword=otp.gen();
					SendEmail.email(id,onetimepassword);
					HttpSession session=req.getSession();
					session.setAttribute("email", id);
					session.setAttribute("otp", onetimepassword);
					res.sendRedirect("otp.jsp");
				}
			} catch (SQLException | IOException e) {
 				e.printStackTrace();
			}
			}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect Number or Password", "Error", JOptionPane.ERROR_MESSAGE);
			res.sendRedirect("login.jsp");
		}
	}
	}
