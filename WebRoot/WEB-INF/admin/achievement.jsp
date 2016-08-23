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
	<link rel="stylesheet" type="text/css" href="css/admin/application.css">
  	<link rel="stylesheet" href="css/public.css" type="text/css">
	
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  	<script type="text/javascript">
	  	$(document).ready(function(){
	    	$("#apptable tr").mouseover(function(){
    		$(this).addClass("over");}).mouseout(function(){ 
            $(this).removeClass("over");});
  			$("#teamtable tr:even").addClass("alt");
	  	});  
  	</script>

  </head>
  
  <body>
    <div class="publicpanel">
    <jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
    	<div class="application">
    		<div class="operate">
    		<form action="${pageContext.request.contextPath }/exportExcel.do">
    		<input type="hidden" name="method" value="tinfo">
    			<button type="submit"><img alt="导出当前数据" src="images/excel.png"><span>导出当前数据</span></button>
    		</form></div>  		
    		<table cellspacing="0" id="teamtable">
    			<tr>
    			<th>序号</th>
			    <th>队名</th>
			    <th>领队</th>
			    <th>性别</th>
			    <th>身份</th>
			    <th>电话</th>
			    <th>邮箱</th>
			    <th>学校
			    	<select name="sid" id="sid" onchange="javascript:alert($('#sid option:selected').val())">
    				<option selected="selected" value="0">全部学校</option>
    				<c:forEach items="${schlist }" var="sch">
    				<option value="${sch.stname }" id="${sch.sid }">${sch.sname }</option>
    				</c:forEach>
    				</select>
			    </th>
			    <th>
					<select name="aid" id="aid" onchange="javascript:alert($('#aid option:selected').val())">
    				<option selected="selected" value="0">全部赛区</option>
    				<c:forEach items="${arealist }" var="area">
    				<option value="${area.aname }" id="${area.aid }">${area.aname }</option>
    				</c:forEach>
    				</select>
				</th>
			    <th>成绩
				</th>
			    </tr>
    			<c:forEach items="${teamInfo}" var="info" varStatus="num">
			  	<tr class="row"><td class="num">${num.count }</td>
			  	<td><span><c:out value="${info.tname }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.mname }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.mgender }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.mtype }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.mphone }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.memail }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.sname }" default="暂无"></c:out></span></td>
			  	<td><span><c:out value="${info.aname }" default="暂无"></c:out></span></td></tr>
			  	</c:forEach>
    		</table>
    	</div>  
    </div>
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
</html>
