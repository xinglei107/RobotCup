<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
	<link rel="stylesheet" href="css/article-notice.css" type="text/css">
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
        <div class="notice">
    	<div class="notice_title">
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=4" class="left"><span >比赛日程</span></a>
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=4" class="right"><span >more++</span></a>
    	</div>
    	<div class="notice_content">
    		<ul>
    		<c:forEach items="${schedule }" var="sch">
    			<li><!-- 标题最长十八个字符 -->
    				<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${sch.nid}" title="${sch.title }">
    				<img src="images/message.png"/><span class="spantitle">
    				${fn:length(sch.title)>17?fn:substring(sch.title,0,17):sch.title}
    				<c:if test="${sch.mtop==1 }"><span style="color:red;">[置顶]</span></c:if></span></a>
    				<span class="spantime"><fmt:formatDate value="${sch.mdate}" pattern="yyyy-MM-dd"/></span>
    			</li>
    		</c:forEach>
    		</ul>
		</div>
   	</div>
  </body>
</html>
