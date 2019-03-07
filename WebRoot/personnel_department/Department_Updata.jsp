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
<title>修改部门信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/popwindow.js" charset="utf-8"></script>
<script language="javascript" src="js/updataDepartment.js" charset="gbk"></script>
<!--
<script language="javascript" src="../js/jquery.js" charset="utf-8"></script>
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
</head>
<body>
<form name="form" action="PersonAdminServlet?method=updateDepartment" method="post">
<div class="head"><div class="head_title"><h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />修改部门信息</h1></div></div>	  
<div class=".content_pop">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	   <table class="formtable">
	       <tr class="dataContainer" datakey="Department_Updata">
			   <th width="30%">部门编号</th>
			   <td width="40%"class="TableDetail1 template">
			 <input name="depid" type="text" class="button30" value="${param.depid }" readonly="ture"/> 	       
			 </td>
			 <td >
			 	<div name="depiderror">
			 	</div>
			 </td>
	      </tr>
			<tr class="dataContainer" datakey="Department_Updata">
			   <th width="20%">部门名称</td>
			   <td width="30%" class="TableDetail1 template">
				 <input name="dname" type="text"  class="button22" value="${param.dname }" maxlength="10" onfocus="clearError(this)"/>
		       </td>
		       <td width="50%">
		       		<div name="dnameerror" >
		       		
		       		</div>
		       </td>
		    </tr>
	   </table>
	</div>
	<table align="center" width="100%" class="bottomback">
	  <tr>
	      <td align="center">
		       <input type="button" id="button_new"  value="保存" onclick="Commit()"/>
			   <input type="reset" id="button_new"  value="重置" onclick="doreset()"/>
         </td>
	  </tr>   
	</table> 

  </div> 		 
</div>

</form>
</body>
</html>
