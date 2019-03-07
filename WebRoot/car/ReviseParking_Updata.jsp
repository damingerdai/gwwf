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
<title>>修改车位</title>
<base href="<%=basePath %>"/>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
<script language="javascript" src="js/updataParking.js" charset="gbk"></script>
</head>
<body onload="NnmShow()">
<form name="form" action="VehicleManageServlet?method=updateParking" method="post">
<div class="head"><div class="head_title">
  <h1><img src="img/item_point.png" />车位管理
		<img src="img/item_point.png" />修改车位信息</h1>
</div></div>

<div class=".content_pop">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	<table class="formtable">
            <tr class="dataContainer" datakey="ParkingInfo_List2">
				<th width="30%">车位编号</th>
				<td width="50%" class="TableDetail1 template">
			  <input name="pid" readonly="readonly" "text" class="button30" value="${param.pid}" readonly="ture"/></td>
			  <td width="20%"><div></div></td>
			</tr>
			<tr class="dataContainer" datakey="ParkingInfo_List2">
				<th>对应车辆</th>
				<td class="TableDetail1 template"><input name="carid" maxlength="15" type="text" class="button3" value="${param.carid}" onblur="checkCar(this)" onfocus="clearError(this)"/></td>
				<td><div name="cariderror"></div></td>
				<script type="text/javascript">
					 
				</script>
			</tr>
			<tr class="dataContainer" datakey="ParkingInfo_List2">
				<th>说&nbsp;&nbsp;&nbsp;&nbsp;明</th>
				<td class="TableDetail1 template"><input name="instrucation" maxlength="50" type="text" class="button3" value="${param.instrucation}" onfocus="clearError(this)"/></td>
				<td><div name="instrucationerror"></div></td>
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