
function Commit()
{
	var dname = document.getElementsByName("dname")[0];
	var dnameerror = document.getElementsByName("dnameerror")[0];
	var flag = true;
	if(dname.value.trim() == "")
	{
		dnameerror.innerHTML = "<font color='red'>部门名称不能为空</font>";
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
function clearError(input)
{
	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}
function doreset()
{
	document.getElementsByName("dnameerror")[0].innerHTML = "";
	return true;
}