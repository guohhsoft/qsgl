function findlou(){
	//查看楼
	$.ajax({
		url:"http://localhost:8080/qsgl/louhao/find.do",
		dataType:"json",
		Type:"post",
		success:function(res){
			console.log(res);
			if(res.data.length!=null){
				for(var i=0;i<res.data.length;i++){
					var louhao=res.data[i];
					createLou(louhao);
				}
				$(".xian").hide();
				$("#dormitory").empty();
				//获取楼号信息
			var louhao = $("#depSel").val();
			var lh= louhao.substring(0,1);
				addDormitory(lh);
			$("#depSel").change(function(){
				louhao=$(this).val();
				var lh= louhao.substring(0,1);
				addDormitory(lh);
				$("#dormitory").empty();
				});
			}
		},

		error:function(){
			alert("加载失败");
		}
	})
}
function createLou(louhao){
	$op="<option>"+louhao.louhao+"</option>";
	$("#depSel").append($op);
}



function finddepartment(){
$.ajax({
	url:"http://localhost:8080/qsgl/department/find.do",
	dataType:"json",
	Type:"post",
	success:function(res){	
		console.log(res);
		if(res.data.length!=null){
			for(var i=0;i<res.data.length;i++){
				var department=res.data[i];
				$op="<option>"+department.department+"</option>";
				$("#department").append($op);
			}
		}
	},
	error:function(){
		alert("加载失败");
	}
});
}


function saveL(louhao){
	$.ajax({
		url:"http://localhost:8080/qsgl/louhao/save.do",
		dataType:"json",
		Type:"post",
		data:{"louhao":louhao},
		success:function(res){
			alert(res.msg);
			window.location.href="system.html"
		},
		error:function(){
			alert("添加失败");
		}	
	
	});
	
}



function saveD(department){
	$.ajax({
		url:"http://localhost:8080/qsgl/department/save.do",
		dataType:"json",
		Type:"post",
		data:{"department":department},
		success:function(res){
			alert(res.msg);
			window.location.href="system.html";
		},
		error:function(){
			alert("添加失败");
		}	
	
	});
	
}



function deletel(louhao){
	$.ajax({
		url:"http://localhost:8080/qsgl/louhao/delete.do",
		dataType:"json",
		Type:"post",
		data:{"louhao":louhao},
		success:function(res){
			alert(res.msg);
			window.location.href="system.html"
			
		},
		error:function(){
			alert("删除失败");
		}	
	
	});
	
}

function deleted(department){
	$.ajax({
		url:"http://localhost:8080/qsgl/department/delete.do",
		dataType:"json",
		Type:"post",
		data:{"department":department},
		success:function(res){
			alert(res.msg);
			window.location.href="system.html"
		},
		error:function(){
			alert("删除失败");
		}	
	
	});
	
}