<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<li><a href="home.do">HOME</a></li>
	<li><a href="mongo_findAll.do">findAll.do</a></li>
	<li><a href="mongo_findAll2.do?page=1&limit=3">1 findAll.do : skip , limit</a></li>
	<li><a href="mongo_findAll2.do?page=2&limit=3">2 findAll.do : skip , limit</a></li>
	<li><a href="mongo_searchList.do?searchKey=name&searchWord=im">searchList.do : name</a></li>
	<li><a href="mongo_searchList.do?searchKey=tel&searchWord=2">searchList.do : tel</a></li>
	<li><a href="mongo_searchList2.do?num1=3&num2=6">searchList2.do : Filters.and,or,in</a></li>
	<li><a href="mongo_searchList3.do?num1=3&num2=6">searchList3.do : Document</a></li>
	<li><a href="mongo_findOne.do?num=1">findOne.do : num</a></li>
	<li><a href="mongo_findOne_idCheck.do?id=tester1">findOne_idCheck.do : id</a></li>
	<li><a href="mongo_findOne.do?mid=648a76706f82fa43147a718a">findOne.do : mid</a></li>
	<li><a href="mongo_insertOK.do?num=7&id=tester7&pw=hi77&name=han7&tel=077">insertOK.do</a></li>
	<li><a href="mongo_updateOK.do?num=8&id=tester888&pw=hi8888&name=han8888&tel=08888">updateOK.do</a></li>
	<li><a href="mongo_updateOK.do?mid=6475895d1046e20cc70b8d90&id=tester888&pw=hi8888&name=han8888&tel=08888">updateOK.do</a></li>
	<li><a href="mongo_deleteOK.do?num=7">deleteOK.do : num</a></li>
	<li><a href="mongo_deleteOK.do?mid=648a5ca16f82fa3d2c374eea">deleteOK.do : mid</a></li>
</ul>
<ul>
	<li><a href="mongo_insert.do">몽고디비 회원가입</a></li>
	<li><a href="mongo_selectAll.do">몽고디비 회원목록</a></li>
</ul>