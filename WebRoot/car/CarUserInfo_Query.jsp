<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询车辆使用情况</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
<script language="javascript" src="js/queryCarUserInfo.js" charset="gbk"/>
<!--
<script type="text/javascript">
    function done(){
   var array=document.getElementsByName('id');
   var click=document.getElementById('click');
   if(click.checked==true){
      for(var i=0;i<array.length;i++){
      array[i].checked=true; 
     }
   }else{
      for(var i=0;i<array.length;i++){
      array[i].checked=false; 
     }
    }
   }
</script>
-->
<script type="text/javascript">
	
</script>
</head>
<body>
<form action="">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />车辆管理
		<img src="img/item_point.png" />车辆使用记录列表</h1></div></div>	  
<div class="content">
  <div class="ItemBlockBorder">
	<table cellspacing="0" cellpadding="0" class="datetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="22%">车牌号</td>
				<td width="22%">出车时间</td>
				<td width="22%">返回时间</td>
				<td width="14%">使用人</td>
				<td width="20%">用途</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="CarUse_List">
        	<c:forEach items="${page.list }" var="caruserinfo">
        	<tr class="TableDetail1 template">
				<td>${caruserinfo.carId}</td>
				<td>${caruserinfo.usageTime_begin}</td>
				<td>${caruserinfo.usageTime_end}</td>
				<td>${caruserinfo.userId}</td>
				<td>${caruserinfo.usage}</td>
			</tr>
        	</c:forEach>
			
        </tbody>
    </table>
  </div> 
  
  <!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：<span>${page.pageNo }</span>/<span>${page.totalPageNumber }</span>页 &nbsp;
		每页显示：5条 &nbsp;
		总记录数： <span>${page.totalItemNumber }</span>条
	</div>
	<div id=PageSelectorSelectorArea>
		 
		 <a href="VehicleManageServlet?method=getCarUserinfo&pageNo=1" title="首页" style="cursor: hand;"> 
			 <IMG SRC="img/pageSelectorImg/firstPage2.jpg"/>
		</a>
		
		 
		<a href="VehicleManageServlet?method=getCarUserinfo&pageNo=${page.prevPage }" title="上一页" style="cursor: hand;"> 
			<img src="img/pageSelectorImg/firstPage.jpg"/>
		</a>
		<!--  	
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">1</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">2</span>
		<span class="PageSelectorNum PageSelectorSelected" style="cursor: hand;" onClick="gotoPageNum(2);">3</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">4</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">5</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">6</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">7</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">8</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">9</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">10</span>
		-->	
		 <a href="VehicleManageServlet?method=getCarUserinfo&pageNo=${page.nextPage }" title="下一页" style="cursor: hand;"> 
			<img src="img/pageSelectorImg/lastPage.jpg"/>
		 </a>
		<a href="VehicleManageServlet?method=getCarUserinfo&pageNo=${page.totalPageNumber }" title="末页" style="cursor: hand;"> 
			<IMG SRC="img/pageSelectorImg/lastPage2.jpg"/>
		</a>
		
	</div>
</div>
 
</div>

</form>
</body>
</html>