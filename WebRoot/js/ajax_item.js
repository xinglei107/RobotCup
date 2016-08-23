var xmlrequest;
function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
	}
}
function setTypeItem(o) {	
	createXMLHttpRequest();
	if (xmlrequest) {		
		var req = "ChangeItem?tyid="+o.id;
		// window.alert(req);
		xmlrequest.open("get", req, true);
		xmlrequest.onreadystatechange = getTypeItem;
		xmlrequest.send();
	}
}

function getTypeItem() {
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
			var unis = xmlrequest.responseXML.getElementsByTagName("unis");

			var con = "<table cellspacing='0'>";
			con+= " <tr style='border-top:0px'><th rowspan='2' class='borderright'>可选项目</th>" +
					"<th colspan='4' class='borderright'>参数学生</th>" +
					"<th colspan='4' class='borderright'>指导教师</th>" +
					"<th rowspan='2'>操作</th></tr>"+
   		    		"<tr><th>下限</th><th>上限</th><th>本队</th>" +
   		    		"<th class='borderright'>状态</th><th>下限</th>" +
   		    		"<th>上限</th><th>本队</th><th class='borderright'>状态</th></tr>";

		for (var i = 1; i <= unis.length; i++) {
			var flag=true;
			con+="<tr><td class='borderright'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</td>" +
			
			"<td>"+unis[i - 1].childNodes[2].childNodes[0].data+"人</td>"+
			"<td>" +unis[i - 1].childNodes[3].childNodes[0].data+"人</td>" +
			"<td>" +stuCount+"人</td>" +
			"<td class='borderright'>";
			if(stuCount<=unis[i - 1].childNodes[3].childNodes[0].data&&stuCount>=unis[i - 1].childNodes[2].childNodes[0].data)
				con+="符合";
			else{
				con+="<span style=\"color:red;font-weight:bold\">不符</span>";
				flag=false;
			}
			con+="</td>" +
			
			"<td>" +unis[i - 1].childNodes[4].childNodes[0].data+"人</td>" +
			"<td>" +unis[i - 1].childNodes[5].childNodes[0].data+"人</td>" +
			"<td>" +teaCount+"人</td>" +				
			"<td class='borderright'>";
			if(teaCount<=unis[i - 1].childNodes[5].childNodes[0].data&&teaCount>=unis[i - 1].childNodes[4].childNodes[0].data)
				con+="符合";
			else{
				con+="<span style=\"color:red;font-weight:bold\">不符</span>";
				flag=false;
			}
			con+="</td>";
			if(flag)
				con+="<td><a href='javascript:void(0)' class='close' title='报名此项' onclick='setTeamApp(this)' id='"	+unis[i - 1].childNodes[0].childNodes[0].data+"'>报名此项</a></td>";
			else
				con+="<td><a href='javascript:void(0)' class='close' title='人数不符' onclick='alert(\"人数不符合条件\")'>人数不符</a></td>";
			
			"</tr>" ;
		}
		con += "</table>";
		document.getElementById("selecteddiv1").innerHTML = con;
		}
	}
}
function showTypeItem(o) {
	$('#itemselected').val(o.innerHTML);
	$('#itemselectedid').val(o.id);
}

function setTeamApp(o) {		
	createXMLHttpRequest();
	if (xmlrequest) {
		var req = "TeamApp?itid="+o.id;
		// window.alert(req);
		xmlrequest.open("get", req, true);
		xmlrequest.onreadystatechange = getTeamApp;
		xmlrequest.send();
	}
}

function getTeamApp() {
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
			var result = xmlrequest.responseXML.getElementsByTagName("result");
			var status=result[0].childNodes[0].data;
			if(status==1){
				var unis = xmlrequest.responseXML.getElementsByTagName("unis");
				var con = "<table cellspacing='0'>";
					con+= " <tr style='border-top:0px'><th rowspan='2' class='borderright'>已选项目</th>" +
							"<th colspan='4' class='borderright'>参数学生</th>" +
							"<th colspan='4' class='borderright'>指导教师</th>" +
							"<th rowspan='2'>审核状态</th><th rowspan='2'>操作</th></tr>"+
		   		    		"<tr><th>下限</th><th>上限</th><th>本队</th>" +
		   		    		"<th class='borderright'>状态</th><th>下限</th>" +
		   		    		"<th>上限</th><th>本队</th><th class='borderright'>状态</th></tr>";

				for (var i = 1; i <= unis.length; i++) {
					con+="<tr><td class='borderright'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</td>" +
					
					"<td>"+unis[i - 1].childNodes[2].childNodes[0].data+"人</td>"+
					"<td>" +unis[i - 1].childNodes[3].childNodes[0].data+"人</td>" +
					"<td>" +unis[i - 1].childNodes[4].childNodes[0].data+"人</td>" +
					"<td class='borderright'>" +unis[i - 1].childNodes[5].childNodes[0].data+"</td>" +
					
					"<td>" +unis[i - 1].childNodes[6].childNodes[0].data+"人</td>" +
					"<td>" +unis[i - 1].childNodes[7].childNodes[0].data+"人</td>" +
					"<td>" +unis[i - 1].childNodes[8].childNodes[0].data+"人</td>" +				
					"<td class='borderright'>" +unis[i - 1].childNodes[9].childNodes[0].data+"</td>" +
					
					"<td>" +unis[i - 1].childNodes[10].childNodes[0].data+"</td>" +
					"<td><a href='javascript:void(0)' class='close' title='删除' onclick='delTeamApp(this)' id='"	+unis[i - 1].childNodes[0].childNodes[0].data+"'>删除</a></td>" +
					"</tr>" ;
				}
				con += "</table>";
				document.getElementById("selecteddiv").innerHTML = con;
				console.log(status);
			}else if(status==-1){
				console.log(status);
				alert("请先设置领队！");
			}else if(status==4){
				console.log(status);
				var times = xmlrequest.responseXML.getElementsByTagName("times")[0].childNodes[0].data;
				alert("您所在的学校已经有"+times+"个参赛队报名，不能继续报名该项目！");
			}else if(status==0){
				console.log(status);
				alert("您已经报名该项目！");
			}else if(status==-2){
				alert("报名入口已经关闭，不能继续报名！");
			}
			
		}
	}
}

function delTeamApp(o) {	
	 if(!confirm("确认要删除？"))
    {
        return;
    }
	createXMLHttpRequest();
	if (xmlrequest) {
		var req = "DeleteItem?appid="+o.id+"&tid="+$('#teamuserid').val();
		// window.alert(req);
		xmlrequest.open("get", req, true);
		xmlrequest.onreadystatechange = getTeamApp;
		xmlrequest.send();
	}
}
