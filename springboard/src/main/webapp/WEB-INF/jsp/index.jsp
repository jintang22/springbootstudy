
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>guestbook</title>
</head>
<body>
    <h1>Guestbook</h1>

    <form method="post" action="/write">
        name : <input type="text" name="name"><br />
        content : <textarea name="content"
                cols="30" rows="10"></textarea><br />
        <input type="submit"/>
    </form>

    <br />
    guestbookPage 이름으로 넘어온 값을 출력.
    jstl & el 이라는 것을 이용한다.
    <br />

    <c:forEach items="${guestBookPage}" var="guestBook">
        ${guestBook.id}<br />
        ${guestBook.name}<br />
        <pre>${guestBook.content}</pre><br/>
    </c:forEach>
</body>
</html>