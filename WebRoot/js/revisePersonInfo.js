function immediately() {
	var empid = document.getElementsByName("empid")[0];
	if (empid.value = "") {
		var floatArea = document.getElementById("popup");
		floatArea.innerHTML = "";
	}
	if ("\v" == "v") {
		empid.onpropertychange = webChange;
	} else {
		empid.addEventListener("input", webChange, false);
	}

	function webChange() {
		var floatArea = document.getElementById("popup");
		floatArea.innerHTML = "";
		if (empid.value.trim()) {
			var url = "PersonAdminServlet?method=searchEmpId";
			var sendData = {
				"empidPart" : empid.value
			};
			$.post(url, sendData, function(backData, textStatus, xhr) {
				var empids = backData.split(":");
				var size = empids.length;
				floatArea.style.display = "none";
				for (var i = 0; i < size; i++) {
					floatArea.innerHTML = floatArea.innerHTML + "<br/>"
							+ empids[i];
					floatArea.style.display = "inline";
				}
			});
		}
	}
}

function clearPopup() {
	var popup = document.getElementById("popup");
	popup.innerHTML = "";
}

function searchEmployee() {
	var empid = document.getElementsByName("empid")[0].value.trim();
	if (empid == "") {
		return false;
	}
	var url = "PersonAdminServlet?method=searchEmployee";
	var sendData = {
		"empid" : empid
	};
	$.post(url, sendData, function(backData, textStatus, xhr) {
		//alert(backData);
		if (backData == "success") {
			/*
			var emp = backData.split(":");
			
			for (var i = 0; i < emp.length; i++) {
				var input = document.createElement("input");
				input.name = "emp" + i;
				input.value = emp[i];
				input.style.display = "none";
				form.appendChild(input);
			}
			*/
			 
			var form = document.getElementsByName("form")[0];
			//alert(form);
			form.submit();
			//location.href="personInforevise_update.jsp?emp="+emp[0]+"&&username="+emp[1];
		} else if(backData == "error"){
			var popup = document.getElementById("popup");
			popup.innerHTML = "<font color='red'>没有该员工</font>";
		}

	});
	return false;
}
