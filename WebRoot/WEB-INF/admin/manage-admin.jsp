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
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=deladm&adid="+o.id;
 		}
 	}
 	function reP(o){
 		if(confirm("密码将会被重置为123456，是否继续？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=resetAdPwd&adid="+o.id;
 		}
 	}
 	function ceP(o){
 		if(confirm("密码将会被重置为000000，是否继续？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=clearAdPwd&adid="+o.id;
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
    			<p style="font-size:20px;color:orange;font-weight:bold;">添加管理员</p>
    			<form action="${pageContext.request.contextPath }/addAdmin.do" method="post" onsubmit="return checkadmin()">
	    			<table>
    				<tr><td>赛区</td>
    				<td>
						<select name="aid">
							<c:forEach var="area" items="${alist}">
							<c:if test="${adform.aid==area.aid }"><option value="${area.aid }" selected="selected">${area.aname}</option></c:if>
							<c:if test="${adform.aid!=area.aid }"><option value="${area.aid }">${area.aname}</option></c:if>
							</c:forEach>
						</select>
					</td></tr>
					<tr><td>管理员名</td><td><input type="text" name="adname" id="adname"/></td></tr>
    				<tr><td>初始密码</td><td><input type="password" name="adpwd" id="adpwd"/></td></tr>
					<tr><td>确认密码</td><td><input type="password" name="repwd" id="repwd"/></td></tr>
    				<tr><td><button type="submit">添加</button></td>
    				<td>
    					<c:if test="${addres==1}"><a style="color:red;">添加成功！</a></c:if>
    					<c:if test="${addres==0}"><a style="color:red;">已经存在该管理员！</a></c:if>
    				</td></tr>
    			</table>
    			</form>
    			</div>
    			<div class="current">
    				<div>
    				<table cellspacing="0">
    				<tr><th>序号</th><th>名称</th><th>所属赛区</th><th>操作</th><th>密码</th></tr>
						<c:forEach var="adm" items="${adlist}" varStatus="num">
    					<tr>
	 		    			<td>${num.count}</td>
	 		    			<td>${adm.adname}</td>
	 		    			<td>${adm.teamArea.aname}</td>
	 		    			<td><a id="${adm.adid}" onclick="delcon(this)">删除</a></td>
	 		    			<td><a id="${adm.adid}" onclick="reP(this)">重置</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="${adm.adid}" onclick="ceP(this)">清零</a></td>
	 		    		</tr>
	 		    		</c:forEach>
    				</table>
    				<%
    					Object o=request.getAttribute("resetPwd");
    					if(o!=null){
    						String txt=o.toString();%>
    					<script>
    						var txt="<%=txt%>";
    						alert("密码已重置为："+txt);
    					</script>
    				<%
    					}
    				 %>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
  </body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(8).addClass("on");
  </script>
</html>
