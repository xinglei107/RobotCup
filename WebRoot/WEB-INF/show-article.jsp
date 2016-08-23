<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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

	<link rel="stylesheet" href="css/article.css" type="text/css">
	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
  <div class="publicpanel">
    <jsp:include flush="true" page="/WEB-INF/head.jsp"></jsp:include>
  	<div class="article">
    	<div class="articletitle"><span class="title">文章内容</span></div>
		<div class="articlecontent">
			<br><br>
			<h3>${rn.mtitle }</h3>
			<h5><fmt:formatDate value="${rn.mdate }" pattern="yyyy-MM-dd"/></h5>
			<p>${rn.mcontent }</p>
			<br>
			<div class="download">
				<c:if test="${rn.matname!=null }">
				附件下载：<a href="${pageContext.request.contextPath }/download.do?name=${rn.mattachment}&relname=${rn.matname}">
				<c:out value="${rn.matname }" default=""></c:out>
				</a>
				</c:if>
			</div><br><br><br>
		</div>
		<div class="articlebottom"><div></div></div>	  
	</div>
    <jsp:include flush="true" page="/WEB-INF/article-relation.jsp"></jsp:include>
	</div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
