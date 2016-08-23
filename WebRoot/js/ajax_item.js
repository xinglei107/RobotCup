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
			con+= " <tr style='border-top:0px'><th rowspan='2' class='borderright'>��ѡ��Ŀ</th>" +
					"<th colspan='4' class='borderright'>����ѧ��</th>" +
					"<th colspan='4' class='borderright'>ָ����ʦ</th>" +
					"<th rowspan='2'>����</th></tr>"+
   		    		"<tr><th>����</th><th>����</th><th>����</th>" +
   		    		"<th class='borderright'>״̬</th><th>����</th>" +
   		    		"<th>����</th><th>����</th><th class='borderright'>״̬</th></tr>";

		for (var i = 1; i <= unis.length; i++) {
			var flag=true;
			con+="<tr><td class='borderright'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</td>" +
			
			"<td>"+unis[i - 1].childNodes[2].childNodes[0].data+"��</td>"+
			"<td>" +unis[i - 1].childNodes[3].childNodes[0].data+"��</td>" +
			"<td>" +stuCount+"��</td>" +
			"<td class='borderright'>";
			if(stuCount<=unis[i - 1].childNodes[3].childNodes[0].data&&stuCount>=unis[i - 1].childNodes[2].childNodes[0].data)
				con+="����";
			else{
				con+="<span style=\"color:red;font-weight:bold\">����</span>";
				flag=false;
			}
			con+="</td>" +
			
			"<td>" +unis[i - 1].childNodes[4].childNodes[0].data+"��</td>" +
			"<td>" +unis[i - 1].childNodes[5].childNodes[0].data+"��</td>" +
			"<td>" +teaCount+"��</td>" +				
			"<td class='borderright'>";
			if(teaCount<=unis[i - 1].childNodes[5].childNodes[0].data&&teaCount>=unis[i - 1].childNodes[4].childNodes[0].data)
				con+="����";
			else{
				con+="<span style=\"color:red;font-weight:bold\">����</span>";
				flag=false;
			}
			con+="</td>";
			if(flag)
				con+="<td><a href='javascript:void(0)' class='close' title='��������' onclick='setTeamApp(this)' id='"	+unis[i - 1].childNodes[0].childNodes[0].data+"'>��������</a></td>";
			else
				con+="<td><a href='javascript:void(0)' class='close' title='��������' onclick='alert(\"��������������\")'>��������</a></td>";
			
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
					con+= " <tr style='border-top:0px'><th rowspan='2' class='borderright'>��ѡ��Ŀ</th>" +
							"<th colspan='4' class='borderright'>����ѧ��</th>" +
							"<th colspan='4' class='borderright'>ָ����ʦ</th>" +
							"<th rowspan='2'>���״̬</th><th rowspan='2'>����</th></tr>"+
		   		    		"<tr><th>����</th><th>����</th><th>����</th>" +
		   		    		"<th class='borderright'>״̬</th><th>����</th>" +
		   		    		"<th>����</th><th>����</th><th class='borderright'>״̬</th></tr>";

				for (var i = 1; i <= unis.length; i++) {
					con+="<tr><td class='borderright'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</td>" +
					
					"<td>"+unis[i - 1].childNodes[2].childNodes[0].data+"��</td>"+
					"<td>" +unis[i - 1].childNodes[3].childNodes[0].data+"��</td>" +
					"<td>" +unis[i - 1].childNodes[4].childNodes[0].data+"��</td>" +
					"<td class='borderright'>" +unis[i - 1].childNodes[5].childNodes[0].data+"</td>" +
					
					"<td>" +unis[i - 1].childNodes[6].childNodes[0].data+"��</td>" +
					"<td>" +unis[i - 1].childNodes[7].childNodes[0].data+"��</td>" +
					"<td>" +unis[i - 1].childNodes[8].childNodes[0].data+"��</td>" +				
					"<td class='borderright'>" +unis[i - 1].childNodes[9].childNodes[0].data+"</td>" +
					
					"<td>" +unis[i - 1].childNodes[10].childNodes[0].data+"</td>" +
					"<td><a href='javascript:void(0)' class='close' title='ɾ��' onclick='delTeamApp(this)' id='"	+unis[i - 1].childNodes[0].childNodes[0].data+"'>ɾ��</a></td>" +
					"</tr>" ;
				}
				con += "</table>";
				document.getElementById("selecteddiv").innerHTML = con;
				console.log(status);
			}else if(status==-1){
				console.log(status);
				alert("����������ӣ�");
			}else if(status==4){
				console.log(status);
				var times = xmlrequest.responseXML.getElementsByTagName("times")[0].childNodes[0].data;
				alert("�����ڵ�ѧУ�Ѿ���"+times+"�������ӱ��������ܼ�����������Ŀ��");
			}else if(status==0){
				console.log(status);
				alert("���Ѿ���������Ŀ��");
			}else if(status==-2){
				alert("��������Ѿ��رգ����ܼ���������");
			}
			
		}
	}
}

function delTeamApp(o) {	
	 if(!confirm("ȷ��Ҫɾ����"))
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
