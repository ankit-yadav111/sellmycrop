package Otp_verfi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/otp1")
public class otp_forgetpasssword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String otp = (String) session.getAttribute("otp");
		String id = (String) session.getAttribute("email");
		String code=request.getParameter("code");
		session.setAttribute("email", id);
		if(otp.equals(code)) {
			response.sendRedirect("newpassword.jsp");
		}
		else {
		JOptionPane.showMessageDialog(null, " Incorrect ", "Info:", JOptionPane.INFORMATION_MESSAGE);
		session.setAttribute("otp", otp);
		response.sendRedirect("otp1.jsp");
		}
	}

}
