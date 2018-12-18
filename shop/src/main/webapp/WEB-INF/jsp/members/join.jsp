<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <!-- web api 호출시 사용 -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>login form</title>
</head>
<body>
<h1>회원 가입</h1>
<hr />
<form method="post" action="/members/join">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    email : <input type="text" name="email"><br>
    name : <input type="text" name="name"><br>
    password : <input type="password" name="password"><br>
    <input type="submit" value="회원가입">
</form>

</body>
</html>