<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>华北五省大学生机器人大赛</title>

	<link rel="stylesheet" type="text/css" href="css/slide-interval.css" />
  	<link rel="stylesheet" href="css/public.css" type="text/css">

</head>
<body>
	<div class="review">
		<div class="title" >
			<a href="${pageContext.request.contextPath}/more.do?method=list&atid=2" class="left">参赛风采</a>
		    <div class="flip">
				<p id="trigger"></p>
		        <a class="prev" id="car_prev" href="javascript:void(0);"></a>
			    <a class="next" id="car_next" href="javascript:void(0);"></a>
			</div> 
			<a href="${pageContext.request.contextPath}/more.do?method=list&atid=2" class="right">more++</a>
		</div>
			<div class="profld" id="indexcar" data-listnum="5">
				<ol class="list-none">
				<c:forEach items="${introList }" var="intro">
					<li ><div class="shadow"></div><div class="image"><a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${intro.nid}" title="${intro.title }"><img src="${intro.imageUrl }" /></a></div>
					<div class="link"><a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${intro.nid}" title="${intro.title }">${fn:length(intro.title)>30?fn:substring(intro.title,0,30):intro.title}</a></div></li>
				</c:forEach>
				</ol>
			</div>
	</div>

<footer data-module="10001"></footer>
<script src="js/fun.inc.js" type="text/javascript"></script>

</body>
</html>