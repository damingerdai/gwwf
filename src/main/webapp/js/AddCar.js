function checkCar(input)
{
	if(input.value == null || input.value.trim() == "")
	{
		return;
	}
	var url = "VehicleManageServlet?method=searchCar";
	var sendData = {
		"carid" : input.value
	};
	$.post(url, sendData, function(backData, textStatus, xhr) {
		if (backData == "Car_is_null") {
			var error = document.getElementsByName("cariderror")[0];
			error.innerHTML = "<font color='red'>该车辆信息不存在</font>";
		}
	});
}
function checkEmp(input)
{
	if(input.value == null || input.value.trim() == "")
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
			 var error = document.getElementsByName("useriderror")[0];
			error.innerHTML = "<font color='red'>该员工信息不存在</font>";
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
	var carid = document.getElementsByName("carid")[0].value;
	var cariderror = document.getElementsByName("cariderror")[0];
	if(carid == null || carid.trim() == "")
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
	var userid = document.getElementsByName("userid")[0].value;
	var useriderror = document.getElementsByName("useriderror")[0];
	if(userid == null || userid.trim() == "")
	{
		useriderror.innerHTML = "<p><font color='red'>请填写正确的员工编号</font></p>";
		flag = false;
	}
	else
	{
		if(useriderror.innerHTML != "")
		{
			flag = false;
		}
	}
	var usage = document.getElementsByName("usage")[0].value;
	var usageerror = document.getElementsByName("usageerror")[0];
	if(usage == null || usage.trim() == "")
	{
		usageerror.innerHTML = "<p><font color='red'>请填写用途</font></p>";
		flag = false;
	}
	var usagetime_begin = document.getElementsByName("usagetime_begin")[0].value;
	var usagetime_beginerror = document.getElementsByName("usagetime_beginerror")[0];
	if(usagetime_begin == null || usagetime_begin.trim() == "")
	{
		usagetime_beginerror.innerHTML = "<p><font color='red'>请填写出发时间</font></p>";
		flag = false;
	}
	var usagetime_end = document.getElementsByName("usagetime_end")[0].value;
	var usagetime_enderror = document.getElementsByName("usagetime_enderror")[0];
	if(usagetime_end == null || usagetime_end.trim() == "")
	{
		usagetime_enderror.innerHTML = "<p><font color='red'>请填写返回时间</font></p>";
		flag = false;
	}
	if(usagetime_begin.trim() != "" && usagetime_end.trim() != "")
	{
		var beginDate = usagetime_begin.split(" ")[0];
		var endDate = usagetime_end.split(" ")[0];
		var bDate = new Date(beginDate.replace(/-/g,"/"));
		var eDate = new Date(endDate.replace(/-/g,"/"));
		if(bDate > eDate)
		{
			usagetime_enderror.innerHTML = "<p><font color='red'>出发时间不能大于返回时间</font></p>";
			flag = false;
		}
		else
		{
			if(bDate = eDate)
			{
				var beginTime = usagetime_begin.split(" ")[1];
				var endTime = usagetime_end.split(" ")[1];
				var bHour = beginTime.split(":")[0];
				var eHour = endTime.split(":")[0];
				if(bHour > eHour)
				{
					usagetime_enderror.innerHTML = "<p><font color='red'>出发时间不能大于返回时间</font></p>";
					flag = false;
				}
				else
				{
					var bMin = beginTime.split(":")[1];
					var eMin = beginTime.split(":")[1];
					if(bMin > eMin)
					{
						usagetime_enderror.innerHTML = "<p><font color='red'>出发时间不能大于返回时间</font></p>";
						flag = false;
					}	 
				}
			}
		}
	}
	if(flag)
	{
		var form = document.getElementsByName("form")[0];
		form.submit();
	}
	
}

function  doreset()
{
	document.getElementsByName("cariderror")[0].innerHTML = "";
	document.getElementsByName("useriderror")[0].innerHTML = "";
	document.getElementsByName("usageerror")[0].innerHTML = "";
	document.getElementsByName("usagetime_beginerror")[0].innerHTML = "";
	document.getElementsByName("usagetime_enderror")[0].innerHTML = "";
	return true;
}
