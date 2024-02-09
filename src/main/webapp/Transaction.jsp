<%@page import="Dto.Customer"%>
<%@page import="Dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body style="margin: 50px " >
<%   Long no   =(Long)request.getSession().getAttribute("ac_number"); 
BankDao bankDao=new BankDao();
 Bank_account bank_account =bankDao.fatch_account_Ditails(no);
List<BankTransaction>list=bank_account.getList();
%>

<h1>Transaction History</h1>
<%  Customer customer=(Customer )request.getSession().getAttribute("customer");%>

 
 <h1>Hello:dear  <%=customer.getCname() %> </h1> 
<table class="table" border="2px">
<thead>
<tr>
<th>Tid</th>
<th>Withdraw</th>
<th>Deposit</th>

<th>Balance</th>
<th>Transaction time</th>
</tr>
</thead>
<%for(BankTransaction bankTransaction :list) {%>
<tbody>
<tr>
<th><%= bankTransaction.getTid()%></th>
<th><%= bankTransaction.getWithdraw()%></th>
<th><%= bankTransaction.getDeposit()%></th>
<th><%= bankTransaction.getBalance()%></th>
<th><%= bankTransaction.getDate_time()%></th>

</tr>
</tbody>
<%} %>
</table>
<a href="account_home.html"><button>Back</button></a>
</body>
</html>