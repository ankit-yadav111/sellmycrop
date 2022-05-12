package Otp_verfi;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Newpass.Database;


@WebServlet("/otp")
public class otp_login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session=request.getSession();
		String id =(String) session.getAttribute("email");
		String otp =(String) session.getAttribute("otp");
		String code=request.getParameter("code");
		if(otp.equals(code)) {
			
			Database database = new Database();
			try {
				database.verify(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Verified Successfully", "Info:", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("login.jsp");
			session.removeAttribute("email");
			session.invalidate();
		}
		else {
			JOptionPane.showMessageDialog(null, "Incoreect Code", "Info:", JOptionPane.INFORMATION_MESSAGE);
			session.setAttribute("email", id);
			session.setAttribute("otp", otp);
			response.sendRedirect("otp.jsp");
		}
	}
}