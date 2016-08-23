<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="css/article-menu.css">
  	<link rel="stylesheet" href="css/public.css" type="text/css">

  </head>
  
  <body>
	 <div class="articlemenu">
    	<div class="articlemenutitle"><a href="${pageContext.request.contextPath }/justJump.do?method=baseinfo">团队管理</a></div>
   		<div class="menucontent" style="height:650px;"><br>
   			<ul>
   				<li><a href="${pageContext.request.contextPath }/justJump.do?method=baseinfo"><img src="images/rightlist.png"/><span class="spanlist">基本信息</span></a></li>
   				<li><a href="${pageContext.request.contextPath }/updateTeamMember.do?method=showmember&tid=${teamuser.tid}"><img src="images/rightlist.png"/><span class="spanlist">成员管理</span></a></li>
   				<li><a href="${pageContext.request.contextPath }/updateTeamItems.do?method=show&tid=${teamuser.tid}"><img src="images/rightlist.png"/><span class="spanlist">参赛项目</span></a></li>
   				<li><a href="${pageContext.request.contextPath }/justJump.do?method=letterlist"><img src="images/rightlist.png"/><span class="spanlist">站内公告</span></a></li>
   				<li><a href="${pageContext.request.contextPath }/justJump.do?method=changepwd"><img src="images/rightlist.png"/><span class="spanlist">修改密码</span></a></li>
   				<li><hr></li>
   				<li><a href="${pageContext.request.contextPath }/loginAndout.do?method=logout"><img src="images/rightlist.png"/><span class="spanlist">退出登录</span></a></li>
   			</ul><br>
   		</div>
    </div>
  </body>
</html>
