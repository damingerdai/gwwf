function checkCar(input)
{
	if(input.value.trim() == null || input.value.trim() == "")
	{
		return;
	}
	var url = "VehicleManageServlet?method=searchCar";
	var sendData = {
		"carid" : input.value.trim()
	};
	$.post(url, sendData, function(backData, textStatus, xhr) {
		if (backData == "Car_is_null") {
			var error = document.getElementsByName("cariderror")[0];
			error.innerHTML = "<font color='red'>该车不存在</font>";
		}
	});
}
function clearError(input) {
	 
	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}
function dosubmit()
{
	 
	var flag = true;
	var carid = document.getElementsByName("carid")[0].value.trim();
	var cariderror = document.getElementsByName("cariderror")[0];
	if(carid == null || carid == "")
	{
		cariderror.innerHTML = "<p><font color='red'>请填写车牌号</font></p>";
		flag = false;
	}
	else
	{
		if(cariderror.innerHTML != "")
		{
			flag = false;
		}
	}
	var instrucation = document.getElementsByName("instrucation")[0].value.trim();
	if(instrucation == null || instrucation == "")
	{
		var instrucationerror = document.getElementsByName("instrucationerror")[0];
		instrucationerror.innerHTML = "<p><font color='red'>请填写说明</font></p>";
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
function doreset()
{
	document.getElementsByName("cariderror")[0].innerHTML = "";
	document.getElementsByName("instrucationerror")[0].innerHTML = "";
	return true;
}
