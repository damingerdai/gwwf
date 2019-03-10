<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>top</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/top.css"/>
	<link type="text/css" rel="stylesheet" href="css/icon.css"/>
	<script language="javascript" src="js/showtime.js"></script>	
<script type="text/javascript">
  
function getparastr(strname)
{
var hrefstr,pos,parastr,para,tempstr;
hrefstr = window.parent.location.href;
pos = hrefstr.indexOf("?")
parastr = hrefstr.substring(pos+1);
para = parastr.split("&");
tempstr="";
for(i=0;i<para.length;i++)
{
tempstr = para[i];
pos = tempstr.indexOf("=");
if(tempstr.substring(0,pos) == strname)
{
return tempstr.substring(pos+1);
}
}
return null;
}
</script>
<script>
// 获取tr参数
//var tr = ${requestScope.user.empid};
</script>
 
</HEAD>

<BODY CLASS="PageBody" STYLE="margin: 0" onLoad="startTime()">

<form>
<div id="Head">
    <div id="Head_logo">
        <div id="LOGO_left"></div>
        <div id="LOGO"><img src="img/LoginImg/toplogo.png" /></div>
        <div id="LOGO_End"></div>
    </div>
	<div id="Head_right">
		<table height="88">
			<tr><td colspan="2"></td></tr>
			<tr>
				<td id="TimeArea"><div id="ShowTime"></div></td>
				<td id="BottonArea">
					<div id="right_begin"></div>
					<div id="right_back">
						<table>
							<tr>
							    <td align="center" style="width: 16px">
                                            <span class="ui-write person"></span>
                                        </td>
								<td align="center">
								  
								  
								<script type="text/javascript">		
								 document.write("${sessionScope.user.username}"+"，您好");     
                                </script>
								 
								</td>
								<td align="center" style="width:18px"><img src="img/images/yline.jpg" /></td>
								<td align="center" style="width: 16px">
                                            <span class="ui-write power"></span>
                                        </td>
								<td align="center">
								<a  id="logout" style="color: #ffffff; background-color: Transparent" href="" onclick="userlogout();" target="_parent">退出系统</a>
								</td>
							</tr>
						</table>
						
					</div>
					<div id="right_end"></div>
				</td>
			</tr>
		</table>
	</div>
	
</div>


</form>
<script type="text/javascript" >
	 function userlogout()
	 {
	 	var flag = confirm("您确定退出系统吗？"); 	 
	 	if(flag)
	 	{	
	 		var logout = document.getElementById("logout");
	 		logout.href="LoginServlet?method=logout";
	 		return true;
	 	}
	 	else
	 	{
	 		return false;
	 	}
	 	 
	 	
	 }
	 
	
  
</script>
</BODY>
</HTML>