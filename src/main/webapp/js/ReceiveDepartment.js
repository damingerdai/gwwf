function getDepartment()
{
	var url = "PersonAdminServlet?method=getDepartmentByOffice";
	var sendData = null;
	$.post(url,sendData,function(backData,textStatus,xhr)
	{
		var json = eval(backData);
		var size = json.length;
		$("#department option:gt(0)").remove(); 
		for(var i = 0;i < size;i++)
		{
			var depid = json[i].depid;
			var dname = json[i].dname;
			var $option = "<option value="+depid+">"+dname+"</option>";
			$("#department").append($option);
		}
	}
	);
}

function getEmployee()
{
	var select = document.getElementsByName("department")[0];
	var index = select.selectedIndex;
	if(index == 0)
	{
		alert("«Î—°‘Ò≤ø√≈");
		return false;
	}
	
	var form = document.getElementsByName("form")[0];
	form.submit();
	
}