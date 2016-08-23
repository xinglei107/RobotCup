<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<style type="text/css">
		.com{
			width:200px;
			height:650px;
			float:left;	
			background:white;
			margin-top:5px;		
		}
		.com ul{
			margin:0px;
			padding:0px;
		}
		.com ul li{
			list-style: none;
			text-align: center;
			font-size:16px;
			margin-top: 15px;
		}
		.com ul li a{
			text-decoration: none;
			color:blue;
		}
		.com ul li a:hover{
			text-decoration: underline;
		}
	</style>

  </head>
  
  <body>
    <div class="com">
    	<ul>
    		<li><br></li>
    		<li><br></li>
    		<li><a href="${pageContext.request.contextPath }/manageTeams.do?method=showteams&aid=${teamadmin.teamArea.aid}">参赛统计</a></li>
    		<li><a href="${pageContext.request.contextPath }/manageApplication.do?method=page">报名审核</a></li>
    		<li><a href="${pageContext.request.contextPath }/report.do?method=item">项目统计</a></li>
    	</ul>
    </div>
  </body>
</html>
