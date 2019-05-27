window.onload = function() {

	var ajax = new XMLHttpRequest();

	//2. 连接服务器的servlet  ,参数(method,servlet名称,是否异步提交)
	ajax.open('get', 'LoadQuestionServlet', true);

	//3.发送ajax请求
	ajax.send();

	//4.处理服务器的回应
	ajax.onload = function() {
	
		//alert("adada");
		/*var  s = xhr.responseText;
	
		if(s=='1'){
			document.getElementById("message").innerHTML="用户名重复";
		}else{
			document.getElementById("message").innerHTML="用户名不重复,可以注册";
		}*/
	}
}

function getCategory(cate) {
//alert("in getcategory method");
	$.ajax({
		type: "GET",
		url: "LoadCategoryQuestionServlet?category="+cate+"&start="+0+"&end="+3,
		dataType: "json",
		success: function(result) {
			$(".innerQuestion").remove();
			 var dataObj = result, //返回的result为json格式的数据
	         con = "";
			 $.each(dataObj, function(index, item){
				 var s1 =  item.question_id; 
	             var s2 =  item.title; 
	             var s3 =  item.content; 
	             var s4 =  item.fever;
	             var s5 =  item.answer_num;
	             var s6 =  item.collect_num;
	             var div="<div class='innerQuestion' id='innerQuestion"+s1+"'>"+
					"<div class='layui-row '>"+
					"&nbsp;"+
				"</div>"+
				"<div class='title' id='title"+s1+"'>"+
					"<a href=''>"+s2+"</a>"+
				"</div>"+
				"<div class='layui-row'>"+
					"<div class='layui-col-md8'>"+
						"<div class='brief' id='brief"+s1+"'>"+
							"<a href=''>"+s3+"</a>"+
							"<a href='' style='color: steelblue;'>查看全文</a>"+
							"<a style=''visibility: hidden;' name='questionID'></a>"+
						"</div>"+
					"</div>"+
					"<div class='layui-col-md1'>"+
						"<span>&nbsp;</span>"+
					"</div>"+
					"<div class='layui-col-md3'>"+
						"<div class='picture'>"+
						"	<img src='Resource/webSite/test1.jpg' />"+
						"</div>"+
					"</div>"+
				"</div>"+
				"<div class='status'>"+
					"<div class='answer-button' style='margin-top: 20px;'>"+

						"<div class='upvote  div-inline question-btn-padding-right'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-praise ' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>"+s4+"热度</span>"+
							"</a>"+
						"</div>"+

						"<div class='downvote div-inline question-btn-padding-right'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-tread' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>"+s6+"收藏</span>"+
						"	</a>"+
						"</div>"+

						"<div class='comment div-inline question-btn-padding-right'>"+
							"<a href=''>"+
							"	<i class='layui-icon layui-icon-reply-fill' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>"+s5+"评论</span>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share-type div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-login-wechat' style='font-size: 20px; color: #1E9FFF;'></i>"+
							"	<i class='layui-icon layui-icon-login-qq' style='font-size: 20px; color: #1E9FFF;'></i>"+
							"	<i class='layui-icon layui-icon-login-weibo' style='font-size: 20px; color: #1E9FFF;'></i>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-release' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>分享</span>"+
						"</a>"+
						"</div>"+

					"</div>"+

				"</div>"+
				"<div class='layui-row '>"+
				"	<span>&nbsp;</span>"+
				"</div>"+
				"<div class='layui-row '>"+
				"	<span>&nbsp;</span>"+
				"</div>"+
			"</div>  "; 
	             $('#question').append(div);  
	         });
		},
		error: function() {
			alert(123);
		}
	});

}

$(document).scroll(function() {
	//滚动条滑动的时候获取滚动条距离顶部的距离
	var scroll = $(document).scrollTop();
	//屏幕的高度
	var client = $(window).height();
	var h = $(document).height();
	if(h <= scroll + client) { // 到达底部时,加载新内容
		alert($('.question').children().length);//duide!
    }
});


