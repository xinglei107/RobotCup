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
  <script type="text/javascript" src="js/addcheck.js" charset="gbk"></script>

  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript">
 	function delcon(o){
 		if(confirm("确定要删除吗？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageImage.do?method=del&nid="+o.id;
 		}
 	}
 </script>
  </head>

  <body>    
    <div class="publicpanel">
    	<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
    	<jsp:include page="/WEB-INF/admin/manage-com.jsp" flush="true"></jsp:include>
    	<div class="competition">
    		<div class="panel">
    			<div class="add">
    			<p style="font-size:20px;color:orange;font-weight:bold;">首页展示</p>
    			<form action="${pageContext.request.contextPath }/indexImage.do" method="post" enctype="multipart/form-data" onsubmit="return checkimg()">
	    			<input type="hidden" value="${teamadmin.adid }" name="adid">
	    			<table>
	    				<tr><td>标题</td><td><input type="text" name="title" id="title"/></td></tr>
	    				<tr><td>图片</td><td><input type="file" name="path" id="path" onchange="checkimage(this)"/></td></tr>
	    				<tr><td><button type="submit">添加</button></td><td>
	    				<c:if test="${res==1}"><span style="color:red">插入成功</span></c:if>
	    				<c:if test="${res==0}"><span style="color:red">文件类型不合法！</span></c:if>
    				</td></tr>
	    			</table>
	    		</form>
    			</div>
    			<div class="current">
    				<div>
    				<table cellspacing="0">
    				<tr><th>序号</th><th>标题</th><th>图片名</th><th>操作</th></tr>
						<c:forEach var="pic" items="${imglist}" varStatus="num">
    					<tr>
	 		    			<td>${num.count}</td>
	 		    			<td>${pic.mtitle}</td>
	 		    			<td>${pic.matname}</td>
	 		    			<td><a id="${pic.nid}" onclick="delcon(this)">删除</a></td>
	 		    		</tr>
	 		    		</c:forEach>
    				</table>
    				</div>
    			</div>
    		</div>    		
    	</div>
    </div>
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
</html>
