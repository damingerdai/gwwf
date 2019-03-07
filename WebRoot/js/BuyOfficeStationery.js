 
function addOfficeStationery() {
	 
	var $table = $("#TableData");
	var flag = true;
	var $trs = $table.children().last().children();
	for(var i = 0;i < 3; i++)
	{
		if($trs.children().eq(i).val().trim() == "")
		{
			alert("请将最后一行的数据填完整");
			return false;
		}
	}
	
	var $tr = $("<tr class='TableDetail1 template'>"
			+"<td><input name='uname' type='text' class='button22' maxlength='10'/></td>"
			+"<td><input name='number' type='text' class='button32' maxlength='10' onblur='blurHandle(this)'/></td>"
			+"<td><input name='unit' type='text' class='button31' maxlength='10' </td>"
			+"<td>"	
			+"<a onclick='Cancel(this)'>取消</a>"
			+"</td>"
			+"</tr>");
	$table.append($tr);
	 
}
function doreset()
{
	$("#TableData tr:gt(0)").remove();
}
function Cancel(a)
{
	 var size = $("#TableData tr").size();
	 if(size > 1)
	 {
	 	var $tr = $(a).parent().parent();
	 	$tr.remove();
	 }
	 else
	 {
	 	 var reset = document.getElementsByName("reset")[0];
	 	 var uname = document.getElementsByName("uname")[0];
	 	 var number = document.getElementsByName("number")[0];
	 	 var unit = document.getElementsByName("unit")[0];
	 	 
	 	 uname.value = "";
	 	 
	 	 number.value = "";
	 	 
	 	 unit.value = "";
	 }
}

function blurHandle(input)
{
	if(input.value != "")
	{
		var reg = new RegExp("^[0-9]*$");
	 	if(!reg.test(input.value))
	 	{
	 		input.value = "";
	 	 	alert("数量必须为数字");
	 	}
	} 
}

function dosubmit()
{
	var flag = true;
	var unames = document.getElementsByName("uname");
	var numbers = document.getElementsByName("number");
	var units = document.getElementsByName("unit");
	if(unames[unames.length-1].value.trim() == "")
	{
		alert("请填写最后一行的商品名称");
		flag = false;
		return false;
	}
	if(numbers[numbers.length-1].value.trim() == "")
	{
		alert("请填写最后一行的数量");
		flag = false;
		return false;
	}
	if(units[units.length-1].value.trim(6) == "")
	{
		alert("请填写最后一行的单位");
		flag = false;
		return false;
	}
	for(var i = 0;i < unames.length;i++)
	{
		for(var j = i+1;j < unames.length;j++)
		{
			if(unames[i].value.trim() == unames[j].value.trim() && units[i].value.trim() == units[j].value.trim())
			{
				alert("第"+(i+1)+"行的数据和第"+(j+1)+"行数据可以合并，请重新填写");
				flag = false;
				return false;
			}
		}
	}
	if(flag)
	{
		var form = document.getElementsByName("form")[0];
		form.submit();
	}
}