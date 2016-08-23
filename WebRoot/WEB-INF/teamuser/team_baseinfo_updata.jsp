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

  <link rel="stylesheet" href="css/teamuser/menage.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">  
  	<link rel="stylesheet" href="css/register.css" type="text/css">  
  <script type="text/javascript" src="js/ajax_uni.js"></script>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/check.js"></script>
  </head>
  
  <body>
   	 <div class="publicpanel">
	    <jsp:include flush="true" page="team_info.jsp"></jsp:include>
	    <jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
	    <div class="manage">
	    <form action="${pageContext.request.contextPath }/updateTeamInfo.do?method=change" method="post" onsubmit="return checkupdate()">
   			<div class="manage_title">
				<a class="left"><span >信息修改</span></a>
   			</div>
   			<div class="manage_content">
   		    	<table style="float:left">   		    		
   		    		<tr><td>队名：</td><td><input type="text" value="${teamuser.tname }" id="tname" name="tname"></td></tr>
   		    		<tr><td>学校：</td><td><input type="text" name="tunversity" id="tuniversity" readonly="readonly" onclick="showUniDiv()" value="${teamuser.teamUnversity.sname }">
	    			<input type="hidden" name="sid" id="sid" value="${teamuser.teamUnversity.sid }">
	    			<input type="hidden" name="tid" id="tid" value="${teamuser.tid }"></td></tr>
   		    		<tr><td>邮箱：</td><td><input type="text" value="${teamuser.temail }" id="temail" name="temail"></td></tr>
   		    		<tr><td rowspan="3">备注：</td><td rowspan="3"><textarea id="tremark" name="tremark">${teamuser.tremark }</textarea></td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td></td><td><button type="submit">提&nbsp;&nbsp;&nbsp;交</button></td></tr>
   		    	</table>
   		    	<div class="filling" id="university" style="width:340px;">
				<c:forEach var="area" items="${areaList }" varStatus="num">
		    		<a href="javascript:void(0)" id="${area.aid}" onclick="setAreaUni(this)">${area.aname}</a>&nbsp;&nbsp;&nbsp;
		    	</c:forEach>
		    	<hr>
		    	<div id="ulist">
				<table>
					<tr>
					<c:forEach var="school" items="${universityList }" varStatus="num">
 		    			<td><a href="javascript:void(0)" onclick="showMyUni(this)" id="${school.sid }">${school.sname}</a></td>
 		    			<c:if test="${num.count%3==0}"></tr><tr></c:if>
 		    		</c:forEach>
 		    		</tr>
				</table>
				</div>
				<a href="javascript:void(0)" onclick="closeUniDiv()" style="float:right;color:black;border:2px solid black;font-size:16px;text-align:center;">关闭</a>
			</div>
			</div>
			</form>
  		</div>
  	</div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
