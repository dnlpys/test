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
	<h1>회원수정</h1>
	
	<form action="m_updateOK.do" method="post" enctype="multipart/form-data">
		<table id="memberList">
			<tr>
				<td><label for="num">num:</label></td>
				<td><span id="span_num">${vo2.num}</span><input type="hidden" id="num" name="num"
					value="${vo2.num}"></td>
			</tr>
			<tr>
				<td><label for="id">id:</label></td>
				<td><span id="span_id">${vo2.id}</span></td>
			</tr>
			<tr>
				<td><label for="pw">pw:</label></td>
				<td><input type="password" id="pw" name="pw" value="${vo2.pw}"></td>
			</tr>
			<tr>
				<td><label for="name">name:</label></td>
				<td><input type="text" id="name" name="name"
					value="${vo2.name}"></td>
			</tr>
			<tr>
				<td><label for="tel">tel:</label></td>
				<td><input type="text" id="tel" name="tel" value="${vo2.tel}"></td>
			</tr>
			<tr>
				<td><label for="file">file:</label></td>
				<td>
					<input type="file" id="file" name="file">
					<input type="hidden" id="save_name" name="save_name" value="${vo2.save_name}">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원수정완료"></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>