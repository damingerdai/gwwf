function clear()
{
	var depiderror = document.getElementById("depiderror");
 	var dnameerror = document.getElementById("dnameerror");
 	depiderror.innerHTML = "";
 	dnameerror.innerHTML = "";
}
function checkDepId()
{
	  var depid = document.getElementsByName("depid")[0].value;
	  var dname = document.getElementsByName("dname")[0].value;
	  var depiderror = document.getElementById("depiderror");
	  var dnameerror = document.getElementById("dnameerror");
	  depiderror.innerHTML = "";
 	  dnameerror.innerHTML = "";
	  var flag = true;
	  if(depid.trim() == "")
	  {
	  		flag = false;
	  		depiderror.innerHTML = "<p><font color='red'>����д���ű��</font></p>";
	  }
	  if(dname.trim() == "")
	  {
	  		flag = false;
	  		dnameerror.innerHTML = "<p><font color='red'>����д��������</font></p>";
	  }
	  if(flag == false)
	  {
	  		return flag;
	  }
	   
	var url = "PersonAdminServlet?method=searchDepartment";
	var sendData = {"depid":depid};
		$.post(url,sendData,function(backData,textStatus,xhr)
		{
			  if(backData == "")
			  {
			  		var form = document.getElementsByName("form")[0];
			  		form.submit();
			  }
			  else  
			  {
			  	depiderror.innerHTML = "<p><font color='red'>�ò��ű���Ѿ�����,��������д</font></p>"
			  }
		});
		return false;
}
function clearError(input) {
	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}
function doreset()
{
	var depiderror = document.getElementsByName("depiderror")[0];
	depiderror.innerHTML = "";
	var dnameerror = document.getElementsByName("dnameerror")[0];
	dnameerror.innerHTML= "";
	return true;
}

 
