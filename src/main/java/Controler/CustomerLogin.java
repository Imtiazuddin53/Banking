package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Customer_dao;
import Dto.Customer;

@WebServlet("/customerLogin")
public class CustomerLogin extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid=req.getParameter("custid");
		int customerid=Integer.parseInt(cid);
		String password=req.getParameter("pwd");
		
		Customer_dao customer_dao=new Customer_dao();
	Customer customer= customer_dao.login(customerid);
	String masage;
		if(customer==null) {
			//resp.getWriter().print("<h1>Invalid cust id</h1>");
			masage="Invalid cust id";
			req.getSession().setAttribute("masage", masage);
			req.getRequestDispatcher("customerLogin.jsp").include(req, resp);
			//req.getRequestDispatcher("customerLogin.html").include(req, resp);
		}
		else {
			if(customer.getPwd().equals(password)) {
				
				
				//session tracking
				req.getSession().setAttribute("customer", customer);  //it is used to store or set the information of customer 
			
			req.getRequestDispatcher("customerHome.html").include(req, resp);

			
			}
			else {
			//	resp.getWriter().print("<h1>Invalid Password</h1>");
				masage="Invalid cust password";
				req.getSession().setAttribute("masage", masage);
				req.getRequestDispatcher("customerLogin.jsp").include(req, resp);
				
				//req.getRequestDispatcher("customerLogin.html").include(req, resp);
			}
		}
		
	}
}
