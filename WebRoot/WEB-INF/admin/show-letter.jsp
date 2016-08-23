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
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  	<link rel="stylesheet" href="css/admin/competition.css" type="text/css">

  <script type="text/javascript" src="js/jquery.min.js"></script>
  </head>

  <body>    
    <div class="publicpanel">
    	<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
    	<jsp:include page="/WEB-INF/admin/manage-com.jsp" flush="true"></jsp:include>
    	<div class="competition">
   			<div style="text-align:center;margin-top: 30px;"><h3>${let.ltitle}</h3></div>
   			<div style="margin-top: 10px;padding-left: 87px;padding-right: 100px;">
   			<pre style="font-size:15px;white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;
						white-space:-o-pre-wrap;word-wrap:break-word;font-family: Microsoft YaHei;width:600px;
						height:400px;overflow:auto;border:6px solid orange;padding:10px;">${let.lcontent}</pre></div>
   			<logic:empty name="let">
				<p>暂无公告</p>
			</logic:empty>
			<button style="float:right;margin-right: 100px;margin-top: 30px;" type="button" onclick="window.location.href='${pageContext.request.contextPath }/publishLetter.do?method=redi'">点此重新发布</button>
    	</div>
    </div>
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(6).addClass("on");
  </script>
</html>
