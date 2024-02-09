package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;
@WebServlet("/changestatus")
public class Change_status extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String acc_no=	req.getParameter("acno");
	long Acc_no=Long.parseLong(acc_no);
	BankDao bankDao=new BankDao();
	Bank_account bank_account =bankDao.fatch_account_Ditails(Acc_no);
	if(bank_account.isStatus()) {
		bank_account.setStatus(false);
	}
	else {
		bank_account.setStatus(true);
	}
	bankDao.update_account_ditails(bank_account);
	List<Bank_account>list=bankDao.fatchAll();
	req.getSession().setAttribute("list", list);
	req.getRequestDispatcher("adminhome.jsp").include(req, resp);	
	}
}
