<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/user_home_page/userHeader.jsp" %>
<%@include file="/header.jsp" %>


<script>
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>

<div class = "user_edit_box">
	<form class="layui-form" action= "/qaSystem/editUserInfoService">
		<div class="layui-form-item">
    		<label class="layui-form-label">芥末名：</label>
    		<div class="layui-input-block">
      			<input type="text" name="user_name" placeholder="${user.nickname }" autocomplete="off" class="layui-input">
    		</div>
  		</div>
  
  	<div class="layui-form-item">
    	<label class="layui-form-label">单选框</label>
    	<div class="layui-input-block">
    	<c:if test="${user.sex}.equals("男")>
    		<input type="radio" name="user_sex" value="男" title="男" checked>
      		<input type="radio" name="user_sex" value="女" title="女" >
    	</c:if>
    	<c:if test="${user.sex}。equals("女")>
    		<input type="radio" name="user_sex" value="男" title="男">
      		<input type="radio" name="user_sex" value="女" title="女" checked>
    	</c:if>
      	</div>
  	</div>
  
  	<div class="layui-form-item layui-form-text">
    	<label class="layui-form-label">文本域</label>
    		<div class="layui-input-block">
      		<textarea name="user_introduction" placeholder="${user.introduction}" class="layui-textarea"></textarea>
    	</div>
  	</div>
  
  	<div class="layui-form-item">
    	<div class="layui-input-block">
      		<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
    	</div>
  	</div>
  
</form>
 
</div>