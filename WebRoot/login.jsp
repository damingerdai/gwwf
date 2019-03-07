<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>长城内部流程管理系统_用户登录</title>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/login.css" />
<script language="javascript" src="js/jquery.js" charset="utf-8"></script>
<script language="javascript" src="js/login.js" charset="gbk"></script>
<script language="javascript" src="js/jquery-1.8.0.js" charset="utf-8"></script>
  
<script type="text/javascript">
 
</script> 
 
<style type="text/css">
img{ border:0;}
</style>
</head>

<body style="margin:0">


<div id="bj">
	<div id="login_bj" >
	   <div id="loginback_up" >
	        <div id="login_title"><h2>长城计算机软件与系统有限公司</h2></div>
			<div id="login_logo"><img src="img/LoginImg/logo.jpg"/></div>
			<div id="login_login">
			<FORM name = "form" action="LoginServlet?method=login" method="post">
				<table align="center" width="553">
				   <tr>
					   <td width="98" height="20px"  align="right" class="txtname">员工号</td>
					   <td width="152">
					   <input name="empid" type="text" id="empid" onfocus="clearError(this)" class="textfield" />
					   </td>
					   <td><div name="empiderror"></div></td>
				  </tr>
				  <tr>
						<td width="98" height="20px" align="right" class="txtname">密&nbsp;码</td>
						<td><input name="password" type="password" id="wuserPw" onfocus="clearError(this)" class="textfield" /></td>
						<td><div name="passworderror"></div></td>
				  </tr>
				  <tr height="38">
				        <td height="38" colspan="2" align="center">
						<img src="img/LoginImg/button_login.jpg" id="loginbotton" onclick="clicklogin()">
						<img src="img/LoginImg/botton_close.jpg"  onclick="">
						</td>
				  </tr>
			 </table>
			 </FORM>
		    </div>
	   </div>
	   <div id="loginback_down"></div>
	</div>
</div>
 
  
</body>
</html>
