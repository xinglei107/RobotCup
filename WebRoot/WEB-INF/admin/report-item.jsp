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

<link rel="stylesheet" type="text/css" href="css/admin/application.css">
<link rel="stylesheet" href="css/public.css" type="text/css">
<link rel="stylesheet" href="css/article.css" type="text/css"></link>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#apptable tr").mouseover(function() {
			$(this).addClass("over");
		}).mouseout(function() {
			$(this).removeClass("over");
		});
		$("#teamtable tr:even").addClass("alt");

		$("div.sabrosus a").click(function() {
			$(".current").removeClass("current");
			$(this).addClass("current");
		});
	});
	function outputExcel() {
		window.location.href = "${pageContext.request.contextPath }/exportExcel.do?method=itinfo&year="
				+ $("#seyear").val();
	}
	function changeYear() {
		window.location.href = "${pageContext.request.contextPath }/report.do?method=item&year="
				+ $("#seyear").val();
	}
</script>

</head>

<body>
	<div class="publicpanel">
		<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
		<%--<jsp:include page="/WEB-INF/admin/report-menu.jsp" flush="true"></jsp:include> --%>
		<div class="application" style="width:1000px;margin:0">
		<br>
		<div style="width:98%;border:1px solid gray;margin:0 auto;">
		<table cellspacing="0" id="teamtable">
			<tr>
				<th>参数学校</th>
				<th>参数队伍</th>
				<th>参赛学生（人）</th>
				<th>参赛教师（人）</th>
			</tr>
			<tr>
				<td style="text-align: center">${schC }</td>
				<td style="text-align: center">${teamC }</td>
				<td style="text-align: center">${stuC }</td>
				<td style="text-align: center">${teaC }</td>
			</tr>
		</table>
		</div>
			<div class="operate">
				<div style="width:500px;float:left;text-align:right;padding:10px;">
					<%
						int startYear = 2014;
						Date date = new Date();
						int year = date.getYear() + 1900;
						ArrayList<Integer> yearList = new ArrayList<Integer>();
						for (int i = 2014; i <= year; ++i) {
							yearList.add(i);
						}
						request.setAttribute("yearList", yearList);
					%>
					年份<select id="seyear" name="year" onchange="changeYear()">
						<c:forEach items="${yearList }" var="year">
							<c:if test="${year == curYear }">
								<option selected value="${year }">${year }</option>
							</c:if>
							<c:if test="${year != curYear}">
								<option value="${year }">${year }</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<button onclick="outputExcel()">
					<img alt="导出当前数据" src="images/excel.png"><span>导出当前数据</span>
				</button>
			</div>
			<div style="width:98%;height:480px;overflow:auto;border:1px solid gray;margin:0 auto">
				<table cellspacing="0" id="teamtable">
					<tr>
						<th>序号</th>
						<th>项目名</th>
						<th>参赛学生（人）</th>
						<th>指导教师（人）</th>
						<th>总计</th>
					</tr>
					<c:forEach items="${itemInfo}" var="info" varStatus="num">
						<tr>
							<td>${num.count}</td>
							<td><span><c:out value="${info.itname }" default="暂无"></c:out>
							<c:if test="${info.visible == 0 }"><span style="color:red">（已关闭）</span></c:if></span>
							</td>
							<td><span><c:out value="${info.students }"
										default="暂无"></c:out> </span>
							</td>
							<td><span><c:out value="${info.teachers }"
										default="暂无"></c:out> </span>
							</td>
							<td><span><c:out value="${info.sum_s_t }"
										default="暂无"></c:out> </span>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
</body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(3).addClass("on");
  </script>
</html>
