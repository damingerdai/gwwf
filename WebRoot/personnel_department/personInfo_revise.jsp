<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改员工个人信息</title>
<base href="<%=basePath%>"/>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js" charset="utf-8"></script>
<script language="javascript" src="js/revisePersonInfo.js" charset="gbk"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<form name = "form" action="PersonAdminServlet?method=getEmployeeByEmpId" method="post"  >
<div class="head"><div class="head_title"><h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />选择修改员工</h1></div></div>	  
<div class="content">
  <div class="ItemBlockBorder">
	<div class="ItemBlock">
	   <table class="formtable">
	       <tr>
			   <th width="179">请输入要修改员工工号：</td>
			   <td width="283">
				 <input name="empid" type="text"  maxlength="20" class="button22" />
				 <script type="text/javascript">
				 	immediately();
				 </script>
	         </td>
			   <td width="284">
			   <input type="button" id="button_new" value="确 定" onclick="searchEmployee()" />
			   <input type="reset" id="button_new" value="重 置" onclick="clearPopup()"/>
		     </td>
		   </tr> 
	   </table>
	   <table class="ItemBlock">
	   	<tr>
	   		<td width="179"></td>
	   		<td width="283">
	   			<div id="popup" style="postion:middle;display:none; background-color:#eeeeee"></div>
	   		</td>
	   		<td width="284"></td>
	   	</tr>
	   </table>
	   
	</div>
  </div>  
</div>
</form>
</body>
</html>
