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

  <link rel="stylesheet" href="css/teamuser/menage.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  
  </head>
  
  <body>
   	 <div class="publicpanel">
	    <jsp:include flush="true" page="team_info.jsp"></jsp:include>
	    <jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
	    <div class="manage">
   			<div class="manage_title">
				<a class="left"><span >基本信息</span></a>
   			</div>
   			<div class="manage_content">
   		    	<table>
   		    		<tr><td>队名：</td><td><input type="text" disabled="disabled" value="${teamuser.tname }"></td></tr>
   		    		<tr><td>学校：</td><td><input type="text" disabled="disabled" value="${teamuser.teamUnversity.sname }"></td></tr>
   		    		<tr><td>邮箱：</td><td><input type="text" disabled="disabled" value="${teamuser.temail }"></td></tr>
   		    		<tr><td rowspan="3"  colspan="1">备注：</td><td rowspan="3" colspan="1"><textarea  disabled="disabled">${teamuser.tremark }</textarea></tr>
   		    		
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a href="${pageContext.request.contextPath }/updateTeamInfo.do?method=team_baseinfo_update">修&nbsp;&nbsp;&nbsp;改</a></td></tr>
   		    	</table>
			</div>
  		</div>
  	</div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
