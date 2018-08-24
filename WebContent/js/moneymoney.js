window.onload = function(){
	var url="/../Medy/moneymoney.do?method=money";
	var params = "";
	sendRequest(url,params,'POST',showres);
}
function showres(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info=xmlHttpRequest.responseText;
			var title = "<tr>"
			+"<th>药品名称</th>"
			+"<th>药品类别</th>"
			+"<th>卖出量</th>"
			+"<th>卖出价格</th>"
			+"<th>总盈利</th>";
			document.getElementById("find-box-table").innerHTML = title + info;
		}
	}
}
