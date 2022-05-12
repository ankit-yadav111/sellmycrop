package DeleteData;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/remove")
public class del extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crop=request.getParameter("crop");
		HttpSession session=request.getSession();
		String email = (String) session.getAttribute("email");
		
	   int opt= JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record","Delete", JOptionPane.YES_NO_OPTION);
		if(opt==0) {
			dao d= new dao();
			try {
				d.delete(crop, email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			session.removeAttribute("crop");
			response.sendRedirect("buyer.jsp");
	}

}
