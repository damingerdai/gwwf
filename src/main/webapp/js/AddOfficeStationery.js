function addOfficeStationery()
{
	 
	var $tr = "<tr>"
		        +"<td><input name='uname' type='text'  class='button22'/></td>"
                +"<td><input name='number' type='text'  class='button32'/></td>"				
                +"<td><input name='unit' type='text'  class='button31'/></td>"
				+"<td><a href=''>提交</a><a href=''>取消</a></td>"
				+"</tr>";
	$table.append($tr);
}
function removeOfficeStationery()
{
	var size = $("#mainTable tr").size();
	if(size > 2)
	{
		$("#mainTable tr:last").remove();
	}
}
function doreset()
{
	$("#mainTable tr:gt(1)").remove();
}
function closeWin()
{ 
	var uname = document.getElementsByName("uname");
	var number = document.getElementsByName("number");
	var unit = document.getElementsByName("unit");
	var remark = document.getElementsByName("remark");
	for(var i = 0;i < uname.length;i++)
	{
		if(uname[i].value.trim() == ""||number[i].value.trim() == "" || unit[i].value == "" || remark[i].value == "")
		{
			 alert("还有空格没有完整！");
			 return false;
		}
	}
	var tableData = opener.document.getElementById("TableData");
	for(var i = 0;i < uname.length;i++)
	{
		 var $tduname = $("<td>"+uname[i].trim()+"</td>");
		 
		 var $tdnumber = $("<td class='Text_Num'>"+number[i]+"</td>");
	 
		 var $tdunit = $("<td>"+unit[i]+"</td>");
	 
		 var $tr = $("<tr class='TableDetail1 template'></tr>");
	 
		 $tr.append($tduname);
	 
		 $tr.append($tdnumber);
	 
		 $tr.append($tdunit);
		 
		 $("#TableData").append($tr);
	}
	CloseWin();

}