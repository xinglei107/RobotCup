<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
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
	<link rel="stylesheet" href="css/article.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
	<script src="js/jquery.min.js"></script>
  	<script type="text/javascript">
		$(document).ready(function(){
		  $("div.sabrosus a").click(function(){
		  	$(".current").removeClass("current");
		    $(this).addClass("current");
		  });
		});
	</script>
  </head>
  
  <body>
  <div class="publicpanel">
    <jsp:include flush="true" page="/WEB-INF/head.jsp"></jsp:include>
    <jsp:include flush="true" page="/WEB-INF/article-menu.jsp"></jsp:include>
     <div class="notice" style="width:795px;float:left;height:550px;margin-left:5px;">
    	<div class="notice_title">
			<a class="left"><span >文章列表</span></a>
    	</div>
    	<div class="notice_content" style="background-color: white;height:515px;">
    		<ul>
    			<li><br></li>
    			<logic:empty name="artlist">
    			<li style="font-size:16px;margin-left:40px;width:auto;">暂时没有数据</li>
    			</logic:empty>
    			<c:forEach items="${artlist}" var="art">
	    			<li style="font-size:14px;margin-left:40px;width:auto;"><!-- 标题最长17个字符 -->
	    				<a target="_blank" href="${pageContext.request.contextPath }/articleShow.do?method=intro&nid=${art.nid}" title="${art.title}"><img src="images/direction/right-black-16.png"/>
	    				<span class="spantitle">${art.title}<c:if test="${art.mtop==1 }"><span style="color:red;">[置顶]</span></c:if></span>
	    				</a><span class="spantime" style="font-size:12px;margin-right:30px;width:auto;"><fmt:formatDate value="${art.mdate}" pattern="yyyy-MM-dd"/></span>
	    			</li>
	    		</c:forEach>
    		</ul>
    		<br>
    		<br>
    		<br>
    	<div class="sabrosus">
	    	<c:if test="${pageNum<=1 }">
				<a target="_self" href="javascript:void(0)" onclick="javascript:alert('已经到达首页！')">上一页</a>
			</c:if>
	    	<c:if test="${pageNum>1 }">
				<a target="_self" href="${pageContext.request.contextPath }/more.do?method=list&atid=${cat}&pageNum=${pageNum-1}">上一页</a>
			</c:if>
			<c:forEach begin="${pageNum-5>0?(pageNum-5<pageSum-9?pageNum-5:(pageSum-9>0?pageSum-9:1)):1 }" end="${pageSum<10?(pageSum):((pageNum+4)>pageSum?(pageSum):(pageNum+4>10?pageNum+4:10)) }" var="num">
				<c:if test="${pageNum==num }"><a target="_self" class="current" href="${pageContext.request.contextPath }/more.do?method=list&atid=${cat}&pageNum=${num}">${num}</a></c:if>
				<c:if test="${pageNum!=num }"><a target="_self" href="${pageContext.request.contextPath }/more.do?method=list&atid=${cat}&pageNum=${num}">${num}</a></c:if>
			</c:forEach>
			<c:if test="${pageNum<pageSum }">
				<a target="_self" href="${pageContext.request.contextPath }/more.do?method=list&atid=${cat}&pageNum=${pageNum+1}">下一页</a>
			</c:if>
			<c:if test="${pageNum>=pageSum }">
				<a target="_self" href="javascript:void(0)" onclick="javascript:alert('已经到达尾页！')">下一页</a>
			</c:if>
			<span style="color:gray">${pageNum}/${pageSum==0?1:pageSum }</span>
		</div>
    		<br>
		</div>  
   	</div></div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
