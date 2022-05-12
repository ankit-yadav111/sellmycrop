package Newpass;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/newpassword")
public class password extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id= (String) session.getAttribute("email");
		String pass=request.getParameter("pass");
		String confirm=request.getParameter("confirm");
		if(pass.equals(confirm)) {
			Database database = new Database();
			try {
				database.newpassword(id, pass);
				session.removeAttribute("email");
				session.invalidate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
		session.setAttribute("eamil", id);
     	response.sendRedirect("newpassword.jsp");
		
	}

}
