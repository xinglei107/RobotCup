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
    
	<title>华北五省大学生机器人大赛</title>
	<link rel="stylesheet" type="text/css" href="css/slide-show.css" />
  	<link rel="stylesheet" href="css/public.css" type="text/css">
	<script src="js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){			
				$('.slideshow').cycle({
					fx: 'scrollLeft',
					speed: 1000,
					timeout: 4000
				});
			});
		</script>
	</head>
	<body>
	  <div id="billboard">
	    <ul class="slideshow">
	    <c:forEach items="${imglist }" var="pic">
	      <li><a href="javascript:void(0)"><img src="index/${pic.mattachment }"/></a><div class="textblock"><p>${pic.mtitle}</p></div></li>
	     </c:forEach>
	    </ul>
	  </div>
	</body>
</html>
