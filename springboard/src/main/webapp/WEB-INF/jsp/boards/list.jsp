<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8" />
        <meta charset="UTF-8" />
    <title>list</title>
</head>
<body>
    <h1>Board List!</h1>

    <c:forEach items="${boardPage.getContent()}" var="board">
        ${board.title} , ${board.member.name} , ${board.readCount}, ${board.createDate}
        <br />
    </c:forEach>

    <a href="/boards/writeform">글쓰기</a>
</body>
</html>