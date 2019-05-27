<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<script src="./js/jquery-3.2.1.min.js"></script>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Answer.css">

		<script type="text/javascript">
			$(document).ready(function() {
				$(".see-comment").parent().parent().next().hide();
				$(document).scroll(function() {
					//滚动条滑动的时候获取滚动条距离顶部的距离
					var scroll = $(document).scrollTop();
					//屏幕的高度
					var client = $(window).height();
					var h = $(document).height();
					var nickname = '1234';
					var intro = '4123';
					var flag = true;
					if(h <= scroll + client) { // 到达底部时,加载新内容
						if(flag == false) {
							return;
						}
						$.each($.parseJSON(data),function(idx,obj){
//							
//							var odiv = '<div class="one-answer">' +
//							'<div class="writer-info">' +
//							'<img src="//t.cn/RCzsdCq" class="layui-nav-img">' +
//							'<span>' + nickname +'&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;' + '</span>' +
//							'<span>' + intro + '</span>' +
//							'<button class="layui-btn layui-btn-normal layui-btn-sm" style="margin-left: 170px;">&nbsp;&nbsp;&nbsp;+&nbsp;关注&nbsp;&nbsp;&nbsp;</button>' +
//							'</div>'+
//							'<div class="answer-content" style="margin-top: 30px;margin-bottom: 30px;">' +
//							'<p>' + obj.content +'</p>' +
//							'</div>'+
//							'<div class="answer-date">'+
//							'<p>最后编辑' + obj.answer_date +'</p>' +
//							'</div>'+ 
//							'<div class="answer-button" style="margin-top: 30px;">'+
//							'<div class="upvote  div-inline question-btn-padding-right">'+
//							'<a href="">'+
//							'<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>'+obj.upvote_num+'赞</span>'+
//							'</a>'+
//							'</div>'+
//							'<div class="downvote div-inline question-btn-padding-right">'+
//							'<a href="">'+
//							'<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>'+obj.downvote_num+'踩</span>'+
//							'</a>'+
//							'</div>'+
//							'<div class="comment div-inline question-btn-padding-right">'+
//							'<a class="see-comment" href="javascript:void(0)">'+
//							'<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>'+obj.comment_num+'评论</span>'+
//							'</a>'+
//							'</div>'+
//							'<div class="answer-share div-inline question-btn-padding-right">'+
//							'<a href="">'+
//							'<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>分享</span>'+
//							'</a>'+
//							'</div>'+
//							'<div class="answer-share-type div-inline question-btn-padding-right">'+
//							'<a href="">'+
//							'<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'</a>'+
//							'</div>'+
//							'</div>'+
//							'<div class="comment-container" style="margin-top: 30px;margin-bottom: 30px;background: #F0F0F0;">'+
//							'<div class="add-my-comment  div-inline" style="margin-bottom: 30px;">'+
//							'<div class="input-comment" style="padding-top: 30px;">'+
//							'<textarea name="desc" placeholder="" class="layui-textarea" autoHeight="true" style="margin-left: 30px; overflow:hidden; width:540px; height:120px; "></textarea>'+
//							'</div>'+
//							'</div>'+
//							'<div class="comment-submit" style="width: 510px;margin-left: 30px;height: 38px;">'+
//							'<button class="layui-btn" style="margin-left: 440px;width: 100px;">发表</button>'+
//							'</div>'+
//							'<div class="all-comments" style="margin-top: 30px;margin-bottom: 30px;">'+
//							'<div class="comment">'+
//							'<div class="layui-row">'+
//							'<div class="layui-col-md1">'+
//							'<img src="//t.cn/RCzsdCq" class="layui-nav-img" style="margin-left: 0px;width:40px;height:40px;">'+
//							'</div>'+
//							'<div class="layui-col-md11">'+
//							'<ul class="comment-list">'+
//							'<li class="comment-item">'+
//							'<a>啊啊啊啊啊</a>'+
//							'<div class="comment-text" style="margin-top: 5px;margin-bottom: 10px;">'+
//							'是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是'+
//							'</div>'+
//							'<div class="comment-button">'+
//							'<p style="margin-bottom: 10px;">2019-5-23</p>'+
//							'<div class="upvote  div-inline question-btn-padding-right" style="margin-top: 5px;">'+
//							'<a href="">'+
//							'<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>142赞</span>'+
//						    '</a>'+
//						    '</div>'+
//						    '<div class="downvote div-inline question-btn-padding-right">'+
//						    '<a href="">'+
//						    '<i class="layui-icon layui-icon-tread " style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>14踩</span>'+
//						    '</a>'+
//						    '</div>'+
//						    '<div class="comment div-inline question-btn-padding-right">'+
//						    '<a href="">'+
//						    '<i class="layui-icon layui-icon-reply-fill " style="font-size: 20px; color: #1E9FFF;"></i>'+
//							'<span>评论</span>'+
//						    '</a>'+
//						    '</div>'+
//						    '</div>'+
//						    '</li>'+
//						    '</ul>'+
//						    '<div class="load-more" style="margin-top: 30px; height: 50px;text-align:center;line-height:50px;">'+
//						    '<a href="javascript:void(0)">点击加载更多</a>'+
//						    '</div>'+
//						    '</div>'+
//						    '</div>'+
//						    '</div>'+
//						    '</div>'+
//						    '</div>'+
//						    '<hr />'+
//						    '</div>';
//							
//									
//							$(".all-answers").append(odiv);		
//							$(".see-comment").parent().parent().next().hide();
//							
//
							})		
								
						alert(1);
						$.ajax({
							type: "GET",
							url: "LoadAnswerServlet?question_id=" + "1" + "&start=" + "1" + "&end=" + "4",
							dataType: "text",
							success: function(data) {
								
							alert(data);
							
							
							},
							error: function() {
								alert(123);
							}
						});

					}

				});

				$(function() {
					$.fn.autoHeight = function() {
						function autoHeight(elem) {
							elem.style.height = 'auto';
							elem.scrollTop = 0; //防抖动
							elem.style.height = elem.scrollHeight + 'px';
						}
						this.each(function() {
							autoHeight(this);
							$(this).on('keyup', function() {
								autoHeight(this);
							});
						});
					}
					$('textarea[autoHeight]').autoHeight();
				});

				$("body").on("click",".see-comment",function(){
								
								$(this).parent().parent().next().toggle();
								
				});
				$(".load-more").click(function() {
					alert(1);
					var odiv = '<div class="one-answer">' +
						'<div class="writer-info">' +
						'<img src="//t.cn/RCzsdCq" class="layui-nav-img">' +
						'<span>' + "nickname" + '</span>' +
						'<span>' + "intro" + '</span>' +
						'<button class="layui-btn layui-btn-normal layui-btn-sm" style="margin-left: 170px;">&nbsp;&nbsp;&nbsp;+&nbsp;关注&nbsp;&nbsp;&nbsp;</button>' +
						'</div>' + '</div>';

					$(this).parent().prev().append(odiv);

				});

				$("[value=GETsubmit]").click(function() {
					$.ajax({
						type: "GET",
						url: "LoadAnswerServlet?question_id=" + "1" + "&start=" + "1" + "&end=" + "4",
						dataType: "text",
						success: function(data) {
							alert(data);
						},
						error: function() {
							alert(123);
						}
					});
				});

			});
		</script>

	</head>

	<body>

		<div>
			<div class="layui-header">
				<jsp:include page="Navbar.jsp" flush="true" />
			</div>

			<div class="layui-container" style="margin-top:50px;">
				<div class="layui-row">
					<div class="layui-col-md2">
						<div>
							<ul class="layui-nav layui-nav-tree" lay-filter="test">
								<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
								<li class="layui-nav-item layui-nav-itemed">
									<a href="javascript:;">默认展开</a>
									<dl class="layui-nav-child">
										<dd>
											<a href="javascript:;">选项1</a>
										</dd>
										<dd>
											<a href="javascript:;">选项2</a>
										</dd>
										<dd>
											<a href="">跳转</a>
										</dd>
									</dl>
								</li>
								<li class="layui-nav-item">
									<a href="javascript:;">解决方案</a>
									<dl class="layui-nav-child">
										<dd>
											<a href="">移动模块</a>
										</dd>
										<dd>
											<a href="">后台模版</a>
										</dd>
										<dd>
											<a href="">电商平台</a>
										</dd>
									</dl>
								</li>
								<li class="layui-nav-item">
									<a href="" class="yq">产品</a>
								</li>
								<li class="layui-nav-item">
									<a href="">大数据</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="layui-col-md7 question-padding-left">
						<div class="question-answer">
						</div>

						<div class="question clearfix">
							<div class="all-tags question-margin">
								<a>三农</a>
								<a>科技</a>
							</div>

							<div class="question-title question-margin">
								<span>东软睿道？？？？</span>
							</div>

							<div class="question-button question-margin">

								<div class="collect-question div-inline question-btn-padding-right">
									<a href="">
										<i class="layui-icon layui-icon-star" style="font-size: 20px; color: #1E9FFF;"></i>
										<span>收藏问题</span>
									</a>
								</div>

								<div class="invite-answer div-inline question-btn-padding-right">
									<a href="">
										<i class="layui-icon layui-icon-friends" style="font-size: 20px; color: #1E9FFF;"></i>
										<span class="yq">邀请回答</span>
									</a>
								</div>
								<div class="question-share-question div-inline question-btn-padding-right">
									<a href="">
										<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>
										<span>分享</span>
									</a>
								</div>

								<div class="question-share-type div-inline question-btn-padding-right">
									<a href="">
										<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>
										<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>
										<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>
									</a>
								</div>

							</div>

							<div class="write-answer">
								<div class="layui-btn-group layui-bg-cyan" style="border:0;">
									<button class="layui-btn layui-btn-sm layui-btn-primary" style="border:none;">
										    <i class="layui-icon">&#xe62b;</i>
										</button>
									<button class="layui-btn layui-btn-sm layui-btn-primary" style="border:none;">
										    <i class="layui-icon">&#xe646;</i>
										</button>
									<button class="layui-btn layui-btn-sm layui-btn-primary" style="border:none;">
										    <i class="layui-icon">&#xe644;</i>
										</button>
									<button class="layui-btn layui-btn-sm layui-btn-primary" style="border:none;">
										    <i class="layui-icon">&#xe64a;</i>
										</button>
									<button class="layui-btn layui-btn-sm layui-btn-primary" style="border:none;">
										    <i class="layui-icon">&#xe6ed;</i>
										</button>
								</div>
								<form class="layui-form" action="">
									<div class="layui-form-item layui-form-text">
										<label class="layui-form-label"></label>
										<div class="layui-input-block" style="margin-left:0px;margin-top:0px;min-height:0px">
											<textarea name="desc" placeholder="" class="layui-textarea" autoHeight="true" style="overflow:hidden;"></textarea>
										</div>
										<div class="layui-form-item">
											<div class="layui-input-block" style="margin-left:0px;margin-top:30px;">
												<button class="layui-btn" lay-submit lay-filter="formDemo">回答</button>
												<button type="reset" class="layui-btn layui-btn-primary yq">重置</button>
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="answer-num" style="margin-bottom: 20px;">
								<h3>129个回答</h3>
								<hr style="height:1px;border:none;border-top:1px solid darkolivegreen;" />
							</div>
							<div class="all-answers">
								<div class="one-answer">

									<div class="writer-info">
										<img src="//t.cn/RCzsdCq" class="layui-nav-img">
										<span>组织者组织&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
										<span>装BBBBBBBBBBBBBBBBBBBBB</span>
										<button class="layui-btn layui-btn-normal layui-btn-sm" style="margin-left: 170px;">&nbsp;&nbsp;&nbsp;+&nbsp;关注&nbsp;&nbsp;&nbsp;</button>
									</div>

									<div class="answer-content" style="margin-top: 30px;margin-bottom: 30px;">
										<p>如果你想叫农民满意那是办不到，农民懂得感恩吗？农民会满足吗？农民的需求是无止境的，朱之文给他们村做了那么多好事，最后的结局大家都看到了，村头碑砸了，还有人说每家给买辆小轿车，再给10000元我们才说他好，农民就是一群无法满足的无知懒蛋。</p>
										<p>首先说明一下，我也是农民，地地道道的农民，我最看不惯我们农民的作风，我们村有个尿毒症患者，国家一分钱不要，看一次病还给他50元，从来没有说过国家好，天天骂骂咧咧，到处找事，总感觉没有人敢惹他，确实也是，我们当地乡民政都怕他，最后死了，不是我爸爸都没有人帮忙埋他，确实恶贯满盈。</p>
										<p></p>
										<p></p>
									</div>

									<div class="answer-date">
										<p>最后编辑 2019-5-23</p>
									</div>

									<div class="answer-button" style="margin-top: 30px;">

										<div class="upvote  div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
												<span>142赞</span>
											</a>
										</div>

										<div class="downvote div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
												<span>12踩</span>
											</a>
										</div>

										<div class="comment div-inline question-btn-padding-right">
											<a class="see-comment" href="javascript:void(0)">
												<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>
												<span>45评论</span>
											</a>
										</div>

										<div class="answer-share div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>
												<span>分享</span>
											</a>
										</div>

										<div class="answer-share-type div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>
												<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>
												<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>
											</a>
										</div>

									</div>

									<div class="comment-container" style="margin-top: 30px;margin-bottom: 30px;background: #F0F0F0;">

										<div class="add-my-comment  div-inline" style="margin-bottom: 30px;">
											<div class="input-comment" style="padding-top: 30px;">
												<textarea name="desc" placeholder="" class="layui-textarea" autoHeight="true" style="margin-left: 30px; overflow:hidden; width:540px; height:120px; "></textarea>
											</div>
										</div>

										<div class="comment-submit" style="width: 510px;margin-left: 30px;
	height: 38px;
	background: #e2e2e2;">
											<button class="layui-btn" style="margin-left: 440px;width: 100px;">发表</button>
										</div>

										<div class="all-comments" style="margin-top: 30px;margin-bottom: 30px;">
											<div class="comment">
												<div class="layui-row">
													<div class="layui-col-md1">
														<img src="//t.cn/RCzsdCq" class="layui-nav-img" style="margin-left: 0px;width:40px;height:40px;">
													</div>
													<div class="layui-col-md11">
														<ul class="comment-list">
															<li class="comment-item">
																<a>啊啊啊啊啊</a>
																<div class="comment-text" style="margin-top: 5px;margin-bottom: 10px;">
																	是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是

																</div>
																<div class="comment-button">
																	<p style="margin-bottom: 10px;">2019-5-23</p>
																	<div class="upvote  div-inline question-btn-padding-right" style="margin-top: 5px;">
																		<a href="">
																			<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
																			<span>142赞</span>
																		</a>
																	</div>

																	<div class="downvote div-inline question-btn-padding-right">
																		<a href="">
																			<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
																			<span>12踩</span>
																		</a>
																	</div>

																	<div class="comment div-inline question-btn-padding-right">
																		<a href="">
																			<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>
																			<span>评论</span>
																		</a>
																	</div>
																</div>
															</li>
															<li class="comment-item">

															</li>

														</ul>
														<div class="load-more" style="margin-top: 30px; height: 50px;text-align:center;line-height:50px;">
															<a href="javascript:void(0)">点击加载更多</a>
														</div>
													</div>
												</div>

											</div>
										</div>

									</div>

									<hr />
								</div>
								<div class="one-answer">

									<div class="writer-info">
										<img src="//t.cn/RCzsdCq" class="layui-nav-img">
										<span>组织者组织&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
										<span>装BBBBBBBBBBBBBBBBBBBBB</span>
										<button class="layui-btn layui-btn-normal layui-btn-sm" style="margin-left: 170px;">&nbsp;&nbsp;&nbsp;+&nbsp;关注&nbsp;&nbsp;&nbsp;</button>
									</div>

									<div class="answer-content" style="margin-top: 30px;margin-bottom: 30px;">
										<p>如果你想叫农民满意那是办不到，农民懂得感恩吗？农民会满足吗？农民的需求是无止境的，朱之文给他们村做了那么多好事，最后的结局大家都看到了，村头碑砸了，还有人说每家给买辆小轿车，再给10000元我们才说他好，农民就是一群无法满足的无知懒蛋。</p>
										<p>首先说明一下，我也是农民，地地道道的农民，我最看不惯我们农民的作风，我们村有个尿毒症患者，国家一分钱不要，看一次病还给他50元，从来没有说过国家好，天天骂骂咧咧，到处找事，总感觉没有人敢惹他，确实也是，我们当地乡民政都怕他，最后死了，不是我爸爸都没有人帮忙埋他，确实恶贯满盈。</p>
										<p></p>
										<p></p>
									</div>

									<div class="answer-date">
										<p>最后编辑 2019-5-23</p>
									</div>

									<div class="answer-button" style="margin-top: 30px;">

										<div class="upvote  div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
												<span>142赞</span>
											</a>
										</div>

										<div class="downvote div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
												<span>12踩</span>
											</a>
										</div>

										<div class="comment div-inline question-btn-padding-right">
											<a class="see-comment" href="javascript:void(0)">
												<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>
												<span>45评论</span>
											</a>
										</div>

										<div class="answer-share div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>
												<span>分享</span>
											</a>
										</div>

										<div class="answer-share-type div-inline question-btn-padding-right">
											<a href="">
												<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>
												<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>
												<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>
											</a>
										</div>

									</div>

									<div class="comment-container" style="margin-top: 30px;margin-bottom: 30px;background: #F0F0F0;">

										<div class="add-my-comment  div-inline" style="margin-bottom: 30px;">
											<div class="input-comment" style="padding-top: 30px;">
												<textarea name="desc" placeholder="" class="layui-textarea" autoHeight="true" style="margin-left: 30px; overflow:hidden; width:540px; height:120px; "></textarea>
											</div>
										</div>

										<div class="comment-submit" style="width: 510px;margin-left: 30px;
	height: 38px;
	background: #e2e2e2;">
											<button class="layui-btn" style="margin-left: 440px;width: 100px;">发表</button>
										</div>

										<div class="all-comments" style="margin-top: 30px;margin-bottom: 30px;">
											<div class="comment">
												<div class="layui-row">
													<div class="layui-col-md1">
														<img src="//t.cn/RCzsdCq" class="layui-nav-img" style="margin-left: 0px;width:40px;height:40px;">
													</div>
													<div class="layui-col-md11">
														<ul class="comment-list">
															<li class="comment-item">
																<a>啊啊啊啊啊</a>
																<div class="comment-text" style="margin-top: 5px;margin-bottom: 10px;">
																	是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是是

																</div>
																<div class="comment-button">
																	<p style="margin-bottom: 10px;">2019-5-23</p>
																	<div class="upvote  div-inline question-btn-padding-right" style="margin-top: 5px;">
																		<a href="">
																			<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>
																			<span>142赞</span>
																		</a>
																	</div>

																	<div class="downvote div-inline question-btn-padding-right">
																		<a href="">
																			<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>
																			<span>12踩</span>
																		</a>
																	</div>

																	<div class="comment div-inline question-btn-padding-right">
																		<a href="">
																			<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>
																			<span>评论</span>
																		</a>
																	</div>
																</div>
															</li>
															<li class="comment-item">

															</li>

														</ul>

													</div>
												</div>
												<div class="load-more" style="background: #e2e2e2;margin-top: 30px; height: 50px;text-align:center;line-height:50px;">
													<span>点击加载更多</span>
												</div>
											</div>
										</div>

									</div>

									<hr />
								</div>

							</div>

						</div>

					</div>
					<div class="layui-col-md5 question-padding-left">
						<div class="user-info">

						</div>

					</div>

				</div>

			</div>

			<div class="layui-footer">
				<p style="margin-top:10px">© 2017 拴蛋头条 </p>
				<p>中国互联网举报中心京ICP证1401号京ICP备125439号-3京公网安备</p>
				<p> 联系方式：qq:18202415206 邮箱：tongyongxin@163.com </p>

			</div>

		</div>

	</body>

</html>