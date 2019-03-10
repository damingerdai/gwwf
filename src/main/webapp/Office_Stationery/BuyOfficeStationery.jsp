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
<title>购买办公用品登记</title>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/jquery-1.8.0.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/PagecCommon.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
<script language="javascript" src="js/BuyOfficeStationery.js" charset="gbk"></script>
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
<form name="form" action="OfficeServlet?method=updateOfficeInfo" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />办公用品
		<img src="img/item_point.png" />购买办公用品登记</h1></div></div>	  
<div class="content">
  <div class="ItemBlockBorder">
	<table cellspacing="0" cellpadding="0" class="datetable">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td width="40%">商品名称</td>
				<td width="15%">数量</td>
				<td width="10%">单位</td>
				<td width="20%">相关操作</td>
				 
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="BuyOfficeStationeryInfo">
			<tr class="TableDetail1 template">
			<!--  
				<td><input type="text"/></td>
				<td class="Text_Num">${OfficeStationery.number}</td>
				<td>${OfficeStationery.unit}&nbsp;</td>
				<td>	
					<a href="#">提交</a>
					<a href="#">取消</a>
				</td>
				-->
			 
                <td><input name="uname" type="text"  class="button22" maxlength="10"/></td>
                <td ><input name="number" type="text"  class="button32" maxlength="10" onblur="blurHandle(this)"/></td>				
                <td><input name="unit" type="text"  class="button31" maxlength="10" /></td>
				 <td>	
				 	<!--  
					<a href="OfficeServlet?method=addOfficeStationery" >提交</a>
					-->
					<a onclick="Cancel(this)" >取消</a>
				</td>
				 
              	 
			</tr>
        </tbody>
    </table>
	
	<table align="center" width="100%" class="bottomback">
	  <tr>
	  <td align="center">
		<input type="button" id="button_new2" onclick="addOfficeStationery()" value="新增办公用品信息"/>
		<input type="reset" name="reset" id="button_new2" value="重置" onclick="doreset()"/>
		<input  type="button" id="button_new2" onclick="dosubmit()" value="一键提交" onclick="dosubmit()"/>
	  </td>
		
	  </tr>   
	</table>
  </div> 
			 
</div>

</form>
<script type="text/javascript">
	 


</script>
</body>
</html>