
function clearError(input) {
	 
		var error = input.name + "error";
		document.getElementsByName(error)[0].innerHTML = "";
	
}
function checkCar(input) {
	if(input.value == null || input.value == "")
	{
		return;
	}
	var url = "VehicleManageServlet?method=searchCar";
	var sendData = {
		"carid" : input.value
	};
	$.post(url, sendData, function(backData, textStatus, xhr) {
		var error = document.getElementsByName("cariderror")[0];
		if (backData == "Car_is_null") {
			error.innerHTML = "<font color='red'>�ó���������</font>";
		}
		else if(backData == "Car_has_park")
		{
			error.innerHTML = "<font color='red'>�ó����Ѿ����˳�λ</font>";
		}
		
	});
}
function checkPark(input) {
	if(input.value == null || input.value == "")
	{
		return;
	}
	var url = "VehicleManageServlet?method=searchPark";
	var sendData = {
		"pid" : input.value
	};
	 
	$.post(url, sendData, function(backData, textStatus, xhr) {
		if (backData == "error") {
			var error = document.getElementsByName("piderror")[0];
			error.innerHTML = "<font color='red'>�ó�λ��Ϣ�Ѿ�����</font>";
		}
	});
}
function dosubmit()
{
	
	var flag = true;
	var pid = document.getElementsByName("pid")[0].value;
	var piderror = document.getElementsByName("piderror")[0];
	if(pid == "")
	{
		piderror.innerHTML = "<font color='red'>����д��λ���</font>";
		flag = false;
	}
	else
	{
		if(piderror.innerHTML != "")
		{
			flag = false;
		}
	}
	var carid = document.getElementsByName("carid")[0].value;
	var cariderror = document.getElementsByName("cariderror")[0];
	if(carid == "")
	{
		cariderror.innerHTML = "<font color='red'>����д��λ���</font>";
		flag = false;
	}
	else
	{
		if(cariderror.innerHTML != "")
		{
			flag = false;
		}
	}
	var instrucation = document.getElementsByName("instrucation")[0].value;
	var instrucationerror = document.getElementsByName("instrucationerror")[0];
	if(instrucation == "")
	{
		instrucationerror.innerHTML = "<font color='red'>����д˵��</font>";
		flag = false;
	}

	if(flag)
	{
		var form = document.getElementsByName("form")[0];
		form.submit();
	}
	
	
}
 
