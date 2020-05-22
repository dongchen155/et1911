<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>参数传递</title>
</head>
<body>
<h2>测试数组传参</h2>
<form action="${pageContext.request.contextPath }/complex/array" method="post">
爱好：
<input type="checkbox" name="hobby" value="踢球" />踢球
<input type="checkbox" name="hobby" value="听音乐" />听音乐
<input type="checkbox" name="hobby" value="看书" />看书
<br />
<input type="submit"  value="测试数组传参" />
<hr />
</form>
<h2>测试List传参</h2>
<form action="${pageContext.request.contextPath }/complex/list" method="post">
爱好：
<input type="checkbox" name="hobbyList" value="踢球" />踢球
<input type="checkbox" name="hobbyList" value="听音乐" />听音乐
<input type="checkbox" name="hobbyList" value="看书" />看书
<br />
<input type="submit"  value="测试list传参" />
</form>
<hr />
<button id="testMap"type="button" >测试Map传参 </button>
<hr />
<button onclick="jsonToMap()" type="button">测试json 传参</button>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js" ></script>
<script type="text/javascript">
	const path="${pageContext.request.contextPath}"
	$(function(){
		$('#testMap').click(()=>{
			$.ajax({
				url:path+'/complex/map',
				type:'post',
				dataType:'text',
				
				data:"stuMap['id']=1&stuMap['name']=zhangsan",
				success:function(data){
					alert(data)
				}
			})
		});
		
	});
	function jsonToMap(){
		let obj={id:1,name:"et1911"};
		$.ajax({
			url:path+"/json/jsonToMap",
			type:'post',
			data:JSON.stringify(obj),
			contentType:'application/json;charset=UTF-8',
			dataType:'json',
			success:function(data){
				alert(data)
			}
		})
		
		
	}

</script>




</body>
</html>