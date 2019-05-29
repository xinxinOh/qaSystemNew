<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/register.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
<script src="<%=request.getContextPath()%>/layui/layui.all.js"></script>
</head>
<body>

    <div class="form" style="position:relative">
        <div class="form_register" style="position:absolute">  
            <form action="registerServlet"  method="post">
                <h1>注册</h1>
                <div class="form_item">
                    <label for="username">用户名:</label>
                    <input type="text" name="username" id="username" placeholder="请输入用户名" required >
                  <div class="layui-form-mid layui-word-aux">请输入自定义用户名</div>
                </div>
                <div class="form_item">
                    <label for="password">密码:</label>
                    <input type="password" name="password" id="password" placeholder="请输入密码名"  style="ime-mode:disabled;-webkit-ime-mode:inactive;"  required>
                 <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                </div>
                <div class="form_item">
                    <label for="">验证码:</label>
                    <input type="text"  id="key" placeholder="请输入验证码--区分大小写"  name="code" value="" style="ime-mode:disabled;-webkit-ime-mode:inactive;" onBlur="textBlur(this)" onFocus=" textFocus(this) "  required />
                    <input type="hidden" name="yzmH" id="yzmH"/>
                    <span class="add phoKey"></span>
                    <span class="error error7"></span>
                </div>
                <div class="form_item">
                    <input type="submit" value="注册">
                </div>
            </form>	
            <div class="info">已有账号？点击<a href="login.jsp"><span>登录</span></a></div>
        </div>
	
</body>
</html>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript" src="js/jquery.md5.js" ></script> 
<script>
/*生成验证码  ---区分大小写*/
create_code();
function create_code() {
    function shuffle() {
        var arr = ['1', 'r', 'Q', '4', 'S', '6', 'w', 'u', 'D', 'I', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', '2', 's', 't', '8', 'v', '7', 'x', 'y', 'z', 'A', 'B', 'C', '9', 'E', 'F', 'G', 'H', '0', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '3', 'R',
            '5', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
        return arr.sort(function () {     /*随机数组排序*/
            return (Math.random() - .5);
        });
    };
    shuffle();
    function show_code() {
        var ar1 = '';
        var code = shuffle();
        for (var i = 0; i < 5; i++) {
            ar1 += code[i];
        };
        document.getElementById("yzmH").value=ar1;
        $(".phoKey").text(ar1);
    };
    show_code();
        $(".phoKey").click(function () {
        show_code();
       
    });
}
//md5加密
var pwd = $(input[name=password]).val();
//加密成md5
//var newword = $.md5(pwd);   //调用$.md5()函数进行数据加密

$.ajax({
url:'/registerServlet',
type:'post', 
async:true,    
data: {
username: username,
password:  pwd
},
contentType: "application/json; charset=utf-8",
dataType:'json',    //返回的数据格式
success:function(data){
alert("加密成功");
console.log(data);
},
error:function() {        
alert("异常！");      
}
})    



</script>


