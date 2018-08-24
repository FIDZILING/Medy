<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/signupSuccess.css" />
    <title>signinError</title>
</head>
<body>
    <div class="header">
        <a href="Medysignin.html">
        	<div class="logo">Medy</div>
        </a>
    </div>
    <div class="wrapper">
        <div class="successinfo">
            <div style="text-align:center;"><img src="/../Medy/img/success.gif" style="margin:0 auto;"></img></div>
            <p><%=request.getAttribute("successinfo")%></p><br>
            <p><a href="Medysignin.html">点击返回登陆</a></p><br>
        </div>
    </div>
    <div class="footer">
        <p>版权所有：吴睿凌   联系电话：13163370773</p>
        <p>本项目仅用于测试，禁止用于商业用途</p>
    </div>
</body>
</html>