<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" type="text/css" href="css/teamuser/team_info.css">
  	<link rel="stylesheet" href="css/public.css" type="text/css">


  </head>
  
  <body>
    	<div class="teaminfo">
    		<div class="head">
	    		<div class="left"><span>欢迎您&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)">${teamuser.tname}</a></span></div>
	    		<div class="right"><a href="${pageContext.request.contextPath }/loginAndout.do?method=logout">退出登录</a><a href="${pageContext.request.contextPath }/index.do">返回首页</a></div>
    		</div>
    		<div class="info">
    			<ul>
    				<li>邮箱：${teamuser.temail}</li>
    				<li>学校：${teamuser.teamUnversity.sname}</li>
    				<li>赛区：${teamuser.teamUnversity.teamArea.aname}</li>
    			</ul>
    		</div>
    		<div class="btn"><a href="${pageContext.request.contextPath }/updateTeamInfo.do?method=team_baseinfo_update">修改注册信息</a></div>
    	</div>
 </body>
</html>
