package Mycrop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Mycrop.database.forgetdao;
import verification.OtpGen;
import verification.SendEmail;

@WebServlet("/forgetpassword")
public class forgetpassword extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("num");
		
		forgetdao fdao = new forgetdao();
		if(fdao.validate(id)) {
			OtpGen otp= new OtpGen();
			String onetimepassword=otp.gen();
			SendEmail.email(id,onetimepassword);
			HttpSession session=request.getSession();
			session.setAttribute("email", id);
			session.setAttribute("otp", onetimepassword);
			response.sendRedirect("otp1.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect Email ID:", "Info:", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("forgetpassword.jsp");
		}
	}

}
