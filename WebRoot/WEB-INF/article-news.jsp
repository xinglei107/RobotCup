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
    
    <title>北京市大学生机器人大赛</title>

  	<link rel="stylesheet" href="css/article-news.css" type="text/css"></link>  
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
    <div class="news">
    	<div class="news_title">
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=1" class="left"><span >新闻动态</span></a>
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=1" class="right"><span >more++</span></a>
		</div>
    	<div class="news_content">
    		<ul>
    		<c:forEach items="${newsimp }" var="news">
   				<li>
   				<div class="word"><!--标题30内容 40个字 ；标题15内容55-->
   					<div class="shadow"></div>
   					<div class="image">
   						<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${news.nid}"><img alt="" src="${news.imageUrl }"/></a>
   					</div>
   					<div class="article">
   						<p class="title"><a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${news.nid}" title="${news.title }">${news.title }<c:if test="${news.mtop==1 }"><span style="color:red;">[置顶]</span></c:if></a></p>
   						<p class="content"><a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${news.nid}" class="more">${news.preContent}···
   						</a></p>
   					</div>
   				</div>
   				</li>
   				</c:forEach>
    		</ul>
    	</div>
    </div>
  </body>
</html>
