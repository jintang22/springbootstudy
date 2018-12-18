<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <!-- web api 호출시 사용 -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>tang shop</title>
    <script>
        function addCart(itemId) {

            //alert(document.querySelector("meta[name='_csrf']").content);

            if ( document.getElementById('loginStatus').value !== 'Login' )
            {
                alert('로그인이 필요합니다.');
                return ;
            }

            var http = null
            if (window.ActiveXObject) {
                try {
                    http = new ActiveXObject("Msxml2.XMLHTTP");
                } catch(e) {
                    http = new ActiveXObject("Microsoft.XMLHTTP");
                }
            } else {
                http = new XMLHttpRequest();
            }
            if( !http )
            {
                alert('http request 객체 생성 실패');
            }
            http.open('POST', '/api/cart/add', false);
            http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

            var params = "";

            params += 'itemId' + '=' + itemId;
            params += '&' + document.getElementById('paramName').value + '=' + document.getElementById('paramValue').value;

            http.send(params);
            alert(http.responseText);
/*
            http.onreadystatechange = function() {
                if(http.readyState == 4) {
                    alert(http.responseText);
                }
                alert('test');
            }
            */
        }
    </script>
</head>
<body>

    <table style="border:0px">
        <tr>
            <td>
                <h1>Hi, ${name} Welcom to TANG SHOP</h1>
            </td>
            <c:if test = "${loginStatus == 'Logout'}">
                <td>
                    <a href="/members/login">Login</a> / <a href="/members/join">Join</a>
                </td>
            </c:if>
            <c:if test = "${loginStatus == 'Login'}">
                <td>
                    <a href="/cart">Cart</a>
                </td>
                <td>
                    <a href="/members/logout">Logout</a>
                </td>
            </c:if>
        </tr>
    </table>

    <c:forEach items="${itemPage.getContent()}" var="item">
        ${item.name} , ${item.price}
        <a href="javascript:addCart(${item.id})">장바구니 담기</a>
        <a href="/order?itemId=${item.id}">즉시구매</a>
        <br />
    </c:forEach>




    <input type="hidden" id="paramName" value="${_csrf.parameterName}"/>
    <input type="hidden" id="paramValue" value="${_csrf.token}" />
    <input type="hidden" id="loginStatus" value="${loginStatus}" />
</body>
</html>