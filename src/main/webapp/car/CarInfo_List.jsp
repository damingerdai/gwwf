<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改车辆信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
<base href="<%=basePath%>" /> 
</head>
<body>
<form action="">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />车辆管理
		<img src="img/item_point.png" />车辆列表</h1></div></div>	  
<div class="content">
  <div class="ItemBlockBorder">

	<table cellspacing="0" cellpadding="0" class="datetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="16%">车牌号</td>
				<td width="16%">车型</td>
				<td width="14%">司机</td>
				<td width="14%">购买时间</td>
				<td width="10%">容量</td>
				<td width="12%">使用类型</td>
				<td>相关操作</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="CarInfo_List">
        <c:forEach items="${cars }" var="car">
        <tr class="TableDetail1 template">
				<td>${car.carId}</td>
				<td>${car.carType}</td>
				<td>${car.dirverId}</td>
				<td>${car.buyTime}</td>
				<td>${car.capacity}${car.capunit }</td>
				<td>${car.usageType}</td>
				<td><a href="javascript:popWin('car/CarInfo_Update.jsp?carid=${car.carId }&carType=${car.carType }&dirverid=${car.dirverId }&buytime=${car.buyTime }&capacity=${car.capacity }&capunit=${car.capunit }&usagetype=${car.usageType }','popWindow',650,380,true)">修改</a></tr>
        </c:forEach>
        <!-- 
			<tr class="TableDetail1 template">
				<td>${CarInfo_List.CarNum}</td>
				<td>${CarInfo_List.carmodelmode}</td>
				<td>${CarInfo_List.driver}</td>
				<td>${CarInfo_List.buytime}</td>
				<td>${CarInfo_List.carry}</td>
				<td>${CarInfo_List.usepower}</td>
				<td><a href="javascript:popWin('CarInfo_Update.jsp','popWindow',580,380,true)">修改</a></tr>
				 -->
        </tbody>
    </table>

  </div> 
		<table align="center">
	  <tr>
	      <td align="center">
		       <input type="button" align="center" id="button_new"  value="新增"  onclick="window.location.href='car/AddcarNum.jsp'" />
         </td>
	  </tr>   
	</table>  
</div>

</form>
</body>
</html>
