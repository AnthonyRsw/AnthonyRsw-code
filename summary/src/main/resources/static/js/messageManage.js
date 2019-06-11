layui.config({
     base: "layuiadmin/layui/lay/modules/"
  }).use('table', function(){
  var table = layui.table;
  var form = layui.form;
  var ipPort = $("#ipPort").val();
  table.render({
    elem: '#approveTable'
    ,url: 'getAllUnReadMessage'
    ,where: {
    	"messageType": 0
    }
    ,cols:[[{type:"checkbox",fixed:"left"},
            {field:"msgContent", title:"标题内容", minWidth:300, templet: function(rowData){
            	if($("#messageType").val() == 0){
            		return '<a lay-href="' + ipPort + rowData.menuUrl + '">' + rowData.msgContent + '</a>';
            	}else{
            		return '<a lay-href="toNoticeDetail?noticeId=' + rowData.noticeId + '&messageId=' + rowData.id + '" >' + rowData.msgContent + '</a>';
            	}
        	}
            },
            {field:"createTime", title:"时间", width:170, templet: function(rowData){
            	return rowData.createTime;
            	}
            }
          ]]
    ,skin:"line"
  });
  
  reloadCnt();
  
  $("#approveLi").click(function(){
	  $("#approveLi").addClass("layui-this");
	  $("#noticeLi").removeClass("layui-this");
	  $("#messageType").val(0);
	  reloadTable(0);
  });
  
  $("#noticeLi").click(function(){
	  $("#noticeLi").addClass("layui-this");
	  $("#approveLi").removeClass("layui-this");
	  $("#messageType").val(1);
	  reloadTable(1);
  });
  
  $("#delBtn").click(function(){
	  var selectedIds = [];
	  var selectedRows = table.checkStatus('approveTable').data;
	  if(selectedRows.length == 0){
		  layer.alert('请选择数据', {
	  		  icon: 5,
	  		  skin: 'layer-ext-moon'
	  		});
	  }else{
		  layer.confirm('真的删除么？', {
			  btn: ['确认','取消'] //按钮
		  }, function(){
			  $.each(selectedRows, function(index, obj){
    			  selectedIds.push(obj.id);
    		  });
			  post("deleteMessage" , {"messageIds": selectedIds.join(",")}, function(result){
				  if(result.code == '0'){
					  layer.msg(result.msg);
					  reloadTable($("#messageType").val());
					  reloadCnt();
				  }else{
					  layer.msg(result.msg);
				  }
			  });
		  }, function(){
			  
		  });
	  }
  });
  
  $("#readyBtn").click(function(){
	  var selectedIds = [];
	  var selectedRows = table.checkStatus('approveTable').data;
	  if(selectedRows.length == 0){
		  layer.alert('请选择数据', {
	  		  icon: 5,
	  		  skin: 'layer-ext-moon'
	  		});
	  }else{
		  $.each(selectedRows, function(index, obj){
			  selectedIds.push(obj.id);
		  });
		  post("updateMessage" , {"messageIds": selectedIds.join(",")}, function(result){
			  if(result.code == '0'){
				  layer.msg(result.msg);
				  reloadTable($("#messageType").val());
				  reloadCnt();
			  }else{
				  layer.msg(result.msg);
			  }
		  });
	  }
  });
  
  $("#readyAllBtn").click(function(){
	  post("updateAllMessage" , {"messageType": $("#messageType").val()}, function(result){
		  if(result.code == '0'){
			  layer.msg(result.msg);
			  reloadTable($("#messageType").val());
			  reloadCnt();
		  }else{
			  layer.msg(result.msg);
		  }
	  });
  });
  
  function reloadTable(messageType){
	  table.reload('approveTable', {
	        where: {
	        	"messageType": messageType
	        },
	        page: 1
	      });
  }
  
  function reloadCnt(){
	  post("getMessageCount" , {}, function(result){
		  if(result.code == '0'){
			  $("#unApproveCnt").empty();
			  $("#unNoticeCnt").empty();
			  $("#unApproveCnt").append(result.approveTotalCount);
			  $("#unNoticeCnt").append(result.noticeTotalCount);
		  }else{
			  layer.msg(result.msg);
		  }
	  });
  }

});