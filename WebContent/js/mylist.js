window.onload = function(){
	var url="/../Medy/mylist.do?method=findlist";
	var params = "";
	sendRequest(url,params,'POST',showres);
}
function showres(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info=xmlHttpRequest.responseText;
			var title = "<tr>"
			+"<th>编号</th>"
			+"<th>用户名</th>"
			+"<th>药品id</th>"
			+"<th>购买数量</th>"
			+"<th>购买单价</th>"
			+"<th>购买总价格</th>"
			+"<th>购买时间</th>";
			document.getElementById("find-box-table").innerHTML = title + info;
		}
	}
}