layui.use('flow', function(){
    var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
    var flow = layui.flow;
    flow.load({
      elem: '.question' //指定列表容器
      ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
        var lis = [];
        //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
        $.get("LoadCategoryQuestionServlet?category="+2+"&start="+$('.question').children().length+"&end="+$('.question').children().length+3, function(res){              
          //假设你的列表返回在data集合中
          layui.each(res.data, function(index, item){

				 var s1 =  item.question_id; 
	             var s2 =  item.title; 
	             var s3 =  item.content; 
	             var s4 =  item.fever;
	             var s5 =  item.answer_num;
	             var s6 =  item.collect_num;
	             var div="<div class='innerQuestion' id='innerQuestion"+s1+"'>"+
					"<div class='layui-row '>"+
					"&nbsp;"+
				"</div>"+
				"<div class='title' id='title"+s1+"'>"+
					"<a href=''>"+s2+"</a>"+
				"</div>"+
				"<div class='layui-row'>"+
					"<div class='layui-col-md8'>"+
						"<div class='brief' id='brief"+s1+"'>"+
							"<a href=''>"+s3+"</a>"+
							"<a href='' style='color: steelblue;'>查看全文</a>"+
							"<a style=''visibility: hidden;' name='questionID'></a>"+
						"</div>"+
					"</div>"+
					"<div class='layui-col-md1'>"+
						"<span>&nbsp;</span>"+
					"</div>"+
					"<div class='layui-col-md3'>"+
						"<div class='picture'>"+
						"	<img src='Resource/webSite/test1.jpg' />"+
						"</div>"+
					"</div>"+
				"</div>"+
				"<div class='status'>"+
					"<div class='answer-button' style='margin-top: 20px;'>"+

						"<div class='upvote  div-inline question-btn-padding-right'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-praise ' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>"+s4+"热度</span>"+
							"</a>"+
						"</div>"+

						"<div class='downvote div-inline question-btn-padding-right'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-tread' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>"+s6+"收藏</span>"+
						"	</a>"+
						"</div>"+

						"<div class='comment div-inline question-btn-padding-right'>"+
							"<a href=''>"+
							"	<i class='layui-icon layui-icon-reply-fill' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>"+s5+"评论</span>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share-type div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-login-wechat' style='font-size: 20px; color: #1E9FFF;'></i>"+
							"	<i class='layui-icon layui-icon-login-qq' style='font-size: 20px; color: #1E9FFF;'></i>"+
							"	<i class='layui-icon layui-icon-login-weibo' style='font-size: 20px; color: #1E9FFF;'></i>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-release' style='font-size: 20px; color: #1E9FFF;'></i>"+
								"<span>分享</span>"+
						"</a>"+
						"</div>"+

					"</div>"+

				"</div>"+
				"<div class='layui-row '>"+
				"	<span>&nbsp;</span>"+
				"</div>"+
				"<div class='layui-row '>"+
				"	<span>&nbsp;</span>"+
				"</div>"+
			"</div>  "; 
	             $('.question').append(div);  
	         
          }); 
          
          //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
          //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
          next($('#question').append(div), page < res.pages);    
        });
      }
    });
  });
       

/*$('body').on('click','#askQuestion', function(){
    layer.open({
      type: 1,
      area: ['600px', '360px'],
      shadeClose: true, //点击遮罩关闭
      content: '\<\div style="padding:20px;">自定义内容\<\/div>'
    });
  });*/
 
 function askQuestion() {
 	 layer.open({
 	      type: 1,
 	      area: ['600px', '360px'],
 	      shadeClose: true, //点击遮罩关闭
 	      content: 	  
 	    	 '<form class="layui-form" action="">'+
 	  '<div class="layui-form-item">'+
 	    '<label class="layui-form-label">输入框</label>'+
 	    '<div class="layui-input-block">'+
 	      '<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">'+
 	    '</div>'+
 	  '</div>'+
 	  '<div class="layui-form-item">'+
 	    '<label class="layui-form-label">密码框</label>'+
 	    '<div class="layui-input-inline">'+
 	      '<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">'+
 	    '</div>'+
 	    '<div class="layui-form-mid layui-word-aux">辅助文字</div>'+
 	  '</div>'+
 	  '<div class="layui-form-item">'+
 	    '<label class="layui-form-label">选择框</label>'+
 	   ' <div class="layui-input-block">'+
 	      '<select name="city" lay-verify="required">'+
 	        '<option value=""></option>'+
 	        '<option value="0">北京</option>'+
 	        '<option value="1">上海</option>'+
 	        '<option value="2">广州</option>'+
 	        '<option value="3">深圳</option>'+
 	        '<option value="4">杭州</option>'+
 	     ' </select>'+
 	   ' </div>'+
 	  '</div>'+
 	 ' <div class="layui-form-item">'+
 	    '<label class="layui-form-label">复选框</label>'+
 	    '<div class="layui-input-block">'+
 	      '<input type="checkbox" name="like[write]" title="写作">'+
 	      '<input type="checkbox" name="like[read]" title="阅读" checked>'+
 	      '<input type="checkbox" name="like[dai]" title="发呆">'+
 	    '</div>'+
 	  '</div>'+
 	  '<div class="layui-form-item">'+
 	    '<label class="layui-form-label">开关</label>'+
 	    '<div class="layui-input-block">'+
 	      '<input type="checkbox" name="switch" lay-skin="switch">'+
 	    '</div>'+
 	 ' </div>'+
 	  '<div class="layui-form-item">'+
 	    '<label class="layui-form-label">单选框</label>'+
 	   ' <div class="layui-input-block">'+
 	    '  <input type="radio" name="sex" value="男" title="男">'+
 	  '    <input type="radio" name="sex" value="女" title="女" checked>'+
 	   ' </div>'+
 	 ' </div>'+
 	 ' <div class="layui-form-item layui-form-text">'+
 	  '  <label class="layui-form-label">文本域</label>'+
 	  '  <div class="layui-input-block">'+
 	   '   <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>'+
 	   ' </div>'+
 	'  </div>'+
 	'  <div class="layui-form-item">'+
 	 '   <div class="layui-input-block">'+
 	    '  <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>'+
 	    '  <button type="reset" class="layui-btn layui-btn-primary">重置</button>'+
 	   ' </div>'+
 	 ' </div>'+
 	'</form>'
 	    	  
 	    	  
 	    	  
 	    });
 }
