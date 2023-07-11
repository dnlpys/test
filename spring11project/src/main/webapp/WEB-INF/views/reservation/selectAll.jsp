<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매목록</title>
<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>예매목록</h1>
	
	<div style="padding:5px">
		<form action="r_searchList.do">
			<input type="hidden" name="user_id" value="${user_id}">
			<select name="searchKey" id="searchKey">
				<option value="movie_date">movie_date</option>
				<option value="title">title</option>
			</select>
			<input type="text" name="searchWord" id="searchWord" value="06">
			<input type="submit" value="검색">
		</form>
	</div>

	<table id="memberList">
	<thead>
		<tr>
			<th>num</th>
			<th>movie_num</th>
			<th>title</th>
			<th>regdate</th>
			<th>movie_date</th>
			<th>price</th>
			<th>mcount</th>
			<th>img</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>
					<a href="r_update.do?num=${vo.num}&movie_num=${vo.movie_num}&user_id=${user_id}" class="myButton">예약변경</a>
					<a href="r_deleteOK.do?num=${vo.num}&user_id=${user_id}" class="myButton">예약취소</a>
				</td>
				<td>${vo.movie_num}</td>
				<td>${vo.title}</td>
				<td>${vo.regdate}</td>
				<td>${vo.movie_date}</td>
				<td>${vo.price}</td>
				<td>${vo.mcount}</td>
				<td><img width="35px" src="resources/uploadimg/thumb_${vo.save_name}"></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">1 2 3 4 5</td>
		</tr>
	</tfoot>
	</table>
</body>
</html>