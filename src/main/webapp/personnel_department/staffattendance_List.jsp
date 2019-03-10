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
<title>考勤统计</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
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
<body onload="AttendanceShow()">
<form action="">
<div class="head">
	<div class="head_title">
		<h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />出勤情况</h1>
	</div>
</div>	
  
<div class="content">
  <div class="ItemBlockBorder">
	<table cellspacing="0" cellpadding="0" class="datetable" id="AttendanceList">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
            	<td width="20%">员工编号</td>
				<td width="20%">考勤日期</td>
				<td width="20%">上班时间</td>
				<td width="20%">下班时间</td>
				<td width="20%">说明</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="StaffAttendance_List">
        <c:forEach items="${page.list }" var="StaffAttendance">
        	<tr class="TableDetail1 template">
				<td>${StaffAttendance.empid}</td>
				<td>${StaffAttendance.cdate}</td>
				<td>${StaffAttendance.ontime}</td>
				<td>${StaffAttendance.offtime}</td>
				<c:if test="${StaffAttendance.remark == '正常' }">
					<td>${StaffAttendance.remark}</td>
				</c:if>
				<c:if test="${StaffAttendance.remark != '正常' }">
					<td><font color="red">${StaffAttendance.remark}</font></td>
				</c:if>
				
			</tr>
        
        </c:forEach>
        <!-- 
			<tr class="TableDetail1 template">
				<td>${StaffAttendance.date}</td>
				<td>${StaffAttendance.workbegintime}</td>
				<td>${StaffAttendance.workendtime}</td>
				<td>${StaffAttendance.explain}</td>
			</tr>
			-->
        </tbody>
    </table>
  </div> 
  
  <!--分页信息-->
	<div id=PageSelectorBar>
		<div id=PageSelectorMemo>
			页次：<span>${page.pageNo }</span>/<span>${page.totalPageNumber }</span>页 &nbsp;
			每页显示：5条 &nbsp;
			总记录数：<span>${page.totalItemNumber }</span>条
		</div>
		<div id=PageSelectorSelectorArea>
			 
		
			 
			<a href="PersonAdminServlet?method=getAttendanceRecord&pageNo=1" title="首页" style="cursor: hand;">
			
				<IMG SRC="/GWWF/img/pageSelectorImg/firstPage2.jpg"/>
			</a>
			 <a href="PersonAdminServlet?method=getAttendanceRecord&pageNo=${page.prevPage }" title="上一页" style="cursor: hand;">
				<img src="/GWWF/img/pageSelectorImg/firstPage.jpg"/>
			</a>	
			<!--  	
			<span class="PageSelectorNum PageSelectorSelected" style="cursor: hand;" onClick="gotoPageNum(2);">1</span>
			<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">2</span>
			<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">3</span>
			<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">4</span>
			<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">5</span>
			<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">6</span>
			-->
			
			 <!--  
			<IMG SRC="/GWWF/img/pageSelectorImg/lastPage2.jpg">
			-->
			 
			<a href="PersonAdminServlet?method=getAttendanceRecord&pageNo=${page.nextPage }" title="末页" style="cursor: hand;">
				<img src="/GWWF/img/pageSelectorImg/lastPage.jpg"/>
			</a>
			<a href="PersonAdminServlet?method=getAttendanceRecord&pageNo=${page.totalPageNumber }" title="末页" style="cursor: hand;">
				<IMG SRC="/GWWF/img/pageSelectorImg/lastPage2.jpg">
			</a><!--  
			<input type="button" id="button_new"  value="返 回" onclick="javascript:history.back()"/>
			-->
		</div>
	</div>
 
</div>

</form>
</body>
</html>