<%@page import="Dto.Customer"%>
<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Activeacount.css">
<title>Insert title here</title>
</head>
<body>
<%  Customer customer=(Customer )request.getSession().getAttribute("customer");%>

 
 
<div id="a">
    <h1 style="color: azure;">Welcome to active account page</h1>
    

 
 <h1 style="color: white;">Hello:dear  <%=customer.getCname() %> </h1> 
<div id="b">
<%List<Bank_account>list=(List<Bank_account>)request.getSession().getAttribute("acctive_account"); 
if(list.isEmpty())
{%>
<h1>No_accounts_found</h1>
<%}else { %>
<h1 style="color: azure;">Select bank accout</h1>
<%for(Bank_account bank_account :list) {%>

<a href="setactiveaccount?acno=<%=bank_account.getAcc_no()%>"><button><%=bank_account.getAcc_no() %></button></a>
<br>
<%} %>
<a href="customerHome.html"><button>Back</button></a>
<%} %>
</div></div>
</body>
</html>