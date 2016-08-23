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
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=delsch&sid="+o.id;
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
    			<p style="font-size:20px;color:orange;font-weight:bold;">学校管理</p>
    			<form id="addForm" action="${pageContext.request.contextPath }/addUnversity.do" method="post" onsubmit="return checkschool()">
	    			<table>
    				<tr><td>赛区</td>
    				<td>
						<select name="aid">
							<c:forEach var="area" items="${alist}">
							<c:if test="${sform.aid==area.aid }"><option value="${area.aid }" selected="selected">${area.aname}</option></c:if>
							<c:if test="${sform.aid!=area.aid }"><option value="${area.aid }">${area.aname}</option></c:if>
							</c:forEach>
						</select>
					</td></tr>
					<tr><td>学校名</td><td><input type="text" name="sname" id="sname"/></td></tr>
    				<tr><td><button type="submit">添加</button></td>
    				<td>
    					<c:if test="${addres==1}"><a style="color:red;">添加成功！</a></c:if>
    					<c:if test="${addres==0}"><a style="color:red;">已经存在该学校！</a></c:if>
    					<c:if test="${chgres==1}"><a style="color:red;">修改成功！</a></c:if>
    				</td></tr>
    			</table>
    			</form>
    			<form id="chgForm" style="display:none" action="${pageContext.request.contextPath }/ChgUniversity" method="post">
	    			<table>
    				<tr><td>原校名</td><td><input type="text" name="yname" id="yname" readonly/></td></tr>
					<tr><td>新校名</td><td><input type="text" name="nname" id="nname"/></td></tr>
    				<tr><td><button type="submit">修改</button></td><td>
    				
    				</td></tr>
    			</table>
    			</form>
    			</div>
    			<div class="current">
    				<div>
    				<table cellspacing="0">
    				<tr><th>序号</th><th>名称</th><th>所属赛区</th><th>操作</th></tr>
						<c:forEach var="sch" items="${slist}" varStatus="num">
    					<tr>
	 		    			<td>${num.count}</td>
	 		    			<td>${sch.sname}</td>
	 		    			<td>${sch.teamArea.aname}</td>
	 		    			<td><a id="${sch.sid}" onclick="delcon(this)">删除</a>&nbsp;&nbsp;&nbsp;<a id="${sch.sname}" onclick="edit(this)">修改</a></td>
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
  <script>
  	function edit(o){
  		$("#addForm").hide();
  		$("#chgForm").show();
  		$("#yname").val(o.id);  		
  	}
  	
  </script>
</html>
