package Controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankTransaction;
import Dto.Bank_account;
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String amo=req.getParameter("amount");
	double amount=Double.parseDouble(amo);
	Long  acnumber =(Long) req.getSession().getAttribute("ac_number");
	BankDao bankDao=new BankDao();
	Bank_account bank_account=bankDao.fatch_account_Ditails(acnumber);
	if(bank_account.getAmount()<amount) {
		resp.getWriter().print("<h1>Insufient balance   your available balance is : "+bank_account.getAmount()+"</h1>");
		
	}
	else {
		if(bank_account.getAcc_limit()<amount) {
			
			resp.getWriter().print("<h1>you are try to withdraw more than account limit your account limit is "+bank_account.getAcc_limit()+"</h1>");
		}
		else {
			bank_account.setAmount(bank_account.getAmount()-amount);
			
			bankDao.update_account_ditails(bank_account);
			
			BankTransaction bankTransaction=new BankTransaction();
			bankTransaction.setDeposit(0);
			bankTransaction.setWithdraw(amount);
			bankTransaction.setBalance(bank_account.getAmount());
			bankTransaction.setDate_time(LocalDateTime.now());
			
			
			List<BankTransaction>TransactionList=bank_account.getList();
			TransactionList.add(bankTransaction);
			bank_account.setList(TransactionList);
			bankDao.update_account_ditails(bank_account);
			resp.getWriter().print("<h1>amount withdraw successfully</h1>");
			req.getRequestDispatcher("account_home.html").include(req, resp);
		}
	}
	
	}
}
