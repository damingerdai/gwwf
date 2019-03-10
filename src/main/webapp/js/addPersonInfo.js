function checkEmployee() {
	var flag = true;
	var empid = document.getElementsByName("empid")[0].value;
	if (empid == "" || empid == null) {
		alert("请输入员工编号！");
		flag = false;
		return false;
	}
	var username = document.getElementsByName("username")[0].value;
	if (username.trim() == "") {
		alert("请输入姓名");
		flag = false;
		return false;
	}
	
	var radioGroups = document.getElementsByName("gender");
	var gender = null;
	var rflag = false;
	for (var i = 0; i < radioGroups.length; i++) {
		if (radioGroups[i].checked) {
			rflag = true;
			gender = radioGroups[i].value;
		}
	}
	if (!rflag) {
		alert("请选择性别");
		flag = false;
		return false;
	}
	var birthday = document.getElementsByName("birthday")[0].value;
	
	if (birthday.trim() == "") {
		alert("请输入出生日期");
		flag = false;
		return false;
	} else if (birthday.trim().match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/) == null) {
		alert("请输入正确的时间格式:yyyy-MM-dd");
		flag = false;
		return false;
	}
	var dindex = document.getElementsByName("department")[0].selectedIndex;
	var dep = document.getElementsByName("department")[0].value;
	if (dindex == 0) {

		alert("请选择部门");
		flag = false;
		return false;
	}
	

	var college = document.getElementsByName("college")[0].value;
	if (college.trim() == "") {
		alert("请输入学校");
		flag = false;
		return false;
	}

	var major = document.getElementsByName("major")[0].value;
	if (major.trim() == "") {
		alert("请输入专业");
		flag = false;
		return false;
	}
	var edu = document.getElementsByName("edu")[0].value;
	if (edu.trim() == "") {
		alert("请输入学历");
		flag = false;
		return false;
	}
	var pwds = document.getElementsByName("password");
	if (pwds[0].value == "") {
		alert("请输入密码");
		flag = false;
		return false;
	} else if (pwds[1].value == "") {
		alert("请确认密码");
		flag = false;
		return false;
	} else if (pwds[0].value != pwds[1].value) {
		alert("密码和确认密码不一致");
		flag = false;
		return false;
	}
	if(flag)
	{
		 var form = document.getElementsByName("form")[0];
		 form.submit();
		 alert("保存成功");
	}
	
}

function selectChange(select) {
	var value = select.value;
	if(value != "dep")
	{
		var empid = document.getElementsByName("empid")[0];
		var val = empid.value.substring(2);
		empid.value = value + val;
	}
}