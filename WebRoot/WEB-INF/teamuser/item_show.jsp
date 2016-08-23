<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Object stuCount_ = request.getSession().getAttribute("stuCount");
	int stuCount = 0;
	if (stuCount_ != null) {
		stuCount = Integer.parseInt(stuCount_.toString());
	}
	Object teaCount_ = request.getSession().getAttribute("teaCount");
	int teaCount = 0;
	if (teaCount_ != null) {
		teaCount = Integer.parseInt(teaCount_.toString());
	}
	Object maxCount_ = request.getAttribute("maxCount");
	int maxCount = 0;
	if (maxCount_ != null) {
		maxCount = Integer.parseInt(maxCount_.toString());
	}
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
<link rel="stylesheet" href="css/teamuser/item_show.css" type="text/css">
<link rel="stylesheet" href="css/public.css" type="text/css">
<script type="text/javascript" src="js/ajax_item.js" charset="gbk"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
	<div class="publicpanel">
		<jsp:include flush="true" page="team_info.jsp"></jsp:include>
		<jsp:include flush="true" page="manage_menu.jsp"></jsp:include>
		<div class="manage">
			<div class="manage_title">
				<a class="left"><span>项目管理</span> </a>
			</div>
			<div class="manage_content">
				<div class="selected" style="height:auto">
					<h3>可选项目</h3>
					<div style="">
						<span style="font-weight:bold;margin-left: 30px;">类别：</span> <select
							id="type"
							style="font-size:15px;height:25px;width:200px;font-family:Microsoft YaHei">
							<c:forEach items="${types}" var="t" varStatus="num">
								<option id="${t.tyid }" value="${t.tyid }">${t.tyname }</option>
							</c:forEach>
						</select>
					</div>
					<div id="selecteddiv1">
						<table cellspacing="0">
							<tr style="border-top:0px">
								<th rowspan="2" class="borderright">可选项目</th>
								<th colspan="4" class="borderright">参数学生</th>
								<th colspan="4" class="borderright">指导教师</th>
								<th rowspan="2">操作</th>
							</tr>
							<tr>
								<th>下限</th>
								<th>上限</th>
								<th>本队</th>
								<th class="borderright">状态</th>
								<th>下限</th>
								<th>上限</th>
								<th>本队</th>
								<th class="borderright">状态</th>
							</tr>
							<c:forEach items="${items}" var="item">
								<tr>
									<td class="borderright">${item.itname}</td>
									<td>${item.itremark }人</td>
									<td>${item.itlimit }人</td>
									<td>${stuCount }人</td>
									<td class="borderright"><c:if
											test="${stuCount>=item.itremark&&stuCount<=item.itlimit }">
							符合
							</c:if> <c:if test="${stuCount<item.itremark||stuCount>item.itlimit }">
											<span style="color:red;font-weight:bold">不符</span>
										</c:if></td>
									<td>${item.ittealim }人</td>
									<td>${item.itteacap }人</td>
									<td>${teaCount }人</td>
									<td class="borderright"><c:if
											test="${teaCount>=item.ittealim&&teaCount<=item.itteacap }">
							符合
							</c:if> <c:if test="${teaCount<item.ittealim||teaCount>item.itteacap }">
											<span style="color:red;font-weight:bold">不符</span>
										</c:if></td>
									<td><c:if
											test="${teaCount>=item.ittealim&&teaCount<=item.itteacap&&stuCount>=item.itremark&&stuCount<=item.itlimit }">
											<a href="javascript:void(0)" class="close" title="报名此项"
												onclick="setTeamApp(this)" id="${item.itid }">报名此项</a>
										</c:if> <c:if
											test="${teaCount<item.ittealim||teaCount>item.itteacap||stuCount<item.itremark||stuCount>item.itlimit }">
											<a href="javascript:void(0)" class="close" onclick="alert('人数不符合条件，不能报名，请调整成员后再试')" title="条件不符">条件不符</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="selected" style="height:auto">
					<h3>已选项目</h3>
					<div id="selecteddiv">
						<table cellspacing="0">
							<logic:empty name="apps">
								<th colspan="3">您还没有选择项目</th>
							</logic:empty>
							<logic:notEmpty name="apps">
								<tr style="border-top:0px">
									<th rowspan="2" class="borderright">已选项目</th>
									<th colspan="4" class="borderright">参数学生</th>
									<th colspan="4" class="borderright">指导教师</th>
									<th rowspan="2">审核状态</th>
									<th rowspan="2">操作</th>
								</tr>
								<tr>
									<th>下限</th>
									<th>上限</th>
									<th>本队</th>
									<th class="borderright">状态</th>
									<th>下限</th>
									<th>上限</th>
									<th>本队</th>
									<th class="borderright">状态</th>
								</tr>

							</logic:notEmpty>
							<c:forEach items="${apps }" var="item">
								<tr>
									<td class="borderright">${item.teamItems.itname }</td>
									<td>${item.teamItems.itremark }人</td>
									<td>${item.teamItems.itlimit }人</td>
									<td>${stuCount }人</td>
									<td class="borderright"><c:if
											test="${stuCount>=item.teamItems.itremark&&stuCount<=item.teamItems.itlimit }">
							符合
							</c:if> <c:if
											test="${stuCount<item.teamItems.itremark||stuCount>item.teamItems.itlimit }">
											<span>不符</span>
										</c:if></td>
									<td>${item.teamItems.ittealim }人</td>
									<td>${item.teamItems.itteacap }人</td>
									<td>${teaCount }人</td>
									<td class="borderright"><c:if
											test="${teaCount>=item.teamItems.ittealim&&teaCount<=item.teamItems.itteacap }">
							符合
							</c:if> <c:if
											test="${teaCount<item.teamItems.ittealim||teaCount>item.teamItems.itteacap }">
											<span>不符</span>
										</c:if></td>
									<td><c:if test="${item.appstate==0 }">待审核</c:if> <c:if
											test="${item.appstate==-1 }">审核未通过</c:if> <c:if
											test="${item.appstate==1 }">审核通过</c:if>
									</td>
									<td><a href="javascript:void(0)" class="close" title="删除"
										onclick="delTeamApp(this)" id="${item.appid }">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
</body>
<script type="text/javascript">
var stuCount="<%=stuCount%>";
var teaCount="<%=teaCount%>";
var maxCount="<%=maxCount%>";
	$("#type").change(function() {
		var obj = {};
		obj.id = $(this).children('option:selected').val();
		setTypeItem(obj);
	});
</script>
</html>
