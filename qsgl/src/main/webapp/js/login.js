
function login(){
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	//格式检查之前 先对内容进行清空
	$("#count_msg").html("");
	$("#password_msg").html("");
	//格式检测
	var ok=true;
	if(name==""){
		$("#count_msg").html("帐号不能为空");
		ok=false;
	}
	else if(password==""){
		$("#password_msg").html("密码不能为空");
		ok=false;
	}
	if(ok==true){  // 检测格式是否通过
		// 调用ajax发送请求
		$.ajax({
			url:"http://localhost:8080/qsgl/login.do",
			type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(res){
				if(res.status==0)
					$("#count_msg").html(res.msg);
				else if(res.status==1)
					$("#password_msg").html(res.msg);
				else{
					var name = res.data.name;
					var password = res.data.password;
					SetCookie("name",name);
					SetCookie("password", password);
					window.location.href="ht.html";
					
				}
					
				
			},
			error:function(){
				alert("登录失败")
			}
		});
	}
	
}