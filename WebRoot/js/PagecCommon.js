$(function() {
//获取class为Text_Num的元素
$(".Text_Num").click(function() {
var td = $(this);
var txt = td.text();
var input = $("<input type='text' value='" + txt + "' class='textNum'/>");
td.html(input);
input.click(function() { return false; });
//获取焦点
input.trigger("focus");
//文本框失去焦点后提交内容，重新变为文本
input.blur(function() {
var newtxt = $(this).val();
//判断文本有没有修改
if (newtxt != txt) {
	var reg=/[\D\s]/;
    var str=newtxt;
   if(reg.exec(str)){
	   alert('请输入数字');
	   td.html(txt);
	   }
	else{
		
		 td.html(newtxt);
   }

}
else
{
td.html(newtxt);
}
});
});
}); 

$(function() {
//获取class为Text_Num的元素
$(".Text_Num2").click(function() {
var td = $(this);
var txt = td.text();
var input = $("<input type='text' value='" + txt + "' class='textNum'/>");
td.html(input);
input.click(function() { return false;});
//获取焦点
input.trigger("focus");

//文本框失去焦点后提交内容，重新变为文本
input.blur(function() {
var newtxt = $(this).val();
//判断文本有没有修改
if (newtxt != txt) {
	var reg=/[\D\s]/;
    var str=newtxt;
   if(reg.exec(str)){
	   alert('请输入数字');
	   td.html(txt);
	   }
	else{
		if (parseInt(newtxt) > parseInt(txt)) {alert('库存不足，请重新输入！');td.html(txt);}
		 else{td.html(newtxt);}
   }

}
else
{
td.html(newtxt);
}
});
});
}); 


function NnmShow(){ 
		    var danger = 0;
		    var table = document.getElementById("stockdatetable")
			//var table = document.getElementById("t1").rows[0].cells[0]; 
			var rowObj = null; 
			var cellObj = null;     
			 
			// 引用rows 
			for (var i = 0; i < table.rows.length; i ++){ 
				rowObj = table.rows[i]; 
				var s = rowObj.cells[1].innerHTML;			
				if(s==danger){
					//rowObj.cells[1].style.color='red';
					rowObj.cells[0].style.color="red";
					rowObj.cells[1].style.color="red";
					rowObj.cells[2].style.color="red";
				}

            } 
} 

function AttendanceShow(){ 
		    var table = document.getElementById("AttendanceList")
			//var table = document.getElementById("t1").rows[0].cells[0]; 
			var rowObj = null; 
			var cellObj = null;     
			 
			// 引用rows 
			for (var i = 0; i < table.rows.length; i ++){ 
				rowObj = table.rows[i]; 
				var s = rowObj.cells[3].innerHTML;			
				if(s=='早退'||s=='迟到'){
					//rowObj.cells[1].style.color='red';
					rowObj.cells[0].style.color="red";
					rowObj.cells[1].style.color="red";
					rowObj.cells[2].style.color="red";
					rowObj.cells[3].style.color="red";
				}

            } 
} 