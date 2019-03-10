<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增办公用品信息</title>
<link  rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src="js/popwindow.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/AddOfficeStationery.js" charset="gbk"></script>
</head>
<body style="margin:0;">
<form name="form" method="post">
        <div class="head_pop"><div class="head_pop_title"> <h1><img src="img/item_point.png" />办公用品
		<img src="img/item_point.png" />新增办公用品信息</h1> </div></div>
		
        <div class="content">		
          <div class="pop_ItemBlockBorder">
            <table name="table" id="mainTable" class="datetable">
			<thead>
            <tr align="center" valign="middle" id="TableTitle">
                <td width="30%">&nbsp;&nbsp;商品名称</td>
				<td width="15%">&nbsp;&nbsp;数 量</td>
				<td width="15%">&nbsp;&nbsp;单 位</td>
				<td width="40%">&nbsp;&nbsp;备 注</td>                
			  </tr>
			  </thead>
			   <tbody id="TableData">
			  <tr>
                <td><input name="uname" type="text"  class="button22"/></td>
                <td><input name="number" type="text"  class="button32"/></td>				
                <td><input name="unit" type="text"  class="button31"/></td>
				<td><input name="remark" type="text"  class="button22"/></td>
              </tr>
            </table>

		  <table width="100%" class="bottomback">
               <tr><td align="center"  >
               		<input type="button" id="button_new" value="新增" onclick="addOfficeStationery()" />
               		<input type="button" id="button_new" value="删除" onclick="removeOfficeStationery()"/>
            		<input type="button" id="button_new" value="保 存" onclick="closeWin()"/>
            		<input type="reset" id="button_new" value="重 置" onclick="doreset()"/>
          	   </td></tr>   
          </table> 
		  </div>
		
          
        </div>
		
</form>
</body>
</html>

