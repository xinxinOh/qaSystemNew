<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>开始使用layui</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">

<script src="<%=request.getContextPath()%>/layui/layui.all.js"></script>

</head>
<body>
       <ul class="layui-nav" style="background-color:darkolivegreen;">
      <li class="layui-nav-item">
       <a href="">图标</a>
      </li>
    
     
      <li class="layui-nav-item" style="float: right;">
        <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">个人中心</a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;">修改信息</a></dd>
          <dd><a href="javascript:;">安全管理</a></dd>
          <dd><a href="javascript:;">退了</a></dd>
        </dl>
      </li>
      
      <li class="layui-nav-item" style="float: right;">
        <a href="">回到首页</a>
      </li>
      
       <li class="layui-nav-item" style="float: right;">
       	<form class="layui-form" action="" method='post'>
       		    <div class="layui-input-inline" style="margin-top: 17px;">
      						<input style="width: 330px;height:30px;" name="title" required  placeholder="请输入想查询的问题" autocomplete="off" class="layui-input"> 
   				</div>
       	</form>
      </li>
    </ul>
          
          
</body>
</html>
