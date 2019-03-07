<%@ page language="java" import="java.util.*,com.sun.demo.bean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML>
<HEAD>
    <title>长城内部流程管理系统</title>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/jsp; charset=utf-8" />
	<script language="JavaScript" type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
 
</script>
</HEAD>



<FRAMESET ROWS="88,*" FRAMESPACING="0" FRAMEBORDER="0" BORDER="0" bordercolor="#ECE9D8">
 	
	<FRAME noresize NAME="TopMenu" SRC="top.jsp" TARGET="contents"  scrolling="no" />
	<frameset rows="*" cols="220,*" framespacing="0" frameborder="no" border="0" valign=middle>
		<FRAME  NAME="menu" SRC="left.jsp" TARGET="desktop"scrolling="no" noresize="NORESIZE"/>
		<FRAME noresize NAME="desktop" SRC="right.jsp" SCROLLING="yes" />
	</FRAMESET>
	
</FRAMESET>
 
<NOFRAMES>
<BODY>


</BODY>
<script type="text/javascript">
	
</script>
</NOFRAMES>
</HTML>
