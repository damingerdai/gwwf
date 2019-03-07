<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改员工个人信息</title>
<base href="<%=basePath %>"/>
<link  rel="stylesheet" type="text/css" href="css/style.css";/>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/DemoData.js" charset="utf-8"></script>
<script language="javascript" src="js/DataShowManager.js" charset="utf-8"></script>
<script language="javascript" src="js/reviseEmployee.js" charset="gbk"></script>
<script language="javascript" src="js/laydate/laydate.js" ></script>
</head>
<body style="margin:0;">
<form name="updateform" action="PersonAdminServlet?method=updateEmployee" method="post">
        <div class="head"><div class="head_title"> <h1>位置<img src="img/item_point.png" />人事管理
		<img src="img/item_point.png" />修改员工个人信息</h1> </div></div>
		
        <div class="content2">		
          <div class="ItemBlockBorder2">
			  <div class="ItemBlock2">
				<table class="formtable">
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th width="11%">员工号</th>
					  <td width="50%" class="TableDetail1 template"><input name="empid" type="text" class="button30" value="${requestScope.empid}" readonly="ture"/></td>
					  <td></td>
					</tr>
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th width="11%">姓名</th>
						<td class="TableDetail1 template">
						<input name="username" maxlength="20" type="text" class="button3" value="${requestScope.username}" onfocus="clearError(this)"/>
						</td>
						<td><div name="usernameerror" ></div></td>
					</tr>
					<tr>
						<th width="11%">性别</th>
						<td>	
						
						  <label><input type="radio" name="gender" value="男" checked="${requestScope.gender=='男'? 'true':'' }" readonly="readonly"/> 男</label>
						  	<label><input type="radio" name="gender" value="女" checked="${requestScope.gender=='女'? 'true':'' }" readonly="readonly"/> 女</label>
						  
						</td>
					</tr>
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th >出生日期</th>
						<td class="TableDetail1 template">
						<input name="birthday" type="text" class="button3" value="${requestScope.birthday}" readonly="readonly" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"/>
						</td>
					</tr>
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th >所属部门</th>
						<td  class="TableDetail1 template">
						<input name="depart" type="text" class="button30" maxlength="20" value="${requestScope.department }" readonly="ture"/>
						</td>
					</tr>
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th >学校</th>
						<td  class="TableDetail1 template">
						<input name="college" type="text" class="button3" maxlength="20" value="${requestScope.college}" onfocus="clearError(this)"/>
						</td>
						<td><div name="collegeerror" ></div></td>
					</tr>
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th >专业</th>
						<td  class="TableDetail1 template">
						<input name="major" type="text" class="button3" maxlength="20" value="${requestScope.major}" onfocus="clearError(this)"/>
						</td>
						<td><div name="majorerror" ></div></td>
					</tr>
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th >学历</th>
						<td  class="TableDetail1 template">
						<input name="edu" type="text" maxlength="20" class="button3" value="${requestScope.edu}" onfocus="clearError(this)"/>
						</td>
						<td><div name="eduerror" ></div></td>
					</tr>
					<!--  
					<tr class="dataContainer" datakey="personInfo_Updata">
						<th >密码</th>
						<td  class="TableDetail1 template">
						<input name="password" type="text" class="button3" value="" maxlength="5"/>
						</td>
					</tr>
					<tr>
						<th >确认密码</th> 
						<td><input name="password" type="text" class="button3" value="" maxlength="5"/></td>
						<td><div id="pwderror" style="display:none; background-color:#eeeeee"></div></td>             
					</tr>
				  -->
				</table>
			  </div>
			 <table width="100%" class="bottomback">
				   <tr><td align="center"  >
						<input type="button" id="button_new" value="保 存" onclick="updateEmployee()" />
						<input type="reset" id="button_new" value="重 置"  onclick="doreset()"/>
				   </td></tr>   
			  </table> 
		  </div>
		
          
        </div>
		
</form>
<script type="javascript" charset="gbk">
	
</script>
</body>
</html>
