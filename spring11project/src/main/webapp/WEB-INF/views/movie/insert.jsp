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
	<h1>영화입력</h1>
	
	<form action="mv_insertOK.do" method="post" enctype="multipart/form-data">
		<table id="memberList">
			<tr>
				<td><label for="title">title:</label></td>
				<td><input type="text" id="title" name="title"
					value="괴물"></td>
			</tr>
			<tr>
				<td><label for="price">price:</label></td>
				<td><input type="number" id="price" name="price" value="10000"></td>
			</tr>
			<tr>
				<td><label for="producer">producer:</label></td>
				<td><input type="text" id="producer" name="producer"
					value="봉준구"></td>
			</tr>
			
			<tr>
				<td><label for="file">file:</label></td>
				<td>
					<input type="file" id="file" name="file">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="영화입력완료"></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>