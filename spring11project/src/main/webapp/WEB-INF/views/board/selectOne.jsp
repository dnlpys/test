<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>글정보 ${user_id}</h1>

	<table id="boardList">
		<thead>
			<tr>
				<th>wnum</th>
				<th>title</th>
				<th>writer</th>
				<th>wdate</th>
				<th>vcount</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo2.wnum}</td>
				<td>${vo2.title}</td>
				<td>${vo2.writer}</td>
				<td>${vo2.wdate}</td>
				<td>${vo2.vcount}</td>
			</tr>
			<tr>
				<td colspan="5">${vo2.content}</td>
			</tr>
		</tbody>
		<c:if test="${user_id eq vo2.writer }">
			<tfoot>
				<tr>
					<td colspan="5">
					<a href="b_update.do?wnum=${param.wnum}"  class="myButton">글수정</a>
					<a href="b_deleteOK.do?wnum=${param.wnum}" class="myButton">글삭제</a>
					</td>
				</tr>
			</tfoot>
		</c:if>
	</table>
	<hr>
	<h1>댓글</h1>
	<table id="commentsList">
		<tr>
			<th>content</th>
			<th>writer</th>
		</tr>
		<tr>
			<td>
				<form action="c_insertOK.do">
					<input type="hidden" name="wnum" value="${param.wnum}">
					<input type="hidden" name="writer" value="${user_id}">
					<input type="text" name="content" value="댓글입니다.">
					<input type="submit" value="입력완료" class="myButton">
				</form>
			</td>
			<td>${user_id}</td>
		</tr>
	</table>	
	
	<hr>
	<table id="commentsList">
		<tr>
			<th>cnum</th>
			<th>content</th>
			<th>writer</th>
			<th>wdate</th>
			<th></th>
		</tr>
		<c:forEach var="com" items="${coms}">
			<tr>
				<td>${com.cnum}</td>
				<c:if test="${user_id eq com.writer }">
				<td>
					<form action="c_updateOK.do">
						<input type="hidden" name="wnum" value="${com.wnum}">
						<input type="hidden" name="cnum" value="${com.cnum}">
						<input type="text" name="content" value="${com.content}">
						<input type="submit" value="수정완료" class="myButton">
					</form>
				</td>
				</c:if>
				<c:if test="${user_id ne com.writer }">
					<td>${com.content}</td>
				</c:if>
				<td>${com.writer}</td>
				<td>${com.wdate}</td>
				<td>
					<c:if test="${user_id eq com.writer }">
						<a href="c_deleteOK.do?cnum=${com.cnum}&wnum=${com.wnum}" class="myButton">댓글삭제</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>