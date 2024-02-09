package Controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Bank_account;
import Dto.Customer;
@WebServlet("/Fetch_ActiveAccount")
public class Fetch_ActiveAccount extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Customer customer=(Customer)req.getSession().getAttribute("customer");
List<Bank_account> list=customer.getBankaccounts();
List<Bank_account> list2=new ArrayList<Bank_account>();
for(Bank_account bank_account : list) {
	if(bank_account.isStatus()) {
		System.out.println("ststus is active");
		list2.add(bank_account);
	}
}
req.getSession().setAttribute("acctive_account", list2);
req.getRequestDispatcher("ActiveAccount.jsp").include(req, resp);
}
}
