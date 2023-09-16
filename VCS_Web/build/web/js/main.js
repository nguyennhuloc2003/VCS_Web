(function($) {

	"use strict";


})(jQuery);

var bodys = document.getElementsByName(body);
for(var body of bodys) {
    body.addEventListener('click', offUpdateTime);
}

var openLoginBox = function() {
    if(document.querySelector('.login-box').style.display==='block'){
        document.querySelector('.login-box').style.display='none';  
        document.querySelector('.user-icon').style.width='80px'; 
        return;
    }
    document.querySelector('.login-box').style.display='block';   
    document.querySelector('.user-icon').style.width='135px'; 
    document.querySelector('.user-icon').style.backgroundColor='#00132b';
};

var openUserInfo = function () {
    if(document.querySelector('.user-info').style.display==='block'){
        document.querySelector('.user-info').style.display='none';  
        document.querySelector('.user-icon').style.width='80px'; 
        return;
    }
    document.querySelector('.user-info').style.display='block';   
    document.querySelector('.user-icon').style.width='17%'; 
    document.querySelector('.user-icon').style.backgroundColor='#00132b';
}

var detailInfo = function(sID){
        window.location.assign(`scheduleInfo?id=${sID}`);
}

var updateTime = (sID) => {
    document.querySelector(`.time-input-${sID}`).style.display='block';   
    document.querySelector(`.time-chedule-${sID}`).style.display='none';  
    document.querySelector('.input-div-dis-none').style.display='block';  
}

var offUpdateTime = () => {
    console.log('offupdate');
    document.querySelector(`.time-input-${sID}`).style.display='none';   
    document.querySelector(`.time-chedule-${sID}`).style.display='block';  
    document.querySelector('.input-div-dis-none').style.display='none';  
}



