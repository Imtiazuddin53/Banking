<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="customerhome.css">
<title>Insert title here</title>
</head>
<body>
<%  Customer customer=(Customer )request.getSession().getAttribute("customer");%>

 <div id="a">
 <h1>Hello:dear  <%=customer.getCname() %> </h1> 
    <a href="logout"><button style=" color: red;">Logout</button></a>
    <a href="customerHome.html"><button>Back</button></a>
    <div id="b">
    <h3>Select Accounttype</h3>
    <br>
  <form action="createbankaccount">
   <input type="radio" name="accounttype" value="savings" required="required"> Savings
   <input type="radio" name="accounttype" value="current" required="required" style="margin-left: 10px;"> Current<br><br>
   <button>Submit</button> <button type="reset">Cancel</button>
  </form>
</div></div>
</body>
</html>