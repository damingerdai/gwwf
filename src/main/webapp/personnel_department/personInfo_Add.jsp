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
<title>新增员工个人信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script type="text/javascript" src="js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="css/select.css"/>
<script language="JavaScript" src="js/select-ui.min.js"></script>
<script language="JavaScript" src="js/addPersonInfo.js" charset="gbk"></script>
 
</head>
<body style="margin:0;">
<form name="form" action="PersonAdminServlet?method=addEmployee" method="post">
        <div class="head"><div class="head_title"> <h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />新增员工个人信息</h1> </div></div>
		
        <div class="content">		
          <div class="ItemBlockBorder">
			  <div class="ItemBlock">
				<table class="formtable">
					<tr>
						<th width="10%">员工号</th>
					  <td width="25%"><input name="empid" type="text" value="${requestScope.empid }" readonly="readonly" class="button33" /></td>
						<th width="10%">姓 名</th>
				      <td width="25%"><input name="username" type="text" class="button33" maxlength="20" /></td>
						<th width="8%">性 别</th>
						<td width="22%">		
						  <label><input type="radio" name="gender" id="man" value="男" checked="checked" /> 男</label>
						  <label><input type="radio" name="gender" id="woman" value="女" /> 女</label>
					  </td>
					</tr>
					<tr>
						<th >出生日期</th><td><input name="birthday" type="text" class="button33" maxlength="20" /></td>
						<th >所属部门</th>
						<td colspan="3">
						<select  name="department" id="department" class="button11" onchange="selectChange(this)">
						   <option value="dep">请选择部门</option>
						   <c:forEach items="${requestScope.list }" var="dep">
						   	<option value="${dep.depid }">${dep.dname }</option>
						   </c:forEach>
					   </select>
					   <!--  
					   <script type="text/javascript">
					   		uploadDepartment();
						</script>
						-->
						</td>
					</tr>
					<tr>
						<th >学 校</th>
						<td><input name="college" type="text" class="button33" maxlength="20"/></td>
						<th >专 业</th>
						<td><input name="major" type="text" class="button33" maxlength="20"/></td>
						<th >学 历</th>
						<td><input name="edu" type="text" class="button33" maxlength="10" /></td>
					</tr>
					<tr>
						<th >密 码</th>
						<td><input name="password" type="password" class="button33" maxlength="5"/></td>
						<th >确认密码</th> 
						<td colspan="3"><input name="password" type="password" class="button33"  maxlength="5" /></td>            
					</tr>
				  
				</table>
			  </div>
	
          <table width="100%" class="bottomback">
               <tr><td align="center"  >
            		<input type="button" id="button_new" value="保 存" onclick="checkEmployee()"/>
            		<input type="reset" id="button_new" value="重 置"/>
          	   </td></tr>   
          </table> 
		 
		 </div>
		  
        </div>
</form>
<script type="text/javascript"> 

	 
		$(document).ready(function(e) {
		$(".button11").uedSelect({
			width : 118			  
		});
	});
	 
	
	</script>
</body>
</html>
