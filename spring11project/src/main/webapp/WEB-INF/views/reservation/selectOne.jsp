<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화예매</title>
<jsp:include page="../css.jsp"></jsp:include>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	console.log("onload...");
	$.ajax({
		url : "json_mv_selectOne.do",
		data:{num:${param.num}},
		method:'GET',
		dataType:'json', 
		success : function(vo2) {
// 			console.log('ajax...success:', vo2);//[{},{}]
			
// 	 		console.log(vo2.num,vo2.title,vo2.price,vo2.producer,vo2.save_name);
 			let tag_vo2 =  `
 				<tr>
					<td>\${vo2.num}</td>
					<td>\${vo2.title}</td>
					<td>\${vo2.price}</td>
					<td>\${vo2.producer}</td>
				</tr>
				<tr>
					<td colspan="5">
						<img width="300px" src="resources/uploadimg/\${vo2.save_name}">
					</td>
				</tr>  					
				<tr>
					<td colspan="5">
						<form action="r_insertOK.do">
							<input type="hidden" name="user_id" value="${user_id}">
							<input type="hidden" name="movie_num" value="\${vo2.num}">
							<label>관람일자:</label><input type="datetime-local" name="movie_date">
							<label>관람인원수:</label><input type="number" name="mcount" value="2">
							<input type="submit" value="예약완료">
						</form>
					</td>
				</tr>  					
 				`;
			
			$("#vo2").html(tag_vo2);
		},
		error:function(xhr,status,error){
			console.log('xhr.status:', xhr.status);
		}
	});//end $.ajax()...
});//end onload...

</script>	


</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>영화예매 ${user_id}</h1>

	<table id="memberList">
	<thead>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>price</th>
			<th>producer</th>
		</tr>
	</thead>
	<tbody id="vo2">
	</tbody>
	
	</table>

</body>
</html>