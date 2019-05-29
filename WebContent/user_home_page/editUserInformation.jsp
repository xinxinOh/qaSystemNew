<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script>
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});

var birth_year = "${user.birthdate.year}";
if (birth_year < 1900) {
	birth_year = "${user.birthdate.year+2018-118}";
	//alert(birth_year);
}

layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#birthdate' ,//指定元素
    isInitValue: false,
    value: birth_year+"-"+"${user.birthdate.month}"+"-"+"${user.birthdate.day}"
  });
  


});
$("#user_content_return").click(function() {
	$("#content").load("<%=request.getContextPath()%>/user_home_page/content.jsp");
});
</script>

<div class = "user_edit_box">
	<form class="layui-form" action= "<%=request.getContextPath()%>/EditUserInfoServlet" method="post">
		<div class="layui-form-item">
    		<label class="layui-form-label">芥末名：</label>
    		<div class="layui-input-block">
      			<input type="text" name="user_nikname" placeholder="${user.nickname }" autocomplete="off" class="layui-input">
    		</div>
  		</div>
  
  	<div class="layui-form-item">
    	<label class="layui-form-label">性别</label>
    	<div class="layui-input-block">
    	<c:if test='${user.sex=="男"}'>
    		<input type="radio" name="user_sex" value="男" title="男" checked>
      		<input type="radio" name="user_sex" value="女" title="女" >
    	</c:if>
    	<c:if test='${user.sex=="女"}'>
    		<input type="radio" name="user_sex" value="男" title="男">
      		<input type="radio" name="user_sex" value="女" title="女" checked>
    	</c:if>
      	</div>
  	</div>
  	
  	<div class="layui-form-item layui-inline">
	  	<label class="layui-form-label">生日</label>
    	<div class="layui-input-block"> 
    		<input type="text" name="user_birthdate" class="layui-input" id="birthdate">
    	</div>
	  	
	</div>

  	<div class="layui-form-item layui-form-text">
    	<label class="layui-form-label">自我介绍</label>
    		<div class="layui-input-block">
      		<textarea name="user_introduction" placeholder="${user.introduction}" class="layui-textarea"></textarea>
    	</div>
  	</div>
  
  	<div class="layui-form-item">
    	<div class="layui-input-block">
      		<button class="layui-btn" type="submit">立即提交</button>
      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
      		<button type = "button" class ="layui-btn layui-btn-primary" id = "user_content_return">返回</button>
    	</div>
  	</div>
 
</form>
 
</div>