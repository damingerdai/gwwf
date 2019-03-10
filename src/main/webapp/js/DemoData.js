// JavaScript Document
var demoData = {
	BuyOfficeStationeryInfo: [
		{ "OfficeStationery.name": "閹垫挸宓冪痪锟� ","OfficeStationery.number": "100","OfficeStationery.unit":"瀵拷"},
		{ "OfficeStationery.name": "閺囨彃娲栭柦锟�","OfficeStationery.number": "50","OfficeStationery.unit":"閺嶏拷"},
		{ "OfficeStationery.name": "濮樺鐟�", "OfficeStationery.number": "10","OfficeStationery.unit":"閻╋拷"},
		{ "OfficeStationery.name": "濮楋紕姣�", "OfficeStationery.number": "0","OfficeStationery.unit":"閸э拷"}
	],
	GetOfficeStationeryInfo: [
		{ "GetOfficeStationery.name": "閹垫挸宓冪痪锟�", "GetOfficeStationery.number": "100","GetOfficeStationery.unit":"瀵拷"},
		{ "GetOfficeStationery.name": "閺囨彃娲栭柦锟�", "GetOfficeStationery.number": "50","GetOfficeStationery.unit":"閺嶏拷"},
		{ "GetOfficeStationery.name": "鐠侇澀鍔熼張锟�", "GetOfficeStationery.number": "10","GetOfficeStationery.unit":"娑擄拷"}
	],
	ParkingInfo_List: [
		{ "ParkingInfo_List.Num": "CW001", "ParkingInfo_List.platenum": "娴滅徑K-9999","ParkingInfo_List.Explain":"閹崵绮￠悶鍡曠瑩閻€劏婧呮担锟�"},
		{ "ParkingInfo_List.Num": "CW002", "ParkingInfo_List.platenum": "娴滅徑K-8888","ParkingInfo_List.Explain":"缁夋ü鍔熸稉鎾舵暏鏉烇缚缍�"},
		{ "ParkingInfo_List.Num": "CW003", "ParkingInfo_List.platenum": "娴滅徑K-7777","ParkingInfo_List.Explain":"濞翠礁濮╂潪锔跨秴"}
	],
	ParkingInfo_List2: [
		{ "ParkingInfo_List.Num": "CW001", "ParkingInfo_List.platenum": "娴滅徑K-9999","ParkingInfo_List.Explain":"閹崵绮￠悶鍡曠瑩閻€劏婧呮担锟�"}
	],
	CarInfo_List: [
		{ "CarInfo_List.CarNum": "娴滅徑K-9999", "CarInfo_List.carmodelmode": "benz","CarInfo_List.driver":"閺夊孩鏌�","CarInfo_List.buytime":"2009-03-18","CarInfo_List.carry":"5娴滐拷","CarInfo_List.usepower":"娑撴挾鏁�"},
		{ "CarInfo_List.CarNum": "娴滅徑K-9988", "CarInfo_List.carmodelmode": "benc","CarInfo_List.driver":"閻滃绨�","CarInfo_List.buytime":"2005-01-23","CarInfo_List.carry":"8娴滐拷","CarInfo_List.usepower":"閸忣剛鏁�"},
		{ "CarInfo_List.CarNum": "娴滅徑K-7788", "CarInfo_List.carmodelmode": "benc","CarInfo_List.driver":"鐠ч潧鍙�","CarInfo_List.buytime":"2012-05-17","CarInfo_List.carry":"3閸氾拷","CarInfo_List.usepower":"娑撴挾鏁�"},
	],
	CarInfo_Update: [
		{ "CarInfo_Update.CarNum": "娴滅徑K-9999", "CarInfo_Update.carmodelmode": "benz","CarInfo_Update.driver":"閺夊孩鏌�","CarInfo_Update.buytime":"2009-03-18","CarInfo_Update.carry":"5","CarInfo_Update.usepower":"娑撴挾鏁�"}
	],
	CarUse_List:[
		{"CarUse.usetime":"2009-03-01","CarUse.outtime":"9:30","CarUse.gobacktime":"13:45","CarUse.useperson":"閺夊骸娲�","CarUse.purpose":"閸欐垼鎻�"},
		{"CarUse.usetime":"2009-03-02","CarUse.outtime":"9:30","CarUse.gobacktime":"16:05","CarUse.useperson":"閺夊骸娲�","CarUse.purpose":"閸欐垼鎻�"},
		{"CarUse.usetime":"2009-03-04","CarUse.outtime":"9:30","CarUse.gobacktime":"14:45","CarUse.useperson":"閺夊骸娲�","CarUse.purpose":"閸欐垼鎻�"},
		{"CarUse.usetime":"2009-03-06","CarUse.outtime":"9:30","CarUse.gobacktime":"12:50","CarUse.useperson":"閺夊骸娲�","CarUse.purpose":"閸欐垼鎻�"},
		{"CarUse.usetime":"2009-03-12","CarUse.outtime":"9:30","CarUse.gobacktime":"18:05","CarUse.useperson":"閻滃绨�","CarUse.purpose":"閹锋粏顔栫�銏″煕"}
	],
	personInfo_Updata:[
	    {"personInfo.personNum":"AD20060004","personInfo.personname":"閺屾劖鐓囬弻锟�","personInfo.sex":"閻拷","personInfo.birthtime":"1967.06.25","personInfo.department":"鐞涘本鏂傞柈銊╂，","personInfo.Graduateschool":"閺屾劖鐓囬弻鎰厙閺屾劕銇囩�锟�","personInfo.subject":"娣団剝浼呯粻锛勬倞娑撳簼淇婇幁顖滈兇缂佺喍绗撴稉锟�","personInfo.education":"閺堫剛顫�","personInfo.password":"123456"}
	],
	StaffAttendance_List:[
	    {"StaffAttendance.month":"2006楠烇拷閺堬拷","StaffAttendance.date":"2006-09-01","StaffAttendance.workbegintime":"9:00","StaffAttendance.workendtime":"18:00","StaffAttendance.explain":"濮濓絽鐖�"},
		{"StaffAttendance.month":"2006楠烇拷閺堬拷","StaffAttendance.date":"2006-09-02","StaffAttendance.workbegintime":"9:30","StaffAttendance.workendtime":"17:30","StaffAttendance.explain":"鏉╃喎鍩�"},	
		{"StaffAttendance.month":"2006楠烇拷閺堬拷","StaffAttendance.date":"2006-09-03","StaffAttendance.workbegintime":"9:00","StaffAttendance.workendtime":"19:00","StaffAttendance.explain":"濮濓絽鐖�"},	
		{"StaffAttendance.month":"2006楠烇拷閺堬拷","StaffAttendance.date":"2006-09-04","StaffAttendance.workbegintime":"9:00","StaffAttendance.workendtime":"17:00","StaffAttendance.explain":"閺冣晠锟�"},	
		{"StaffAttendance.month":"2006楠烇拷閺堬拷","StaffAttendance.date":"2006-09-05","StaffAttendance.workbegintime":"9:00","StaffAttendance.workendtime":"18:00","StaffAttendance.explain":"濮濓絽鐖�"}
	],
	Department_List:[
		{"Department.number":"HR","Department.name":"娴滆桨绨ㄩ柈銊╂，"},	
		{"Department.number":"AD","Department.name":"鐞涘本鏂傞柈銊╂，"},	
		{"Department.number":"LG","Department.name":"閸氬骸瀚熼柈銊╂，"}
	],
	Department_Updata:[
		{"Department.number":"AD","Department.name":"鐞涘本鏂傞柈銊╂，"}
	],
	Addresslist_List:[
	    {"Addresslist.workeNum":"AD20060001","Addresslist.workername":"娑撳洦鏌�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060002","Addresslist.workername":"娑撳洦鏌夌粋蹇撴勾","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060003","Addresslist.workername":"濮濓缚绗㈢捄锟�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060004","Addresslist.workername":"瀵姾鍎�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060005","Addresslist.workername":"娑撴粍鏌熼崷锟�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060006","Addresslist.workername":"鐠愭繆鎯冪亸锟�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060007","Addresslist.workername":"鐟楄儻鎸�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"},
		{"Addresslist.workeNum":"AD20060008","Addresslist.workername":"閹晛鐥�","Addresslist.cell-phoneNum":"1235645678","Addresslist.E-mail":"dfffvd@163.com","Addresslist.HomeTelNum":"15656561","Addresslist.CompanyTelNum":"155566645","Addresslist.address":"閺屾劗娓烽弻鎰閺屾劕骞欓弻鎰敎閺屾劖鐓囩捄顖涚厙閺屾劕褰�","Addresslist.ZipCode":"541655"}
		],
    xxList: []
};

// list閻ㄥ嫭娓堕崥搴濈娑擃亜鍘撶槐鐘叉倵娑撳秷顩﹂張澶愶拷閸欏嚖绱濋崥锕�灟閸︺劑銆夐棃顫厬閺勫墽銇氶弫鐗堝祦閺冭绱濇导姘樋閸戣桨绔寸悰灞灸侀弶鑳攽閵嗗倹妲搁崶鐘辫礋濞屸剝婀侀弫鐗堝祦閸愬懎顔愰柅鐘冲灇閻ㄥ嫨锟�
// 閿涘牊妲告担璺ㄦ暏閺囨寧宕查惃鍕煙瀵繐鐣幋鎰畱閺勫墽銇氶弫鐗堝祦閿涘苯顩ч弸婊勭梾閺堝娴涢幑銏狅拷閿涘苯姘ㄦ稉宥勭窗閺囨寧宕查敍灞惧娴犮儰绱版径姘娑擃亝膩閺夎儻顢戦敍锟