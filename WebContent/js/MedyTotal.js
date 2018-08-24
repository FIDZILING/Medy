var Vue_totalwrapper = new Vue({
	el:'#wrapper',
	data:{
		class_main_one:'classbeforeclick',
		class_main_two:'classbeforeclick',
		class_main_three:'classbeforeclick',
		class_main_four:'classbeforeclick',
		class_main_five:'classbeforeclick',
		class_one:'classcheckdown',
		class_two:'classcheckdown',
		class_three:'classcheckdown',
		class_four:'classcheckdown',
		class_five:'classcheckdown',
	},
	methods:{
		funcclick_one:function(){
			if(this.class_one == 'classcheckdown'){
				this.class_main_one = 'classafterclick';
				this.class_one="classcheckon";
			}
			else if(this.class_one == 'classcheckon'){
				this.class_main_one = 'classbeforeclick';
				this.class_one = "classcheckdown";
			}
		},
		funcclick_two:function(){
			if(this.class_two == 'classcheckdown'){
				this.class_main_two = 'classafterclick';
				this.class_two="classcheckon";
			}
			else if(this.class_two == 'classcheckon'){
				this.class_main_two = 'classbeforeclick';
				this.class_two = "classcheckdown";
			}
		},
		funcclick_three:function(){
			if(this.class_three == 'classcheckdown'){
				this.class_main_three = 'classafterclick';
				this.class_three = "classcheckon";
			}
			else if(this.class_three == 'classcheckon'){
				this.class_main_three = 'classbeforeclick';
				this.class_three = "classcheckdown";
			}
		},
		funcclick_four:function(){
			if(this.class_four == 'classcheckdown'){
				this.class_main_four = 'classafterclick';
				this.class_four = "classcheckon";
			}
			else if(this.class_four == 'classcheckon'){
				this.class_main_four = 'classbeforeclick';
				this.class_four = "classcheckdown";
			}
		},
		funcclick_five:function(){
			if(this.class_five == 'classcheckdown'){
				this.class_main_five = 'classafterclick';
				this.class_five = "classcheckon";
			}
			else if(this.class_five == 'classcheckon'){
				this.class_main_five = 'classbeforeclick';
				this.class_five = "classcheckdown";
			}
		},
	},
});

var Vue_totaluserinfo = new Vue({
	el:'#userinfo',
	data:{
		classofuserinfo:'userinfo-type-one',
	},
	methods:{
		funcuserFin:function(){
			Vue_totaluserinfo.classofuserinfo = 'userinfo-type-two';
		},
		funcuserBin:function(){
				Vue_totaluserinfo.classofuserinfo = 'userinfo-type-one';
		},
	},
});

var Vue_totalheader = new Vue({
	el:'#header',
	methods:{
		funcuserF:function(){
			Vue_totaluserinfo.classofuserinfo = 'userinfo-type-two';
		},
		funcuserB:function(){
			if(Vue_totaluserinfo.funcuserFin() == false){
				setTimeout(() => {
					Vue_totaluserinfo.classofuserinfo = 'userinfo-type-one';
	            }, 1000);
			}
		},
	},
});



//ajax
function find_Medy(target){
	var url="/../Medy/findmedy.do?method=findmedy";
	var params = "type="+target;
	sendRequest(url,params,'POST',showresofmedyall);
}

function seeinfo(name){
	var url="/../Medy/seemedyinfo.do?method=seemedyinfo";
	var params = "name="+name;
	sendRequest(url,params,'POST',showresofonemedy);
}

function buydrugs(Id){
	var number = document.getElementById("numberofbuy").value;
	var url="/../Medy/buydrugs.do?method=buydrugs";
	var params = "buynum="+number+"&Id="+Id;
	sendRequest(url,params,'POST',showresofbuydrugs);
}

function showresofmedyall(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info=xmlHttpRequest.responseText;
			var title = "<tr>" +
						"<th>药品id</th>" +
						"<th>药品名称</th>" +
						"<th>是否为处方药</th>" +
						"<th>药品类别</th>" +
						"<th>售价</th>" +
						"<th>剩余量</th>" +
						"</tr>";
			document.getElementById("find-box-table").innerHTML = title + info;
		}
	}
}

function showresofonemedy(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info=xmlHttpRequest.responseText;
			document.getElementById("info-main").innerHTML = info;
		}
	}
}

function showresofbuydrugs(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info=xmlHttpRequest.responseText;
			alert(info);
			location.reload();
		}
	}
}


