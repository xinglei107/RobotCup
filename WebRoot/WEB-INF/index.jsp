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
     
  	<link rel="stylesheet" href="css/public.css" type="text/css"></link>
	<script src="js/jquery.min.js"></script>
	</head>
 
	<body>
	<div style="width:100%;height:auto;">
		<jsp:include flush="true" page="/WEB-INF/head.jsp"></jsp:include>

		<div style="position:relative;margin-left:-500px;width:1000px;height:350px;left:50%;">
    		<jsp:include flush="true" page="/WEB-INF/slide-show.jsp"></jsp:include>
    		<jsp:include flush="true" page="/WEB-INF/article-news.jsp"></jsp:include>
    	</div>
    	
		<div style="position:relative;margin-left:-500px;width:1000px;height:220px;left:50%;">
			<jsp:include flush="true" page="/WEB-INF/article-intro.jsp"></jsp:include>
			<jsp:include flush="true" page="/WEB-INF/article-movement.jsp"></jsp:include>
    	</div>
    	<div style="position:relative;margin-left:-500px;width:1000px;height:220px;left:50%;margin-top:5px">
			<jsp:include flush="true" page="/WEB-INF/article-rule.jsp"></jsp:include>
			<jsp:include flush="true" page="/WEB-INF/article-download.jsp"></jsp:include>
			<jsp:include flush="true" page="/WEB-INF/article-schedule.jsp"></jsp:include>
    	</div>
    
    	<jsp:include flush="true" page="/WEB-INF/slide-interval.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tailtop.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
    	
	</div>
	</body>
</html>