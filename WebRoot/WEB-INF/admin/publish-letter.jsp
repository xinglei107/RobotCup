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
  </head>

  <body>    
    <div class="publicpanel">
    	<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
    	<jsp:include page="/WEB-INF/admin/manage-com.jsp" flush="true"></jsp:include>
    	<div class="competition">
    		<form action="${pageContext.request.contextPath }/publishLetter.do?method=pub" method="post">
    			<input type="hidden" name="adid" value="${teamadmin.adid }">
    			<div style="text-align:center;margin-top: 30px;"><span>标题&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="text" name="ltitle" value="${let.ltitle}"/></div>
    			<div style="text-align:center;margin-top: 10px;"><textarea rows="20" cols="80" name="lcontent" style="padding:10px;font-size:15px;font-family:Microsoft YaHei;">${let.lcontent}</textarea></div>
    			<div style="text-align:center;margin-top: 30px;"><button type="submit">发布</button></div>
    		</form>
    	</div>
    </div>
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(6).addClass("on");
  </script>
</html>
