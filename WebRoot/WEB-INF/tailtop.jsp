<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华北五省大学生机器人大赛</title>
	<link rel="stylesheet" href="css/tailtop.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/public.css" type="text/css">
  </head>
  
  <body>
    <div class="tailtop">
    	<div class="topleft">
	    	<div class="toptitle"><span>主办单位</span></div>
	    	<div class="toplink">
	    	<table>
	    		<tr>
	    			<td><a target="_blank" href="http://www.bjedu.gov.cn">北京市教育委员会</a></td>
	    			<td><a target="_blank" href="http://www.tjmec.gov.cn">天津市教育委员会</a></td>
	    		</tr>
	    		<tr>
	    			<td><a target="_blank" href="http://www.sxedu.gov.cn">山西教育厅</a></td>
	    			<td><a target="_blank" href="http://www.nmgov.edu.cn">内蒙古教育厅</a></td>
	    		</tr>
	    		<tr>
	    			<td><a target="_blank" href="http://www.hee.cn">河北省教育厅</a></td>
	    			<td><a target="_blank" href="#"></a></td>
	    		</tr>
	    	</table>
	    	</div>
    	</div>
    	<div class="topsplit"></div>
    	<div class="topcenter">
    		<div class="toptitle"><span>承办单位</span></div>
	    	<div class="toplink">
	    	<table>
	    		<tr>
	    			<td><a target="_blank" href="http://www.bistu.edu.cn">北京信息科技大学</a></td>
	    			<%-- <td><a target="_blank" href="#">天津市教育委员会</a></td>--%>
	    		</tr>
	    		<%-- <tr>
	    			<td><a target="_blank" href="#">山西教育</a></td>
	    			<td><a target="_blank" href="#">内蒙古教育</a></td>
	    		</tr>
	    		<tr>
	    			<td><a target="_blank" href="#">河北省教育厅</a></td>
	    			<td><a target="_blank" href="#">内蒙古教育</a></td>
	    		</tr>--%>
	    	</table>
	    	</div>
    	</div>
    	<div class="topsplit"></div>
    	<div class="topright">
    		<div class="toptitle"><span>友情链接</span></div>
	    	<div class="toplink">
	    	<table>
	    		<tr>
	    			<td><a target="_blank" href="http://www.fira.net">FIRA</a></td>
	    			<td><a target="_blank" href="http://www.robocup.org">RoboCup</a></td>
	    		</tr>
	    		<tr>
	    			<td><a target="_blank" href="http://fira.wit.edu.cn/menu/menu1_2.htm">FIRA中国</a></td>
	    			<td><a target="_blank" href="http://www.robotpk.com">机器人竞赛</a></td>
	    		</tr>
	    		<tr>
	    			<td><a target="_blank" href="http://www.robotsky.com">机器人天空</a></td>
	    		</tr>
	    	</table>
	    	</div>
    	</div>
    </div>
  </body>
</html>
