 
function addOfficeStationery() {
	 
	var $table = $("#TableData");
	var flag = true;
	var $trs = $table.children().last().children();
	for(var i = 0;i < 3; i++)
	{
		if($trs.children().eq(i).val().trim() == "")
		{
			alert("�뽫���һ�е�����������");
			return false;
		}
	}
	
	var $tr = $("<tr class='TableDetail1 template'>"
			+"<td><input name='uname' type='text' class='button22' maxlength='10'/></td>"
			+"<td><input name='number' type='text' class='button32' maxlength='10' onblur='blurHandle(this)'/></td>"
			+"<td><input name='unit' type='text' class='button31' maxlength='10' </td>"
			+"<td>"	
			+"<a onclick='Cancel(this)'>ȡ��</a>"
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
	 	 	alert("��������Ϊ����");
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
		alert("����д���һ�е���Ʒ����");
		flag = false;
		return false;
	}
	if(numbers[numbers.length-1].value.trim() == "")
	{
		alert("����д���һ�е�����");
		flag = false;
		return false;
	}
	if(units[units.length-1].value.trim(6) == "")
	{
		alert("����д���һ�еĵ�λ");
		flag = false;
		return false;
	}
	for(var i = 0;i < unames.length;i++)
	{
		for(var j = i+1;j < unames.length;j++)
		{
			if(unames[i].value.trim() == unames[j].value.trim() && units[i].value.trim() == units[j].value.trim())
			{
				alert("��"+(i+1)+"�е����ݺ͵�"+(j+1)+"�����ݿ��Ժϲ�����������д");
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