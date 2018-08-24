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
            <p>注册错误</p>
            <p>错误信息：<%=request.getAttribute("errorinfo")%></p><br>
            <p><a href="Medysignup.html">点击返回注册</a></p><br>
            <p v-on:click="funcseeinfo" style="cursor: pointer;">点击查看错误类型具体描述</p>
        </div>
        <div class="errormain" v-bind:style="{display:display}">
            <p style="color:red;">error1.插入数据库失败！</p>
            <p>插入数据库失败，请联系下方管理员！</p><br>
            <p style="color:red;">error2.存在重复用户名！</p>
            <p>该用户已存在！请重选用户名！</p><br>
            <p style="color:red;">error3.注册失败！请联系管理员！</p>
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