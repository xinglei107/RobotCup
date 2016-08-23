<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery.min.js" type="text/javascript"></script>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
	<link rel="stylesheet" href="css/article-notice.css" type="text/css"></link>
	
</head>
<body>
  <div class="publicpanel">
	    <jsp:include flush="true" page="team_info.jsp"></jsp:include>
	    <jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
     <div class="notice" style="width:790px;float:left;height:680px;margin-left:10px;+margin-left:8px;">
    	<div class="notice_title">
			<a class="left"><span >站内消息</span></a>
    	</div>
    	<div class="notice_content" style="background-color: white;height:650px;overflow:hidden;word-break: break-all; word-wrap:break-word;">
			<h3 style="text-align: center;margin-top:30px;">${rletter.ltitle }</h3>
			<pre style="font-size:15px;white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;
						white-space:-o-pre-wrap;word-wrap:break-word;font-family: Microsoft YaHei;
						margin-left: 100px;margin-right: 870px;padding:10px;width:600px;height:400px;
						overflow:auto;border:6px solid orange">${rletter.lcontent }</pre>
			<logic:empty name="rletter">
				<p>暂无公告</p>
			</logic:empty>
		</div>	  
   	</div></div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
</body>

</html>
