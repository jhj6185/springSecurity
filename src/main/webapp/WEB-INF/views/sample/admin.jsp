<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/admin page</h1>
	
	<p>principal : <sec:authentication property="principal"/></p>
	<!-- principal은 시큐리티에서 제공해주는 유저정보 -->
	<p>MemberVO : <sec:authentication property="principal.member"/></p>
	<p>사용자 이름 : <sec:authentication property="principal.member.userName"/></p>
	<p>사용자 아이디 : <sec:authentication property="principal.username"/></p>
	<!-- 사용자 아이디는 무조건 principal.username임 -->
	<p>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/></p>
	
	<a href="/customLogout">로그아웃</a>
	
</body>
</html>