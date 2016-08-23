<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
		function del(o)
		{
			if(confirm("确定删除该新闻吗？"))
			{
				window.location.href="${pageContext.request.contextPath}/articleManage.do?method=del&nid="+o.id;
			}
		}
	</script>
  </head>
  
  <body>
  <div class="publicpanel">
	    <jsp:include flush="true" page="head.jsp"></jsp:include>
     <div class="notice" style="width:1000px;height:650px;left:50%;margin-left:-500px;margin-top:5px;background-color: white;">
    	<div class="notice_content" style="background-color: white;height:650px;overflow:auto;">
    		<ul>
    		<li><br></li>
    		<li style="font-size:15px;margin-left:40px;width:900;font-weight: bold;">
    		<a target="_self" href="javascript:void(0)" style="margin-left:30px;">消息标题</a>
    		<span class="spantime" style="width:80px;margin-right:0px;text-align:center">操&nbsp;&nbsp;&nbsp;&nbsp;作</span>
    		<span class="spantime" style="width:80px;margin-right:0px;">所属模块</span>
    		<span class="spantime" style="width:80px;margin-right:0px;">发布时间</span>
    		<span class="spantime" style="width:80px;margin-right:0px;">发布者</span>
    		</li>
    		<li><br></li>
    		<c:forEach items="${allnews }" var="art">
    			<li style="font-size:14px;margin-left:40px;width:900;"><!-- 标题最长17个字符 -->
    				<a target="_blank" href="${pageContext.request.contextPath}/articleShow.do?method=intro&nid=${art.nid}">
    					<img src="images/direction/right-black-16.png"/>
    					<span class="spantitle">${art.title}<c:if test="${art.mtop==1 }"><span style="color:red;">[置顶]</span></c:if></span>
    				</a>
    				<span class="spantime" style="width:40px;margin-right:0px;">
    				<a id="${art.nid}" href="javascript:void(0)" onclick="del(this)" style="color:blue">删除</a></span>
    				<span class="spantime" style="width:40px;margin-right:0px;">
    				<a href="${pageContext.request.contextPath}/articleManage.do?method=update&nid=${art.nid}" style="color:blue">修改</a></span>
    				<span class="spantime" style="width:80px;margin-right:0px;font-size:12px;">${art.attachment }</span>
    				<span class="spantime" style="width:80px;margin-right:0px;font-size:12px;"><fmt:formatDate value="${art.mdate}" pattern="yyyy-MM-dd"/></span>
    				<span class="spantime" style="width:80px;margin-right:0px;">${art.author }</span>
    			</li>
    		</c:forEach>
    		</ul>
    		<br>
    		<br>
    	<div class="sabrosus">
			<c:if test="${pageNum<=1 }">
				<a target="_self" href="javascript:void(0)" onclick="javascript:alert('已经到达首页！')">上一页</a>
			</c:if>
	    	<c:if test="${pageNum>1 }">
				<a target="_self" href="${pageContext.request.contextPath }/articleManage.do?method=page&pageNum=${pageNum-1}">上一页</a>
			</c:if>
			<c:forEach begin="${pageNum-5>0?(pageNum-5<pageSum-9?pageNum-5:(pageSum-9>0?pageSum-9:1)):1 }" end="${pageSum<10?(pageSum):((pageNum+4)>pageSum?(pageSum):(pageNum+4>10?pageNum+4:10)) }" var="num">
				<c:if test="${pageNum==num }"><a target="_self" class="current" href="${pageContext.request.contextPath }/articleManage.do?method=page&pageNum=${num}">${num}</a></c:if>
				<c:if test="${pageNum!=num }"><a target="_self" href="${pageContext.request.contextPath }/articleManage.do?method=page&pageNum=${num}">${num}</a></c:if>
			</c:forEach>
			<c:if test="${pageNum<pageSum }">
				<a target="_self" href="${pageContext.request.contextPath }/articleManage.do?method=page&pageNum=${pageNum+1}">下一页</a>
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
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(5).addClass("on");
  </script>
</html>
