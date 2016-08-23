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
    					<p style="font-size:20px;color:orange;font-weight:bold;">修改信息</p>
    					</td>	
   		    		</tr>
					<tr>
						<td>
    						<form action="${pageContext.request.contextPath }/updateAdminInfo.do" onsubmit="return checkadmin()" method="post">
							<input type="hidden" name="adminid" id="adminid" value="${teamadmin.adid }">
							<p>				
							<label>用户名</label>				
							<br>				
							<input type="text" name="adminname" id="adminname" value="${teamadmin.adname }">
							</p>
							<p>				
							<label>邮箱</label>				
							<br>				
							<input type="text" name="adminemail" id="adminemail" value="${teamadmin.ademail }">
							</p>			
							<p> 				
							<button type="submit">确定</button>	
							<c:if test="${res==1 }">
							<span id="oldpwderr" style="color:red;margin-left: 5px;">修改成功！</span>
							</c:if>	
							<c:if test="${res==0 }">
							<span id="oldpwderr" style="color:red;margin-left: 5px;">用户名已经存在！</span>
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
</html>
