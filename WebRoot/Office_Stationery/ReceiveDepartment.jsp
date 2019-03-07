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
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<!--
</script>
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
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/jquery-1.8.0.js"></script>
<script language="javascript" src="js/ReceiveDepartment.js" charset="gbk"></script>
<link type="text/css" rel="stylesheet" href="css/select.css"/>
<script language="JavaScript" src="js/select-ui.min.js" ></script>
	<script type="text/javascript"> 
	$(document).ready(function(e) {
		$(".button11").uedSelect({
			width : 132			  
		});
	});
	</script>
</head>
<body>
<form name="form" action="PersonAdminServlet?method=getEmployeeByOffice" method="post">
<div class="head"><div class="head_title"><h1><img src="img/item_point.png" />办公用品
		<img src="img/item_point.png" />选择领取用品部门</h1></div></div>	  
<div class="content">
  <div class="ItemBlockBorder">
	<div class="ItemBlock">
	   <table class="formtable">
	       <tr>
			   <th width="167" >领取用品员工所属部门：</td>
			   <td width="175">
				   <select name="department" id="department" class="button11">
					   <option>请选择部门</option>
					   <option>行政部门</option>
					   <option>后勤部门</option>
					   <option>人事部门</option>
				   </select>
		     </td>
			   <td width="404" >
			   <input type="button" id="button_new" value="确 定" onclick="getEmployee()"/>
		     </td>
		   </tr>
	   </table>
	</div>
  </div> 
		 
</div>

</form>
<script type="text/javascript">
	getDepartment();
</script>
</body>
</html>