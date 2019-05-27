<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use(['laypage', 'layer'], function(){
		var laypage = layui.laypage
		,layer = layui.layer;
		  
		  //自定义首页、尾页、上一页、下一页文本
		laypage.render({
			elem: 'demo1'
		    ,count: 100
		    ,first: '首页'
		    ,last: '尾页'
		    ,prev: '<em>←</em>'
		    ,next: '<em>→</em>'
		    
		    ,jump:function(obj,first){
		    	start1 = obj.curr;
		    	start2 = 0 ;
		    	start3 = 0;
		    }
		});
		  
		laypage.render({	    
			elem: 'demo2'
		   	,count: 100
			,first: '首页'
		    ,last: '尾页'
		    ,prev: '<em>←</em>'
		    ,next: '<em>→</em>'
			    
		    ,jump:function(obj,first){
		    	start2 = obj.curr;
		    	start1 = 0 ;
		    	start3 = 0;
		    }
		});
		  
	 	laypage.render({
		    elem: 'demo3'		    
		    ,count: 100
			,first: '首页'
		    ,last: '尾页'
		    ,prev: '<em>←</em>'
		    ,next: '<em>→</em>'
			    
		    ,jump:function(obj,first){
		    	start3 = obj.curr;
		    	start2 = 0 ;
		    	start1 = 0;
		    }
		});
	});

