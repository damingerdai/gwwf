function updateEmployee() {
	/*
	var pwderror = document.getElementById("pwderror");
	pwderror.innerHTML = "";
	var pwds = document.getElementsByName("password");
	if (pwds[0].value != pwds[1].value) {
		pwderror.style.display = "inline";
		pwderror.innerHTML = "<p><font color='red'>�������벻һ��</font></p>";
		return false;
	}
	*/
	 
	var flag = true;
	var username = document.getElementsByName("username")[0];
	var usernameerror = document.getElementsByName("usernameerror")[0];
	if(username.value.trim() == "")
	{
		usernameerror.innerHTML = "<font color='red'>����д����</font>";
		flag = false;
	}
	var college = document.getElementsByName("college")[0];
	var collegeerror = document.getElementsByName("collegeerror")[0];
	if(college.value.trim() == "")
	{
		collegeerror.innerHTML = "<font color='red'>����дѧУ</font>";
		flag = false;
	}
	 
	var major = document.getElementsByName("major")[0];
	var majorerror = document.getElementsByName("majorerror")[0];
	if(major.value.trim() == "")
	{
		majorerror.innerHTML = "<font color='red'>����дרҵ</font>";
		flag = false;
	}
	var edu = document.getElementsByName("edu")[0];
	var eduerror = document.getElementsByName("eduerror")[0];
	if(edu.value.trim() == "")
	{
		eduerror.innerHTML = "<font color='red'>����дѧ��</font>";
		flag = false;
	}
	if(flag)
	{
		var form = document.getElementsByName("updateform")[0];
		form.submit();
	}
	
}
function openWin()
{
	 var pwderror = document.getElementById("pwderror");
	 pwderror.style.display="none";
	 pwderror.innerHTML="";
}
function clearError(input)
{
	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}
function doreset()
{
	document.getElementsByName("usernameerror")[0].innerHTML = "";
	document.getElementsByName("collegeerror")[0].innerHTML = "";
	document.getElementsByName("eduerror")[0].innerHTML = "";
	document.getElementsByName("majorerror")[0].innerHTML = "";
	return false;
}
