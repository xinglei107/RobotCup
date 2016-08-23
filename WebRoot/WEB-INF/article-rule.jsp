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
    
    <title>北京市大学生机器人大赛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/article-notice.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
        <div class="notice" style="width:320px;float:left">
    	<div class="notice_title">
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=3" class="left"><span >竞赛规则</span></a>
			<a target="_blank" href="${pageContext.request.contextPath}/more.do?method=list&atid=3" class="right"><span >more++</span></a>
    	</div>
    	<div class="notice_content">
    		<ul>    		   		
	    		<c:forEach items="${rule}" var="rul">
	    			<li><!-- 标题最长17个字符 -->
	    				<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${rul.nid}" title="${rul.title }">
	    				<img src="images/rightlist.png"/>
	    				<span class="spantitle">${fn:length(rul.title)>17?fn:substring(rul.title,0,17):rul.title}
	    				<c:if test="${rul.mtop==1 }"><span style="color:red;">[置顶]</span></c:if></span>
	    				</a><span class="spantime"><fmt:formatDate value="${rul.mdate}" pattern="yyyy-MM-dd"/></span>
	    			</li>
	    		</c:forEach>
    		</ul>
		</div>
   	</div>
  </body>
</html>
