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
<script language="javascript" src="js/jquery.js" charset="utf-8"></script>
<script language="javascript" src="js/jquery-1.8.0.js" charset="utf-8"></script>
<script language="javascript" src="js/addStaffattendance.js" charset="gbk"></script>
<script language="javascript" src="js/laydate/laydate.js" charset="gbk" ></script>
<title>登记员工考勤记录</title>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
</head>
<body onload="NnmShow()">
<form name="form" action="PersonAdminServlet?method=addAttendance" method="post">
<div class="head"><div class="head_title"><h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />员工考勤登记</h1></div></div>
<div class="content2">
  <div class="ItemBlockBorder2">
	<div class="ItemBlock2">
	<table class="formtable">
            <tr>
				<th width="11%">员工号</th>
				<td width="50%"><input name="empid" id="empid" type="text" class="button3" onblur="JavaScript:blurHandle()" onfocus="JavaScript:focusHandle()"/></td>
				<td width="39%"><div name="empiderror"></div></td>
			</tr>
			<tr>
				<th>考勤日期</th>
				<td><input name="cdate" id="cdate" type="text" class="button3" onfocus="clearError(this)" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" readonly="readonly"/></td>
				<td><div name="cdateerror"></div></td>
			</tr>
			<tr>
				<th>上班时间</th>
				<td><input name="ontime" id="ontime" type="text" class="button3" onfocus="clearError(this)"/></td>
				<td><div name="ontimeerror"></div></td>
			</tr>
			<tr>
				<th>下班时间</th>
				<td><input name="offtime" id="offtime" type="text" class="button3" onfocus="clearError(this)"/></td>
				<td><div name="offtimeerror"></div></td>
			</tr>
			<tr>
				<th>考勤类型</th>
				<td>
				  <input name="ctype"  type="radio" value="上班" checked="checked"/>上班
				  <input name="ctype"  type="radio" value="加班" />加班
				</td>
				<td><div name="ctypeerror"></div></td>
			</tr>
			<!-- 
			<tr>
				<th>使用类型</th>
				<td>
				  <label>
				    <input type="radio" name="RadioGroup2" value="单选" /> 公用</label>
				  <label>
				    <input type="radio" name="RadioGroup2" value="单选" />专用</label>
				</td>
			</tr>	
			 -->			
    </table>
	</div>
	<table align="center" width="100%" class="bottomback">
	  <tr>
	      <td align="center">
		       <input type="button" id="button_new"  value="保存" onclick="Commit()"/>
			   <input type="reset" id="button_new"  value="重置"  onclick="doreset()"/>
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