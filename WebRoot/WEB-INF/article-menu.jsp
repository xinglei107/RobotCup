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
    
  
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/article-menu.css">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	
	
  </head>
  
  <body>
    <div class="articlemenu">
    	<div class="articlemenutitle"><a>相关选项</a></div>
   		<div class="menucontent"><br>
   			<ul>
   			<c:forEach items="${menu }" var="m">
   				<li><a href="${pageContext.request.contextPath}/more.do?method=list&atid=${m.atid}"><img src="images/rightlist.png"/><span class="spanlist">${m.atname }</span></a></li>
   			</c:forEach>
   			</ul><br>
   		</div>
    </div>
  </body>
</html>
