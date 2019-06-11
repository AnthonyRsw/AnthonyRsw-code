var str;
	function createNewCode() {
		var arr = ['0','1','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
		str = "";
		var strlength = 4;
		for(var i = 0; i < strlength; i++)
		{
			var num = Math.floor(Math.random()*arr.length);
			str+= arr[num];
		};
		var btn = document.getElementById("rightcode");
		btn.value = str;
	}
	window.onload = createNewCode;
	
$(document).ready( function(){
	if (window != top){
        top.location.href = location.href;
    }
    $("#loginBtn").click( function(){
    	loginAction();
    });
    
    $('#password').on('keypress',function(event){ 
        if(event.keyCode == 13)      
        {  
        	loginAction();
        }  
    });
    
    function loginAction(){
    	var codetext = document.getElementById('J_codetext');
		
    	if($("#username").val().replace(/(^\s*)|(\s*$)/g, '') == ''){
    		layui.use('layer', function(){
  			  layer.open({
  				  title: '提示'
  				  ,content: '用户名不能为空'
  				}); 
  			});
    		return;
    	}else if($("#password").val().replace(/(^\s*)|(\s*$)/g, '') == ''){
    		layui.use('layer', function(){
   			   layer.open({
   				  title: '提示'
   				  ,content: '密码不能为空'
   				}); 
   			});
    		return;
    	}else if(codetext.value.toLowerCase() != str.toLowerCase()){
			layui.use('layer', function(){
	  			  layer.open({
	  				  title: '提示'
	  				  ,content: '验证码不正确'
	  				}); 
	  			});
			createNewCode();
			return;
    	}else{
		$("#loginBtn").val("登录中...");
	    	$.ajax({  
		        type : "POST",  //提交方式  
		        url : "login",//路径  
		        data : {"username" : $("#username").val(), "password": $("#password").val()},
		        success : function(result) {
				
		        	if(result.result == '1'){
		        		$("#loginBtn").val("登录");
		        		layui.use('layer', function(){
		        			  layer.open({
		        				  title: '提示'
		        				  ,content: '密码不正确'
		        				}); 
		        			});
		        	}else if(result.result == '2'){
		        		$("#loginBtn").val("登录");
		        		layui.use('layer', function(){
		        			  layer.open({
		        				  title: '提示'
		        				  ,content: '用户不存在'
		        				}); 
		        			});
		        	}else if(result.result == '3'){
		        		$("#loginBtn").val("登录");
		        		layui.use('layer', function(){
		        			  layer.open({
		        				  title: '提示'
		        				  ,content: '用户已注销'
		        				}); 
		        			});
		        	}else if(result.result == 'success'){
		        		window.location.href="index";
		        		$("#loginBtn").val("登录");
		        	}
		        	
		        },
		        error : function(result) {
		        	$("#loginBtn").val("登录");
		        } 
	    	});
    	}
    }
});