$(function () {
	$(".page_bar").click(function(){

		$.ajax({
			type:"GET",
			url:"LoadUserContentServlet?start1="+start1+"&start2="+start2+"&start3="+start3
			,success: function(data) {
				$(".content_box").remove();
				alert("start remove!");
			}
		});
		
	});
});
/*


*/
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/MainPage.css">
<div class="layui-tab layui-tab-card">
  	<ul class="layui-tab-title content_bar">
		<li class="layui-this">动态</li>
		<li>回答</li>
		<li>收藏</li>
		<li>提问</li>
	</ul>
	<div class="layui-tab-content" style="">
	
    	<div class="layui-tab-item layui-show contentDetail_box">暂无动态</div>
    
    	<!-- 回答 -->
    	<div class="layui-tab-item contentDetail_box" varStatus="status" id = "">
    		<div id = "answer_content_box">
    		<div class = "content_box">
    		<c:forEach items = "${answers}" var="answer">
				<div class="innerQuestion" id="innerAnswer${answer.answer_id}">
				<div class="layui-row ">&nbsp;</div>
				
				<div class="title">
					<a href="">"${answerQuestions[status.count].title}"</a>
				</div>
				
				<div class="layui-row ">
					<div class="layui-col-md8">
						<div class="brief">
							<a href="">${answer.content}</a>
							<a href="" style="color: steelblue;">查看全文</a>
							<a style="visibility: hidden;" name="questionID"></a>
						</div>
					</div>
					<div class="layui-col-md1"><span>&nbsp;</span></div>
						<div class="layui-col-md3">
							<div class="picture"><img src="Resource/webSite/test1.jpg" /></div>
						</div>
					</div>
					<div class="status">
						<div class="answer-button" style="margin-top: 20px;">
							<div class="upvote  div-inline question-btn-padding-right">
								<a href="">
								<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
								<span>${answer.upvote_num}赞</span>
								</a>
							</div>

						<div class="downvote div-inline question-btn-padding-right">
							<a href="">
							<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
							<span>${answer.downvote_num}踩</span>									
							</a>
						</div>

						<div class="comment div-inline question-btn-padding-right">
							<a href="">
								<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>					
								<span>${answer.comment_num}评论</span>
							</a>
						</div>
						
						<div class="answer-share-type div-inline question-btn-padding-right" style="float: right;">
							<a href="">
								<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>
								<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>									
								<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>
							</a>
						</div>
			
						<div class="answer-share div-inline question-btn-padding-right" style="float: right;">
							<a href="">
								<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>
								<span>分享</span>								
							</a>
						</div>

					</div>

				</div>
					<div class="layui-row "><span>&nbsp;</span></div>
						<div class="layui-row ">
							<span>&nbsp;</span>
						</div>
			</div>   		
   			</c:forEach>
   			</div>
   			</div>
   			<div id="demo1" class = "page_bar"></div>
 		 </div>
 		 
 		 <!-- 收藏 -->
    <div class="layui-tab-item contentDetail_box">
   		<div id = "collect_content_box">
    	<div class = "content_box">
        <c:forEach items = "${collectQuestions}" var="question" >
        	<div class="innerQuestion" id="innerQuestion${question.question_id}">
				<div class="layui-row ">&nbsp;</div>
				
				<div class="title">
					<a href="">${question.title}</a>
				</div>
				
				<div class="layui-row ">
					<div class="layui-col-md8">
						<div class="brief">
							<a href="">${question.content}</a>
							<a href="" style="color: steelblue;">查看全文</a>
							<a style="visibility: hidden;" name ="questionID"></a>
						</div>
					</div>
					<div class="layui-col-md1"><span>&nbsp;</span></div>
						<div class="layui-col-md3">
							<div class="picture"><img src="Resource/webSite/test1.jpg" /></div>
						</div>
					</div>
					<div class="status">
						<div class="answer-button" style="margin-top: 20px;">
							<div class="upvote  div-inline question-btn-padding-right">
								<a href="">
								<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
								<span>${question.fever}热度</span>
								</a>
							</div>

						<div class="downvote div-inline question-btn-padding-right">
							<a href="">
							<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
							<span>${question.collect_num}收藏</span>									
							</a>
						</div>

						<div class="comment div-inline question-btn-padding-right">
							<a href="">
								<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>					
								<span>${question.answer_num}评论</span>
							</a>
						</div>
						
						<div class="answer-share-type div-inline question-btn-padding-right" style="float: right;">
							<a href="">
								<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>
								<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>									
								<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>
							</a>
						</div>
			
						<div class="answer-share div-inline question-btn-padding-right" style="float: right;">
							<a href="">
								<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>
								<span>分享</span>								
							</a>
						</div>

					</div>

				</div>
					<div class="layui-row "><span>&nbsp;</span></div>
						<div class="layui-row ">
							<span>&nbsp;</span>
						</div>
			</div>
    	</c:forEach>
    	</div>
    	</div>
		<div id="demo2" class = "page_bar"></div>
    </div>
    
    <!-- 提问 -->
    <div class="layui-tab-item contentDetail_box" >
    	<div id = "question_content_box">
    	<div class = "content_box">
    	<c:forEach items = "${questions}" var="question">
    		<div class="innerQuestion" id="innerQuestion${question.question_id}">
				<div class="layui-row ">&nbsp;</div>
				
				<div class="title">
					<a href="">${question.title}</a>
				</div>
				
				<div class="layui-row ">
					<div class="layui-col-md8">
						<div class="brief">
							<a href="">${question.content}</a>
							<a href="" style="color: steelblue;">查看全文</a>
							<a style="visibility: hidden;" name="questionID"></a>
						</div>
					</div>
					<div class="layui-col-md1"><span>&nbsp;</span></div>
						<div class="layui-col-md3">
							<div class="picture"><img src="Resource/webSite/test1.jpg" /></div>
						</div>
					</div>
					<div class="status">
						<div class="answer-button" style="margin-top: 20px;">
							<div class="upvote  div-inline question-btn-padding-right">
								<a href="">
								<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
								<span>${question.fever}热度</span>
								</a>
							</div>

						<div class="downvote div-inline question-btn-padding-right">
							<a href="">
							<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
							<span>${question.collect_num}收藏</span>									
							</a>
						</div>

						<div class="comment div-inline question-btn-padding-right">
							<a href="">
								<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>					
								<span>${question.answer_num}评论</span>
							</a>
						</div>
						
						<div class="answer-share-type div-inline question-btn-padding-right" style="float: right;">
							<a href="">
								<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>
								<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>									
								<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>
							</a>
						</div>
			
						<div class="answer-share div-inline question-btn-padding-right" style="float: right;">
							<a href="">
								<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>
								<span>分享</span>								
							</a>
						</div>

					</div>

				</div>
					<div class="layui-row "><span>&nbsp;</span></div>
						<div class="layui-row ">
							<span>&nbsp;</span>
						</div>
			</div>
   		</c:forEach>
   		</div>
   		</div>
   		<div id="demo3" class = "page_bar"></div>
   		
   		
   	</div>
</div>
</div>

