<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>몽고디비 회원수정</title>
<jsp:include page="../../css.jsp"></jsp:include>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">



$(function(){
	console.log("onload....");
		$('#form_updateOK').submit(function(){
			
				console.log("mongo_updateOK....");
				console.log($('#id').val(),$('#pw').val(),$('#name').val(),$('#tel').val());
				
				$.ajax({
					url : "mongo_updateOK.do",
					data:{
						mid:$('#mid').val(),
						id:$('#id').val(),
						pw:$('#pw').val(),
						name:$('#name').val(),
						tel:$('#tel').val()
					},
					method:'GET',
					dataType:'json',
					success : function(obj) {
						console.log('ajax...success:', obj);
						console.log('ajax...success:', obj.result);
						if(obj.result==1){
							location.href = 'mongo_selectOne.do?mid='+$('#mid').val();
						}
					},
					error:function(xhr,status,error){
						console.log('xhr.status:', xhr.status);
					}
				});//end $.ajax()...
				
			
			
			return false;
		});	//end submit....
		
		$.ajax({
			url : "mongo_findOne.do",
			data:{mid:'${param.mid}'},
			method:'GET',
			dataType:'json',
			success : function(vo2) {
				console.log('ajax...success:', vo2);
				
				$('#span_mid').text(vo2.mid);
				$('#span_id').text(vo2.id);
				
				$('#mid').val(vo2.mid);
				$('#id').val(vo2.id);
				$('#pw').val(vo2.pw);
				$('#name').val(vo2.name);
				$('#tel').val(vo2.tel);
				
			},
			error:function(xhr,status,error){
				console.log('xhr.status:', xhr.status);
			}
		});//end $.ajax()...
	
});


</script>
</head>
<body>
	<jsp:include page="../../top_menu.jsp"></jsp:include>
	<h1>몽고디비 회원수정</h1>
	
	<form id="form_updateOK">
		<table id="memberList">
			<tr>
				<td><label for="mid">mid:</label></td>
				<td><span id="span_mid"></span><input type="hidden" id="mid" name="mid" value=""></td>
			</tr>
			<tr>
				<td><label for="id">id:</label></td>
				<td><span id="span_id"></span><input type="hidden" id="id" name="id" value=""></td>
			</tr>
			<tr>
				<td><label for="pw">pw:</label></td>
				<td><input type="password" id="pw" name="pw" value=""></td>
			</tr>
			<tr>
				<td><label for="name">name:</label></td>
				<td><input type="text" id="name" name="name" value=""></td>
			</tr>
			<tr>
				<td><label for="tel">tel:</label></td>
				<td><input type="text" id="tel" name="tel" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="myButton"></td>
			</tr>
		</table>
	</form>
</body>
</html>