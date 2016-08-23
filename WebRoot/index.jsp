<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华北五省大学生机器人大赛</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
     
  </head>
  
  <body>
  <!-- <div id="youkuplayer" style="width:480px;height:400px"></div>
	<script type="text/javascript" src="http://player.youku.com/jsapi">
	player = new YKU.Player('youkuplayer',{
	styleid: '0',
	client_id: 'b990e35d90ad8861',
	vid: '22116254',
	autoplay: false,
	show_related: false
	});
	</script>--> 
	
	<!-- <embed src="http://player.youku.com/player.php/sid/XNTY3Mzc3NjY0/v.swf" allowFullScreen="true" quality="high" width="480" height="400" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed> -->
   <%response.sendRedirect("index.do"); %> 
  </body>
</html>
