<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link rel="stylesheet" type="text/css" href="css/admin/head.css">
<link rel="stylesheet" href="css/public.css" type="text/css">


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function open1() {
		$.ajax({
			url : "ChangeDoor?op=1",
			type : "get",
			success : function(msg) {
				$("#odoor").hide();
				$("#cdoor").hide();
				if (msg == "0") {
					$("#odoor").show();
					alert("报名入口已关闭！");
				} else if (msg == "1") {
					$("#cdoor").show();
					alert("报名入口已打开！");
				}
			},
			error : function(msg, status) {
			}
		});
	}
	function close1() {
		$.ajax({
			url : "ChangeDoor?op=0",
			type : "get",
			success : function(msg) {
				$("#odoor").hide();
				$("#cdoor").hide();
				if (msg == "0") {
					$("#odoor").show();
					alert("报名入口已关闭！");
				} else if (msg == "1") {
					$("#cdoor").show();
					alert("报名入口已打开！");
				}
			},
			error : function(msg, status) {
			}
		});
	}
</script>
</head>

<body>
	<div class="adminhead">
		<div class="thetop">
			<a
				href="${pageContext.request.contextPath }/loginAndout.do?method=logout">退出登录</a>
			<a href="${pageContext.request.contextPath }/index.do">返回首页</a>
		</div>
		<div class="themiddle">
			<div>
				<span>欢迎您&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)">${teamadmin.adname}</a>&nbsp;&nbsp;&nbsp;&nbsp;管理员</span>
			</div>
			<div class="info">
				<ul>
					<li>邮箱：<c:out value="${teamadmin.ademail}" default="未设置"></c:out>
					</li>
					<li>赛区：${teamadmin.teamArea.aname}</li>
					<li><a
						href="${pageContext.request.contextPath }/justJump.do?method=uai"
						style="color:rgb(230,230,230);font-size:14px;">修改信息</a></li>
					<li><button id="odoor" style="display:none" onclick="open1()">打开报名入口</button>
						<button id="cdoor" style="display:none" onclick="close1()">关闭报名入口</button>
					</li>
				</ul>
			</div>
		</div>
		<div class="thebottom">
			<ul>
				<li><a
					href="${pageContext.request.contextPath }/manageCom.do?method=area">大赛管理</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/manageApplication.do?method=page">报名审核</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/manageTeams.do?method=showteams&aid=${teamadmin.teamArea.aid}">参赛统计</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/report.do?method=item">项目统计</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/justJump.do?method=publish">新闻发布</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/justJump.do?method=managenews">新闻管理</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/publishLetter.do?method=show">站内公告</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/justJump.do?method=adchpwd">修改密码</a>
				</li>
				<c:if test="${teamadmin.teamArea.aid==0}">
					<li><a
						href="${pageContext.request.contextPath }/manageCom.do?method=adm">添加管理员</a>
					</li>
				</c:if>
				<%--<li><a
					href="${pageContext.request.contextPath }/loginAndout.do?method=logout">退出登录</a>
				</li> --%>
			</ul>
		</div>
	</div>
</body>

<script type="text/javascript">
	$.ajax({
		url : "ChangeDoor",
		type : "get",
		success : function(msg) {
			if (msg == "0") {
				$("#odoor").show();
			} else if (msg == "1") {
				$("#cdoor").show();
			}
		},
		error : function(msg, status) {

		}
	});
</script>

</html>
