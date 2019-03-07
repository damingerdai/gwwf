function clearError(input) {

		var error = input.name + "error";
		document.getElementsByName(error)[0].innerHTML = "";
}
function checkCar(input)
{
	if(input.value == null || input.value == "")
	{
		return;
	}
	var url = "VehicleManageServlet?method=searchCar";
	var sendData = {
		"carid" : input.value
	};
	$.post(url, sendData, function(backData, textStatus, xhr) {
		if (backData != "Car_is_null") {
			var error = document.getElementsByName("cariderror")[0];
			error.innerHTML = "<font color='red'>该车辆信息已经存在</font>";
		}
	});
}
function findDriver()
{
	var url = "VehicleManageServlet?method=searchDriver";
	var sendData = null;
	$.post(url,sendData,function(backData,textStatus,xhr)
	{
		  var json = eval(backData);
		  var size = json.length;
		  $("#driverid option:gt(0)").remove();
		  for(var i = 0;i < size;i++)
		  {
			  var empid = json[i].empId;
			  var username = json[i].username;
			  var $option = $("<option value="+empid+">" + username + "</option>");
			  $("#driverid").append($option);
		  }
	}		
	)
}
function dosubmit()
{
	var flag = true;
	var carid = document.getElementsByName("carid")[0].value;
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
	var cartype = document.getElementsByName("cartype")[0].value;
	var cartypeerror = document.getElementsByName("cartypeerror")[0];
	if(cartype == null || cartype == "")
	{
		cartypeerror.innerHTML = "<p><font color='red'>请填写车型信息</font></p>";
		flag = false;
	}
	var buytime = document.getElementsByName("buytime")[0].value;
	var buytimeerror = document.getElementsByName("buytimeerror")[0];
	if(buytime == null || buytime == "")
	{
		buytimeerror.innerHTML = "<p><font color='red'>请填写购买时间</font></p>";
		flag = false;
	}
	var dirverid = document.getElementsByName("dirverid")[0];
	var index = dirverid.selectedIndex;
	var dirveriderror = document.getElementsByName("dirveriderror")[0];
	if(index == 0)
	{
		dirveriderror.innerHTML = "<p><font color='red'>请选择司机</font></p>";
		flag = false;
	}
	var capacity = document.getElementsByName("capacity")[0].value;
	var capacityerror = document.getElementsByName("capacityerror")[0];
	if(capacity == null || capacity == "")
	{
		capacityerror.innerHTML = "<p><font color='red'>请填写容量</font></p>";
		flag = false;
	}
	else if(!/^[0-9]*$/.test(capacity))
	{
		capacityerror.innerHTML = "<p><font color='red'>请填写数字</font></p>";
		flag = false;
	}
	
	if(flag)
	{
		var form = document.getElementsByName("form")[0];
		form.submit();
	}
	
}
function clearError(input) {
	 
	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";

}

function immediately()
{
	var capacity = document.getElementsByName("capacity")[0];
	if("\v"=="v")
	{
		capacity.onpropertychange = webChange;
	}
	else
	{
		capacity.addEventListener("input",webChange,false);
	}
	
	function webChange()
	{

	    if(!/^[0-9]*$/.test(capacity.value)){
	        alert("请输入数字!");
	        capacity.value = "";
	    }
	}
}

function doreset()
{
	document.getElementsByName("cariderror")[0].innerHTML = "";
	document.getElementsByName("cartypeerror")[0].innerHTML = "";
	document.getElementsByName("buytimeerror")[0].innerHTML = "";
	document.getElementsByName("dirveriderror")[0].innerHTML = "";
	document.getElementsByName("capacityerror")[0].innerHTML = "";
	return true;
}
function clearSelectError(select)
{
	var index = select.selectedIndex;
	if(index != 0)
	{
		document.getElementsByName("dirveriderror")[0].innerHTML = "";
	}
}
function cleaerError(input)
{
	document.getElementsByName(input.name+"error")[0].innerHTML = "";
	laydate({istime: true, format: 'YYYY-MM-DD'});
}
 
 

