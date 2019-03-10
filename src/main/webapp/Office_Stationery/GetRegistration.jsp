<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登记办公用品领用情况</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery-1.8.0.js"></script>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src=".js/PagecCommon.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="css/select.css"/>
	<script language="JavaScript" src="js/select-ui.min.js"></script>
	<script type="text/javascript"> 
	$(document).ready(function(e) {
		$(".button11").uedSelect({
			width : 132			  
		});
	});
	</script>
</head>
<body>
<form name="form" action="OfficeServlet?method=updateOfficeStationery" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />办公用品
		<img src="img/item_point.png" />领用办公用品登记</h1></div></div>	  
<div class="content">
   <table class="formtable" style="margin-left:18px; margin-bottom:4px;">
	       <tr>
			   <th width="91" >领取员工：</th>
			   <td width="685">
				   <select id="employee" name="employee" class="button11">
					   <option>${requestScope.dname }员工</option>
					   	<c:forEach items="${requestScope.list }" var="emp">
					   		<option value="${emp.empId }">${emp.username}</option>
					   </c:forEach>
				   </select>
				   
				   	 
		     </td>
		   </tr>
	   </table>
  <div class="ItemBlockBorder">

	<table cellspacing="0" cellpadding="0" class="datetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="8%">选择</td>
				<td width="33%" >商品名称</td>
				<td width="31%">数量</td>
				<td width="28%" >单位</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="GetOfficeStationeryInfo">
        <c:forEach items="${requestScope.offList }" var="off">
        	<c:if test="${off.storeNumber > 0 }">
        	<tr class="TableDetail1 template">
				<td>
					<input name="checkbox" type="checkbox" value="0" />
				</td> 
				<td>
					<input name="uname" type="hidden" value="${off.uname} " class="button32" />
					${off.uname}
				</td>
				<td class="Text_Num2">
					<input name="storeNumber" type="text"  value="${off.storeNumber }" maxlength="10" class="button32" onblur="checkNum(this)"/>
					<input name="number" type="hidden" value="${off.storeNumber }" />
				 </td>
				<td>
					<input name="unit" type="hidden" value="${off.unit}" />
					${off.unit}&nbsp;
				</td>
				
			</tr>
        	
        	</c:if>
			
		</c:forEach>
        </tbody>
    </table>
	
	<table align="center" width="100%" class="bottomback">
	  <tr><td align="center">
		<input type="button" id="button_new" onclick="dosubmit()" value="提交"/></td>
	  </tr>   
	</table>
  </div> 
			 
</div>

</form>
</body>
<script type="text/javascript">
	function dosubmit()
	{
		var flag = true;
		var index = document.getElementById("employee").selectedIndex;
		if(index == 0)
		{
			alert("请选择员工");
			flag = false;
			return false;
		}
		var uname = document.getElementsByName("uname");
		var storeNumber = document.getElementsByName("storeNumber");
		var number = document.getElementsByName("number");
		var unit = document.getElementsByName("unit");
		var size = storeNumber.length;
		for(var i = 0;i < size;i++)
		{
		 	if(!/^[0-9]*$/.test(number[i].value)){
		 		number[i].value = "";
       			alert("第"+(i+1)+"行的数量必须为数字");
       			flag = false;
				return false;
    		}
    		if(number[i].value == "")
    		{
    			alert("第"+(i+1)+"行的数量没有填写");
       			flag = false;
				return false;
    		}
			if(parseInt(number[i].value) < parseInt(storeNumber[i].value))
			{
				alert("第"+(i+1)+"行的数量不能超过原值"+number[i].value);
				storeNumber[i].value = "";
				flag = false;
				return false;
			}
			if(parseInt(storeNumber[i].value) < 0)
			{
				alert("第"+(i+1)+"行的数字不能小于0");
				storeNumber[i].value = "";
				flag = false;
				return false;
			}
		}
		
		if(flag)
		{
			var checkbox = document.getElementsByName("checkbox");
			for(var i = 0;i < checkbox.length;i++)
			{
				if(checkbox[i].checked == true)
				{
					 uname[i].disabled = false;
					 storeNumber[i].disabled = false;
					 unit[i].disabled = false;
				}
				else
				{
					uname[i].disabled = true;
					 storeNumber[i].disabled = true;
					 unit[i].disabled = true;
				}
				
			}
			var form = document.getElementsByName("form")[0];
			form.submit();
		}
	}
	function checkNum(input)
	{
		if(input.value == "")
		{
			return false;
		}
		else
		{
			var reg = new RegExp("^[0-9]*$");
	 		if(!reg.test(input.value))
	 		{
	 			input.value = "";
	 	 		alert("请填写合理的数值");
	 		}
		}
		
		 
	}
</script>
</html>