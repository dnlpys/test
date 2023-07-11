<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>영화수정</h1>
	
	<form action="mv_updateOK.do" method="post" enctype="multipart/form-data">
		<table id="memberList">
			<tr>
				<td><label for="num">num:</label></td>
				<td><span id="span_num">${vo2.num}</span><input type="hidden" id="num" name="num"
					value="${vo2.num}"></td>
			</tr>
			<tr>
				<td><label for="title">title:</label></td>
				<td><input type="text" id="title" name="title"
					value="${vo2.title}"></td>
			</tr>
			<tr>
				<td><label for="price">price:</label></td>
				<td><input type="number" id="price" name="price" value="${vo2.price}"></td>
			</tr>
			<tr>
				<td><label for="producer">producer:</label></td>
				<td><input type="text" id="producer" name="producer"
					value="${vo2.producer}"></td>
			</tr>
			
			<tr>
				<td><label for="file">file:</label></td>
				<td>
					<input type="file" id="file" name="file">
					<input type="hidden" id="save_name" name="save_name" value="${vo2.save_name}">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="영화수정완료"></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>