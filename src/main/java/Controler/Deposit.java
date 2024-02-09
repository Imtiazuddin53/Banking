package Controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankTransaction;
import Dto.Bank_account;
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String amt=req.getParameter("amnt");
	double amount=Double.parseDouble(amt);
	long acno=(long) req.getSession().getAttribute("ac_number");
	BankDao bankDao=new BankDao();
	Bank_account bank_account=bankDao.fatch_account_Ditails(acno);
	bank_account.setAmount(bank_account.getAmount()+amount);
	bankDao.update_account_ditails(bank_account);
	
	
	BankTransaction bankTransaction=new BankTransaction();
	bankTransaction.setDeposit(amount);
	bankTransaction.setWithdraw(0);
	bankTransaction.setBalance(bank_account.getAmount());
	bankTransaction.setDate_time(LocalDateTime.now());
	
	
	List<BankTransaction>TransactionList=bank_account.getList();
	TransactionList.add(bankTransaction);
	bank_account.setList(TransactionList);
	
	bankDao.update_account_ditails(bank_account);
	resp.getWriter().print("<h1>amount deposited successfully</h1>");
	req.getRequestDispatcher("account_home.html").include(req, resp);
}
}
