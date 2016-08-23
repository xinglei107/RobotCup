<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">

	<link rel="stylesheet" href="css/article-notice.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
        <div class="notice" style="width:320px;float:left;margin-left:10px">
    	<div class="notice_title">
			<a href="${pageContext.request.contextPath}/more.do?method=list&atid=9" class="left"><span >附件下载</span></a>
			<a href="${pageContext.request.contextPath}/more.do?method=list&atid=9" class="right"><span >more++</span></a>
    	</div>
    	<div class="notice_content">
    		<ul>
    		<c:forEach items="${attlist}" var="att">
    			<li><!-- 标题最长十八个字符 -->
    				<a href="${pageContext.request.contextPath }/download.do?name=${att.name}&relname=${att.relname}" title="${att.relname }"><img src="images/bluedown.png"/>
    				<span class="spantitle">${fn:length(att.relname)>21?fn:substring(att.relname,0,21):att.relname}
    				<c:if test="${att.top==1 }"><span style="color:red;">[置顶]</span></c:if>
    				</span></a>
    			</li>
    		</c:forEach>
    		</ul>
		</div>
   	</div>
  </body>
</html>
