layui.use(['form','layer','jquery'], function(){
	var form = layui.form;
	var layer = layui.layer;
	$ = layui.jquery;
	
	form.verify({
		  code: [
		    /^[\S]{1,32}$/
		    ,'编码必须1到32位，且不能出现空格'
		  ] 
      	,name: [
		    /^[\S]{1,64}$/
		    ,'名称必须1到64位，且不能出现空格'
		  ] 
		}); 
	
	 
	form.on('submit(addBasicTable)', function(data){
		var basicTable=data.field;
		post('addBasicTable',basicTable,function(result){
			  if(result.code === 0){
				  msg(result.msg);
				  setTimeout("parent.layer.closeAll()",2000);
				  setTimeout("parent.$('#searchBtn').click()",2000);
				  }else{
	        	  msg(result.msg);
	        	}
		});	
		return false;
	});
});

