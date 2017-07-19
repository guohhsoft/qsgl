//加载学生信息
function addstudent(department){
	$.ajax({
		url:"http://localhost:8080/qsgl/findsAll.do",
		dataType:"json",
		data:{"department":department},
		type:"post",
		success:function(res){
			for(var i=0;i<res.data.length;i++){
				var student = res.data[i];
				adds(student);
			}
			if(res.data.length>15){
				 $(".message .addrTd").css("width",184);
			}else{
				$(".message .addrTd").css("width",200);
			}
//修改学生信息
			$("#student").on("click",".updates",function(){
			  	var studentId=$(this).parents("tr").find("td:first").html();
			  	sessionStorage.studentId=studentId;
			  	location.href="student/update.html";
			  });
//删除学生信息
			$("#student").on("click","input",del);
		},

		error:function(){
			alert("加载失败");
		}
	});
}
//用于加载学生信息
function adds(student){
	var $tr= " <tr>"
	           +"<td>"+student.studentId+"</td>"
	           +"<td>"+student.name+"</td>"
	           +"<td>"+student.sex+"</td>"
	           +"<td>"+student.department+"</td>"
	           +"<td>"+student.louhao+"</td>"
	           +"<td>"+student.sushehao+"</td>"
	           +"<td><span  class='updates'>修改</sapn></td>"
	           +"<td><input type='button' value='删除' class='.del'></td>"
            +"<td class='addrTd'>"+student.addr+"</td>"
            +"</tr>";
    $("#student").append($tr);
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
				//alert(res.msg);
				window.location.href="../student.html";
			}
		},
		error:function(){
			alert("修改失败");
		}
	});	
}
//删除学生信息
function del(){
	var studentId=$(this).parents("tr").find("td:first").html();
	$.ajax({
		url:"http://localhost:8080/qsgl/deletestudent.do",
		dataType:"json",
		data:{"studentId":studentId},
		type:"post",
		success:function(res){
			if(res.status==1){
				//alert(res.msg);
				window.location.href="student.html";
			}
		},
		error:function(){
			alert("删除失败");
		}
		});
}
//查询信息
function search(name){
	if(name==""){
		//alert("请输入要查询的信息");
	}else{
	$.ajax({
		url:"http://localhost:8080/qsgl/serachstudent.do",
		dataType:"json",
		data:{"name":name},
		type:"post",
		success:function(res){
			if(res.data!=null){
				$("#student").empty();
				for(var i=0;i<res.data.length;i++){
					var student = res.data[i];
					adds(student);
				}
				if(res.data.length>15){
					 $(".message .addrTd").css("width",184);
				}else{
					$(".message .addrTd").css("width",200);
				}
			}else{
				alert("查询无果");
			}
		},
		error:function(){
			alert("查询失败");
		}
		});
	}
}
//增加学生
function addstu(){
	//alert("*******************************");
	$("#warning_1").html("");
	$("#warning_2").html("");
	$("#warning_3").html("");
	var ok=true;
	var studentId=$("#id").val();
	var name=$("#name").val();
	var sex=$("#sex").val();
	var department = $("#department").val();
	var sushehao = $("#sushehao").val();
	var louhao = $("#louhao").val();
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
				window.location.href="../student.html";
			}else{
				alert(res.msg);
			}
		},
		error:function(){
			alert("修改失败");
		}
	});	
	}
}
