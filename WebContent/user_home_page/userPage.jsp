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