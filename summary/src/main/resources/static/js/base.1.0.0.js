$(".main").css({marginLeft:treeWith});
$(".eleTree").css({height:(treeHeight-50)});
$(".eleTree").css({width:(treeWith-6)});
$(".sidebar").height(treeHeight);
var isShow = true;
$(".closeMenu span").click(function(){
    $(this).hide().siblings().show();
    if(isShow){
        $("#list_left").animate({
            width : 0
        },200,"linear",function(){
            isShow = false;
            $(".closeMenu > span").css({
                opacity:1
            });
             $(".title").css({display:"none"});
        });
        $(".main").animate({margin:"0 auto",marginLeft:0},"linear");
        $(".sideTree").hide();
    }else{
        $("#list_left").animate({
            width : treeWith
        },200,"linear",function(){
            isShow = true;
        });
        $(".main").animate({marginLeft:treeWith},"linear");
        $(".title").css({display:"block"});
        $(".sideTree").show();
    }
});

//$(window).resize(function(){
//    $("#list_left").height($(window).height());
//});