function focusHandle() {
	var empiderror = document.getElementsByName("empiderror")[0];
	empiderror.innerHTML = "";
}
function clearError(input) {

	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}
function Commit()
{
	var flag = true;
	var empid = document.getElementsByName("empid")[0];
	var empiderror = document.getElementsByName("empiderror")[0];
	if(empid.value == "")
	{
		empiderror.innerHTML ="<p><font color='red'>请填写员工编号</font></p>";
		flag = false;
	}
	else if(empiderror.innerHTML != "")
	{
		flag = false
	}
	var $cdate = $("#cdate");
	var cdateerror = document.getElementsByName("cdateerror")[0];
	
	if($cdate.val() == "")
	{
		cdateerror.innerHTML = "<p><font color='red'>请填写日期</font></p>";
		flag = false;
	}
	else if($cdate.val().match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/) == null)
	{
		cdateerror.innerHTML = "<p><font color='red'>请写成yyyy-MM-dd的格式</font></p>";
		flag = false;
	}
	
	var ontime = $("#ontime").val();
	var ontimerror = document.getElementsByName("ontimeerror")[0];
	if(ontime == "" )
	{
		ontimerror.innerHTML = "<p><font color='red'>请填写上班时间</font></p>";
		flag = false;
	}
	else if(ontime.match(/^([0-1][0-9]|[2][0-3]):([0-5][0-9])$/) == null)
	{
		ontimerror.innerHTML = "<p><font color='red'>请写成HH:mm的时间形式</font></p>";
		flag = false;
		 
	}
	 
	var offtime = $("#offtime").val();
	 
	var offtimerror = document.getElementsByName("offtimeerror")[0];
	if(offtime == "" )
	{
		offtimerror.innerHTML = "<p><font color='red'>请填写上班时间</font></p>";
		flag = false;
	}
	else if(offtime.match(/^([0-1][0-9]|[2][0-3]):([0-5][0-9])$/) == null)
	{
		offtimerror.innerHTML = "<p><font color='red'>请写成HH:mm的时间形式</font></p>";
		flag = false;
	}
	 
	if(!flag)
	{
		return flag;
	}

	var form = document.getElementsByName("form")[0];
	form.submit();
} 


function blurHandle()
{
	var empid = document.getElementsByName("empid")[0].value;
	var empiderror = document.getElementsByName("empiderror")[0];
	if(empid != "")
	{
		var url = "PersonAdminServlet?method=searchEmployee";
		var sendData = {"empid":empid};
		$.post(url,sendData,function(backData,textStatus,xhr)
		{
			if(backData == "error")
			{
				empiderror.innerHTML = "<p><font color='red'>该员工不存在</font></p>"
			}
		}
		);
	}
	else
	{
		empiderror.innerHTML = "";
	}
	
} 
function doreset()
{
	document.getElementsByName("empiderror")[0].innerHTML = "";
	document.getElementsByName("cdateerror")[0].innerHTML = "";
	document.getElementsByName("ontimeerror")[0].innerHTML = "";
	document.getElementsByName("offtimeerror")[0].innerHTML = "";
	document.getElementsByName("ctypeerror")[0].innerHTML = "";
	return true;
}

