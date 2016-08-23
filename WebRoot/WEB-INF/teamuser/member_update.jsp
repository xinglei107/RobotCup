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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/teamuser/menage.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  	
  <script type="text/javascript" src="js/check.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
   	 <div class="publicpanel">
	    <jsp:include flush="true" page="team_info.jsp"></jsp:include>
	    <jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
	    <div class="manage">
   			<div class="manage_title">
				<a class="left"><span >更新成员</span></a>
   			</div>
   			<form action="${pageContext.request.contextPath }/addTeamMember.do" method="post" onsubmit="return checkmember()">
   			<input type="hidden" name="tid" value="${teamuser.tid }">
   			<input type="hidden" name="mid" value="${teammeb.mid }">
    		<div class="manage_content">
   			<div style="color:red;margin-left:100px;margin-top:20px;font-size:14px;">
   				<p>提示</p>
   				<p>参赛队必须且只能设置一名领队成员（可以为学生或老师），否则无法通过审核</p>
   			</div>
    			<table>    				
   		    		<tr><td>姓名：</td><td><input type="text" value="${teammeb.mname }" name="mname" id="mname"></td></tr>
   		    		<tr><td>性别：</td><td>
   		    		<select name="mgender" id="mgender">
	   		    		<c:if test="${teammeb==null }">
	   		    		<option selected="selected" value="男">男</option>
	   		    		<option value="女">女</option>
	   		    		</c:if>
	   		    		<c:if test="${teammeb.mgender eq '男' }">
	   		    		<option selected="selected" value="男">男</option>
	   		    		<option value="女">女</option>
	   		    		</c:if>
	   		    		<c:if test="${teammeb.mgender eq '女' }">
	   		    		<option value="男">男</option>
	   		    		<option selected="selected" value="女">女</option>
	   		    		</c:if>
   		    		</select></td></tr>
   		    		<tr><td>电话：</td><td><input type="text" value="${teammeb.mphone }" name="mphone" id="mphone"></td></tr>
   		    		<tr><td>邮箱：</td><td><input type="text" value="${teammeb.memail }" name="memail" id="memail"></td></tr>
   		    		
   		    		<tr><td>角色：</td><td>
   		    		<select name="mtype">
   		    			<c:if test="${teammeb.mtype eq '学生' ||type==0 }">
	   		    		<option selected="selected" value="学生">学生</option>
	   		    		</c:if>
	   		    		<c:if test="${teammeb.mtype eq '教师' ||type==1 }">
	   		    		<option selected="selected" value="教师">指导教师</option>
	   		    		</c:if>
   		    		</select>
   		    		</td></tr>
   		    		
   		    		<tr><td>身份：</td><td>
	    			<c:if test="${teammeb.mleader==1 }">
	    				<input style="width:30px;border: 0px;" type="checkbox" name="mleader" checked="checked" value="1"><span>领队</span>
 		    		</c:if>
	    			<c:if test="${teammeb.mleader!=1 }">
	    				<input style="width:30px;border: 0px;" type="checkbox" name="mleader" value="1"><span>领队</span>
 		    		</c:if>
   		    		</td></tr>
   		    		
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
   		    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>
   		    		<c:if test="${teammeb!=null}">
   		    			<button type="submit">提&nbsp;&nbsp;&nbsp;交</button>
   		    			<c:if test="${res==0}"><span>已经存在一名领队！</span></c:if>
   		    		</c:if>
   		    		<c:if test="${teammeb==null}">
   		    			<button type="submit">添&nbsp;&nbsp;&nbsp;加</button>
   		    			<c:if test="${res==0}"><span>已经存在一名领队！</span></c:if>
   		    		</c:if>
   		    		</td></tr>
   		    	</table>
    		</div></form>
  		</div>
  	</div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
