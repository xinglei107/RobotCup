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
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  	<link rel="stylesheet" href="css/admin/competition.css" type="text/css">
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  	<script type="text/javascript" src="js/check.js"></script>
  </head>

  <body>    
    <div class="publicpanel">
    	<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
    	<jsp:include page="/WEB-INF/admin/manage-com.jsp" flush="true"></jsp:include>
    	<div class="competition">
    		<div class="changepwd">    			
    			<table style="margin-top: 40px;margin-left: 30px;">
   		    		<tr>
   		    			<td>
    					<p style="font-size:20px;color:orange;font-weight:bold;">修改密码</p>
    					<p style="font-size:13px;color:gray">密码修改成功后会返回登录界面重新登录</p>
    					</td>	
   		    		</tr>
					<tr>
						<td>
    						<form action="${pageContext.request.contextPath }/changePwd.do" onsubmit="return checkadpwd()" method="post">
							<input type="hidden" name="adid" id="adid" value="${teamadmin.adid }">
							<p>				
							<label for="oldpwd1">原密码</label>				
							<br>				
							<input type="password" name="oldpwd" id="oldpwd1">
							</p>
							<p>				
							<label for="newpwd1">新密码</label>				
							<br>				
							<input type="password" name="newpwd" id="newpwd1">
							</p>				
							<p>				
							<label for="repwd1">请确认</label>				
							<br>				
							<input type="password" name="repwd" id="repwd1">				
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
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(7).addClass("on");
  </script>
</html>
