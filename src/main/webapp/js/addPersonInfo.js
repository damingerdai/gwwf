function checkEmployee() {
	var flag = true;
	var empid = document.getElementsByName("empid")[0].value;
	if (empid == "" || empid == null) {
		alert("������Ա����ţ�");
		flag = false;
		return false;
	}
	var username = document.getElementsByName("username")[0].value;
	if (username.trim() == "") {
		alert("����������");
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
		alert("��ѡ���Ա�");
		flag = false;
		return false;
	}
	var birthday = document.getElementsByName("birthday")[0].value;
	
	if (birthday.trim() == "") {
		alert("�������������");
		flag = false;
		return false;
	} else if (birthday.trim().match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/) == null) {
		alert("��������ȷ��ʱ���ʽ:yyyy-MM-dd");
		flag = false;
		return false;
	}
	var dindex = document.getElementsByName("department")[0].selectedIndex;
	var dep = document.getElementsByName("department")[0].value;
	if (dindex == 0) {

		alert("��ѡ����");
		flag = false;
		return false;
	}
	

	var college = document.getElementsByName("college")[0].value;
	if (college.trim() == "") {
		alert("������ѧУ");
		flag = false;
		return false;
	}

	var major = document.getElementsByName("major")[0].value;
	if (major.trim() == "") {
		alert("������רҵ");
		flag = false;
		return false;
	}
	var edu = document.getElementsByName("edu")[0].value;
	if (edu.trim() == "") {
		alert("������ѧ��");
		flag = false;
		return false;
	}
	var pwds = document.getElementsByName("password");
	if (pwds[0].value == "") {
		alert("����������");
		flag = false;
		return false;
	} else if (pwds[1].value == "") {
		alert("��ȷ������");
		flag = false;
		return false;
	} else if (pwds[0].value != pwds[1].value) {
		alert("�����ȷ�����벻һ��");
		flag = false;
		return false;
	}
	if(flag)
	{
		 var form = document.getElementsByName("form")[0];
		 form.submit();
		 alert("����ɹ�");
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