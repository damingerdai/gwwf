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
<title>登记车辆使用情况</title>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script language="javascript" src="js/AddCar.js" charset="gbk"></script>
<script language="javascript" src="js/jquery-1.8.0.js" charset="UTF-8"></script>
<script language="javascript" src="js/laydate/laydate.js" ></script>
</head>
<body onload="NnmShow()">
<form name="form" action="VehicleManageServlet?method=addCarUseInfo" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />车辆管理
		<img src="img/item_point.png" />车辆使用信息登记</h1></div></div>

<div class="content2">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	<table class="formtable">
            <tr>
				<th width="20%">车牌号</th>
				<td width="40%"><input name="carid" type="text" class="button3" onblur="checkCar(this)" onfocus="clearError(this)"/></td>
				<td width="40%"><div name="cariderror"></div></td>
			</tr>
			<tr>
				<th>使用者</th>
				<td><input name="userid" type="text" class="button3" onblur="checkEmp(this)" onfocus="clearError(this)"/></td>
				<td><div name="useriderror"></div></td>
			</tr>
			<tr>
				<th>用 途</th>
				<td><input name="usage" type="text" class="button3" onfocus="clearError(this)"/></td>
				<td><div name="usageerror"></div></td>
			</tr>
			<tr>
				<th>出发时间</th>
				<td>
				  <input name="usagetime_begin" readonly="true" type="text" class="button3" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm'})" onfocus="clearError(this)" />  
				</td>
				<td><div name="usagetime_beginerror"></div></td>
			</tr>
			<tr>
				<th>返回时间</th>
				<td>
				 <input name="usagetime_end" readonly="true" type="text" class="button3" onclick="laydate({istime: true,format: 'YYYY-MM-DD hh:mm'})" onfocus="clearError(this)" />
				</td>
				<td><div name="usagetime_enderror"></div></td>
			</tr>	
    </table>
	</div>
	<table align="center" width="100%" class="bottomback">
	  <tr>
	      <td align="center">
		       <input type="button" id="button_new"  value="保存" onclick="dosubmit()"/>
			   <input type="reset" id="button_new"  value="重置" onclick=" doreset()"/>
         </td>
	  </tr>   
	</table> 
  </div> 
  
</div>

</form>
</body>
</html>