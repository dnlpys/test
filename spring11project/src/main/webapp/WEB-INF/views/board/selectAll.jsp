<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h1>글목록</h1>
	
	<div style="padding:5px">
		<form action="b_searchList.do">
			<select name="searchKey" id="searchKey">
				<option value="title">title</option>
				<option value="content">content</option>
				<option value="writer">writer</option>
			</select>
			<input type="text" name="searchWord" id="searchWord" value="tit">
			<input type="submit" value="검색">
		</form>
	</div>

	<table id="boardList">
	<thead>
		<tr>
			<th>wnum</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>wdate</th>
			<th>vcount</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="b_selectOne.do?wnum=${vo.wnum}">${vo.wnum}</a></td>
				<td>${vo.title}</td>
				<td>${vo.content}</td>
				<td>${vo.writer}</td>
				<td>${vo.wdate}</td>
				<td>${vo.vcount}</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">1 2 3 4 5</td>
		</tr>
	</tfoot>
	</table>
</body>
</html>