<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" href="css/admin/application.css" type="text/css">
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
		$("#apptable tr:even").addClass("alt");
		$("div.sabrosus a").click(function() {
			$(".current").removeClass("current");
			$(this).addClass("current");
		});
	});
	function del(o) {
		if (confirm("将会删除此条报名信息！确定删除吗？")) {
			window.location.href = "${pageContext.request.contextPath }/manageApplication.do?method=del&appid="
					+ o.id;
		}
	}
	function outputExcel() {
		window.location.href = "${pageContext.request.contextPath }/exportExcel.do?method=app&year="
				+ $("#seyear").val();
	}
	function changeYear() {
		window.location.href = "${pageContext.request.contextPath }/manageApplication.do?method=page&year="
				+ $("#seyear").val();
	}
</script>

</head>

<body>
	<div class="publicpanel">
		<jsp:include page="/WEB-INF/admin/head.jsp" flush="true"></jsp:include>
		<%--<jsp:include page="/WEB-INF/admin/report-menu.jsp" flush="true"></jsp:include> --%>
		<div class="application" style="overflow: auto;width:1000px;margin:0">
			<div class="operate">
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
				<div style="width:550px;float:left;text-align:right;padding:10px;">
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
				<button title="将全部数据导出到一个Excel文件中" onclick="outputExcel()">
					<img src="images/excel.png"><span>导出全部数据</span>
				</button>
				<!-- <button title="将数据按项目分别导出到多个Excel文件中" onclick="window.location.href='${pageContext.request.contextPath }/exportExcel.do'"><img src="images/excel.png"><span>按项目导出数据</span></button> -->
			</div>
			<form action="" method="post" id="form1">
				<table cellspacing="0" id="apptable">
					<tr>
						<th><a>序号</a>
						</th>
						<th><a>选择</a>
						</th>
						<th><a>学校</a>
						</th>
						<th><a>队名</a>
						</th>
						<th><a>领队</a>
						</th>
						<th><a>成员</a>
						</th>
						<th><a>指导教师</a>
						<th>项目</th>
						<th>状态</th>
						<th colspan="3">操作</th>
					</tr>
					<c:forEach items="${application }" var="app" varStatus="num">
						<tr>
							<td>${num.count}</td>
							<td><input type="checkbox" value="${app.appid}"
								class="selall" name="check[]">
							</td>
							<td>${app.sname }</td>
							<td>${app.tname }</td>
							<td>${app.mname }</td>
							<c:if test="${fn:length(app.members)>11}">
								<td title="${app.members}">${fn:substring(app.members,0,11)}···</td>
							</c:if>
							<c:if test="${fn:length(app.members)<=11}">
								<td>${app.members}</td>
							</c:if>

							<td>${app.teacherName }</td>
							<td>${app.itname }</td>
							<td style="color:red">${app.appstates }</td>
							<td><a
								href="${pageContext.request.contextPath }/manageApplication.do?method=permit&appid=${app.appid}">通过</a>
							</td>
							<td><a
								href="${pageContext.request.contextPath }/manageApplication.do?method=refuse&appid=${app.appid}">拒绝</a>
							</td>
							<td><a class="del" href="javascript:void(0)"
								onclick="del(this)" id="${app.appid}">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="12" align="left">

							<button type="button" style="cursor:pointer;" onclick="selAll()">全选</button>
							<button type="button" style="cursor:pointer;"
								onclick="selContrary()">反选</button>
							<button type="button" style="cursor:pointer;" onclick="perSel()">通过</button>
							<button type="button" style="cursor:pointer;" onclick="refSel()">拒绝</button>
							<button type="button" style="cursor:pointer;" onclick="delSel()">删除</button>
						</td>
					</tr>
				</table>
			</form>
			<div class="sabrosus" style="margin-top:20px;">
				<c:if test="${appPageNum<=1 }">
					<a target="_self" href="javascript:void(0)"
						onclick="javascript:alert('已经到达首页！')">上一页</a>
				</c:if>
				<c:if test="${appPageNum>1 }">
					<a target="_self"
						href="${pageContext.request.contextPath }/manageApplication.do?method=page&appPageNum=${appPageNum-1}">上一页</a>
				</c:if>
				<c:forEach
					begin="${appPageNum-5>0?(appPageNum-5<pageSum-9?appPageNum-5:(pageSum-9>0?pageSum-9:1)):1 }"
					end="${pageSum<10?(pageSum):appPageNum+4>pageSum?(pageSum):appPageNum+4>10?appPageNum+4:10 }"
					var="num">
					<c:if test="${appPageNum==num }">
						<a target="_self" class="current"
							href="${pageContext.request.contextPath }/manageApplication.do?method=page&appPageNum=${num}">${num}</a>
					</c:if>
					<c:if test="${appPageNum!=num }">
						<a target="_self"
							href="${pageContext.request.contextPath }/manageApplication.do?method=page&appPageNum=${num}">${num}</a>
					</c:if>
				</c:forEach>
				<c:if test="${appPageNum<pageSum }">
					<a target="_self"
						href="${pageContext.request.contextPath }/manageApplication.do?method=page&appPageNum=${appPageNum+1}">下一页</a>
				</c:if>
				<c:if test="${appPageNum>=pageSum }">
					<a target="_self" href="javascript:void(0)"
						onclick="javascript:alert('已经到达尾页！')">下一页</a>
				</c:if>
				<span style="color:gray">${appPageNum}/${pageSum==0?1:pageSum
					}</span> <br> <br>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/tail.jsp" flush="true"></jsp:include>
</body>
<script type="text/javascript">
	$(".thebottom ul").find("a").removeClass("on");
	$(".thebottom ul").find("a").eq(1).addClass("on");

	function selAll() {
		$.each($("input[name='check[]']"), function(i, n) {
			this.checked = "checked";
		});
	}
	function selContrary() {
		$.each($("input[name='check[]']"), function(i, n) {
			this.checked = !this.checked;
		});
	}
	function getCheckValue() {
		var vals = [];
		$.each($("input[name='check[]']"), function(i, n) {
			if (this.checked) {
				vals.push(this.value);
			}
		});
		return vals;
	}
	function perSel() {
		var vals = getCheckValue();
		if(vals.length==0){
			alert("请选择要通过的项目");
			return;
		}
		$("#form1").attr("action","<%=basePath%>manageApplication.do?method=persel");
		$("#form1").submit();
	}
	function refSel() {
		var vals = getCheckValue();
		if(vals.length==0){
			alert("请选择要拒绝的项目");
			return;
		}
		$("#form1").attr("action","<%=basePath%>manageApplication.do?method=refsel");
		$("#form1").submit();
	}
	function delSel() {
		var vals = getCheckValue();
		if(vals.length==0){
			alert("请选择要删除的项目");
			return;
		}
		if (confirm("确认删除选中的项目吗？")) {
			var vals = getCheckValue();
			$("#form1").attr("action","<%=basePath%>manageApplication.do?method=delsel");
			$("#form1").submit();
		}

	}
</script>
</html>
