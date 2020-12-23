window.addEventListener("load",function(){

    var section = document.querySelector(".content-box");
    var recommend = section.querySelector(".recommend-test>ul");
    var recommentList = recommend.querySelectorAll("li");
    var current = recommentList[4];
    var index = 4; 
    
    function move() {
        index += 0.001;
        if(index < 3){
            index +=10;
        }else if(index >13){
            index = 3;
        }
        var right = (index * 200) - 1500 +"px";
        recommend.style.right = right;
    }

    setInterval(move, 1);
    
    
});