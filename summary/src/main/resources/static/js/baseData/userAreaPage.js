layui.use(['form','table','layer','jquery','laydate'], function(){
  var table = layui.table;
  var layer = layui.layer;
  $ = layui.jquery;
  var form = layui.form;
  var laydate = layui.laydate;
  
//日期范围
  laydate.render({
    elem: '#createTime'
    ,range: true
  });
  
  var tableName=$('#tableName').val();
    	 //执行一个 table 实例
    	table.render({
    	    elem: "#"+tableName
    	    ,url: 'getAllTableList?tableName='+tableName //数据接口
    	    ,title: '用户地区表'
    	    ,page: true //开启分页
    	    ,toolbar: '#toolBar'
    	    ,height: 600
    	    ,cols: [[ //表头、
    		   {type: 'numbers',title: '序号', fixed: 'left',width:80,sort: true}
    	      ,{field: 'user_id', title: '用户ID', width:150,align:'center'}
    	      ,{field: 'username', title: '姓名', width:150,align:'center'}
    	      ,{field: 'province', title: '省', width:150,align:'center'}
    	      ,{field: 'city', title: '市', width:150,align:'center'}
    	      ,{field: 'country', title: '区', width:150,align:'center'}
    	      ,{field: 'createTime', title: '注册日期', width:150,align:'center'}
    	    ]]
    	    
    	  });
    
    form.on('submit(LAY-user-front-search)', function(data){
        var field = data.field;
        //执行重载
        table.reload(tableName, {
          where: field,
          page:1
        });
      });
    
});