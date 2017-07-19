//加载 li(页码)
function addli(){
	  var ok=true;
	  var name = getCookie("name");
	  if(name==null){
		  window.location.href="login.html";
		  ok=false;
	  }
	  $("#name").html(name);
	  if(ok){
	 $.ajax({
		  url:"http://localhost:8080/qsgl/findall.do",
		  type:"post",
		  dataType:"json",
		  success:function(res){
			  var count = res.data.length;
			  var manager = res.data;
			  for(var i=2;i<count/6+1;i++){
				  var $li = $("<li>"+i+"</li>");
				  $(".pageList").append($li);
				  
			  }
			  var n = $(".active").html();
			  addManager(n,manager);
			
		  },
		  error:function(){
			  alert("查询失败");
		  }
		
	  });
}
}
function addManager(n){
	$("#manager").empty();
	$.ajax({
		  url:"http://localhost:8080/qsgl/findall.do",
		  type:"post",
		  dataType:"json",
		  success:function(res){
			  var max = res.data.length;
			  var manager = res.data;
			  
			  for(var i =(n-1)*6;i<max&&i<n*6;i++){
			  createTr(manager[i]);
			  }
			//动态绑定事件-----------------删除
			  $(".del").on("click",function(){
			  		var name = $(this).parents("tr").find("td:first-child").html();
			  		//alert(name);
			  	    $.ajax({
			  	    	url:"http://localhost:8080/qsgl/delete.do",
			  			data:{"name":name},
			  			dataType:"json",
			  			type:"post",
			  			success:function(res){
			  				
			  				if(res.status==1){
			  						alert(res.msg);
			  						addManager(n);
			  					}
			  			},
			  			error:function(){
			  				alert("删除失败");
			  					}
			  	    });

			  });
			//修改
			  $(".updateM").on("click",function(){
			  			  	var a=$(this).parents("tr").find("td:first").html();
			  			  	sessionStorage.name=a;
			  			  	location.href="manager/update.html";
			  			  })

		  },
		  error:function(){
			  alert("加载失败");
			  
		  }
	});
}

//添加行
function createTr(manager){
	  var $tr = $("    <tr>"
				+"<td>"+manager.name+"</td> "
              +"<td>"+manager.password+"</td>"
              +"<td>"+manager.job+"</td>"
              +"<td>"+manager.telephone+"</td> "
              +"<td>"+manager.louhao+"</td>"
              +"<td>"+manager.sushehao+"</td>"
              +"<td>"+manager.quanxian+"</td>"
              +"<td><span  class='updateM'>修改</sapn></td>"
              +"<td> <input type='button' value='删除' class='del' style='border:none;'></td>"
              +"</tr>");
              $("#manager").append($tr);
}

/**********************************************************************************************/

//查询
function search(){
	var name = $(".search").val();
	  $("#manager").empty();
	  //alert(name);
	$.ajax({
		url:"http://localhost:8080/qsgl/search.do",
		data:{"name":name},
		dataType:"json",
		type:"post",
		success:function(res){
			var count = res.data.length;
			if(count!=null){
				for(var i=0;i<count;i++){
					var man = res.data[i];
					createTr(man);
				}
			}
		},
		error:function(){
			alert("搜索失败");
		}
	});
}

//增加管理员
function addmanager(){
	//清空提示信息
	$("#warning_1").html("");
	$("#warning_2").html("");
	$("#warning_3").html("");
	var ok = true;
	var name = $("#name").val();
	var password = $("#password").val();
	var password_c = $("#password_c").val();
	var telephone = $("#tel").val();
	var quan = $("#quanxian").val();
	var job = $("#job").val();
	var louhao = $("#louhao").val();
	var sushehao = $("#sushehao").val();
	var quanxian=parseInt(quan);
	//alert(typeof quanxian);
	if(name==""){
		$("#warning_1").html("姓名不能为空");
		$("#warning_1").show();
		ok=false;
	}
	if(password==""){
		$("#warning_2").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
	}else if(password.length>0&&password.length<6){
		$("#warning_2").html("密码少于6位");
		$("#warning_2").show();
		ok=false;
	}
	if(password!=password_c){
		$("#warning_3").html("密码不一致");
		$("#warning_3").show();
		ok=false;
	}
	//alert(sushehao);
	if(ok){
	$.ajax({
		url:"http://localhost:8080/qsgl/addmanager.do",
		dataType:"json",
		data:{"name":name,"password":password,"job":job,"telephone":telephone,"louhao":louhao,"quanxian":quanxian,"sushehao":sushehao},
		type:"post",
		success:function(res){
			if(res.status==0){
				alert("添加成功");
				window.location.href="../manager.html";
			}
		},
		error:function(){
			alert("添加失败");
		}
	});
	}
}
//修改管理员
function updatem(user){
	var id = user.id;
	var name=$("#name").val();
	var password=$("#password").val();
	var job=$("#job").val();
	var quanxian = parseInt($("#quanxian").val());
	var tel = $("#tel").val();
	var louhao=$("#louhao").val();
	$.ajax({
		url:"http://localhost:8080/qsgl/updatem.do",
		dataType:"json",
		data:{"id":id,"name":name,"password":password,"telephone":tel,"job":job,"quanxian":quanxian,"louhao":louhao},
		type:"post",
		success:function(res){
			if(res.status==0){
				alert("修改成功");
				window.location.href="../manager.html";
			}
			},
			error:function(){
				alert("修改失败");
			}
	});
}
//权限检查
function check(){
	var name=getCookie("name");
	console.log(name);
	if(name==""){
		window.location.href="login.html";
	}else{
		$.ajax({
			url:"http://localhost:8080/qsgl/check.do",
			type:"post",
			data:{"name":name},
			dataType:"json",
			success:function(res){
				if(res.data.quanxian==0){
					window.location.href="quanxian.html";
				}else{
					window.location.href="manager.html";
				}				
			},error:function(){
				alert("登录失败")
			}
		});
	}
}