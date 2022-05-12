package Update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class buyerupdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crop=request.getParameter("crop");
		int price=Integer.parseInt(request.getParameter("price"));
		String contact=request.getParameter("num");
		String address=request.getParameter("add");
		int pin=Integer.parseInt(request.getParameter("pincode"));
		
		System.out.println();
		HttpSession s= request.getSession();
		String email=(String)s.getAttribute("email");
				
		beans a=new beans();
		a.setAddress(address);
		a.setContact(contact);
		a.setCrop(crop);
		a.setEmail(email);
		a.setPincode(pin);
		a.setPrice(price);
		s.setAttribute("email", email);
		dao d = new dao();
		if(d.validate(a)==false) {
				d.insert(a);}
		else {
			d.update(a);;
		}
		response.sendRedirect("buyer.jsp");
	}

}
