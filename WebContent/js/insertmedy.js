function funcinsert(){
	var name = document.getElementById("name").value;
	var isprescription = document.getElementById("isprescription").value;
	var approvalnumber = document.getElementById("approvalnumber").value;
	var type = document.getElementById("type").value;
	var residual = document.getElementById("residual").value;
	var information = document.getElementById("information").value;
	var sales = 0;
	var inprice = document.getElementById("inprice").value;
	var outprice = document.getElementById("outprice").value;
	var totalprice = 0;
	var url="/../Medy/insertmedy.do?method=insertmedy";
	var params = "name="+name+"&isprescription="+isprescription+
		"&approvalnumber="+approvalnumber+"&type="+type+"&residual="+residual+
		"&information="+information+"&sales="+sales+"&inprice="+inprice+
		"&outprice="+outprice+"&totalprice="+totalprice;
	sendRequest(url,params,'POST',showres);
}

function showres(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info=xmlHttpRequest.responseText;
			alert(info);
			location.reload();
		}
	}
}