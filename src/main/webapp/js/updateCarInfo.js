function setCapunit()
{

	var capuint = document.getElementsByName("capunit");
	capuint[0].checked="checked";
	capuint[1].checked="";
}
function setUsagetype()
{
	var usageType = document.getElementsByName("usageType");
	usageType[0].checked = "checked";
	usageType[1].checked = "";
}
function dosubmit()
{
	var dirverId = document.getElementsByName("dirverId")[0].value;
	var flag = true;
	if(dirverId == null || dirverId == "")
	{
		 var error = document.getElementsByName("dirverIderror")[0];
		error.innerHTML = "<font color='red'>ÇëÌîÐ´Ë¾»ú</font>";
		flag = false;
	}
	if(flag)
	{
		var form = document.getElementsByName("form")[0];
		form.submit();
		window.opener.location.reload();
		CloseWin();
	}
	
}
function checkEmp(input)
{
	if(input.value == null || input.value == "")
	{
		return;
	}
	var url = "VehicleManageServlet?method=searchEmployee";
	var sendData = {
		"userid" : input.value
	};
	$.post(url, sendData, function(backData, textStatus, xhr) {
		 if(backData == "error")
		 {
			
			 var error = document.getElementsByName("dirverIderror")[0];
			error.innerHTML = "<font color='red'>X</font>";
		 }
	});
}
function clearError(input) {
	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}