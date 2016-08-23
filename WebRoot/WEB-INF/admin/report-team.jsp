<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
		window.location.href = "${pageContext.request.contextPath }/exportExcel.do?method=tinfo&year="
				+ $("#seyear").val();
	}
	function changeYear() {
		window.location.href = "${pageContext.request.contextPath }/manageTeams.do?method=showteams&aid=${teamadmin.teamArea.aid}&year="
				+ $("#seyear").val();
	}
</script>

</head>

<body>
	<div class="publicpanel">
		<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
		<%-- <jsp:include page="/WEB-INF/admin/report-menu.jsp" flush="true"></jsp:include>--%>
		<div class="application" style="overflow: auto;width:1000px;margin:0">
			<div class="operate">
				<h4
					style="float:left;margin: 0px;margin-left: 30px;margin-top: 15px;color:rgb(50,50,50)">${teamadmin.teamArea.aname}赛区总计${schoolcount}所学校参赛</h4>
				<div style="width:330px;float:left;text-align:right;padding:10px;">
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
			<table cellspacing="0" id="teamtable">
				<tr>
					<th>序号</th>
					<th>学校</th>
					<th>队名</th>
					<th>领队</th>
					<th>电话</th>
					<th>成员</th>
					<th>指导老师</th>
				</tr>
				<c:forEach items="${teamInfo}" var="info" varStatus="num">
					<tr>
						<td>${num.count}</td>
						<td><span><c:out value="${info.sname }" default="暂无"></c:out>
						</span></td>
						<td><span><c:out value="${info.tname }" default="暂无"></c:out>
						</span></td>
						<td><span><c:out value="${info.mname }" default="暂无"></c:out>
						</span></td>
						<td><span><c:out value="${info.mphone }" default="暂无"></c:out>
						</span></td>
						<td><c:if test="${fn:length(info.members)>17}">
								<span title="${info.members}">
									${fn:substring(info.members,0,17)}···</span>
							</c:if> <c:if test="${fn:length(info.members)<=17}">
								<span>${info.members}</span>
							</c:if> </span></td>
						<td><span><c:out value="${info.teachers }"
									default="暂无"></c:out> </span></td>
				</c:forEach>
			</table>

			<div class="sabrosus" style="margin-top:20px;">
				<c:if test="${pageNum<=1 }">
					<a target="_self" href="javascript:void(0)"
						onclick="javascript:alert('已经到达首页！')">上一页</a>
				</c:if>
				<c:if test="${pageNum>1 }">
					<a target="_self"
						href="${pageContext.request.contextPath }/manageTeams.do?method=page&pageNum=${pageNum-1}">上一页</a>
				</c:if>
				<c:forEach
					begin="${pageNum-5>0?(pageNum-5<pageSum-9?pageNum-5:(pageSum-9>0?pageSum-9:1)):1 }"
					end="${pageSum<10?(pageSum):((pageNum+4)>pageSum?(pageSum):(pageNum+4>10?pageNum+4:10)) }"
					var="num">
					<c:if test="${pageNum==num }">
						<a target="_self" class="current"
							href="${pageContext.request.contextPath }/manageTeams.do?method=page&pageNum=${num}">${num}</a>
					</c:if>
					<c:if test="${pageNum!=num }">
						<a target="_self"
							href="${pageContext.request.contextPath }/manageTeams.do?method=page&pageNum=${num}">${num}</a>
					</c:if>
				</c:forEach>
				<c:if test="${pageNum<pageSum }">
					<a target="_self"
						href="${pageContext.request.contextPath }/manageTeams.do?method=page&pageNum=${pageNum+1}">下一页</a>
				</c:if>
				<c:if test="${pageNum>=pageSum }">
					<a target="_self" href="javascript:void(0)"
						onclick="javascript:alert('已经到达尾页！')">下一页</a>
				</c:if>
				<span style="color:gray">${pageNum}/${pageSum==0?1:pageSum }</span>
				<br> <br>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
</body>
  <script type="text/javascript">
  $(".thebottom ul").find("a").removeClass("on");
  $(".thebottom ul").find("a").eq(2).addClass("on");
  </script>
</html>
