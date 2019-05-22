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
    	<div class="layui-tab-item contentDetail">3</div>
    	<div class="layui-tab-item contentDetail">4</div>
    	<div class="layui-tab-item contentDetail">5</div>
  	</div>
</div>