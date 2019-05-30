<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<script src="./js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="./js/md5.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">

		<script src="<%=request.getContextPath()%>/layui/layui.all.js"></script>
		<script src="<%=request.getContextPath()%>/layui/layer/layer.js"></script>

	</head>

	<body>

		<div class="form" style="position:relative">
			<div class="form_register" style="position:absolute">
				<form action="<%=request.getContextPath()%>/loginServlet" method="post">
					<h1>登录</h1>
					<div class="form_item">
						<label for="username">用户名:</label>
						<input type="text" name="username" id="username" placeholder="请输入用户名" required>
						<div class="layui-form-mid layui-word-aux">请填写正确的用户名</div>
					</div>
					<div class="form_item">
						<label for="password">密码:</label>
						<input type="password" name="password" id="password" placeholder="请输入密码名" style="ime-mode:disabled;-webkit-ime-mode:inactive;" required>
						<div class="layui-form-mid layui-word-aux">请填写6到18位密码</div>
					</div>
					<div class="form_item">
						<input class="submit-from-btn" type="submit" value="登录">
					</div>
				</form>
				<div class="info">没有账号？点击
					<a href="<%=request.getContextPath()%>/register.jsp"><span>注册</span></a>
				</div>
			</div>
		</div>
	</body>

</html>

<script type="text/javascript">
	var pwd = $("input[name=password]").val();
	//加密成md5
	//var pass = $.md5(pwd);   //调用$.md5()函数进行数据加密

	$.ajax({
		url: '/loginServlet',
		type: 'post',
		async: true,
		data: {
			username: username,
			password: pwd
		},
		contentType: "application/json; charset=utf-8",
		dataType: 'json', //返回的数据格式
		success: function(data) {
			alert("加密成功");
			console.log(data);
		},
		error: function(data) {
			alert("异常！");
		}

	})

	$(document).keydown(function(event) {
		if(event.keyCode == "13") {
			alert("确认要提交么？");

		}
	});
</script>