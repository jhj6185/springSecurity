<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <!-- sec는 시큐리티관련 tag library임 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Custom Login Page</h1>
<h2><c:out value="${error }"/></h2>
<h2><c:out value="${logout }"/></h2>
<form method="post" action="/login">
<div>
	<input type="text" name="username" value="admin">
</div>
<div>
	<input type="password" name="password" value="admin">
</div>
<input type="checkbox" id="vehicle1" name="remember-me">
<label for="vehicle1"> Remember Me</label><br>
<input type="submit">
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
</form>
</body>
</html>