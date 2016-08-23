<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  	<link rel="stylesheet" href="css/article-intro.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
    <div class="intro">
    	<div class="intro_title">
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=7" class="left"><span >大赛介绍</span></a>
			<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${robotintro.nid}" class="right"><span >阅读全文</span></a>
    	</div>
    	<div class="intro_content">
    		<div class="intro_image">
				<div class="shadow"></div>
				<div class="image">
					<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${robotintro.nid}"><img alt="" src="${robotintro.imageUrl }"/></a>
				</div>
			</div>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;${robotintro.preContent}····</p>
			<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${robotintro.nid}" class="read">阅读全文</a>
		</div>
   	</div>
  </body>
</html>
