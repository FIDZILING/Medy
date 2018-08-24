<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/signError.css" />
    <title>signinError</title>
</head>
<body>
    <div class="header">
        <a href="Medysignin.html">
        	<div class="logo">Medy</div>
        </a>
    </div>
    <div class="wrapper">
        <div class="errorinfo">
            <div style="text-align:center;"><img src="/../Medy/img/error.gif" style="margin:0 auto;"></img></div>
            <p>登陆错误</p>
            <p>错误信息：<%=request.getAttribute("errorinfo")%></p><br>
            <p><a href="Medysignin.html">点击返回登陆</a></p><br>
            <p v-on:click="funcseeinfo" style="cursor: pointer;">点击查看错误类型具体描述</p>
        </div>
        <div class="errormain" v-bind:style="{display:display}">
            <p style="color:red;">error1.密码错误！</p>
            <p>输入了错误的密码，请重新输入正确的密码！</p><br>
            <p style="color:red;">error2.用户名不存在！</p>
            <p><a href="Medysignup.html">该用户不存在！点击前往注册！</a></p><br>
            <p style="color:red;">error3.登录失败！请联系管理员！</p>
            <p>网络或服务器出错，请联系下方管理员！</p>
        </div>
    </div>
    <div class="footer">
        <p>版权所有：吴睿凌   联系电话：13163370773</p>
        <p>本项目仅用于测试，禁止用于商业用途</p>
    </div>
    <script src="js/vue.min.js"></script>
    <script src="js/signError.js"></script>
</body>
</html>