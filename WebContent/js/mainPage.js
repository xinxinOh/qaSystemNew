var cate='100';//默认种类为2 显示社会新闻

window.onload = function() {
	 
		$.ajax({
		type: "GET",
		url: "/qaSystemNew/LoadQuestionServlet?start="+0+"&end="+4,
		dataType: "json",
		success: function(result) {
			$(".innerQuestion").remove();
			 var dataObj = result;//返回的result为json格式的数据
			 $.each(dataObj, function(index, item){
				 var s1 =  item.question_id; 
	             var s2 =  item.title; 
	             var s3 =  item.content; 
	             var s4 =  item.fever;
	             var s5 =  item.answer_num;
	             var s6 =  item.collect_num;
	             var div="<div class='innerQuestion' id='innerQuestion_"+s1+"'>"+
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
								"<i class='layui-icon layui-icon-fire ' style='font-size: 20px; color:darkseagreen;'></i>"+
								"<span>"+s4+"热度</span>"+
							"</a>"+
						"</div>"+

						"<div class='downvote div-inline question-btn-padding-right'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-star' style='font-size: 20px; color:darkseagreen;'></i>"+
								"<span>"+s6+"收藏</span>"+
						"	</a>"+
						"</div>"+
						"<div class='comment div-inline question-btn-padding-right'>"+
							"<a href=''>"+
							"	<i class='layui-icon layui-icon-dialogue' style='font-size: 20px; color:darkseagreen;'></i>"+
								"<span>"+s5+"评论</span>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share-type div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-login-wechat' style='font-size: 20px; color:darkseagreen;'></i>"+
							"	<i class='layui-icon layui-icon-login-qq' style='font-size: 20px; color:darkseagreen;'></i>"+
							"	<i class='layui-icon layui-icon-login-weibo' style='font-size: 20px; color:darkseagreen;'></i>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-release' style='font-size: 20px; color:darkseagreen;'></i>"+
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

function getCategory(category) {
//alert("in getcategory method");
	cate=category;
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
								"<i class='layui-icon layui-icon-fire ' style='font-size: 20px; color:darkseagreen;'></i>"+
								"<span>"+s4+"热度</span>"+
							"</a>"+
						"</div>"+

						"<div class='downvote div-inline question-btn-padding-right'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-star' style='font-size: 20px; color:darkseagreen;'></i>"+
								"<span>"+s6+"收藏</span>"+
						"	</a>"+
						"</div>"+
						"<div class='comment div-inline question-btn-padding-right'>"+
							"<a href=''>"+
							"	<i class='layui-icon layui-icon-dialogue' style='font-size: 20px; color:darkseagreen;'></i>"+
								"<span>"+s5+"评论</span>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share-type div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-login-wechat' style='font-size: 20px; color:darkseagreen;'></i>"+
							"	<i class='layui-icon layui-icon-login-qq' style='font-size: 20px; color:darkseagreen;'></i>"+
							"	<i class='layui-icon layui-icon-login-weibo' style='font-size: 20px; color:darkseagreen;'></i>"+
							"</a>"+
						"</div>"+
						"<div class='answer-share div-inline question-btn-padding-right' style='float: right;'>"+
							"<a href=''>"+
								"<i class='layui-icon layui-icon-release' style='font-size: 20px; color:darkseagreen;'></i>"+
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




window.onscroll = function () { // console.log("1:" + $(document).scrollTop());
	console.log('---------------------');
      console.log(window.innerHeight);//在谷歌浏览器中请使用 innerHeight以替换clientHeight 
      console.log($(document).scrollTop()); 
      console.log(document.body.scrollHeight);//以上三个属性打印出来之后当滚动条滚到底部 1 + 2 = 3。 
    if(window.innerHeight + $(document).scrollTop()+1>document.body.scrollHeight){ 
    	var start = parseInt($('.question').children().length);
    	var end=start+3;
 
    	if(cate=="100")//在热门页面
    		var Surl="/qaSystemNew/LoadQuestionServlet?start="+start+"&end="+end;
    	else
    		var Surl="LoadCategoryQuestionServlet?category="+cate+"&start="+start+"&end="+end;
    	$.ajax({
    		type: "GET",
    		url: Surl,
    		dataType: "json",
    		success: function(result) {
    			
    			 var dataObj = result; //返回的result为json格式的数据
    			 if(dataObj==""){
     				layer.msg('已经到底啦');
     				return;
     			}
    	         con = "";
    			 var ii = layer.load();
     		    //此处用setTimeout演示ajax的回调
     		    setTimeout(function(){
     		      layer.close(ii);
     		    }, 800);
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
    								"<i class='layui-icon layui-icon-fire ' style='font-size: 20px; color:darkseagreen;'></i>"+
    								"<span>"+s4+"热度</span>"+
    							"</a>"+
    						"</div>"+

    						"<div class='downvote div-inline question-btn-padding-right'>"+
    							"<a href=''>"+
    								"<i class='layui-icon layui-icon-star' style='font-size: 20px; color:darkseagreen;'></i>"+
    								"<span>"+s6+"收藏</span>"+
    						"	</a>"+
    						"</div>"+

    						"<div class='comment div-inline question-btn-padding-right'>"+
    							"<a href=''>"+
    							"	<i class='layui-icon layui-icon-dialogue' style='font-size: 20px; color:darkseagreen;'></i>"+
    								"<span>"+s5+"评论</span>"+
    							"</a>"+
    						"</div>"+
    						"<div class='answer-share-type div-inline question-btn-padding-right' style='float: right;'>"+
    							"<a href=''>"+
    								"<i class='layui-icon layui-icon-login-wechat' style='font-size: 20px; color:darkseagreen;'></i>"+
    							"	<i class='layui-icon layui-icon-login-qq' style='font-size: 20px;color:darkseagreen;'></i>"+
    							"	<i class='layui-icon layui-icon-login-weibo' style='font-size: 20px; color:darkseagreen;'></i>"+
    							"</a>"+
    						"</div>"+
    						"<div class='answer-share div-inline question-btn-padding-right' style='float: right;'>"+
    							"<a href=''>"+
    								"<i class='layui-icon layui-icon-release' style='font-size: 20px; color:darkseagreen;'></i>"+
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
    			alert(1231231)
    		}
    	});
    	
    	
            //假设你的列表返回在data集合中
    		/*if(res.data==null){
    			layer.msg('已经到底啦');
    			return;
    		}*/
    	}
    
  }
    
    /*function addItems() { 
    	for(var i =0; i < 10; i ++) 
    		$('.question').append('<li style="float: none;"><a href="#">' + '二级栏目' + '</a></li>'); 
    	clearInterval(addChildTimer); 
    	}
*/



 
 function askQuestion() {
	 layui.use('form', function(){
		  var form = layui.form;
		  
		   layer.open({
		 	      type: 1,
		 	      area: ['600px', '360px'],
		 	      shadeClose: true, //点击遮罩关闭
		 	      content: 	
		 	    	  '<div class="layui-row "><span>&nbsp;</span></div>'+
		 	    	 ' <div class="layui-row ">'+
					'<div class="layui-col-md11">'+
		 	    	 '<form class="layui-form" action="/qaSystemNew/AskQuestionServlet" method="post">'+
		 	  '<div class="layui-form-item">'+
		 	    '<label class="layui-form-label">标题</label>'+
		 	    '<div class="layui-input-block">'+
		 	      '<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">'+
		 	    '</div>'+
		 	  '</div>'+
		 	  
		 	  '<div class="layui-form-item">'+
		 	    '<label class="layui-form-label">问题类型</label>'+
		 	   ' <div class="layui-input-block">'+
		 	      '<select name="category" lay-verify="required">'+
		 	        '<option value=""></option>'+
		 	        '<option value="1">社会</option>'+
		 	        '<option value="2">娱乐</option>'+
		 	        '<option value="3">体育</option>'+
		 	        '<option value="4">军事</option>'+
		 	        '<option value="5">汽车</option>'+
		 	        '<option value="6">财经</option>'+
		 	        '<option value="7">科技</option>'+
		 	        '<option value="8">育儿</option>'+
		 	        '<option value="9">历史</option>'+
		 	     ' </select>'+
		 	   ' </div>'+
		 	  '</div>'+

		 	 ' <div class="layui-form-item layui-form-text">'+
		 	  '  <label class="layui-form-label">问题简介</label>'+
		 	  '  <div class="layui-input-block">'+
		 	   '   <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>'+
		 	   ' </div>'+
		 	'  </div>'+
		 	
		 	'  <div class="layui-form-item">'+
		 	 '   <div class="layui-input-block">'+
		 	    '  <button class="layui-btn" lay-submit lay-filter="formDemo">发布问题</button>'+
		 	    '  <button type="reset" class="layui-btn layui-btn-primary">重置</button>'+
		 	   ' </div>'+
		 	 ' </div>'+
		 	'</form>'+
		 	'</div>'+
		 	'<div class=" layui-col-md1">&nbsp;</div>'+
		 	'</div>'
		 	    	  
		  //各种基于事件的操作，下面会有进一步介绍
	 	
 	});
		  form.render('select'); 
			//  form.render('checkbox'); 
			//  form.render('radio'); 

			  //监听提交
			 /* form.on('submit(formDemo)', function(data){
			    layer.msg(JSON.stringify(data.field));
		  
			    return false;
			  });*/
			});
 };

function ShowOnPage(a){
	layer.msg(a);
}

