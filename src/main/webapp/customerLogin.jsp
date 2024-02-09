<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="customerlogin.css">
<title>Insert title here</title>
</head>
<body>

 <%String ab=(String)request.getSession().getAttribute("masage"); %>
  <%List list=(List)request.getSession().getAttribute("signmasage"); %>
 
     <div id="a">
     <%if(list!=null) {%>
     <h2 ><%=list.get(0) %></h2>
      <h2><%=list.get(1) %></h2>
       <h2><%=list.get(2) %></h2>
        <% 
            request.getSession().setAttribute("signmasage", null);
            } %>
    <div id="b">
        <h1 style="margin: 20px;">Raj Bank</h1>
    <form action="customerLogin">
      <div class="c">  <input type="tel" name="custid" placeholder="Enter your Customer Id"></div>
      <div class="c"><input type="password" name="pwd" placeholder="Enter your Password"></div>
      
        <div class="c"> 
            <%if(ab!=null) {%>
            <ul style="font-size: 15px; color: rgb(245, 14, 14);"><%=ab %></ul>
            <% 
            request.getSession().setAttribute("masage", null);
            } %>
            <button type="submit" id="l">Login</button>  </div>
        
            <div class="c"><button type="reset" id="lc">Cancel</button></div>
    </form> 
</div>
</div>
</body>
</html>