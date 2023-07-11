<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
<jsp:include page="../../css.jsp"></jsp:include>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

let flag_idCheck = 0;

$(function(){
	console.log("onload....");
		$('#form_insertOK').submit(function(){
			if(flag_idCheck==1){
				console.log("mongo_insertOK....");
				console.log($('#id').val(),$('#pw').val(),$('#name').val(),$('#tel').val());
				
				$.ajax({
					url : "mongo_insertOK.do",
					data:{
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
							location.href = 'mongo_selectAll.do';
						}
					},
					error:function(xhr,status,error){
						console.log('xhr.status:', xhr.status);
					}
				});//end $.ajax()...
				
			}else{
				alert("아이디 중복체크를 확인하세요...");
			}
			
			return false;
		});		
	
	
	
});



function idCheck(){
	console.log("idCheck....",$('#id').val());
	
	$.ajax({
		url : "mongo_findOne_idCheck.do",
		data:{id:$('#id').val()},
		method:'GET',
		dataType:'json',
		success : function(obj) {
			console.log('ajax...success:', obj);
			console.log('ajax...success:', obj.id);
			let msg = '';
			if(obj.id == null){
				msg = '사용가능한 아이디입니다.';
				flag_idCheck = 1;
			}else{
				msg = '사용중인 아이디입니다.';
				flag_idCheck = 0;
			}
			$('#demo').text(msg);
		},
		error:function(xhr,status,error){
			console.log('xhr.status:', xhr.status);
		}
	});//end $.ajax()...
	
}//end idCheck()...

</script>
</head>
<body>
	<jsp:include page="../../top_menu.jsp"></jsp:include>
	<h1>몽고디비 회원가입</h1>
	
	<form id="form_insertOK">
		<table id="memberList">
			<tr>
				<td><label for="id">id:</label></td>
				<td><input type="text" id="id" name="id" value="tester">
				<button type="button" onclick="idCheck()" class="myButton">ID중복체크</button>
					<span id="demo"></span></td>
			</tr>
			<tr>
				<td><label for="pw">pw:</label></td>
				<td><input type="password" id="pw" name="pw" value="hi11"></td>
			</tr>
			<tr>
				<td><label for="name">name:</label></td>
				<td><input type="text" id="name" name="name" value="yang양"></td>
			</tr>
			<tr>
				<td><label for="tel">tel:</label></td>
				<td><input type="text" id="tel" name="tel" value="011"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="myButton"></td>
			</tr>
		</table>
	</form>
</body>
</html>