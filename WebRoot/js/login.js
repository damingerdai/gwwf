 
function clicklogin(){
	var flag = true; 
	var empid = document.getElementsByName("empid")[0];
	var empiderror = document.getElementsByName("empiderror")[0]; 
	if(empid.value == null || empid.value.trim() == "")
	{
		empiderror.innerHTML = "<font color='red'>请填写员工号</font>";
		flag = false;
	}
	var password = document.getElementsByName("password")[0];
	var passworderror = document.getElementsByName("passworderror")[0];
	if(password.value == null || password.value == "")
	{
		passworderror.innerHTML = "<font color='red'>请填写密码</font>"; 
		flag = false;

	}
	 
	if(flag)
	{ 
		var url = "LoginServlet?method=login";
		var sendData = {"empid":empid.value.trim(),"password":password.value};
		$.post(url,sendData,function(backData,textStatus,xhr)
		{
			empiderror.innerHTML = "";
			passworderror.innerHTML = "";
			 
			if(backData == "empid_error")
			{
				passworderror.innerHTML = "<font color='red'>员工号或者密码不正确</font>";
			}
			else if(backData == "password_error")
			{
				passworderror.innerHTML = "<font color='red'>员工号或者密码不正确</font>";
			}
			else if(backData == "success")
			{
				 
				location.href = "index.jsp";
			}
		}		
		);
	}
	
}
	
function clearError(input) {

	var error = input.name + "error";
	document.getElementsByName(error)[0].innerHTML = "";
}
 