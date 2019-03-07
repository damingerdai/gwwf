
/*************************************
 ***  閸︺劎缍夋い闈涘鏉炶棄鐣幋鎰倵閸旂姾娴囧鏃傘仛閺佺増宓� *************************************/
 $(document).ready(function() {
	// 閸旂姾娴囧鏃傘仛閺佺増宓�	loadDemoData();
});

/************************************************************
 *** 閻╃鍙ч弬瑙勭《
 ************************************************************/

/**
 * 閸旂姾娴囧鏃傘仛閺佺増宓侀敍宀勭帛鐠併倖妲搁弨鎯у煂 "[class=dataContainer]" 閸忓啰绀屾稉锟�* @param demoDataContainerExpression 鐎涙ɑ鏂佸鏃傘仛閺佺増宓侀惃鍕帗缁辩媴绱欑�鐟版珤閿涳拷 *                                   姒涙顓绘稉锟絒class=dataContainer]
 * @param templateClass 閺勫墽銇氭稉锟芥蒋閺佺増宓侀惃鍕侀弶澶稿敩閻拷 *									 姒涙顓绘稉绨峞mplate
 */
function loadDemoData(demoDataContainerExpression, templateClass) {
    //鐎涙ɑ鏂佸鏃傘仛閺佺増宓侀惃鍕帗缁辩媴绱欑�鐟版珤閿涳拷	
	if(demoDataContainerExpression == null){
		demoDataContainerExpression = ".dataContainer";
	}
	
	if(templateClass == null){
		templateClass = "template";		
	}
		
	// 濞屸剝婀佺�妯绘杹濠曟梻銇氶弫鐗堝祦閻ㄥ嫬顔愰崳銊︽閿涘苯姘ㄦ稉宥夋付鐟曚礁鎮楅棃銏㈡畱閺勫墽銇氬鏃傘仛閺佺増宓佹禍锟�var jDemoDataContainerArrays = $(demoDataContainerExpression);
    if (jDemoDataContainerArrays.size() == 0) {
         return ;
    }
	
	// 閺勫墽銇氬鏃傘仛閺佺増宓侀敍鍫濆讲閼宠姤婀佹径姘槱鐟曚焦妯夌粈鐚寸礆
	jDemoDataContainerArrays.each(function(){
		var jDemoDataContainer = $(this);
		
		// 婵″倹鐏夊▽鈩冩箒閹稿洤鐣剧憰浣规▔缁�櫣娈戦弫鐗堝祦妞ょ櫢绱濋崚娆愬絹缁�拷		var dataKey = jDemoDataContainer.attr("dataKey");
		if(dataKey == null || $.trim(dataKey).length == 0){
			alert("鐠囬攱瀵氱�姘愁洣閺勫墽銇氶惃鍕殶閹诡噣銆嶉敍鍫熷瘹鐎癸拷dataKey 鐏炵偞锟芥稉锟紻emoData.js 娑擃厾娈戞稉锟姐�閺佺増宓侀惃鍕倳缁夊府绱氶敍锟�");
			return;
		}
	
		// 
		var items = demoData[dataKey];
		if(items == null){
			alert("鐠囬攱瀵氱�姘劀绾喚娈戦弫鐗堝祦妞ょ櫢绱欓幐鍥х暰 dataKey 鐏炵偞锟芥稉锟紻emoData.js 娑擃厾娈戞稉锟姐�閺佺増宓侀惃鍕倳缁夊府绱氶敍锟�");
			return;
		}
		
		// 鏉╂稖顢戦弴鎸庡床
		$.each(items, function(index) {
			// 鏉╂柨娲�'false' 鐏忓棗浠犲銏犳儕閻滐拷(鐏忓崬鍎氶崷銊︽珮闁氨娈戝顏嗗箚娑擃厺濞囬悽锟�break')閵嗭拷			// 鏉╂柨娲�'true' 鐠哄疇鍤︽稉瀣╃娑擃亜鎯婇悳锟界亸鍗炲剼閸︺劍娅橀柅姘辨畱瀵邦亞骞嗘稉顓濆▏閻拷continue')
			return addDemoRecord(jDemoDataContainer, items[index], templateClass);
		});
	
		 // 閺勫墽銇氱�灞剧川缁�儤鏆熼幑顔兼倵缁夊娅庤ぐ鎾冲閹碉拷鏁ら惃鍕侀弶鑳攽
		jDemoDataContainer.find("." + templateClass).remove(); 
		
	});
}
/**
 * 濞ｈ濮炴稉锟芥蒋濠曟梻銇氶弫鐗堝祦閿涘本绱ㄧ粈铏规畱閺佺増宓佺悰宀�畱class娑撹　锟絛emodata_record閳ワ拷 * @param jDemoDataContainer
 * @param record
 * @param templateClass
 */
