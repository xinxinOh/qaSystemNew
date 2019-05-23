<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>

<div class="user_infomation_box">
	<div class = "user_head"> 
		<div class = "acount_picture_class">
			<img class="user_account_picture defult" src="Reaources/UserAccountPicture/${session.user.u_id}.jpg"/>
			<img class="user_account_picture userset" src="Reaources/UserAccountPicture/void.jpg"/>
		</div>
		
		<div class = "user_information_detail">
			<p class = "weight_font_color">${user.nickname}</p>
			<p class = "user_introduction light_font_color">${user.introduction}</p>
			<a class="layui-icon layui-icon-edit" style="font-size: 30px; color: darkolivegreen;">编辑个人信息</a>
		</div>
		
		
	</div>
	
	
	<div class = "share">
		<p></p>
		<p class = "light_font_color">分享</p>
		<p class="layui-icon layui-icon-login-wechat" style="font-size: 30px; color: darkolivegreen;"></p>
		<p class="layui-icon layui-icon-login-qq" style="font-size: 30px; color: darkolivegreen;"></p>
		<p class="layui-icon layui-icon-login-weibo" style="font-size: 30px; color: darkolivegreen;"></p>
	</div>
</div>