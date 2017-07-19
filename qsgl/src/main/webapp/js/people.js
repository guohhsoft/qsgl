//加载页码
//function addpeople(){
//	$.ajax({
//		url:"http://localhost:8080/qsgl/fangke/findAll.do",
//		dateType:"json",
//		type:"post",
//		success:function(res){
//			var length = res.data.length;
//			alert(length);
//			//加载页码
//			addpage(length);
//		},
//		error:function(){
//			alert("加载失败");
//		}
//	});
//}
////加载li
//function addpage(length){
//	for(var i=2;i<length/10+1;i++){
//		  var $li = $("<li>"+i+"</li>");
//		  $(".pageList").append($li);
//		  addpeop(1);		  
//	  }
//}
function addpeople(){
	var name = getCookie("name");
	$("#name").html(name);
	//    检册  权限   是1   隐藏 add
	$.get("http://localhost:8080/qsgl/check.do?name="+name,function(data){
		var user=data.data;
		if(user.quanxian==1){
			$("#cli").hide();
		}
	});
	//清空列表
	$("#people").empty()
	//查询信息
	$.ajax({
		url:"http://localhost:8080/qsgl/fangke/findAll.do",
		dateType:"json",
		type:"post",
		success:function(res){
			 var max= res.data.length;
			  for(var i=0;i<max;i++){
				  var people = res.data[i];
				  //加载每条信息
				  createTr(people);
			  }
//加载完之后会离开功能
			  $(".likai").on("click",function(){
				  var timelikai =  $(this).parent().prev().html();
				  var time = $(this).parent().prev().prev().html();
				  if(timelikai==""){
					  $.ajax({
						  url:"http://localhost:8080/qsgl/fangke/update.do",
						  dataType:"json",
						  data:{"time":time},
						  type:"post",
						  success:function(res){
							  alert(res.msg);
							  window.location.href="people.html"
						  },
						  error:function(){
							  alert("记录失败");
						  }
					  });
					  }
			  })
			  
		},
		error:function(){
			alert("加载失败");
		}
	});
}
//加载每一条li
function createTr(people){
	//console.log(people);
	var $tr= " <tr>"      
        +"<td>"+people.lfname+"</td>"
        +"<td style="+"width:197px;"+">"+people.idcard+"</td>"
        +"<td>"+people.telephone+"</td>"
        +"<td>"+people.bfname+"</td>"
        +"<td>"+people.louhao+"</td>"
        +"<td>"+people.sushehao+"</td>"      
        +"<td>"+people.reson+"</td>"
        +"<td style="+"width:198px;"+">"+people.time+"</td>"
        +"<td style="+"width:198px;"+">"+people.time1+"</td>"
        +"<td  style='text-align:center'><input type='button' value='离开' class='likai'></td>"
     +"</tr>";
$("#people").append($tr);
}
// 登记功能
function save(){
	$("#bfname_1").html("");
	$("#idcard_1").html("");
	$("#telephone_1").html("");
	$("#lfname_1").html("");
	$("#reson_1").html("");
	var BFname=$("#bfname").val();
	var Idcard=$("#idcard").val();
	var LFname=$("#lfname").val();
	var telephone=$("#telephone").val();
	var sushehao=$("#sushehao").val();
	var louhao=$("#louhao").val();
	var reson=$("#reson").val();
	var ok=true;
	if(BFname==""){
		$("#bfname_1").html("访问人姓名不能为空");
		ok=false;
	}
	if(Idcard==""){
		$("#idcard_1").html("证件号不能为空");
		ok=false;
	}
	if(telephone==""){
		$("#telephone_1").html("联系方式不能为空");
		ok=false;
	}
	if(LFname==""){
		$("#lfname_1").html("被访问人姓名不能为空");
		ok=false;
	}
	if(reson==""){
		$("#reson_1").html("访问事由不能为空");
		ok=false;
	}
	if(ok){
	$.ajax({
		url:"http://localhost:8080/qsgl/fangke/save.do",
		dateType:"json",
		data:{"BFname":BFname,"Idcard":Idcard,"telephone":telephone,"sushehao":sushehao,"louhao":louhao,"reson":reson,"LFname":LFname},
		type:"post",
		success:function(res){
			window.location.href="people.html";
		},
		error:function(){
			alert("加载失败");
		}
	});
	
}
}
// 搜索信息
function search(){
	 //先清空
	$("#people").empty();
	var time=$("#searchpeople").val();
	//alert(time);
	$.ajax({
	url:"http://localhost:8080/qsgl/fangke/search.do",
	dateType:"json",
	data:{"time":time},
	type:"post",
	success:function(res){
		var max = res.data.length;
		 //先清空
		$("#people").empty();
		 for(var i=0;i<max;i++){
			
			  var people = res.data[i];
			  //加载每条信息
			  createTr(people);
		  }
	},
	error:function(){
		alert("加载失败");
	}
});
}
function likai(){
	//var time = 
}