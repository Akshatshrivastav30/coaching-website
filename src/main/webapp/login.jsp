<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<div class="container">
<h1>login</h1>

<form action="loginservlet" method="post">
<label for="username">username:</label>
<input type="text" id="username" name="username" required><br>
<label for="password">password:</label>
<input type="password" id="password" name="password" required><br>
<button type="submit">login</button>
</form>
<p><a href="index.html">Back to home</a></p>

<% String error =request.getParameter("error");
if(error!= null && error.equals("1")){%>
	<p style="color:red">invalid usename and password</p>
<% }%>

</div>

</body>
</html>