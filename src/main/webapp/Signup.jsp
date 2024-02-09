<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Signup.css">
<title>Insert title here</title>
</head>
<body>

 <div id="a">
        <%String msg=(String)request.getSession().getAttribute("sError");
        if(msg!=null)
        	{%>
        	<h1 style="color: red;"><%= msg%></h1>
        	<%request.getSession().setAttribute("sError", null); } %>
        <div id="b"><h1>Sign Up</h1>
        
    <form action="customersignup">
        <div class="c">   <input type="text" name="name" placeholder="Enter your name"></div>
       <div class="c">  <input type="tel" name="mobi" placeholder="Enter your Mobile no"></div>
       <div class="c">  <input type="password" name="pwd" placeholder="Enter your password"></div>
       <div class="c">  <input type="email" name="email" placeholder="Enter your email id"></div>
       <div class="c"> Gender :
        <input type="radio" name="gender" value="male" required="required" style="height: 20px ;width: 20px;">   Male
        <input type="radio" name="gender" value="female" required="required"style="height: 20px ;width: 20px;">   Female</div>
        <div class="c"> Dob : <input type="date" name="dob" style="height: 30px ;
            width: 150px;"></div>
       
        <div class="c">  <button>Signup</button> <button type="reset">Cancel</button></div>
    </form>
</div>
</div>
</body>
</html>