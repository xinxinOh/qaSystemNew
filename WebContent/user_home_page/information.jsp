<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>

<div class="user_infomation_box">
	<div class = "user_head"> 
		<div class = "acount_picture_class" onclick = "changeUserAccount()">
			<img class="layui-nav-img" src="Reaources/UserAccountPicture/${session.user.u_id}.jpg" style="width:100px;height:100px;z-index:3;position:absolute;"/>
			<img class="layui-nav-img" src="//t.cn/RCzsdCq" style="width:100px;height:100px;z-index:2;position:relative;"/>
		</div>
		
		<div class = "user_information_detail">
			<p class = "weight_font_color">${user.nickname}</p>
			<p class = "user_introduction light_font_color">${user.introduction}</p>
			<a class="layui-icon layui-icon-edit" style="font-size: 18px; color: darkolivegreen;" id="edit_user_information">编辑个人信息</a>
		</div>
		
		
	</div>
	
	
	<div class = "share">
		<p></p>
		<p class = "light_font_color shar_icon">分享</p>
		<p class="layui-icon layui-icon-login-wechat shar_icon" style="font-size: 20px; color: darkolivegreen;"></p>
		<p class="layui-icon layui-icon-login-qq shar_icon" style="font-size: 20px; color: darkolivegreen;"></p>
		<p class="layui-icon layui-icon-login-weibo shar_icon" style="font-size: 20px; color: darkolivegreen;"></p>
	</div>
</div>