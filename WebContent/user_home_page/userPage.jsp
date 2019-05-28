<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/header.jsp" %>
<script>
$(function () {
	$("#content").load("/qaSystem/user_home_page/content.jsp");
	
	$("#edit_user_information").click(function() {
		$("#content").load("/qaSystem/user_home_page/editUserInformation.jsp");
		
	});
});

//更改用户头像
function changeUserAccount() {
	layer.open({
		  title: ''
		  ,btn:[]
		  ,content: '<p>点击上传的头像</p>'
		  +'<button type="button" class="layui-btn" id="test1">'
		  +' <i class="layui-icon">&#xe67c;</i>上传图片'
		  +'</button>'
		}); 
	

	layui.use('upload', function(){
		  var upload = layui.upload;
		   
		  //执行实例
		  var uploadInst = upload.render({
		    elem: '#test1' //绑定元素
		    ,data:{name:"picture"}
		    ,url: '/qaSystem/UserAccountPictureServlet?servletType = batchInFiles' //上传接口
		    ,accept:'images'
		    ,done: function(){
		    	layer.open({
		  		  title: ''
		  		  ,btn:[]
		  		  ,content: '<p>上传成功</p>'
		  		});
		    }
		    ,error: function(){
		    	layer.open({
			  		  title: ''
			  		  ,btn:[]
			  		  ,content: '<p>上传失败</p>'
			  		});
		    }
		  });
		});
}
    
 
</script>

</head>

<body>
<%@include file="/Navbar.jsp" %>
	
	<div class = "layui-fluid userPage">
		<div class = "layui-container layui-col-md-offset1">
		
    	<div class="layui-col-md3 layui-row-space10">
     	  <%@include file="/user_home_page/information.jsp" %>
    	</div>
    	<div class="layui-col-md7 layui-row-space10">
    		<div>
    		<div id = "content">
    		</div>
    		</div>
    	</div>
    	
		</div>
		
	</div>
</body>
</html>