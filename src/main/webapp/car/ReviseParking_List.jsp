<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改车位信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<base href="<%=basePath%>" />  
</head>
<body>
<form action="">
<div class="head"><div class="head_title">
  <h1><img src="img/item_point.png" />车位管理
		<img src="img/item_point.png" />车位信息列表</h1>
</div></div>	  
<div class="content">
  <div class="ItemBlockBorder">
	<table cellspacing="0" cellpadding="0" class="datetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="22%">车位编号</td>
				<td width="22%">对应车辆</td>
				<td >说明</td>
				<td width="12%">相关操作</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="ParkingInfo_List">
        	<c:forEach items="${parks }" var="park">
        	
        	<tr class="TableDetail1 template">
				<td>${park.pid}</td>
				<td>${park.carid}</td>
				<td>${park.instrucation}&nbsp;</td>
				<td>	
					<a href="javascript:window.popWin('car/ReviseParking_Updata.jsp?pid=${park.pid }&carid=${park.carid }&instrucation=${park.instrucation }'
					,'popWindow',650,400,true)">修改</a>
					
				</td>
			</tr>
			 
        	</c:forEach>
			
        </tbody>
      </table> 
  </div> 
	 <table align="center">
	  <tr>
	      <td align="center">
		       <input type="button" align="center" id="button_new"  value="新增"  onclick="window.location.href='car/AddParking.jsp'" />
         </td>
	  </tr>   
	</table> 

  
</div>
	
</form>
</body>
</html>