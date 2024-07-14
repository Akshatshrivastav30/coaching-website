<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<%
HttpSession session1=request.getSession(false);

if (session != null && session.getAttribute("username")!=null)
{
	
  String username=(String)session.getAttribute("username");
%>
<div class="container">
<h1>Welcome,</h1>
<p>we're delighted to have you on our platform.</p>
<h3>explore learn and connect with our vibrant community!</h3>
<p>feel free to stay as long as you like</p>
<a href="logout.jsp">LOGOUT</a>
</div>
<% } else{
	response.sendRedirect("login.jsp");
}
	%>

</body>
</html>