/**
 * 公共js
 * @param {Object} w
 * @version:1.0.0
 * @author:lixiangxiang
 */
(function(w){
	/**
	 * post 统一提交表单
	 * @param {Object} myurl
	 * @param {Object} data
	 * @param {Object} callbackS
	 */
	w.post=function(myurl,data,callbackS){
		var loadIndex=layer.load();
		$.ajax({
		  url: myurl,
		  data: data,
		  type: "post",
		  dataType: "json",
		  success: function(result){
		  	callbackS(result);
			layer.close(loadIndex);
		  },
		  error: function (XMLHttpRequest, textStatus, errorThrown) {
			  layer.alert('系统异常，刷新重试', {
				  icon: 5,
				  skin: 'layer-ext-moon'
				});
		  }
		});	
	};
	
	/**
	 * 重写系统alert事件
	 * @param {Object} data
	 */
	w.alert = function(data){
		layer.alert(data,{
			icon:5,
			skin:'layer-ext-moon'
		});
	};
	
	/**
	 * 重写系统confirm
	 * @param {Object} msg
	 * @param {Object} callbackS
	 */
	w.confirm = function(msg, callbackS){
		layer.confirm(msg,{btn:['确定','取消']},function(){
			callbackS();
		},
		function(){
			
		});
	};
	
	/**
	 * 系统提示事件
	 * @param {Object} data
	 */
	w.msg = function(data){
		layer.msg(data);
	};
	
	/**
	 * 统一表单渲染事件
	 * @param {Object} form
	 * @param {Object} time
	 */
	w.render = function(form, time){
		setTimeout(function(){
			form.render();
		},time);
	};
	
	w.jsonObjToString = function(myJson){
		var conditionValue = '';
		for(var key in myJson){
			if(myJson[key] != '' && (myJson[key] != null)){
				conditionValue = conditionValue + key + "=" + myJson[key] + "&";
			}
		}
		return conditionValue;
	};
	
	w.printHTML = function(){
		// 获取当前页的html代码
	    var bdhtml = window.document.body.innerHTML;
	    var printHtml = document.getElementById('print_html').innerHTML;
	    // 需要打印的页面
	    window.document.body.innerHTML = printHtml;
	    if (!!window.ActiveXObject || "ActiveXObject" in window) {
	        remove_ie_header_and_footer();
	     }
	    window.print();
	    // 还原界面
	    window.document.body.innerHTML = bdhtml;
	    window.location.reload();
	};
	
})(window);