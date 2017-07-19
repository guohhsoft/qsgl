function updata(){
	var name=getCookie("name");
	var pass = getCookie("password");
	var password=$("#yupwd").val();
	var npsw=$("#nupwd").val();
	var npsw1 = $("#rupwd").val();
	var tel = $("#tel").val();
	$("#warning_1").html("");
	$("#warning_2").html("");
	$("#warning_3").html("");
	
	var ok=true;
	//检查数据格式
	//检查用户
	if(password==""){
		// 父子选择器 #warning父亲 span孩子(这里仅有一个不需要下标确定)
		$("#warning_1").html("密码不能为空");
		$("#warning_1").show();
		ok=false;
	}else if(pass!=password){
		$("#warning_1").html("原密码错误");
		$("#warning_1").show();
		ok=false;
	}
	if(npsw==""){
		$("#warning_2").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
	}else if(npsw.length>0&&npsw.length<6){
		$("#warning_2").html("密码少于6位");
		$("#warning_2").show();
		ok=false;
	}
	if(npsw1!=npsw){
		$("#warning_3").html("密码不一致");
		$("#warning_3").show();
		ok=false;
	}
	if(ok==true){
		$.ajax({
			url:"http://localhost:8080/qsgl/updatap.do",
			type:"post",
			data:{"name":name,"password":npsw,"telephone":tel},
			dataType:"json",
			success:function(res){
				if(res.status==0){
					delCookie("name");
					window.location.href="login.html";
				}else{
					$("#warning_1").html("原密码错误");
					$("#warning_1").show();
				}
			},
			error:function(){
				alert("提交失败");
			}
		});
	}
	
};