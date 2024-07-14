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
HttpSession cursession1=request.getSession(false);

if(cursession1!=null){
	cursession1.invalidate();
}
	response.sendRedirect("index.html");

	%>

</body>
</html>