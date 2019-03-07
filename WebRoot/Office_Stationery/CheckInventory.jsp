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
<title>查询办公用品库存</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>

</head>
<body onload="NnmShow()">
<form action="">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />办公用品
		<img src="img/item_point.png" />办公用品库存列表</h1></div></div>

<div class="content2">
  <div class="ItemBlockBorder2">

	<table cellspacing="0" cellpadding="0" id="stockdatetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="50%">商品名称</td>
				<td width="25%">数量</td>
				<td>单位</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="BuyOfficeStationeryInfo">
			<c:forEach items="${requestScope.list }" var="OfficeStationery">
			<tr class="TableDetail1 template">
				<td align="center">${OfficeStationery.uname}</td>
				<td>${OfficeStationery.storeNumber}</td>
				<td>${OfficeStationery.unit}&nbsp;</td>
			</tr>
			
			</c:forEach>
			<!-- 
			<tr class="TableDetail1 template">
				<td>${OfficeStationery.name}</td>
				<td>${OfficeStationery.number}</td>
				<td>${OfficeStationery.unit}&nbsp;</td>
			</tr>
			 -->
        </tbody>
    </table>

  </div>  
</div>

</form>
</body>
</html>