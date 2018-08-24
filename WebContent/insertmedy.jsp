<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/insertmedy.css" />
<title>insertmedy</title>
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
		<div id="insert">
			<form>
				<font class="fontt">药品名称：</font><input type="text" class="input-box" id="name"/>
				<font class="fontt">处&ensp;方&ensp;药：</font><select class="input-box" id="isprescription">
                        <option value="--请选择--">--请选择--</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select><br>
				<font class="fontt">批准文号：</font><input type="text" class="input-box" id="approvalnumber"/>
				<font class="fontt">药品类别：</font><input type="text" class="input-box" id="type"/><br>
				<font class="fontt">进&ensp;货&ensp;量：</font><input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" class="input-box" id="residual"/><br>
				<font class="fontt">进货价格：</font><input type="text" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" class="input-box" id="inprice"/>
				<font class="fontt">出售价格：</font><input type="text" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" class="input-box" id="outprice"/><br>
				<font class="fontt">说明书：</font><textarea cols="200" rows="5" class="big-box" id="information"></textarea><br>
				
				<input type="button" value="入库" class="btn-box" onclick="funcinsert()"/><br>
			</form>
		</div>
	</div>
	<script src="js/insertmedy.js"></script>
	<script src="js/ajax.js"></script>
</body>
</html>