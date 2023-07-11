<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>영화정보</h1>

	<table id="memberList">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>price</th>
				<th>producer</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.num}</td>
				<td>${vo2.title}</td>
				<td>${vo2.price}</td>
				<td>${vo2.producer}</td>
			</tr>
			<tr>
				<td colspan="5">
					<img width="300px" src="resources/uploadimg/${vo2.save_name}">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"><a href="mv_update.do?num=${param.num}" class="myButton">영화수정</a>
					<a href="mv_deleteOK.do?num=${param.num}" class="myButton">영화삭제</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>