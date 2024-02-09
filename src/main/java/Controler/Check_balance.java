package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BankDao;
import Dto.Bank_account;
@WebServlet("/check_balance")
public class Check_balance extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Long  acnumber =(Long) req.getSession().getAttribute("ac_number");
	BankDao bankDao=new BankDao();
	Bank_account bank_account=bankDao.fatch_account_Ditails(acnumber);
	
	resp.getWriter().print("<h1>your current balance is "+bank_account.getAmount()+"</h1>");
	
}
}
