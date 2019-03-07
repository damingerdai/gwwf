<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改部门信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
 <script type="text/javascript">
 	 
 </script>
</head>
<body>
<form action="">
<div class="head"><div class="head_title">
  <h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />部门信息列表</h1>
</div></div>	  
<div class="content2">
  <div class="ItemBlockBorder2">

	<table cellspacing="0" cellpadding="0" class="datetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="22%">部门编号</td>
				<td width="22%">部门名称</td>
				<td width="12%">相关操作</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="Department_List">
        <c:forEach items="${list }" var="dep">
        <tr class="TableDetail1 template">
				<td>${dep.depid}</td>
				<td>${dep.dname}</td>
				<td>	
					<a href="javascript:window.popWin('personnel_department/Department_Updata.jsp?depid=${dep.depid }&dname=${dep.dname }','popWindow',650,380,true)">修改</a>
				</td>
			</tr>
        </c:forEach>
			
			 
        </tbody>
    </table>
  </div> 
  <!--
	<table align="center" width="100%" class="bottomback">
	  <tr>
	     <td align="center" height="18">
		</td>
	  </tr>   
	</table>		
  --> 
</div>
 
</form>
</body>
</html>
