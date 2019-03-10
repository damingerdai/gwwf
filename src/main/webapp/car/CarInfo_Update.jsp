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
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改车辆信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
<script language="javascript" src="js/updateCarInfo.js" charset="gbk"></script>
</head>
<body onload="NnmShow()">
<form name="form" action="VehicleManageServlet?method=uppdateCarInfo" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />车辆管理
		<img src="img/item_point.png" />修改车辆信息</h1></div></div>

<div class=".content_pop">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	<table class="formtable">
            <tr class="dataContainer" datakey="CarInfo_Update">
				<th width="20%">车牌号</th>
				<td width="40%" class="TableDetail1 template" >
				<input name="carid" readonly="readonly" type="text" class="button3" value="${param.carid }"/>
				</td>
			</tr>
			<tr class="dataContainer" datakey="CarInfo_Update" >
				<th>车 型</th>
				<td class="TableDetail1 template">
				<input name="carType" readonly="readonly" type="text" class="button3" value="${param.carType}"/>
				</td>
			</tr>
			<tr class="dataContainer" datakey="CarInfo_Update" >
				<th>购车时间</th>
				<td class="TableDetail1 template">
				<input name="buytime" readonly="readonly" type="text" class="button3" value="${param.buytime}"/></td>
			</tr>
			<tr class="dataContainer" datakey="CarInfo_Update" >
				<th>司 机</th>
				<td class="TableDetail1 template">
				<input name="dirverId" type="text" class="button3" value="${param.dirverid}" onblur="checkEmp(this)" onfocus="clearError(this)" maxlength="10"/></td>
				<td><div name="dirverIderror"></div></td>
			</tr>
			<tr class="dataContainer" datakey="CarInfo_Update" >
				<th>容量</th>
				<td class="TableDetail1 template"><input name="capacity" readonly="readonly" type="text" class="button31" value="${param.capacity}"/>
				  <label>
				    <input type="radio" readonly="readonly" name="capunit" value="吨" /> 吨</label>
				  <label>
				    <input type="radio" readonly="readonly" name="capunit" value="人" checked="checked"/>人</label>
				    
				   <c:if test="${param.capunit =='吨' }">
				   	<script type="text/javascript">
						 setCapunit();
				   	</script>
				   		
				   </c:if>
				   
			  </td>
			</tr>
			<tr class="dataContainer" datakey="CarInfo_Update" >
				<th>使用类型</th>
				<td class="TableDetail1 template">
				  <label>
				    <input type="radio" name="usageType" value="公用" /> 公用</label>
				  <label>
				    <input type="radio" name="usageType" value="${param.usagetype}" checked="checked"/>私用</label>
				</td>
				 
				<c:if test="${param.usagetype == '公用' }">
					<script type="text/javascript">
						setUsagetype();
					</script>
				</c:if>
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