function addDemoRecord(jDemoDataContainer, record, templateClass) {
	// 閹垫儳鍤Ο鈩冩緲鐞涳拷	var jTemplateRecord = jDemoDataContainer.find("." + templateClass);
    if (jTemplateRecord.size() == 0) {
        alert("濞屸剝婀佸Ο鈩冩緲鐞涘矉绱濆Ο鈩冩緲閻ㄥ垻lass娑撶尨绱� + templateClass");
        return false;
    }

    // clone閸氬海娈戦崗鍐鐟曚购emoveClass閿涘苯娲滄稉鐑樐侀弶鑳攽閿涘潏lass=${tempateClass}閿涘妲告稉宥嗘▔缁�櫣娈�    var jNewRecord = jTemplateRecord.clone(true);
    jNewRecord.removeClass(templateClass);
    jNewRecord.addClass("demodata_record");
    var newRecord = jNewRecord[0].outerHTML;
                                  
    for (var key in record) {
        //TODO 鐟曚椒濞囬悽锟�\\$' 鐞涖劎銇氱�妤冾儊 '$'閿涘奔璐熸禒锟界疄娑撳秵妲�'\$'閿涳拷        var regex = new RegExp("\\$\{" + key + "\}","g");
        newRecord = newRecord.replace(regex,record[key]);
    }

    jDemoDataContainer.append(newRecord);
    return true;
}

/*********************************************************************************
 *** outterHTML 閸︹�ireFox闁插苯姘ㄦ稉宥堫攽娴滃棴绱濋崶鐘辫礋outerHTML娑撳秵妲竁3C閻ㄥ嫭鐖ｉ崙鍡楃潣閹拷 *** 缂冩垳绗傞幍鍙ョ啊娑撳濞囬悽鈥昈M閸樼喎鐎烽幍鈺佺潔閺傝纭剁憴锝呭枀閿涘奔鍞惍浣割洤娑撳绱� *********************************************************************************/
if (typeof(HTMLElement) != "undefined" && !window.opera)
{
    HTMLElement.prototype.__defineGetter__("outerHTML",function()
    {
        var a = this.attributes, str = "<" + this.tagName, i = 0;
        for (; i < a.length; i++)
            if (a[i].specified)
                str += " " + a[i].name + '="' + a[i].value + '"';
        if (!this.canHaveChildren)
            return str + " />";
        return str + ">" + this.innerHTML + "</" + this.tagName + ">";
    });
    HTMLElement.prototype.__defineSetter__("outerHTML",function(s)
    {
        var r = this.ownerDocument.createRange();
        r.setStartBefore(this);
        var df = r.createContextualFragment(s);
        this.parentNode.replaceChild(df,this);
        return s;
    });
    HTMLElement.prototype.__defineGetter__("canHaveChildren",function()
    {
        return !/^(area|base|basefont|col|frame|hr|img|br|input|isindex|link|meta|param)$/.test(this.tagName.toLowerCase());
    });
}
