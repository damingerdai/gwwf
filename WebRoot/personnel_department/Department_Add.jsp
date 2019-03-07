<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增部门信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>

<script language="javascript" src="js/jquery.js" charset="utf-8"></script>
<script language="javascript" src="js/addDepartment.js" charset="gbk"></script>
 
<script type="text/javascript">
	window.onload=clear()
</script>
</head>
<body>
<form name="form" action="PersonAdminServlet?method=addDepartment" method="post">
<div class="head"><div class="head_title"><h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />新增部门信息</h1></div></div>	  
<div class="content2">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	   <table class="formtable">
	       <tr>
			   <th width="75">部门编号
			   <td width="200">
				 <input name="depid" type="text"  class="button22" maxlength="2" onfocus="clearError(this)"/> 
	         </td>
	     	 <th>
	     	 	<div name="depiderror" id="depiderror" style="postion:middle;display:inline"  > </div>
	     	 </th>
	      </tr>
			<tr>
			   <th>部门名称</td>
			   <td>
				 <input name="dname" type="text"  class="button22" maxlength="7" onfocus="clearError(this)"/>
		       </td>
		       <th>
		       	<div name="dnameerror" id="dnameerror" style="postion:middle;display:inline"></div>
		       </th>
		    </tr>
	   </table>
	</div>
	<table align="center" width="100%" class="bottomback">
	  <tr>
	      <td align="center">
		       <input type="button" id="button_new"  value="保 存" onclick="checkDepId()"/>
			   <input type="reset" id="button_new"  value="重 置"  onclick="doreset()"/>
         </td>
	  </tr>   
	</table> 

  </div> 
		 
</div>
 
</form>
</body>

</html>

