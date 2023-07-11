<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<li><a href="home.do">HOME</a></li>
	<li><a href="m_insert.do">회원가입</a></li>
	<li><a href="m_selectAll.do">회원목록</a></li>
	
	<li><a href="b_insert.do">글쓰기</a></li>
	<li><a href="b_selectAll.do">글목록</a></li>
	
	<li><a href="mv_insert.do">영화등록</a></li>
	<li><a href="mv_selectAll.do">영화목록</a></li>
	
	<li><a href="r_insert.do">영화예매</a></li>
	<li><a href="r_selectAll.do?user_id=${user_id}">영화예매목록</a></li>
	
	
	<li><a href="login.do">로그인</a></li>
	<li><a href="logout.do">로그아웃</a></li>
	
	<li><a href="rest_api.do">REST_API</a></li>
	<li><a href="mongo_rest_api.do">MONGO_REST_API</a></li>
</ul>