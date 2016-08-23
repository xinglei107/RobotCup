<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华北五省大学生机器人大赛</title>
	
  	<link rel="stylesheet" href="css/head.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
	<script type="text/javascript">
		$(document).ready(function(){
		  $("div ul li a").click(function(){
		  	$(".selected").removeClass("selected");
		    $(this).addClass("selected");
		  });
		});
	</script>
</head>
  
  <body>
  	<div class="headtitle">
  	<c:if test="${teamuser==null&&teamadmin==null}">
    	<a href="${pageContext.request.contextPath }/redirect.do?method=login" class="alogin" >用户登录</a>
    	<a href="${pageContext.request.contextPath }/redirect.do?method=register" class="alogin" >我要参赛</a> 
    </c:if>
  	<logic:notEmpty name="teamadmin">
    	<a href="${pageContext.request.contextPath }/loginAndout.do?method=logout" class="alogin" >退出登录</a>
    	<a href="${pageContext.request.contextPath }/manageCom.do?method=area" class="alogin" >${fn:length(teamadmin.adname)>9?fn:substring(teamadmin.adname,0,9):teamadmin.adname}</a> 
    </logic:notEmpty>
    <logic:notEmpty name="teamuser">
  		<a href="${pageContext.request.contextPath }/loginAndout.do?method=logout" class="alogin">退出登录</a>
  		<a href="${pageContext.request.contextPath }/justJump.do?method=baseinfo" class="alogin">${fn:length(teamuser.tname)>9?fn:substring(teamuser.tname,0,9):teamuser.tname}</a>
  	</logic:notEmpty>
  		 <ul class="navbar">  		 	
			<li><a href="${pageContext.request.contextPath }/index.do" target="_self">网站首页</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=1" target="_self">新闻动态</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=2" target="_self">参赛风采</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=3" target="_self">竞赛规则</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=4" target="_self">比赛日程</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=5" target="_self">组织结构</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=6" target="_self">历届回顾</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=7" target="_self">大赛介绍</a></li>
			<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=8" target="_self">联系我们</a></li>
	   	</ul>
		<!-- <div class="inputWithImge">
			<input type="text" class="searchinput"/>
			<a href="#" class="search"><img src="images/head/search24.png"/></a>
		</div> -->
	</div>
  </body>
</html>
