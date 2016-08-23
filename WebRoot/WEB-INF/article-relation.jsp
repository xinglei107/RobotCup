<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
  	<link rel="stylesheet" href="css/public.css" type="text/css"></link>
  </head>
  
  <body>
     <div class="notice" style="width:250px;float:rihgt">
    	<div class="notice_title">
			<a class="left"><span >相关文章</span></a>
    	</div>
    	<div class="notice_content"style="height:auto;overflow:hidden;">
    		<ul>
    		<li><br></li>
    		<c:forEach items="${relation}" var="rela">
    			<li><!-- 标题最长17个字符 -->
    				<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${rela.nid}" title="${rela.title }">
    					<img src="images/rightlist.png"/>
    					<span class="spantitle">
						${fn:length(rela.title)>15?fn:substring(rela.title,0,15):rela.title}
						<c:if test="${rela.mtop==1 }"><span style="color:red;">[置顶]</span></c:if>
					</span></a>
    			</li>
    		</c:forEach>    			
    		</ul>
    		<br>
    		<br>
		</div>
   	</div>
  </body>
</html>
