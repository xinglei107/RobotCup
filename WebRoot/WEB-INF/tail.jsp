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
	<link rel="stylesheet" href="css/tail.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
    <div class="tail">
    	<div class="link">
    		<a href="${pageContext.request.contextPath}/more.do?method=list&atid=7">大赛介绍</a><span>&nbsp;|</span>
    		<a href="${pageContext.request.contextPath}/more.do?method=list&atid=8">联系我们</a><span><%--&nbsp;|</span>
    		<a href="javascript:void(0)" title="该模块正在建设中···" onclick="javascript:alert('该模块正在建设中，敬请期待···')">在线留言</a><span>&nbsp;|</span>
    		<a href="javascript:void(0)" title="该模块正在建设中···" onclick="javascript:alert('该模块正在建设中，敬请期待···')">在线反馈</a><span>&nbsp;|</span> --%>
    	</div >
    	<div class="label">Copyright © 2004-2014 北京信息科技大学教务处</div>
    </div>
  </body>
</html>
