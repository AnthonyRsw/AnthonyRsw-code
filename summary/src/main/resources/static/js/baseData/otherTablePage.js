layui.use(['form','table','layer','jquery','laydate'], function(){
  var table = layui.table;
  var layer = layui.layer;
  $ = layui.jquery;
  var form = layui.form;
  var laydate = layui.laydate;
  
  var name=$('#name').val(); 
  var tableName=$('#tableName').val();
    	 //执行一个 table 实例
    	table.render({
    	    elem: "#"+tableName
    	    ,url: 'getAllTableList?tableName='+tableName //数据接口
    	    ,title: '其他基本数据维护表'
    	    ,page: true //开启分页
    	    ,toolbar: '#toolBar'
    	    ,height: 500
    	    ,defaultToolbar:['filter']
    	    ,cols: [[ //表头
    	      {type: 'numbers',title: '序号', fixed: 'left',width:80,sort: true}
    	      ,{field: 'code', title: '编码', width:100,align:'center'}
    	      ,{field: 'name', title: '名称', width:200}
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