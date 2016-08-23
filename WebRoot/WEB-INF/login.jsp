<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华北五省大学生机器人大赛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
  	<link rel="stylesheet" href="css/public.css" type="text/css"></link>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script  type="text/javascript" charset="utf-8">
		function reloadImage(){
		document.getElementById("ckc").src="CheckCode?="+Math.random();
		}
		function fp(){
			if($("#lname").val().trim().length>0){
				if(confirm("您确定要重置"+$("#lname").val()+"的密码吗？")){
					window.location.href="FindPwd?tname="+$("#lname").val();
				}
			}
			else
				alert("请输入您要找回密码的账户队名！");
		}
	</script>

  </head>
  
  <body>
    <jsp:include flush="true" page="/WEB-INF/head.jsp"></jsp:include>
    <div class="login">
    	<div class="logincon">
    	<form action="${pageContext.request.contextPath }/loginAndout.do?method=login" method="post">
    		<div class="logint"><br><span>华北五省（市、自治区）大学生机器人大赛登录</span></div>
    		<div class="loginc"><br><br>
    			<div>名字：<br><input class="lname" type="text" name="tname" value="${teamUserForm.tname}" id="lname"/>
    			<select class="lrole" id="lrole" name="lrole">
    			<c:if test="${teamUserForm.lrole!=1}">
	    			<option value="0" selected="selected">参赛队</option>
	    			<option value="1">管理员</option>
	    		</c:if>
	    		<c:if test="${teamUserForm.lrole==1}">
	    			<option value="0">参赛队</option>
	    			<option value="1" selected="selected">管理员</option>
	    		</c:if>
    			</select><span class="errinfo"><logic:notEmpty name="fail">用户名或密码错误</logic:notEmpty></span></div>
    			<br><div>密码：<br><input class="lpwd" type="password" name="tpwd" value="${teamUserForm.tpwd}"/><span class="errinfo"></span></div>
    			<logic:notEmpty name="showcode">
    			<br><div><span>验证码：</span><br><input name="ckc" style="width:60px;" type="text"/>
    			<img alt="点击更换" id="ckc" src="CheckCode" onclick="reloadImage()"/><span class="errinfo"><logic:notEmpty name="failcode">验证码错误</logic:notEmpty></span>
    			</div>
    			</logic:notEmpty>
    			<br><br><button type="submit">登&nbsp;&nbsp;录</button><a href="javascript:void(0)" onclick="fp()">忘记密码</a><br> 			
    		</div>
    		<div class="lbtn"><br><br><a href="${pageContext.request.contextPath }/redirect.do?method=register">注册参赛</a></div>
    	</form>
    	</div>
    </div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
