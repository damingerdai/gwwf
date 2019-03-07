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
<title>新增车辆</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="JavaScript" src="js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="css/select.css"/>
<script language="JavaScript" src="js/select-ui.min.js"></script>
<script language="javascript" src="js/Car.js" charset="GBK"></script>
<script language="javascript" src="js/laydate/laydate.js" ></script>
	<script type="text/javascript"> 
	$(document).ready(function(e) {
		$(".button11").uedSelect({
			width : 118			  
		});
	});
	</script>
</head>
<body onload="NnmShow()">
<form name="form" action="VehicleManageServlet?method=addCar" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />车辆管理
		<img src="img/item_point.png" />新增车辆信息</h1></div></div>

<div class="content2">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	<table class="formtable">
            <tr>
				<th width="20%">车牌号</th>
				<td width="40%"><input name="carid" type="text" class="button3" onblur="checkCar(this)" onfocus="clearError(this)" maxlength="7"/></td>
				<td width="40%" align="left"><div name="cariderror"></div></td>
			</tr>
			<tr>
				<th>车 型</th>
				<td><input name="cartype" type="text" class="button3" maxlegth="10" onfocus="clearError(this)" /></td>
				<td align="left"><div name="cartypeerror"></div></td>
			</tr>
			<tr>
				<th>购车时间</th>
				<td><input name="buytime" readonly="readonly" type="text" class="button3" onclick="cleaerError(this)" readonly="readonly" clearError(this)"/></td>
				<td align="left"><div name="buytimeerror"></div></td>
			</tr>
			<tr>
				<th>司机</th>
				<td>
				    <select name="dirverid" id="driverid"class="button11" onchange="clearSelectError(this)" >
					<option>请选择司机</option>
					<option value="da">大明</option>
				    </select>
				</td>
				<td align="left"><div name="dirveriderror"></div></td>
				<script type="text/javascript">
					findDriver();
				</script>
			</tr>
			<tr>
				<th>容量</th>
				<td>
				  <input name="capacity" type="text" class="button31" onfocus="clearError(this)"/>&nbsp;
				  <script type="text/javascript">
				  	immediately()
				  </script>
				  <label>
				    <input type="radio" name="capunit" value="吨" /> 吨</label>
				  <label>
				    <input type="radio" name="capunit" value="人" checked="checked" />人</label>
				</td>
				<td align="left"><div name="capacityerror"></div></td>
			</tr>
			<tr>
				<th>使用类型</th>
				<td>
				  <label>
				    <input type="radio" name="usageType" value="公用" checked="checked"/> 公用</label>
				  <label>
				    <input type="radio" name="usageType" value="私用" />专用</label>
				</td>
			</tr>				
    </table>
	</div>
	<table align="center" width="100%" class="bottomback">
	  <tr>
	      <td align="center">
		       <input type="button" id="button_new"  value="保存" onclick="dosubmit()"/>
			   <input type="reset" id="button_new"  value="重置" onclick="doreset()"/>
         </td>
	  </tr>   
	</table> 
  </div> 
  
</div>

</form>
</body>
</html>