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
		<script src="<%=request.getContextPath()%>/layui/layer/layer.js"></script>
		<script type="text/javascript">
			var Follow_user = load_user_follow("bfdshter4");

			function load_user_follow(user_id) {
				var Follow_userid = new Array()
				$.ajax({
					async: false,
					type: "GET",
					url: "FollowUserServlet?type=allfollow&user_id=" + user_id + "&start=" + "0" + "&end=" + "1000",
					dataType: "text",
					success: function(data_user) {

						$.each($.parseJSON(data_user), function(idx_user, obj_user) {
							Follow_userid[idx_user] = obj_user.follow_user_id;
						})
					},
					error: function() {
						alert(123);
					}
				});
				return Follow_userid;
			}

			function check_follow() {
				var str = "follow-user-id-";
				var follow_id = "";
				alert(Follow_user[0]);
				for(x in Follow_user) {

					follow_id = str + Follow_user[x];
					$("button[id='" + follow_id + "'").text("已关注");
				}
			}

			function Search_user_name(user_id) {
				var nickname = "error";
				$.ajax({
					async: false,
					type: "GET",
					url: "LoadAnswerServlet?type=user&user_id=" + user_id,
					dataType: "text",
					success: function(data_user) {
						nickname = $.parseJSON(data_user).nickname;
					},
					error: function() {
						alert(123);
					}
				});

				return nickname;
			}

			function loadAnswer() {
				$.ajax({
					async: false,
					type: "GET",
					url: "LoadAnswerServlet?type=answer&question_id=" + "1" + "&start=" + $('.all-answers').children().length + "&end=" + $('.all-answers').children().length + 3,
					dataType: "text",
					success: function(data_answer) {
						if($.parseJSON(data_answer) == "") {
							layer.msg('已经到底啦！');
						}
						$.each($.parseJSON(data_answer), function(idx_answer, obj_answer) {
							user_id = obj_answer.user_id;
							answer_id = obj_answer.answer_id;
							$.ajax({
								async: false,
								type: "GET",
								url: "LoadAnswerServlet?type=user&user_id=" + user_id,
								dataType: "text",
								success: function(data_user) {
									var new_data = $.parseJSON(data_user);

									var odiv = '<div class="one-answer">' +
										'<div class="writer-info">' +
										'<img src="//t.cn/RCzsdCq" class="layui-nav-img">' +
										'<span>' + new_data.nickname + '&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;' + '</span>' +
										'<span>' + new_data.introduction + '</span>' +
										'<button class="layui-btn layui-btn-normal layui-btn-sm user-follow" style="float:right;" id=follow-user-id-' + new_data.user_id + ' >' + '&nbsp;&nbsp;&nbsp;+&nbsp;关注&nbsp;&nbsp;&nbsp;</button>' +
										'</div>' +
										'<div class="answer-content" style="margin-top: 30px;margin-bottom: 30px;">' +
										'<p>' + obj_answer.content + '</p>' +
										'</div>' +
										'<div class="answer-date">' +
										'<p>最后编辑' + obj_answer.answer_date + '</p>' +
										'</div>' +
										'<div class="answer-button" style="margin-top: 30px;">' +
										'<div class="upvote  div-inline question-btn-padding-right">' +
										'<a class="answer-upvote" href="javascript:void(0)" id=answer-upvote-' + obj_answer.answer_id + '>' +
										'<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>' +
										'<span>' + obj_answer.upvote_num + '赞</span>' +
										'</a>' +
										'</div>' +
										'<div class="downvote div-inline question-btn-padding-right">' +
										'<a class="answer-downvote" href="javascript:void(0)" id=answer-downvote-' + obj_answer.answer_id + '>' +
										'<i class="layui-icon layui-icon-tread" style="font-size: 20px; color: #1E9FFF;"></i>' +
										'<span>' + obj_answer.downvote_num + '踩</span>' +
										'</a>' +
										'</div>' +
										'<div class="comment div-inline question-btn-padding-right">' +
										'<a class="see-comment" href="javascript:void(0)">' +
										'<i class="layui-icon layui-icon-reply-fill" style="font-size: 20px; color: #1E9FFF;"></i>' +
										'<span>' + obj_answer.comment_num + '评论</span>' +
										'</a>' +
										'</div>' +
										'<div class="answer-share div-inline question-btn-padding-right">' +
										'<a href="">' +
										'<i class="layui-icon layui-icon-release" style="font-size: 20px; color: #1E9FFF;"></i>' +
										'<span>分享</span>' +
										'</a>' +
										'</div>' +
										'<div class="answer-share-type div-inline question-btn-padding-right">' +
										'<a href="">' +
										'<i class="layui-icon layui-icon-login-wechat" style="font-size: 20px; color: #1E9FFF;"></i>' +
										'<i class="layui-icon layui-icon-login-qq" style="font-size: 20px; color: #1E9FFF;"></i>' +
										'<i class="layui-icon layui-icon-login-weibo" style="font-size: 20px; color: #1E9FFF;"></i>' +
										'</a>' +
										'</div>' +
										'</div>' +
										'<div class="comment-container" style="margin-top: 30px;margin-bottom: 30px;background: #F0F0F0;">' +
										'<div class="add-my-comment  div-inline" style="margin-bottom: 30px;">' +
										'<div class="input-comment" style="padding-top: 30px;">' +
										'<textarea id=textarea-answer-' + obj_answer.answer_id + ' name="desc" placeholder="" class="layui-textarea" autoHeight="true" style="margin-left: 30px; width:540px; height:120px; "></textarea>' +
										'</div>' +
										'</div>' +
										'<div class="comment-submit" style="width: 510px;margin-left: 30px;height: 38px;">' +
										'<button class="layui-btn comment-submit-btn" style="margin-left: 440px;width: 100px;">发表</button>' +
										'</div>' +
										'<div class="all-comments" style="margin-top: 30px;margin-bottom: 30px;">' +

										'<ul class="comment" id=answer_' + answer_id + '>' +

										'</ul>' +

										'<div class="load-more" style="margin-top: 30px; height: 50px;text-align:center;line-height:50px;">' +
										'<a href="javascript:void(0)">点击加载更多</a>' +
										'</div>' +
										'</div>' +
										'</div>' +
										'<hr />' +
										'</div>';

									$(".all-answers").append(odiv);
									$(".see-comment").parent().parent().next().hide();

								},
								error: function() {
									alert(123);
								}
							});

							$.ajax({
								async: false,
								type: "GET",
								url: "LoadAnswerServlet?type=comment&answer_id=" + answer_id + "&start=" + "1" + "&end=" + "4",
								dataType: "text",
								success: function(data_comment) {

									$.each($.parseJSON(data_comment), function(idx_comment, obj_comment) {
										var comment_li =
											'<li class="comment-item">' +
											'<div class="layui-row">' +
											'<div class="layui-col-md1">' +
											'<img src="//t.cn/RCzsdCq" class="layui-nav-img" style="margin-left: 0px;width:40px;height:40px;">' +
											'</div>' +
											'<div class="layui-col-md11">' +

											'<a>' + Search_user_name(obj_comment.user_id) + '</a>' +
											'<div class="comment-text" style="margin-top: 5px;margin-bottom: 10px;">' +
											obj_comment.content +
											'</div>' +

											'<div class="comment-button">' +
											'<p style="margin-bottom: 10px;">' + obj_comment.comment_date + '</p>' +
											'<div class="upvote  div-inline question-btn-padding-right" style="margin-top: 5px;">' +
											'<a class="comment-upvote" href="javascript:void(0)" id=comment-upvote-' + obj_comment.comment_id + '>' +
											'<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>' +
											'<span>' + obj_comment.upvote_num + '赞</span>' +
											'</a>' +
											'</div>' +
											'<div class="downvote div-inline question-btn-padding-right">' +
											'<a class="comment-downvote" href="javascript:void(0)" id=comment-downvote-' + obj_comment.comment_id + '>' +
											'<i class="layui-icon layui-icon-tread " style="font-size: 20px; color: #1E9FFF;"></i>' +
											'<span>' + obj_comment.downvote_num + '踩</span>' +
											'</a>' +
											'</div>' +
											'<div class="comment div-inline question-btn-padding-right">' +
											'<a class ="comment-answer" href="javascript:void(0)" id=answer-user-id-' + obj_comment.user_id + ' >' +
											'<i class="layui-icon layui-icon-reply-fill " style="font-size: 20px; color: #1E9FFF;"></i>' +
											'<span>评论</span>' +
											'</a>' +
											'</div>' +
											'</div>' +

											'<ul class="second-comment" id=comment_' + obj_comment.comment_id + '>' +

											'</ul>' +

											'</div>' +
											'</div>' +

											'</li>';

										var search_answer_id = "answer_" + answer_id;
										$("ul[id='" + search_answer_id + "'").append(comment_li);

										$.ajax({
											async: false,
											type: "GET",
											url: "LoadAnswerServlet?type=second_comment&comment_id=" + obj_comment.comment_id + "&start=" + "1" + "&end=" + "3",
											dataType: "text",
											success: function(data_second_comment) {

												$.each($.parseJSON(data_second_comment), function(idx_second_comment, obj_second_comment) {
													var seconde_comment_li = '<li class="second-comment-item">' +

														'<div class="layui-row">' +
														'<div class="layui-col-md1">' +
														'<img src="//t.cn/RCzsdCq" class="layui-nav-img" style="margin-left: 0px;width:40px;height:40px;">' +
														'</div>' +
														'<div class="layui-col-md11">' +

														'<a>' + Search_user_name(obj_second_comment.user_id) + '</a>' +
														'<div class="comment-text" style="margin-top: 5px;margin-bottom: 10px;">' +
														obj_second_comment.content +
														'</div>' +

														'<div class="comment-button">' +
														'<p style="margin-bottom: 10px;">' + obj_second_comment.comment_date + '</p>' +
														'<div class="upvote  div-inline question-btn-padding-right" style="margin-top: 5px;">' +
														'<a class="comment-upvote" href="javascript:void(0)" id=comment-upvote-' + obj_second_comment.comment_id + '>' +
														'<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>' +
														'<span>' + obj_second_comment.upvote_num + '赞</span>' +
														'</a>' +
														'</div>' +
														'<div class="downvote div-inline question-btn-padding-right">' +
														'<a class="comment-downvote" href="javascript:void(0)" id=comment-downvote-' + obj_second_comment.comment_id + '>' +
														'<i class="layui-icon layui-icon-tread " style="font-size: 20px; color: #1E9FFF;"></i>' +
														'<span>' + obj_second_comment.downvote_num + '踩</span>' +
														'</a>' +
														'</div>' +
														'<div class="comment div-inline question-btn-padding-right">' +
														'<a class ="second-comment" href="javascript:void(0)" id=comment-user-id-' + obj_second_comment.user_id + ' >' +
														'<i class="layui-icon layui-icon-reply-fill " style="font-size: 20px; color: #1E9FFF;"></i>' +
														'<span>评论</span>' +
														'</a>' +
														'</div>' +
														'</div>' +

														'</div>' +
														'</div>' +

														'</li>';

													var search_comment_id = "comment_" + obj_comment.comment_id;
													$("ul[id='" + search_comment_id + "'").append(seconde_comment_li);
												})

											},
											error: function() {
												alert(123);
											}
										});
									})
								},
								error: function() {
									alert(123);
								}
							});
						})

					},
					error: function() {
						alert(123);
					}
				});

			}

			function addNewComment(content) {

				var comment_li =
					'<li class="comment-item">' +
					'<div class="layui-row">' +
					'<div class="layui-col-md1">' +
					'<img src="//t.cn/RCzsdCq" class="layui-nav-img" style="margin-left: 0px;width:40px;height:40px;">' +
					'</div>' +
					'<div class="layui-col-md11">' +

					'<a>' + Search_user_name("bfdshter4") + '</a>' +
					'<div class="comment-text" style="margin-top: 5px;margin-bottom: 10px;">' +
					content +
					'</div>' +

					'<div class="comment-button">' +
					'<p style="margin-bottom: 10px;">' + new Date() + '</p>' +
					'<div class="upvote  div-inline question-btn-padding-right" style="margin-top: 5px;">' +
					'<a class="comment-upvote" href="javascript:void(0)">' +
					'<i class="layui-icon layui-icon-praise " style="font-size: 20px; color: #1E9FFF;"></i>' +
					'<span>0赞</span>' +
					'</a>' +
					'</div>' +
					'<div class="downvote div-inline question-btn-padding-right">' +
					'<a class="comment-downvote" href="javascript:void(0)" >' +
					'<i class="layui-icon layui-icon-tread " style="font-size: 20px; color: #1E9FFF;"></i>' +
					'<span>0踩</span>' +
					'</a>' +
					'</div>' +
					'<div class="comment div-inline question-btn-padding-right">' +
					'<a class ="comment-answer" href="javascript:void(0)">' +
					'<i class="layui-icon layui-icon-reply-fill " style="font-size: 20px; color: #1E9FFF;"></i>' +
					'<span>评论</span>' +
					'</a>' +
					'</div>' +
					'</div>' +

					'<ul class="second-comment">' +

					'</ul>' +

					'</div>' +
					'</div>' +

					'</li>';

				var search_answer_id = "answer_" + answer_id;
				$("ul[id='" + search_answer_id + "'").append(comment_li);
			}

			$(document).ready(function() {
				loadAnswer();
				check_follow();
				$(".see-comment").parent().parent().next().hide();
				$(document).scroll(function() {
					//滚动条滑动的时候获取滚动条距离顶部的距离
					var scroll = $(document).scrollTop();
					//屏幕的高度
					var client = $(window).height();
					var h = $(document).height();
					var flag = true;
					if(h <= scroll + client) { // 到达底部时,加载新内容
						if(flag == false) {
							return;
						}

						loadAnswer();

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

				$("body").on("click", ".see-comment", function() {

					$(this).parent().parent().next().toggle();

				});

				$("body").on("click", ".comment-answer", function() {

					var user_id = $(this).attr('id').split('-')[3];
					var nickname = Search_user_name(user_id);
					$("textarea[id='" + "textarea-answer-" + $(this).parent().parent().parent().parent().parent().parent().attr('id').split('_')[1] + "'").val("//@" + nickname + " ");
				});

				$("body").on("click", ".second-comment", function() {

					var user_id = $(this).attr('id').split('-')[3];
					var nickname = Search_user_name(user_id);
					$("textarea[id='" + "textarea-answer-" + $(this).parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().attr('id').split('_')[1] + "'").val("//@" + nickname + " ");

				});

				$("body").on("click", ".answer-upvote", function() {

					var answer_id = $(this).attr('id').split('-')[2];
					var s = $(this).find("span");

					$.ajax({
						type: "GET",
						url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "1" + "&category=" + "0",
						dataType: "text",
						success: function(data) {
							if(data == 1) {
								var upvote_num = parseInt(s.text().replace("赞", "")) + 1; //截取数字
								s.html(upvote_num + "赞");
								s.text(upvote_num + "赞");
							}

							if(data == 0) {

								layer.confirm('您已赞过该回答，是否取消赞？', {
									btn: ['不取消', '取消赞'] //按钮
								}, function() {
									layer.msg('', {
										icon: 1,
										time: 1,
										isOutAnim: false
									});
								}, function() {
									$.ajax({
										type: "GET",
										url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "3" + "&category=" + "0",
										dataType: "text",
										success: function(data_quxiao) {
											if(data_quxiao == 1) {

												var upvote_num = parseInt(s.text().replace("赞", "")) - 1; //截取数字
												s.html(upvote_num + "赞");
												s.text(upvote_num + "赞");

												layer.msg('取消赞成功', {
													icon: 1
												});
											}
											if(data_quxiao == 0) {
												layer.msg('取消赞失败', {
													icon: 1
												});
											}
										},
										error: function() {
											alert(123);
										}
									});

								});
							}
						},
						error: function() {
							alert(123);
						}
					});

				});

				$("body").on("click", ".answer-downvote", function() {

					var answer_id = $(this).attr('id').split('-')[2];
					var s = $(this).find("span");

					$.ajax({
						type: "GET",
						url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "0" + "&category=" + "0",
						dataType: "text",
						success: function(data) {
							if(data == 1) {
								var downvote_num = parseInt(s.text().replace("踩", "")) + 1; //截取数字
								s.html(downvote_num + "踩");
								s.text(downvote_num + "踩");
							}
							if(data == 0) {

								layer.confirm('您已踩过该回答，是否取消踩？', {
									btn: ['不取消', '取消踩'] //按钮
								}, function() {
									layer.msg('', {
										icon: 1,
										time: 1,
										isOutAnim: false
									});
								}, function() {
									$.ajax({
										type: "GET",
										url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "2" + "&category=" + "0",
										dataType: "text",
										success: function(data_quxiao) {
											if(data_quxiao == 1) {

												var downvote_num = parseInt(s.text().replace("踩", "")) - 1; //截取数字
												s.html(downvote_num + "踩");
												s.text(downvote_num + "踩");

												layer.msg('取消踩成功', {
													icon: 1
												});
											}
											if(data_quxiao == 0) {
												layer.msg('取消踩失败', {
													icon: 1
												});
											}
										},
										error: function() {
											alert(123);
										}
									});

								});
							}
						},
						error: function() {
							alert(123);
						}
					});

				});

				$("body").on("click", ".comment-upvote", function() {

					var answer_id = $(this).attr('id').split('-')[2];
					var s = $(this).find("span");

					$.ajax({
						type: "GET",
						url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "1" + "&category=" + "1",
						dataType: "text",
						success: function(data) {
							if(data == 1) {
								var upvote_num = parseInt(s.text().replace("赞", "")) + 1; //截取数字
								s.html(upvote_num + "赞");
								s.text(upvote_num + "赞");
							}

							if(data == 0) {

								layer.confirm('您已赞过该评论，是否取消赞？', {
									btn: ['不取消', '取消赞'] //按钮
								}, function() {
									layer.msg('', {
										icon: 1,
										time: 1,
										isOutAnim: false
									});
								}, function() {
									$.ajax({
										type: "GET",
										url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "3" + "&category=" + "1",
										dataType: "text",
										success: function(data_quxiao) {
											if(data_quxiao == 1) {

												var upvote_num = parseInt(s.text().replace("赞", "")) - 1; //截取数字
												s.html(upvote_num + "赞");
												s.text(upvote_num + "赞");

												layer.msg('取消赞成功', {
													icon: 1
												});
											}
											if(data_quxiao == 0) {
												layer.msg('取消赞失败', {
													icon: 1
												});
											}
										},
										error: function() {
											alert(123);
										}
									});

								});
							}
						},
						error: function() {
							alert(123);
						}
					});

				});

				$("body").on("click", ".comment-downvote", function() {

					var answer_id = $(this).attr('id').split('-')[2];
					var s = $(this).find("span");

					$.ajax({
						type: "GET",
						url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "0" + "&category=" + "1",
						dataType: "text",
						success: function(data) {
							if(data == 1) {
								var downvote_num = parseInt(s.text().replace("踩", "")) + 1; //截取数字
								s.html(downvote_num + "踩");
								s.text(downvote_num + "踩");
							}
							if(data == 0) {

								layer.confirm('您已踩过该评论，是否取消踩？', {
									btn: ['不取消', '取消踩'] //按钮
								}, function() {
									layer.msg('', {
										icon: 1,
										time: 1,
										isOutAnim: false
									});
								}, function() {
									$.ajax({
										type: "GET",
										url: "VoteServlet?user_id=" + "bfdshter4" + "&to_id=" + answer_id + "&type=" + "2" + "&category=" + "1",
										dataType: "text",
										success: function(data_quxiao) {
											if(data_quxiao == 1) {

												var downvote_num = parseInt(s.text().replace("踩", "")) - 1; //截取数字
												s.html(downvote_num + "踩");
												s.text(downvote_num + "踩");

												layer.msg('取消踩成功', {
													icon: 1
												});
											}
											if(data_quxiao == 0) {
												layer.msg('取消踩失败', {
													icon: 1
												});
											}
										},
										error: function() {
											alert(123);
										}
									});

								});
							}
						},
						error: function() {
							alert(123);
						}
					});

				});

				$("body").on("click", ".comment-submit-btn", function() {
					var answer_id = $(this).parent().prev().find("textarea").attr('id').split('-')[2];
					var content = $(this).parent().prev().find("textarea").val();
					var s = $(this).parent().parent().prev().children(".comment").find("span");
					$.ajax({
						type: "GET",
						url: "UserCommentServlet?type=answer_comment&answer_id=" + answer_id + "&content=" + content + "&user_id=" + "bfdshter4",
						dataType: "text",
						success: function(data) {
							layer.msg('评论成功');
							addNewComment(content, answer_id);
							var comment_num = parseInt(s.text().replace("踩", "")) + 1; //截取数字
							s.text(comment_num + "评论");
						},
						error: function() {
							alert(123);
						}
					});
				});

				$("body").on("click", ".answer-question-btn", function() {
					var question_id = $($("body").children("div").get(0)).attr('id').split('-')[1];
					var content = $(this).parent().parent().prev().find("textarea").val();
					var s = $(this).parent().parent().prev().children(".comment").find("span");
					$.ajax({
						type: "GET",
						url: "AnswerServlet?question_id=" + question_id + "&content=" + content + "&user_id=" + "bfdshter4",
						dataType: "text",
						success: function(data) {
							if(data == 1) {
								layer.msg('回答成功');
							} else {
								layer.msg(data);
							}
						},
						error: function() {
							alert(123);
						}
					});
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

				$("body").on("click", ".user-follow", function() {

					var to_user_id = $(this).attr('id').split('-')[3];
					var s = $(this).find("span");
					var this_temo = $(this);
					var this_str = $(this).text();
					if(this_str.indexOf("已关注") >= 0) {
						layer.confirm('您已关注过，是否取消关注？', {
							btn: ['不取消', '取消关注'] //按钮
						}, function() {
							layer.msg('', {
								icon: 1,
								time: 1,
								isOutAnim: false
							});
						}, function() {
							$.ajax({
								async: false,
								type: "GET",
								url: "FollowUserServlet?type=delete&user_id=" + "bfdshter4" + "&to_user_id=" + to_user_id,
								dataType: "text",
								success: function(data_quxiao) {
									if(data_quxiao == 1) {
										layer.msg('取消成功', {
											icon: 1
										});
										this_temo.text("+关注");
									}
									if(data_quxiao == 0) {
										layer.msg('取消失败', {
											icon: 1
										});
									}
								},
								error: function() {
									alert(123);
								}
							});

						});
					}
					if(this_str.indexOf("已关注") < 0) {
						$.ajax({
							async: false,
							type: "GET",
							url: "FollowUserServlet?type=add&user_id=" + "bfdshter4" + "&to_user_id=" + to_user_id,
							dataType: "text",
							success: function(data) {
								if(data == 1) {
									this_temo.text("已关注");
									layer.msg('关注成功', {
										icon: 1,
									});
								}
							},
							error: function() {
								alert(123);
							}
						});
					}
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

		<div id="question-1">
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
												<button class="layui-btn answer-question-btn">回答</button>
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