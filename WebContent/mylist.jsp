<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/mylist.css" />
<title>mylist</title>
</head>
<body>
	<div class="header" id="header">
		<a href="MedyTotal.jsp">
			<div class="logo">Medy</div>
		</a>
		<div class="welcome">
			欢迎，<a><%=request.getSession().getAttribute("username")%></a>
		</div>
	</div>
	<div class="wrapper" id="wrapper">
		<table id="find-box-table">
			
			
		</table>
	</div>
	<script src="js/mylist.js"></script>
	<script src="js/ajax.js"></script>
</body>
</html>