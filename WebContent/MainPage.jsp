<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>主页</title>
		<script src="./js/mainPage.js"></script>
		<script src="./js/jquery-1.8.3.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/MainPage.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user_home_page.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.mobile.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/modules/layer/default/layer.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/modules/laydate/default/laydate.css">

		<script src="<%=request.getContextPath()%>/layui/layui.js"></script>
		<script src="<%=request.getContextPath()%>/layui/layui.all.js"></script>
		<script src="<%=request.getContextPath()%>/layui/lay/modules/layer.js"></script>

	</head>

	<body>
		<div class="layui-row ">
			<div class=" layui-col-md12">
				<div class="navbar ">
					<jsp:include page="Navbar.jsp" flush="true" />
				</div>
			</div>
		</div>
		<div class="layui-row " style="margin-top: 10px;">

			<div class=" layui-col-md2">
				&nbsp;
			</div>
			<div class=" layui-col-md6">

				<div class="category ">
					<ul>
						<li>
							<a onclick="window.location='MainPage.jsp'">热门</a>
						</li>
						<li>
							<a onclick="getCategory('1')">社会</a>
						</li>
						<li>
							<a onclick="getCategory('2')">娱乐</a>
						</li>
						<li>
							<a onclick="getCategory('3')">体育</a>
						</li>
						<li>
							<a onclick="getCategory('4')">军事</a>
						</li>
						<li>
							<a onclick="getCategory('5')">汽车</a>
						</li>
						<li>
							<a onclick="getCategory('6')">财经</a>
						</li>
						<li>
							<a onclick="getCategory('7')">科技</a>
						</li>
						<li>
							<a onclick="getCategory('8')">育儿</a>
						</li>
						<li>
							<a onclick="getCategory('9')">历史</a>
						</li>

					</ul>
				</div>

			</div>
			<div class=" layui-col-md4">
           
			</div>

		</div>
		<div class="layui-row ">
			&nbsp;
		</div>
		<div class="layui-row ">
			&nbsp;
		</div>

		<div class="layui-row ">
			<div class="layui-col-md2">
				<div class="left">
					&nbsp;
				</div>
			</div>
			<div class="layui-col-md6">
				<div class="center">
					<div class="question" id="question">
						<div class="innerQuestion" id="innerQuestion_${question.question_id}">
							<div class="layui-row ">
								&nbsp;
							</div>
							<div class="title">
								<a id="title_${question.question_id}" href="question.jsp?question_id=${question.question_id}&title=${question.title}">&nbsp;</a>                         
							</div>
							<div class="layui-row ">
								<div class="layui-col-md8">
									<div class="brief" >
										<a href="question.jsp?question_id=${question.question_id}&title=${question.title}" id="brief_${question.question_id}" >&nbsp;</a>
										<a href="question.jsp?question_id=${question.question_id}&title=${question.title}" style="color: steelblue;">查看全文</a>
										<a style="visibility: hidden;" name="questionID"></a>
									</div>
								</div>
								<div class="layui-col-md1">
									<span>&nbsp;</span>
								</div>
								<div class="layui-col-md3">
									<div class="picture" >
										<a href="question.jsp?question_id=${question.question_id}&title=${question.title}">
										<img src="Resource/webSite/test1.jpg" />
										</a>
									</div>
								</div>
							</div>
							<div class="status">
								<div class="answer-button" style="margin-top: 20px;">

									<div class="upvote  div-inline question-btn-padding-right">
										<a href="question.jsp?question_id=${question.question_id}&title=${question.title}">
											<i class="layui-icon layui-icon-fire " style="font-size: 20px; color:darkseagreen;"></i>
											<span id="hot_${question.question_id}">&nbsp;热度</span>
										</a>
									</div>

									<div class="downvote div-inline question-btn-padding-right">
										<a href="javascript:;">
											<i class="layui-icon layui-icon-star" style="font-size: 20px; color:darkseagreen;" onclick='collect($(this).next())'></i>
											<span id="collect_${question.question_id}" onclick="collect($(this))">&nbsp;收藏</span>
										</a>
									</div>

									<div class="comment div-inline question-btn-padding-right">
										<a href="question.jsp?question_id=${question.question_id}&title=${question.title}">
											<i class="layui-icon layui-icon-dialogue" style="font-size: 20px; color:darkseagreen;"></i>
											<span id="comment_${question.question_id}">&nbsp;评论</span>
										</a>
									</div>
									<div class="answer-share-type div-inline question-btn-padding-right" style="float: right;">
										<a href="">
											<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color:darkseagreen;"></i>
											<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color:darkseagreen;"></i>
											<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color:darkseagreen;"></i>
										</a>
									</div>
									<div class="answer-share div-inline question-btn-padding-right" style="float: right;">
										<a href="">
											<i class="layui-icon layui-icon-release" style="font-size: 20px; color:darkseagreen;"></i>
											<span>分享</span>
										</a>
									</div>

								</div>

							</div>
							<div class="layui-row ">
								<span>&nbsp;</span>
							</div>
							<div class="layui-row ">
								<span>&nbsp;</span>
							</div>
						</div>

					</div>

				</div>

			</div>
			<div class=" layui-col-md3">

				<div class="layui-row ">
					<span>&nbsp;</span>
				</div>
				<div class="layui-row ">
					<div class="layui-col-md2">
						<span>&nbsp;</span>
					</div>
					<div class=" layui-col-md10">
						<div class="personalInfo">
							<div class="layui-row ">
								<div class="layui-col-md2">
									<span>&nbsp;</span>
								</div>
								<div class=" layui-col-md5">

									<div class="acount_picture_class">
										<img class="layui-nav-img" src="Reaources/UserAccountPicture/${session.user.u_id}.jpg" style="width:100px;height:100px;z-index:3;position:absolute;" />
										<img class="layui-nav-img" src="//t.cn/RCzsdCq" style="width:100px;height:100px;z-index:2;position:relative;" />
									</div>
								</div>

								<div class="layui-col-md5">
									<p style="font-weight: 400;color: seagreen;font-size: 25px;">${user.nickname}</p>
									<p style="color:gray">${user.introduction}</p>
								</div>

							</div>

							<div class="layui-row ">
								<span>&nbsp;</span>
							</div>

							<div class="layui-row ">
								<div class="layui-col-md2">
									<span>&nbsp;</span>
								</div>
								<div class=" layui-col-md10">

									<div class="share">
										<p></p>
										<p class="light_font_color shar_icon">分享</p>
										<p class="layui-icon layui-icon-login-wechat shar_icon" style="font-size: 20px; color: darkolivegreen;"></p>
										<p class="layui-icon layui-icon-login-qq shar_icon" style="font-size: 20px; color: darkolivegreen;"></p>
										<p class="layui-icon layui-icon-login-weibo shar_icon" style="font-size: 20px; color: darkolivegreen;"></p>
									</div>
								</div>

							</div>
						</div>
							<div class="layui-row ">
					<div class="layui-row ">
						<span>&nbsp;</span>
					</div>
					<div class="layui-row ">
						<span>&nbsp;</span>
					</div>
					<div class="layui-row ">
						<div class="layui-col-md2">
							<span>&nbsp;</span>
						</div>
						<div class=" layui-col-md10">
							<button style="background-color:darkseagreen;border: none;color: white;padding: 10px 20px;text-align: center;text-decoration: none;
                                 display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;" id="askQuestion" onclick="askQuestion()">我要提问</button>
						</div>
					</div>

				</div>

					</div>
					</div>
					
				</div>
				<div class=" layui-col-md1">
						<div class="right">

						</div>
					</div>
					</div>
				<%
String errorInfo = (String)request.getAttribute("message");         // 获取错误属性
if(errorInfo != null) {
%>
				<script type="text/javascript" language="javascript">
					alert("<%=errorInfo%>"); // 弹出错误信息
				</script>
				<%
}
%>
	</body>

</html>