var xmlrequest;
function createXMLHttpRequest() {
  //如果浏览器支持 XMLHttpRequest 对象,则创建 XMLHttpRequest 对象。如果不支持，则创建 ActiveXObject
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
	}
}
function setAreaUni(o) {	
	createXMLHttpRequest();
	if (xmlrequest) {		
		var req = "ChangeArea?aid="+o.id;
		//window.alert(req);
		xmlrequest.open("get", req, true);
		xmlrequest.onreadystatechange = getAreaUni;
		xmlrequest.send();
	}
}

function getAreaUni() {
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
			var unis = xmlrequest.responseXML.getElementsByTagName("unis");
			var con = "<table><tr>";
			for (var i = 1; i <= unis.length; i++) {
				con += "<td><a href='javascript:void(0)' onclick='showMyUni(this)' id='"
					+ unis[i - 1].childNodes[0].childNodes[0].data + "'>" 
					+ unis[i - 1].childNodes[1].childNodes[0].data + "</a></td>";
				if (i % 3 == 0) {
					con += "</tr><tr>";
				}
			}
			con += "</tr></table>";
			document.getElementById("ulist").innerHTML = con;
		}
	}
}
function showMyUni(o) {
	$("#tuniversity").val(o.innerHTML);
	$('#university').slideUp("fast");
	$("#sid").val(o.id);
}
function showUniDiv() {
	$('#university').slideDown("slow");
}
function closeUniDiv() {
	$('#university').slideUp("fast");
}

