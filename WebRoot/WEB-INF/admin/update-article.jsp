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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="ckfinder/ckfinder.js"></script>
	<link rel="stylesheet" type="text/css" href="css/admin/publish.css">
  	<link rel="stylesheet" href="css/public.css" type="text/css">

  <script type="text/javascript" src="js/check.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script></head>
  
  <body>  
    <div class="publicpanel">
    <jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
    	<form name="form" enctype="multipart/form-data" action="${pageContext.request.contextPath}/updateArticle.do" method="post" onsubmit="return checkarticle()">
		<div class="publishcontent">
			<div class="ckeditor">
			<table>
				<tr><th colspan="3"><h2>文章发布</h2></th></tr>
				<tr><td><span class="must">文章类型</span></td><td>
					<select name="atid">
					<c:forEach items="${attlist}" var="att">
						<c:if test="${upart.robotAttachment.atid==att.atid}">
							<option value="${att.atid }" selected="selected">${att.atname }</option>
						</c:if>
						<c:if test="${upart.robotAttachment.atid!=att.atid}">
							<option value="${att.atid }">${att.atname }</option>
						</c:if>
					</c:forEach>
					</select>
				</td><td>置顶
					<c:if test="${upart.mtop==1}"><input class="mtop" type="checkbox" name="mtop" checked="checked" value="1"></c:if>
					<c:if test="${upart.mtop!=1}"><input class="mtop" type="checkbox" name="mtop" value="1"></c:if>
				</td></tr>
				<tr><td><span class="must">文章标题</span></td><td><input type="text" name="mtitle" id="mtitle" value="${upart.mtitle}"></td><td></td></tr>
			</table>					
			<textarea id="mcontent" name="mcontent" class="ckeditor">&nbsp;${upart.mcontent}</textarea>
			<table>
				<tr><td><span>原附件</span></td><td><input type="text" readonly="readonly" value="${upart.matname }" name="relname"></td><td><span class="must">（将被覆盖）</span></td></tr>
	
				<tr><td><span>新附件</span></td>
				<td><input type="file" onchange="checkfilename(this)" name="mattachment" value="${upart.matname }"></td>
				</tr>
			</table>
			</div>
			
			<div class="operate">
				<input type="hidden" value="${upart.nid}" name="nid">
				<input type="hidden" value="${upart.mattachment}" name="md5name">
				<input type="hidden" value="${teamadmin.adid}" name="adid">
				<!-- <input onclick="window.location.href='${pageContext.request.contextPath}/justJump.do?method=prepublish'" type="button" value="预  览" /> -->
				<input type="submit" value="发  布" />
				<p style="color:red;font-size:12px;">重要提示：上传的图片请勿使用汉字命名。<br>文章中图片的宽度不要超过600，否则会导致显示越界。您可以在图片属性窗口中直接设置图片宽度。</p>
			</div>
		</div>
		</form>
    </div>
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(4).addClass("on");
  </script>
</html>
