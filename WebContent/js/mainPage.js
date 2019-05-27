window.onload = function() {

	var ajax = new XMLHttpRequest();

	//2. 连接服务器的servlet  ,参数(method,servlet名称,是否异步提交)
	ajax.open('get', 'LoadQuestionServlet', true);

	//3.发送ajax请求
	ajax.send();

	//4.处理服务器的回应
	ajax.onload = function() {
		alert("adada");
		/*var  s = xhr.responseText;
	
		if(s=='1'){
			document.getElementById("message").innerHTML="用户名重复";
		}else{
			document.getElementById("message").innerHTML="用户名不重复,可以注册";
		}*/
	}
}

function getCategory(cate) {
alert("in getcategory method");
	$.ajax({
		type: "GET",
		url: "LoadCategoryQuestionServlet?category="+cate,
		dataType: "json",
		success: function(result) {
			alert(1234);		
			         var dataObj = result, //返回的result为json格式的数据
			         con = "";
			         $.each(dataObj, function(index, item){
			         	var a="title"+index;
			         	console.log(a);
			        	 document.getElementById(a).innerHTML=item.title;
			                /* con += "<li>姓名："+item.name+"</li>";
			                 con += "<li>性别："+item.sex+"</li>";
			                 con += "<li>现居地："+item.address+"</li>";
			                 con += "<li>岗位："+item.job+"</li>";*/
			        	 console.log(item.title);
			             });
			        // console.log(con);    //可以在控制台打印一下看看，这是拼起来的标签和数据
			         //$("#con").html(con); //把内容入到这个div中即完成
	
		},
		error: function() {
			alert(123);
		}
	});

}