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
<title>新增车位</title>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/Parking.js" charset="GBK"></script>

<script type="text/javascript">

</script>
</head>

<body onload="NnmShow()">
<form name="form" action="VehicleManageServlet?method=addPark" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />车位管理
		<img src="img/item_point.png" />新增车位信息</h1></div></div>

<div class="content2">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	<table class="formtable">
            <tr>
				<th width="20%">车位编号</th>
			  <td width="40%">
			  	<input name="pid" id="pid" type="text" maxlength="7" class="button3" onblur="checkPark(this)" onfocus="clearError(this)" />
			  </td>
			  <td width="40%" align="left"><div name="piderror"></div></td>
			</tr>
			<tr>
				<th>对应车辆</th> 
				<td><input name="carid" id="carid" type="text" class="button3" onblur="checkCar(this)" onfocus="clearError(this)"/></td>
				<td align="left"><div name="cariderror"></div></td>
			</tr>
			<tr>
				<th>说&nbsp;&nbsp;&nbsp;&nbsp;明</th>
				<td><input name="instrucation" type="text" class="button3" onfocus="clearError(this)" maxlength="55"/></td>
				<td align="left"><div name="instrucationerror"></div></td>
			</tr>		
    </table>
	</div>
	 <table align="center" width="100%" class="bottomback">
	  <tr>
	      <td align="center">
		       <input type="button" id="button_new"  value="提交" onclick="dosubmit()"/>
			   <input type="reset" id="button_new"  value="重置" onclick=""/>
         </td>
	  </tr>   
	</table> 
  </div> 
 
</div>

</form>

</body>
</html>