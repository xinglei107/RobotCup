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

  <link rel="stylesheet" href="css/teamuser/menage.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  	
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript">
  	function del(o){
  		if(confirm("确认删除吗？"))
  		{
  			window.location.href="${pageContext.request.contextPath }/updateTeamMember.do?method=del&mid="+o.id;
  		}
  	}
  </script>
  </head>
  
  <body>
   	 <div class="publicpanel">
	    <jsp:include flush="true" page="team_info.jsp"></jsp:include>
	    <jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
	    <div class="manage">
   			<div class="manage_title">
				<a class="left"><span >成员管理</span></a>
   			</div>
    		<div class="manage_content">
    			<div class="perpanel">
    				<div class="operate">
    					<span>指导教师</span>
    				</div>
    				<c:forEach items="${teamMember }" var="member">
    				<c:if test="${member.mtype eq '教师' }">
			    		<div class="person" onclick="">
		    				<span class="name">${member.mname }</span>
		    				<hr>
		    				<span>${member.mgender }</span><br>
		    				<span>${member.mphone }</span><br>
		    				<span>${member.memail }</span><br>
		    				<c:if test="${member.mleader==1 }">
		    					<span class="leader">领队</span>
		    				</c:if>
		    				<a href="${pageContext.request.contextPath }/updateTeamMember.do?method=updatemember&mid=${member.mid}" class="update">修改</a>
		    				<a href="javascript:void(0)" onclick="del(this)" class="update" id=${member.mid }>删除</a>
			    		</div>
		    		</c:if>
		    		</c:forEach>	
		    		<div class="person">
		    			<button onclick="window.location.href='${pageContext.request.contextPath }/updateTeamMember.do?method=addmember&type=1'" ><img alt="添加教师" src="images/add.png"></button>
		    		</div>	    		
	    		</div>
	    		<hr>
    			<div class="perpanel">
    				<div class="operate">
    					<a><span >参赛学生</span><span style="color:red;font-size:12px">（请不要在此处录入教师信息）</span></a>
    				</div>
		    		<c:forEach items="${teamMember }" var="member">
		    		<c:if test="${member.mtype eq '学生' }">
			    		<div class="person">
		    				<span class="name">${member.mname }</span>
		    				<hr>
		    				<span>${member.mgender }</span><br>
		    				<span>${member.mphone }</span><br>
		    				<span>${member.memail }</span><br>
		    				<c:if test="${member.mleader==1 }">
		    					<span class="leader">领队</span>
		    				</c:if>
		    				<a href="${pageContext.request.contextPath }/updateTeamMember.do?method=updatemember&mid=${member.mid}" class="update">修改</a>
		    				<a href="javascript:void(0)" onclick="del(this)" class="update" id=${member.mid }>删除</a>
			    		</div>
		    		</c:if>
		    		</c:forEach>	
		    		<div class="person">
		    			<button  onclick="window.location.href='${pageContext.request.contextPath }/updateTeamMember.do?method=addmember&type=0'"><img alt="添加学生" src="images/add.png"></button>
		    		</div>
		    	</div>
    		</div>
  		</div>
  	</div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
	  <% String errMsg=(String)request.getAttribute("errMsg"); 
	  	if(errMsg!=null){
	  %>
	  <script type="text/javascript">
	  alert("<%=errMsg%>");
	  </script>
	  <%} %>
  </body>
</html>
