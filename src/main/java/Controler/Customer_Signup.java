package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Customer_dao;
import Dto.Customer;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;                                                                





@WebServlet("/customersignup")
public class Customer_Signup extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String name = req.getParameter("name");
	String mobile = req.getParameter("mobi");

	long mob = Long.parseLong(mobile);
	String password = req.getParameter("pwd");
	String email = req.getParameter("email");
	String Gender = req.getParameter("gender");
	String dob = req.getParameter("dob");

//	System.out.println("Customer's details are below:-");// it is print to the console.//
//	System.out.println("------------------------------");
//	System.out.println("Name" + " : " + name);
//	System.out.println("Mobile" + " : " + mobile);
//	System.out.println("Password" + " : " + password);
//	System.out.println("Email id" + " : " + email);
//	System.out.println("Gender" + " : " + Gender);
//	System.out.println("DOB" + " : " + dob);

	/*
	 * arg1.getWriter().print("<h1>Customer's details are below:-</h1>" +
	 * "<h1>---------------------------------------</h1>" +
	 * "<h1>"+"Name"+" : "+name+"</h1>" + "<h1>"+"Mobile"+" : "+mobile+"</h1>" +
	 * "<h1>"+"Password"+" : "+password+"</h1>" +
	 * "<h1>"+"Email id"+" : "+email+"</h1>" + "<h1>"+"Gender"+" : "+Gender+"</h1>"
	 * + "<h1>"+"DOB"+" : "+dob+"</h1>" );
	 */
	Date date = Date.valueOf(dob); // converted string to //

	Period period = Period.between(date.toLocalDate(), LocalDate.now());
	int age = period.getYears();
	
Customer  customer =new Customer();
	
	Customer_dao customer_dao=new Customer_dao();
	String massage1;
	String massage2;
	String massage3;
	String sError;
	if (age > 18) {
//		resp.getWriter()
//				.print("<h1>You are is" + " " + age + " , " + "so you are elijible to create a bank account.</h1>");
if(customer_dao.check1(email).isEmpty() && customer_dao.check2(mob).isEmpty()) {
		customer.setCname(name);
		customer.setEmail(email);
		customer.setGender(Gender);
		customer.setMob(mob);;
		customer.setDate(date);
		customer.setPwd(password);

		customer_dao.save(customer);
		Customer customer2 =customer_dao.check1(email).get(0);
		
		//Customer customer2= list.get(0);
if(customer2.getGender().equals("female")) {
	
	massage1="Hello madam";
	
                                          }

else {
	           massage1="Hello sir";
	
     }
massage2="You are successfully created your bank account";
massage3="Your account no "+customer2.getCid();
ArrayList list=new ArrayList();
list.add(massage1);
list.add(massage2);
list.add(massage3);
req.getSession().setAttribute("signmasage", list);
req.getRequestDispatcher("customerLogin.jsp").include(req, resp);

	                                                                                 }
	else {
		//resp.getWriter().print("<h1>Either email : "+email+" or mobile number : "+mob+" already exists</h1>");
		sError="Either email : "+email+" or mobile number : "+mob+" already exists";
		req.getSession().setAttribute("sError", sError);


req.getRequestDispatcher("Signup.jsp").include(req, resp);
	      }
               }
	else {
		//resp.getWriter().print("Your age is" + " " + age + " , " + "so you are not elijible to create a bank account.</h1>");
		sError="Your age is" + " " + age + " , " + "so you are not elijible to create a bank account.";
		req.getSession().setAttribute("sError", sError);
		
		req.getRequestDispatcher("Signup.jsp").include(req, resp);
	    }

    }
	}
