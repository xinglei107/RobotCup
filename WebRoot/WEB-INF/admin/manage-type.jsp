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
 		if(confirm("如果本记录下存在子记录，则会一并删除，确定要删除吗？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=deltype&tyid="+o.id;
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
    			<p style="font-size:20px;color:orange;font-weight:bold;">项目分类管理</p>
    			<form action="${pageContext.request.contextPath }/addType.do" method="post" onsubmit="return checktype()">
	    			<table>
					<tr><td>类别名</td><td><input type="text" name="tyname" id="tyname"/></td><td><button type="submit">添加</button></td><td>
    					<c:if test="${addres==1}"><a style="color:red;">添加成功！</a></c:if>
    					<c:if test="${addres==0}"><a style="color:red;">已经存在该类别！</a></c:if>
    				</td></tr>
    				</table>
    			</form>
    			</div>
    			<div class="current">
    				<div>
    				<table cellspacing="0">
    				<tr><th>序号</th><th>名称</th><th>操作</th></tr>
						<c:forEach var="type" items="${tlist}" varStatus="num">
    					<tr>
	 		    			<td>${num.count}</td>
	 		    			<td>${type.tyname}</td>
	 		    			<td><a id="${type.tyid}" onclick="delcon(this)">删除</a></td>
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
