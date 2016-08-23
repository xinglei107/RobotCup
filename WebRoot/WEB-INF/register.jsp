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
	
	<link rel="stylesheet" type="text/css" href="css/register.css">
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/ajax_uni.js"></script>
	<script type="text/javascript" src="js/check.js" charset="utf-8"></script>

  </head>
  
  <body>
  
    <jsp:include flush="true" page="/WEB-INF/head.jsp"></jsp:include>
    <div class="register">
    	<div class="necessary">
    		<div class="title"><span>以下是必填信息*</span></div>
    		<div class="baseinfo">
    			<div class="intro">
    				<p>温馨提示：</p>
    				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;队名用于登录，长度不超过20。</p>
    				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码长度不少于6个字符，不超过20个字符。</p>
    				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;此邮箱用于找回密码使用。</p>
    			</div>
    			<form action="${pageContext.request.contextPath }/register.do" method="post" onsubmit="return checkUser()"><!--  -->
    			<div class="basecon">
    			<div class="name">
	    			<span>队名</span><br>
	    			<div class="input"><input title="输入队名" type="text" name="tname" id="tname"><span class="errinfo"></span></div>
    			</div>
    			<div class="pwd">
	    			<div>
		    			<span>密码</span><br>
		    			<input title="输入密码" type="password" name="tpwd" id="tpwd">
	    			</div><div class="repwd">
		    			<span>确认</span><br>
		    			<input title="确认密码" type="password" id="retpwd"><span class="errinfo"></span>
	    			</div>
    			</div>
    			<div class="name">
	    			<span>学校</span><br>
	    			<div class="input">
	    			<input title="选择学校" type="text" name="tunversity" id="tuniversity" readonly="readonly" onclick="showUniDiv()">
	    			<input type="hidden" name="sid" id="sid">
	    			<span class="errinfo"></span></div>
	    			<span>邮箱</span><br>
	    			<div class="input"><input title="输入邮箱" type="text" name="temail" id="temail"><span class="errinfo"></span></div>
	    			<span>备注（此项为选填）</span><br>
	    			<div class="input"><textarea name="tremark" title="输入备注，100字以内" id="tremark"></textarea></div>
    			</div>
    			<div class="submit"><button type="submit">提&nbsp;&nbsp;交</button><a href="${pageContext.request.contextPath }/redirect.do?method=login">已有账号，去登陆</a></div>
    			</div>
    			<div class="filling" id="university">
					<c:forEach var="area" items="${areaList }" varStatus="num">
			    		<a href="javascript:void(0)" id="${area.aid}" onclick="setAreaUni(this)">${area.aname}</a>&nbsp;&nbsp;&nbsp;
			    	</c:forEach>
			    	<hr>
			    	<div id="ulist">
					<table>
						<tr>
						<c:forEach var="school" items="${universityList }" varStatus="num">
	 		    			<td><a href="javascript:void(0)" onclick="showMyUni(this)" id="${school.sid }">${school.sname}</a></td>
	 		    			<c:if test="${num.count%3==0}"></tr><tr></c:if>
	 		    		</c:forEach>
	 		    		</tr>
					</table>
					</div>
					<a href="javascript:void(0)" onclick="closeUniDiv()" style="float:right;color:black;border:2px solid black;font-size:16px;text-align:center;">关闭</a>
				</div>
    		</form>
    	</div>
    	<div class="unnecessary">
    		<div class="title"><span></span></div>
    		<div class="optional">
    			
    		</div>
    	</div>
    </div>
    </div>
    <jsp:include flush="true" page="/WEB-INF/tail.jsp"></jsp:include>
  </body>
</html>
