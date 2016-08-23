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

  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/check.js"></script>
  </head>
  
  <body>
    <div class="publicpanel">
	    <jsp:include flush="true" page="team_info.jsp"></jsp:include>
	    <jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
	    <div class="manage">
   			<div class="manage_title">
				<a class="left"><span >修改密码</span></a>
   			</div>
   			<div class="manage_content">
   		    	<table>
   		    		<tr>
   		    			<td><p>密码修改成功后会返回登录界面重新登录</p></td>	
   		    		</tr>
					<tr> 				
						<td><form action="${pageContext.request.contextPath }/updatePassword.do" onsubmit="return checkpassword()" method="post">
							<input type="hidden" name="tid" id="tid" value="${teamuser.tid }">
							<p>				
							<label for="oldpwd">原密码</label>				
							<br>				
							<input type="password" name="oldpwd" id="oldpwd">
							</p>
							<p>				
							<label for="newpwd">新密码</label>				
							<br>				
							<input type="password" name="newpwd" id="newpwd">
							</p>				
							<p>				
							<label for="repwd">请确认</label>				
							<br>				
							<input type="password" name="repwd" id="repwd">				
							</p>				
							<p> 				
							<button type="submit">确定</button>
							<c:if test="${oldpwderr==0 }">
							<span id="oldpwderr" style="color:red;margin-left: 5px;">原密码错误</span>
							</c:if>		
							</p>				
							<p>&nbsp; </p>
						</form></td>				
				  </tr>
				</table>
			</div>
  		</div>
  	</div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
