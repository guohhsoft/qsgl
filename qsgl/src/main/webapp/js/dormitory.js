function addDormitory(louhao){
	$.ajax({
		url:"http://localhost:8080/qsgl/dormitory/find.do",
		data:{"louhao":louhao},
		dataType:"json",
		type:"post",
		success:function(res){
			var count = res.data.length;
			for(var i=0;i<count;i++){
				var dm = res.data[i];
				createDm(dm);
				//加载信息
			}
			//修改事件
			$(".updates").on("click",function(){
				var lou=$(this).parents("tr").find("td:first").html();
				var sushehao=$(this).parents("tr").find("td:first").next().html();
				sessionStorage.louhao=lou;
				sessionStorage.sushehao=sushehao;
				window.location.href="dormitory/updatem.html";
			})
			//加载完就  点击事件啊
			$(".chakan").on("click",function(){
				$(".xian").show();
				var lou=$(this).parents("tr").find("td:first").html();
				var sushehao=$(this).parents("tr").find("td:first").next().html();
				var max = $(this).parents("tr").find("td:first").next().next().next().html();
				//alert(max);
				max = max.substring(0,1);
				//加载学生信息
				$(".biao_1").empty();
				$.ajax({
					url:"http://localhost:8080/qsgl/dormitory/findStudent.do",
					data:{"louhao":lou,"sushehao":sushehao},
					dataType:"json",
					type:"post",
					success:function(res){
						var length = res.data.length;
						$("#sushe").html(lou+"号楼"+sushehao+"寝室");
						$("#now").html(length+"人");
						$("#max").html(max+"人");
						for(var i=0;i<length;i++){
							var student = res.data[i]
							createSM(student);
						}
						//加载完  点击修改 触发事件
						$(".del").on("click",function(){
							var studentId=$(this).parents("tr").find("td:first").html();
							sessionStorage.studentId=studentId;
							window.location.href="dormitory/update.html"
						})
			
					},
					error:function(){
						alert("加载失败");
						}
					});
			})

		},
		error:function(){
			alert("加载失败")
		}
	});
}
function createDm(dm){
	var $tr = " <tr>"
        +"<td>"+dm.louhao+"</td>"
        +"<td>"+dm.sushehao+"</td>"
        +"<td>"+dm.department+"</td>"
        +"<td>"+dm.max+"人间</td>"
        +"<td>"+dm.depict+"</td>"
        +"<td><span  class='updates'>修改</sapn></td>"
        +"<td><input type='button' value='查看' class='chakan'></td>"
     +"</tr>";
		$("#dormitory").append($tr);
}
function createSM(student){
	var $tr = " <tr>"
		+"<td>"+student.studentId+"</td>"
        +"<td>"+student.name+"</td>"
        +"<td>"+student.sex+"</td>"
        +"<td>"+student.department+"</td>"
        +"<td class='addrTd'>"+student.addr+"</td>"
        +"<td><input type='button' value='修改' class='del'></td>"
     +"</tr>";
		$(".biao_1").append($tr);
}


function adddm(){
	var ok = true;
	$("#warning").html("");
	var louhao=$("#louhao").val();
	var lh= louhao.substring(0,1);
	$("#louhao").change(function(){
		louhao=$(this).val();
		var lh= louhao.substring(0,1);
	});
	var sushehao=$("#sushehao").val();
	var department=$("#department").val();
	$("#department").change(function(){
		department=$(this).val();
	});
	var size=$("#size").val();
	$("#size").change(function(){
		size=$(this).val();
	});
	var depict=$("#message").val();
	$("#depict").change(function(){
		depict=$(this).val();
	});
	if(sushehao==""){
		$("#warning").html("寝室号不能为空");
		ok=false;
	}
	var max;
	if(size=="四人间"){
		max=4
	}else if(size=="六人间"){
		max=6
	}else{
		max=8
	}
	if(ok){
	//console.log(louhao+"   "+sushehao+"  "+depict)
	$.ajax({
		url:"http://localhost:8080/qsgl/dormitory/save.do",
		data:{"louhao":lh,"sushehao":sushehao,"max":max,"depict":depict,"department":department},
		dataType:"json",
		type:"post",
		success:function(res){
			alert("添加成功");
			window.location.href="../dormitory.html"
		},
		error:function(){
			alert("保存失败");
		}
	});
	}
}
//增加学生
function addstu(louhao,sushehao){
	//alert("*******************************");
	$("#warning_1").html("");
	$("#warning_2").html("");
	$("#warning_3").html("");
	var ok=true;
	var studentId=$("#id").val();
	var name=$("#name").val();
	var sex = $("input:radio:checked").val();
	console.log(sex);
	var department = $("#department").val();
	var addr = $("#addr").val();
	if(studentId==""){
		$("#warning_1").html("学号不能为空");
		$("#warning_1").show();
		ok=false;
	}
	if(name==""){
		$("#warning_2").html("姓名不能为空");
		$("#warning_2").show();
		ok=false;
	}
	if(department==""){
		$("#warning_3").html("系别不能为空");
		$("#warning_3").show();
		ok=false;
	}
	if(ok){
	$.ajax({							
		url:"http://localhost:8080/qsgl/savestudent.do",
		data:{"studentId":studentId,"name":name,"sex":sex,"addr":addr,"department":department,"sushehao":sushehao,"louhao":louhao},
		dataType:"json",
		type:"post",
		success:function(res){
			if(res.status==1){
				alert(res.msg);
				window.location.href="../dormitory.html";
			}else{
				//alert(res.msg);
			}
		},
		error:function(){
			alert("修改失败");
		}
	});	
	}
}

//修改学生信息
function updates(){
	var studentId=$("#id").val();
	var name=$("#name").val();
	var sex=$("#sex").val();
	var department = $("#department").val();
	var sushehao = $("#sushehao").val();
	var louhao = $("#louhao").val();
	var addr = $("#addr").val();
	$.ajax({							
		url:"http://localhost:8080/qsgl/updatestudent.do",
		data:{"studentId":studentId,"name":name,"sex":sex,"addr":addr,"department":department,"sushehao":sushehao,"louhao":louhao},
		dataType:"json",
		type:"post",
		success:function(res){
			if(res.status==1){
				alert(res.msg);
				window.location.href="../dormitory.html";
			}
		},
		error:function(){
			alert("修改失败");
		}
	});	
}


function updatedormitory(){
	var louhao=sessionStorage["louhao"];
	var sushehao=sessionStorage["sushehao"];
	var department=$("#department").val();
	var size=$("#size").val();
	$("#size").change(function(){
		size=$(this).val();
	});
	var depict=$("#message").val();
	$("#depict").change(function(){
		depict=$(this).val();
	});
	var max;
	if(size=="四人间"){
		max=4
	}else if(size=="六人间"){
		max=6
	}else{
		max=8
	}
	$.ajax({
		url:"http://localhost:8080/qsgl/dormitory/update.do",
		data:{"louhao":louhao,"sushehao":sushehao,"max":max,"depict":depict,"department":department},
		dataType:"json",
		type:"post",
		success:function(res){
			alert("修改成功");
			window.location.href="../dormitory.html"
		},
		error:function(){
			alert("保存失败");
		}
	});
}