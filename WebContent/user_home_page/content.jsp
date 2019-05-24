<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});

//分页变量:
	var start1 = 0;
	var start2 = 0;
	var start3 = 0;
//调用分页
var layPage_1 = layui.laypage;
layPage_1.render({
    elem: 'content_page_1',
    count: "${answers.size()}",
    limit:10,
    groups:3,
    theme:"darkolivegreen",
    jump: function(obj){
      start1 = obj.cuur;
      start2 = 0;
      start3 = 0;
    }
  });
  
var layPage_2 = layui.laypage;
layPage_2.render({
    elem: 'content_page_2',
    count: "${collectQuestions.size()}",
    limit:10,
    groups:3,
    theme:"darkolivegreen",
    jump: function(obj){
      start2 = obj.cuur;
      start1 = 0;
      start3 = 0;
    }
  });
</script>
<div class="layui-tab layui-tab-card content_box">
  	<ul class="layui-tab-title content_bar">
		<li class="layui-this">动态</li>
		<li>回答</li>
		<li>收藏</li>
		<li>提问</li>
	</ul>
	<div class="layui-tab-content" style="height: 100px;">
    	<div class="layui-tab-item layui-show contentDetail_box">暂无动态</div>
    	<div class="layui-tab-item contentDetail_box">2
    		<c:forEach items = "${answers}" var="answer">
				<div class="contentDetail">
					<p class="answer_content">${answer.content}</p>					
					<p>${answer.upvote_num}</p>
					<p>${answer.downvote_num}</p>
					<p>${answer.comment_num}</p>
					<p>${answer.date}</p>
				</div>    		
   			</c:forEach>
   			<div id="content_page_1"></div>
 		 </div>
    <div class="layui-tab-item contentDetail_box">3
        <c:forEach items = "${collectQuestions}" var="collectQuestion" varStatus="status">
        	<p class="question_title">${collectQuestions.get(status.count).title}</p>
    		<div class = "contentDetail">
    			<p class="question_content">${collectQuestion.content}</p>
   				<div class="question_discribe">
   					<p>${collectQuestion.fever}</p>
    				<p>${collectQuestion.answer_num}</p>
      				<p>${collectQuestion.collect_num}</p>
    				</div>
    		</div>
    	</c:forEach>
    	<div id="content_page_2"></div>
    	<p>收藏</p>
    </div>
    <div class="layui-tab-item contentDetail_box">4
    	<c:forEach items = "${questions}" var="question">
    		<div class = "contentDetail">
    			<p class="question_title">${question.title}</p>
   				<p class="question_content">${question.content}</p>
   				
   				<div class="question_discribe light_font_color">
   					<p>${question.fever}</p>
   					<p>${question.answer_num}</p>
    				<p>${question.collect_num}</p>
   				</div>
    				
   			</div>
   		</c:forEach>
   		
   		<div id="content_page_3"></div>
   		<p>提问</p>
   	</div>
</div>
