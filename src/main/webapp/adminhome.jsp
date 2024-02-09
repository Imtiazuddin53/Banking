<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body style="margin: 50px;">
<%List<Bank_account>list=(List<Bank_account>)request.getSession().getAttribute("list");%>

<a href="Home.html">Home</a>
<table class="table" >
<thead>
<tr>
<th>Account_number</th>
<th>Account_Type</th>
<th>Account_name</th>
<th>Account_id</th>
<th>Account_status</th>
<th>Change_status</th>
</tr>
</thead>
<%for(Bank_account bank_account :list) {%>
<tbody>
<tr>
<th><%=bank_account.getAcc_no() %></th>
<th><%=bank_account.getAccount_type() %></th>
<th><%=bank_account.getCustomer().getCname() %></th>
<th><%=bank_account.getCustomer().getCid() %></th>
<th><%=bank_account.isStatus() %></th>
<th><a href="changestatus?acno=<%=bank_account.getAcc_no()%>"><button>Change_status</button> </a></th>
</tr>
</tbody>
<%} %>
</table>
</body>
</html>