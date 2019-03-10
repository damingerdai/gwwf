<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<base href="<%=basePath%>"/>
	<title>导航菜单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="JavaScript" type="text/javascript" src="js/jquery.js"></script>
	<link type="text/css" rel="stylesheet" href="css/menu.css" />
	<script type="text/javascript">
		$(function(){
		   var $level1=$(".level1 .level1Style");
		   var $showlevel1=$(".level1 .MenuLevel2");
		   $level1.each(function(index){
		   $(this).click(function(){
		     if(!$(this).is(":animated")){
		    
		      $showlevel1.eq(index+1).slideToggle("normal").end()
			  .not($showlevel1[index+1]).slideUp("normal");  
			    };
			  });
			
		  });
		});
	</script>
<!--	
<script type="text/javascript">
function getparastr(strname)
{
var hrefstr,pos,parastr,para,tempstr;
hrefstr = window.parent.location.href;
pos = hrefstr.indexOf("?")
parastr = hrefstr.substring(pos+1);
para = parastr.split("&");
tempstr="";
for(i=0;i<para.length;i++)
{
tempstr = para[i];
pos = tempstr.indexOf("=");
if(tempstr.substring(0,pos) == strname)
{
return tempstr.substring(pos+1);
}
}
return null;
}
</script>
<script>
function toggle(){
  var trs = getparastr("inputStr");
  var tr=trs.slice(0,2);
  if (tr=="HR"){
  document.getElementById("HR").style.display="";
  document.getElementById("LG").style.display="none";
  document.getElementById("AD").style.display="none";
  }
  if (tr=="LG"){
  document.getElementById("HR").style.display="none";
  document.getElementById("LG").style.display="";
  document.getElementById("AD").style.display="none";
  } 
  if (tr=="AD"){
  document.getElementById("HR").style.display="none";
  document.getElementById("LG").style.display="none";
  document.getElementById("AD").style.display="";
  } 
}
</script>
-->
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".level2Style").click(function(){
		$(".level2Style.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})		
</script>
</head>
<body style="margin: 0px;" onload="toggle()">
<div id="Menu" >
	<ul id="MenuUl">
	    
		<li class="level1">
			<div onClick="menuClick(this);" class="level1Sty"> 
			<table id="MenuTop">
				<tr>
					<td width="24"><img src="img/MenuImg/Menutitle_left.jpg"/></td>
					<td>导航菜单</td>
					<td width="24"><img src="img/MenuImg/Menutitle_right.jpg"/></td>
				</tr>
			</table>
			</div>
			<ul style="display: none;"class="MenuLevel2">				
			</ul>
		</li>
		  
		<c:if test="${user.privilege =='HR' }">
		<!--人事管理-->
        <li class="level1" id="HR" >
			<div onClick="menuClick(this);"  class="level1Style">
				<table id="MenuTitle">
				<tr>
				<td width="62" align="right"><img src="img/MenuImg/icon1.jpg"/></td>
				<td>人事管理</td>
				<td width="62"></td>
				</tr>
				</table>
				<img src="img/images/bottonline.jpg" />							
			</div>
			<ul style="display:none;" class="MenuLevel2">				
				<li class="level2">
					<a target="desktop" href="PersonAdminServlet?method=setDefaultAddPersonInfo"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增员工个人信息</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="personnel_department/personInfo_revise.jsp"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改员工个人信息</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="personnel_department/staffattendance_add.jsp"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>维护员工考勤记录</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="PersonAdminServlet?method=getAttendanceRecord&pageNo=1"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>考勤记录</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="personnel_department/Department_Add.jsp"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增部门信息</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="PersonAdminServlet?method=getDepartment"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改部门信息</div></a> 
				</li>
				<!--  
				<li class="level2">
					<a target="desktop" href="personnel_department/PersonTransfer_Choice.HTML"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>登记人员调动情况</div></a> 
				</li>
				-->
			</ul>
		</li>
		</c:if>
		 
		<c:if test="${user.privilege =='LG' }"> 
		<!--车辆管理-->
		
		<li class="level1" ID="LG" >
			<div onClick="menuClick(this);"class="level1Style">
				<table id="MenuTitle"><tr>
				  <td width="62" align="right"><img src="img/MenuImg/icon3.jpg"/></td>
				  <td>车辆管理</td>
				  <td width="62" ></td>
				</tr></table>
				<img src="img/images/bottonline.jpg" />				
			</div>			
			<ul style="display:none;" class="MenuLevel2">	
				<!--			
				<li class="level2">
					<a target="desktop" href="car/AddParking.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>车位信息</div></a> 
				</li>
				 -->
				<li class="level2">
					<a target="desktop" href="VehicleManageServlet?method=getParkingInfo"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>车位信息管理</div></a> 
				</li>
				<!--  
				<li class="level2">
					<a target="desktop" href="car/AddcarNum.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增车辆信息</div></a> 
				</li>
				-->
				<li class="level2">
					<a target="desktop" href="VehicleManageServlet?method=getCarInfo"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>车辆信息管理</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="car/CarUseInfo_Add.jsp"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>登记车辆使用情况</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="VehicleManageServlet?method=getCarUserinfo&pageNo=1"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>查询车辆使用情况</div></a> 
				</li>
			</ul>
		</li>
	 	</c:if>
	 	
	 	<c:if test="${user.privilege =='AD' }">
		<!--办公用品-->
		<li class="level1" ID="AD" >
			<div onClick="menuClick(this);"class="level1Style">
				<table id="MenuTitle">
				<tr>
				<td width="62" align="right"><img src="img/MenuImg/icon2.jpg"/></td>
				<td>办公用品</td>
				<td width="62" ></td>
				</tr>
				</table>
				<img src="img/images/bottonline.jpg" />				
			</div>
			
			<ul style="display:none;" class="MenuLevel2">				
				<li class="level2">
					<a target="desktop" href="Office_Stationery/BuyOfficeStationery.jsp"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>购买办公用品登记</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="Office_Stationery/ReceiveDepartment.jsp"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>登记办公用品使用情况 </div></a>
				</li>
				<!-- 
				<li class="level2">
					<a target="desktop" href="OfficeServlet?method=getOffice"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>查询办公用品库存</div></a> 
				</li>
				 -->
			</ul>			
		</li>		
	 	</c:if>
		<!--我的信息
	    <li class="level1">
			<div onClick="menuClick(this);"class="level1Style">
				<table id="MenuTitle">
				<tr>
				<td width="62" align="right"><img src="img/MenuImg/icon4.jpg"/></td>
				<td>个人信息</td>
				<td width="62" ></td>
				</tr>
				</table>
				<img src="img/images/bottonline.jpg" />				
			</div>
			
			<ul style="display:none;" class="MenuLevel2">				
				<li class="level2">
					<a target="desktop" href="PersonnalInfo/Addresslist_add.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>维护个人通讯录</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="PersonnalInfo/Addresslist_Query.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>查询通讯录</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="PersonnalInfo/WorkRecord.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>填写工作记录</div></a> 
				</li>
				<li class="level2">
					<a target="desktop" href="PersonnalInfo/RevisePassword.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改个人通讯密码</div></a> 
				</li>
			</ul>			
		</li>
		-->
	</ul>

</div>
</body>
</html>
