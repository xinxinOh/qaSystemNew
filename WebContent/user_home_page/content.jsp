<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>
<div id = "content">
	<!-- tab栏 -->
	<div class="content-bar">
		<ul class="layui-tab-title">
			<li class="layui-this">动态</li>
			<li>回答</li>
			<li>收藏</li>
			<li>提问</li>
		</ul>
	</div>
	
	<div class="layui-tab-content">
    	
    	<div class="layui-tab-item layui-show contentDetail" >暂无动态</div>
    	
    	<div class="layui-tab-item contentDetail_box" >
    		<c:forEach items = "${answers}" var="answer">
				<div class="contentDetail">
					<p class="answer_content">${answer.content}</p>
					<p>${answer.upvote_num}</p>
					<p>${answer.downvote_num}</p>
					<p>${answer.comment_num}</p>
					<p>${answer.date}</p>
				</div>    		
    		</c:forEach>
    	</div>
  
    	<div class="layui-tab-item contentDetail">
    		<c:forEach items = "${collectQuestions}" var="collectQuestion">
    			<div class = "contentDetail">
    				<p class="question_title">${collectQuestion.title}</p>
    				<p class="question_content">${collectQuestion.content}</p>
    				<div class="question_discribe">
    					<p>${collectQuestion.fever}</p>
	    				<p>${collectQuestion.answer_num}</p>
    					<p>${collectQuestion.collect_num}</p>
    				</div>
    				
    			</div>
    		</c:forEach>
    	</div>
    	
    	<div class="layui-tab-item contentDetail">
    		<c:forEach items = "${questions}" var="question">
    			<div class = "contentDetail">
    				<p class="question_title">${question.title}</p>
    				<p class="question_content">${question.content}</p>
    				
    				<div class="question_discribe">
    					<p>${question.fever}</p>
	    				<p>${question.answer_num}</p>
    					<p>${question.collect_num}</p>
    				</div>
    				
    			</div>
    		</c:forEach>
    	</div>
    	<div class="layui-tab-item contentDetail">5</div>
  	</div>
</div>