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
	<!-- principal�� ��ť��Ƽ���� �������ִ� �������� -->
	<p>MemberVO : <sec:authentication property="principal.member"/></p>
	<p>����� �̸� : <sec:authentication property="principal.member.userName"/></p>
	<p>����� ���̵� : <sec:authentication property="principal.username"/></p>
	<!-- ����� ���̵�� ������ principal.username�� -->
	<p>����� ���� ����Ʈ : <sec:authentication property="principal.member.authList"/></p>
	
	<a href="/customLogout">�α׾ƿ�</a>
	
</body>
</html>