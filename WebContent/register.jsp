<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
		<script src="./js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="./js/md5.js"></script>
		<script src="<%=request.getContextPath()%>/layui/layui.all.js"></script>
	</head>

	<body>

		<div class="form" style="position:relative">
			<div class="form_register" style="position:absolute">
				<form action="<%=request.getContextPath()%>/registerServlet" method="post">
					<h1>注册</h1>
					<div class="form_item">
						<label for="username">用户名:</label>
						<input type="text" name="username" id="username" placeholder="请输入用户名" required>
						<div class="layui-form-mid layui-word-aux">请输入自定义用户名</div>
					</div>
					<div class="form_item">
						<label for="password">密码:</label>
						<input type="password" name="password" id="password" placeholder="请输入密码" style="ime-mode:disabled;-webkit-ime-mode:inactive;" required>
						<div class="layui-form-mid layui-word-aux">请填写6到18位密码</div>
					</div>
					<div class="form_item">
						<label for="">验证码:</label>
						<input type="text" id="key" placeholder="请输入验证码--区分大小写" name="code" value="" style="ime-mode:disabled;-webkit-ime-mode:inactive;" onBlur="textBlur(this)" onFocus=" textFocus(this) " required />
						<input type="hidden" name="yzmH" id="yzmH" />
						<span class="add phoKey"></span>
						<span class="error error7"></span>
					</div>
					<div class="form_item">
						<input class="submit-from-btn" type="submit" value="注册">
					</div>
				</form>
				<div class="info">已有账号？点击
					<a href="<%=request.getContextPath()%>/login.jsp"><span>登录</span></a>
				</div>
			</div>
		</div>
	</body>

</html>

<script type="text/javascript">
	/*生成验证码  ---区分大小写*/
	create_code();

	function create_code() {
		function shuffle() {
			var arr = ['1', 'r', 'Q', '4', 'S', '6', 'w', 'u', 'D', 'I', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', '2', 's', 't', '8', 'v', '7', 'x', 'y', 'z', 'A', 'B', 'C', '9', 'E', 'F', 'G', 'H', '0', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '3', 'R',
				'5', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
			];
			return arr.sort(function() { /*随机数组排序*/
				return(Math.random() - .5);
			});
		};
		shuffle();

		function show_code() {
			var ar1 = '';
			var code = shuffle();
			for(var i = 0; i < 5; i++) {
				ar1 += code[i];
			};
			document.getElementById("yzmH").value = ar1;
			$(".phoKey").text(ar1);
		};
		show_code();
		$(".phoKey").click(function() {
			show_code();

		});
	}

	//md5加密
	var pwd = $("input[name=password]").val();
	//var newword = $.md5(pwd);   //调用$.md5()函数进行数据加密
	var un = $("input[name=username]").val();
	//输入框提示
	$(".submit-from-btn").click(function() {
		var pattern = /^[a-zA-Z]\w{5,17}$/;
		var str = $("#username").val();
		var s = pattern.test(str);
		console.log(pattern.test(str));
		if(s == true) {
			var pattern = /^[a-zA-Z]\w{5,17}$/;
			var str = $("#password").val();
			var s = pattern.test(str);
			console.log(pattern.test(str));
			if(s == true) {
				return;
			} else {
				layer.msg('请输入以字母开头的密码！');
				$("#password").attr("value", "");
				return;
			}
		} else {
			layer.msg('请输入正确的用户名！');
			$("#username").attr("value", "");
			return;
		}

		$.ajax({
			url: '<%=request.getContextPath()%>/registerServlet',
			type: 'post',
			async: true,
			data: {
				username: un,
				password: pwd
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json', //返回的数据格式
			success: function(data) {
				console.log(data);
			},
			error: function(data) {
				layer.msg('error！');
			}

		})

	});

	$(document).keydown(function(event) {
		if(event.keyCode == "13") {
			alert("确认要提交么？");

		}
	});
</script>