package Mycrop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Mycrop.bean.signupbean;
import Mycrop.database.signupdao;
import verification.OtpGen;
import verification.SendEmail;
@WebServlet("/signup")
public class signup extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String add=req.getParameter("add");
		String state=req.getParameter("state");
		String pass=req.getParameter("pass");
		String confirm=req.getParameter("confirm");
		String mail=req.getParameter("mail");
		int pin=Integer.parseInt((req.getParameter("pincode")));
		
		signupbean sbean=new signupbean();
		sbean.setName(name);
		sbean.setId(mail);
		sbean.setState(state);
		sbean.setAddress(add);
		sbean.setPin(pin);
		sbean.setPass(Security.encode(pass));
		signupdao sdao = new signupdao();
	    if(pass.equals(confirm)) {
		    if(sdao.validate(sbean)) {
		    	JOptionPane.showMessageDialog(null, "Already Registered", "Error", JOptionPane.ERROR_MESSAGE);
		    	res.sendRedirect("signup.jsp");
		   }
		 else {
			OtpGen otp= new OtpGen();
			String onetimepassword=otp.gen();
			sdao.insert(sbean);
			SendEmail.email(mail,onetimepassword);
			HttpSession session=req.getSession();
			session.setAttribute("email", mail);
			session.setAttribute("otp", onetimepassword);
			res.sendRedirect("otp.jsp"); 
	    }
		 }
	    else {
     	JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
     	res.sendRedirect("signup.jsp");
	    }

	}

}
