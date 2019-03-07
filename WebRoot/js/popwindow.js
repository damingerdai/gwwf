// JavaScript Document
function popWin(theURL,winName,theW,theH,showAsModal) {
    theTop = (window.screen.height-theH)/2;
    theLeft = (window.screen.width-theW)/2;
    var features = "toolbar=0,scrollbars=yes,left=" + theLeft + ",top=" + theTop + ",width=" + theW + ",height=" + theH;
    
    window.SubWin = window.open(theURL,winName,features);
    window.SubWin.focus();
    
    if(showAsModal){
        window.CtrlsDisabled = new Array();
        DisableCtrls("INPUT;SELECT;TEXTAREA;BUTTON");
    }

function DisableCtrls(tagNameStr){
        var arrTags = tagNameStr.split(";");
        for(var i=0;i<arrTags.length;i++){
            var arrEle = document.getElementsByTagName(arrTags[i]);
            PushToCtrlsDisabled(arrEle);
        }

        for(var i=0;i<window.CtrlsDisabled.length;i++){
            window.CtrlsDisabled[i].disabled = true;
            window.CtrlsDisabled[i].readOnly = true;
        }
    }
function PushToCtrlsDisabled(arrEle){
        for(var i=0;i<arrEle.length;i++){
            if(!arrEle[i].disabled){
                window.CtrlsDisabled.push(arrEle[i]);
            }
        }
    }
    
    window.onfocus = function(){
        if(window.SubWin && showAsModal){
            if(window.SubWin.closed == true || typeof(window.SubWin.closed) == "undefined"){
                for(var i=0;i<window.CtrlsDisabled.length;i++){
                    window.CtrlsDisabled[i].disabled = false;
                    window.CtrlsDisabled[i].readOnly = false;
                }
            }else{
                window.SubWin.focus();
            }
        }
    }
}

function CloseWin()
{
var ua=navigator.userAgent
var ie=navigator.appName=="Microsoft Internet Explorer"?true:false
if(ie){
    var IEversion=parseFloat(ua.substring(ua.indexOf("MSIE ")+5,ua.indexOf(";",ua.indexOf("MSIE "))))
if(IEversion< 5.5){
    var str = '<object id=noTipClose classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
    str += '<param name="Command" value="Close"></object>';
    document.body.insertAdjacentHTML("beforeEnd", str);
    document.all.noTipClose.Click();
    }
    else{
    window.opener =null;
    window.close();
    }
}
else{
window.close()
}
}
