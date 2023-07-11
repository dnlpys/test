<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>몽고디비 회원목록</title>
<jsp:include page="../../css.jsp"></jsp:include>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	console.log("onload....");
	
	$.ajax({
// 		url : "mongo_findAll.do",
		url : "mongo_findAll_doc.do",
		data:{},
		method:'GET',
		dataType:'json',
		success : function(arr) {
			console.log('ajax...success:', arr);
			let vos = ``;
			$.each(arr,function(index,vo){
				console.log(index,vo);
				let regdate = new Date(vo._id.time).toLocaleString();
				vos += `
					<tr>
						<td><a href="mongo_selectOne.do?mid=\${vo._id}">\${index+1}</a></td>
						<td>\${vo.id}</td>
						<td>\${vo.pw}</td>
						<td>\${vo.name}</td>
						<td>\${vo.tel}</td>
						<td>\${regdate}</td>
					</tr>
				`;
				
			});
			$('#vos').html(vos);
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
	<h1>몽고디비 회원목록</h1>
	
	<div style="padding:5px">
		<form action="m_searchList.do">
			<select name="searchKey" id="searchKey">
				<option value="name">name</option>
				<option value="tel">tel</option>
			</select>
			<input type="text" name="searchWord" id="searchWord" value="ki">
			<input type="submit" value="검색">
		</form>
	</div>

	<table id="memberList">
	<thead>
		<tr>
			<th>_id</th>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>tel</th>
			<th>가입일자</th>
		</tr>
	</thead>
	<tbody id="vos">
		
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">1 2 3 4 5</td>
		</tr>
	</tfoot>
	</table>
</body>
</html>