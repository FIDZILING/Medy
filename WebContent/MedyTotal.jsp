<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/MedyTotal.css" />
<title>MedyTotal</title>
</head>
<body>
	<div id="userinfo" v-bind:class="classofuserinfo">
		<ul id="userul" v-on:mouseover="funcuserFin" v-on:mouseout="funcuserBin">
			<li class="userli">修改密码</li>
			<li></li>
			<a href="mylist.jsp"><li class="userli">购买清单</li></a>
			<li></li>
			<a href="moneymoney.jsp"><li id="abilitycontrol" class="userli">盈利情况</li></a>
			<li></li>
			<a href="insertmedy.jsp"><li class="userli">添加药品</li></a>
		</ul>
	</div>
	<div class="header" id="header">
		<a href="MedyTotal.jsp">
			<div class="logo">Medy</div>
		</a>
		<div class="welcome">
			欢迎，<a v-on:mouseover="funcuserF" v-on:mouseout="funcuserB"><%=request.getSession().getAttribute("username")%></a>
		</div>
	</div>
	<div class="wrapper" id="wrapper">
		<div class="type-of-medy" id="type-of-medy">
			<ul>
				<li><font v-bind:class="class_main_one" v-on:click="funcclick_one" onclick="find_Medy('专科药品')">专科药品</font>
					<ul>
						<li><font v-bind:class="class_one" onclick="find_Medy('肝胆科')">肝胆科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('皮肤科')">皮肤科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('肿瘤科')">肿瘤科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('神经科')">神经科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('消化科')">消化科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('呼吸科')">呼吸科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('心脑科')">心脑科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('风湿科')">风湿科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('泌尿科')">泌尿科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('心理科')">心理科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('五官科')">五官科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('内分泌科')">内分泌科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('儿科')">儿科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('男科')">男科</font></li>
						<li><font v-bind:class="class_one" onclick="find_Medy('妇科')">妇科</font></li>
					</ul></li>
				<li><font v-bind:class="class_main_two" v-on:click="funcclick_two" onclick="find_Medy('家庭用药')">家庭用药</font>
					<ul>
						<li><font v-bind:class="class_two" onclick="find_Medy('感冒发烧')">感冒发烧</font></li>
						<li><font v-bind:class="class_two" onclick="find_Medy('呼吸系统')">呼吸系统</font></li>
						<li><font v-bind:class="class_two" onclick="find_Medy('消化系统')">消化系统</font></li>
						<li><font v-bind:class="class_two" onclick="find_Medy('眼耳口鼻')">眼耳口鼻</font></li>
						<li><font v-bind:class="class_two" onclick="find_Medy('外用药')">外用药</font></li>
					</ul></li>
				<li><font v-bind:class="class_main_three" v-on:click="funcclick_three" onclick="find_Medy('老年药品')">老年药品</font>
					<ul>
						<li><font v-bind:class="class_three" onclick="find_Medy('高血压')">高血压</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('高血脂')">高血脂</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('糖尿病')">糖尿病</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('冠心病')">冠心病</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('脑血栓')">脑血栓</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('骨关节炎')">骨关节炎</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('风湿关节炎')">风湿关节炎</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('类风湿关节炎')">类风湿关节炎</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('骨质疏松')">骨质疏松</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('痛风')">痛风</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('支气管炎')">支气管炎</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('便秘')">便秘</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('腹泻')">腹泻</font></li>
						<li><font v-bind:class="class_three" onclick="find_Medy('白内障')">白内障</font></li>
					</ul>
				</li>
				<li><font v-bind:class="class_main_four" v-on:click="funcclick_four" onclick="find_Medy('滋补保健')">滋补保健</font>
					<ul>
						<li><font v-bind:class="class_four" onclick="find_Medy('基础营养')">基础营养</font></li>
						<li><font v-bind:class="class_four" onclick="find_Medy('妇婴保健')">妇婴保健</font></li>
						<li><font v-bind:class="class_four" onclick="find_Medy('职场保健')">职场保健</font></li>
						<li><font v-bind:class="class_four" onclick="find_Medy('中药滋补')">中药滋补</font></li>
					</ul>
				</li>
				<li><font v-bind:class="class_main_five" v-on:click="funcclick_five" onclick="find_Medy('性用品')">性用品</font>
					<ul>
						<li><font v-bind:class="class_five" onclick="find_Medy('避孕套')">避孕套</font></li>
						<li><font v-bind:class="class_five" onclick="find_Medy('润滑剂')">润滑剂</font></li>
						<li><font v-bind:class="class_five" onclick="find_Medy('避孕药品')">避孕药品</font></li>
						<li><font v-bind:class="class_five" onclick="find_Medy('怀孕检测')">怀孕检测</font></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="medy-main">
			<div class="medy-find-box">
				<table id="find-box-table" style="width:800px;"></table>
			</div>
		</div>
		<div class="medy-info" id="medy-info">
			<div class="medy-info-box">
				<div id="info-main"></div>
			</div>
		</div>
	</div>
	<script id="script-vue" src="js/vue.min.js"></script>
	<script src="js/ajax.js"></script>
	<script src="js/MedyTotal.js"></script>
</body>
</html>