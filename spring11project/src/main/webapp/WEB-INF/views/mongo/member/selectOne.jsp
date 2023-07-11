<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
<jsp:include page="../../css.jsp"></jsp:include>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	console.log("onload....",'${param.mid}');
	
	$('#mongo_deleteOK').click(function(){
		console.log("click mongo_deleteOK....",'${param.mid}');
		
		$.ajax({
			url : "mongo_deleteOK.do",
			data:{mid:'${param.mid}'},
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
		
		return false;
	});

	$.ajax({
		url : "mongo_findOne.do",
		data:{mid:'${param.mid}'},
		method:'GET',
		dataType:'json',
		success : function(vo2) {
			console.log('ajax...success:', vo2);
			
			let data = `
					<tr>
					<td>\${vo2._id}</td>
					<td>\${vo2.id}</td>
					<td>\${vo2.pw}</td>
					<td>\${vo2.name}</td>
					<td>\${vo2.tel}</td>
				</tr>
			`;
			
			$('#vo2').html(data);
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
	<h1>몽고디비 회원정보</h1>

	<table id="memberList">
		<thead>
			<tr>
				<th>_id</th>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>tel</th>
			</tr>
		</thead>
		<tbody id="vo2">

		</tbody>
		<tfoot>
			<tr>
				<td colspan="5"><a href="mongo_update.do?mid=${param.mid}" class="myButton">몽고 회원수정</a>
					<a href="mongo_deleteOK.do?mid=${param.mid}" id="mongo_deleteOK" class="myButton">몽고 회원삭제</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>