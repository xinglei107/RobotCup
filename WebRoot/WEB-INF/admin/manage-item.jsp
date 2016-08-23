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
 <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/addcheck.js" charset="gbk"></script>
  <script type="text/javascript">
 	function delcon(o){
 		if(confirm("如果本记录下存在子记录，则会一并删除，确定要删除吗？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=delitem&itid="+o.id;
 		}
 	}
 	function clVis(o){
 		if(confirm("关闭项目后，参赛队将无法报名该项目，但项目不会删除，确定要关闭吗？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=clvis&itid="+o.id;
 		}
 	}
 	function opVis(o){
 		if(confirm("打开项目后，参赛队可以报名该项目，确定要打开吗？"))
 		{
 			window.location.href="${pageContext.request.contextPath }/manageCom.do?method=opvis&itid="+o.id;
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
    			<p style="font-size:20px;color:orange;font-weight:bold;">项目管理</p>
    			<form action="${pageContext.request.contextPath }/addItem.do" method="post" onsubmit="return checkitem()" id="formadd">
	    			<table>
    				<tr><td>类别</td>
    				<td>
						<select name="tyid">
							<c:forEach var="type" items="${tlist}">
								<c:if test="${iform.tyid==type.tyid}"><option value="${type.tyid }" selected="selected">${type.tyname}</option></c:if>
								<c:if test="${iform.tyid!=type.tyid}"><option value="${type.tyid }">${type.tyname}</option></c:if>
							</c:forEach>
						</select>
					</td><td>项目名</td><td><input type="text" name="itname" id="itname"/></td></tr>
					<tr><td>学生下限</td><td><input type="text" name="itremark" id="itremark" value="${iform.itremark }"/></td>
					<td>学生上限</td><td><input type="text" name="itlimit" id="itlimit" value="${iform.itlimit }"/></td></tr>
					<tr><td>教师下限</td><td><input type="text" name="ittealim" id="ittealim" value="${iform.ittealim }"/></td>
					<td>教师上限</td><td><input type="text" name="itteacap" id="itteacap" value="${iform.itteacap }"/></td></tr>
    				<tr><td><button type="submit">添加</button></td><td>
    					<c:if test="${addres==1}"><a style="color:red;">添加成功！</a></c:if>
    					<c:if test="${addres==0}"><a style="color:red;">已经存在该项目！</a></c:if>
    				</td></tr>
    			</table>
    			</form>
    			<form action="MangeItem" method="post" id="formchange" style="display:none">
	    			<table>
    				<tr><td>类别</td>
    				<td>
    				<input type="hidden" name="itid" id="itid1">
    				<input type="text" readonly="readonly" id="tyname1">
					</td><td>项目名</td><td><input type="text" name="itname" id="itname1" readonly="readonly"/></td></tr>
					<tr><td>学生下限</td><td><input type="text" name="stulim" id="stulim" /></td>
					<td>学生上限</td><td><input type="text" name="stucap" id="stucap" /></td></tr>
					<tr><td>教师下限</td><td><input type="text" name="tealim" id="tealim" /></td>
					<td>教师上限</td><td><input type="text" name="teacap" id="teacap" /></td></tr>
    				<tr><td><button type="submit">修改</button></td><td>
    				</td></tr>
    			</table>
    			</form>
    			</div>
    			<div class="current">
    				<div>
    				<table cellspacing="0">
    				<tr><th rowspan="2">序号</th><th rowspan="2">名称</th><th colspan="2">学生人数</th><th colspan="2">教师人数</th><th rowspan="2">所属类别</th><th rowspan="2" colspan="2">操作</th></tr>
    				<tr><th>下限</th><th>上限</th><th>下限</th><th>上限</th></tr>
						<c:forEach var="item" items="${ilist}" varStatus="num">
    					<tr>
	 		    			<td>${num.count}</td>
	 		    			<td>${item.itname}</td>
	 		    			<td>${item.itremark}</td>
	 		    			<td>${item.itlimit}</td>
	 		    			<td>${item.ittealim}</td>
	 		    			<td>${item.itteacap}</td>	 		    			
	 		    			<td>${item.itemsType.tyname}</td>
	 		    			<c:if test="${item.visible == 1 }"><td><a href="javascript:void(0)" id="${item.itid}" onclick="clVis(this)">关闭</a></td></c:if>
	 		    			<c:if test="${item.visible == 0 }"><td><a href="javascript:void(0)" id="${item.itid}" onclick="opVis(this)" style="color:red">打开</a></td></c:if>
	 		    			<td><a id="${item.itid}" onclick="editVis(this)" href="javascript:void(0)">修改</a></td>
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
  <script type="text/javascript">
  function editVis(o){
  	$("#formadd").hide();
  	$("#formchange").show();
  	$.ajax({
  		url:'MangeItem',
  		data:{itid:o.id},
  		type:"GET",
  		success:function(res){
  			res=JSON.parse(res);
  			$("#itid1").val(res.itid);
  			$("#tyname1").val(res.type);
  			$("#itname1").val(res.itname);
  			$("#stulim").val(res.stulim);
  			$("#stucap").val(res.stucap);
  			$("#tealim").val(res.tealim);
  			$("#teacap").val(res.teacap);
  		},
  		error:function(res){
  		}
  	});
  }
  </script>
</html>
