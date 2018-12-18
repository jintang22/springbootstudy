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
        function removeCart(cartId) {



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
            http.open('POST', '/api/cart/remove', false);
            http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

            var params = "";

            params += 'cartId' + '=' + cartId;
            params += '&' + document.getElementById('paramName').value + '=' + document.getElementById('paramValue').value;

            http.send(params);
            alert(http.responseText);

            window.location.href=window.location.href;
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
            <h1>장바구니</h1>
        </td>
        <c:if test = "${loginStatus == 'Logout'}">
            <td>
                <a href="/members/login">Login</a> / <a href="/members/join">Join</a>
            </td>
        </c:if>
        <c:if test = "${loginStatus == 'Login'}">
            <td>
                <a href="/">Home</a>
            </td>
            <td>
                <a href="/members/logout">Logout</a>
            </td>
        </c:if>
    </tr>
</table>

<table>
    <tr>
        <td>장바구니 번호</td>
        <td>상품명</td>
        <td>가격</td>
        <td>수량</td>
        <td></td>
    </tr>
<c:forEach items="${cartList}" var="cart">
    <tr>
        <td>${cart.id}</td>
        <td>${cart.product.name}</td>
        <td>${cart.price}</td>
        <td>${cart.quantity}</td>
        <td><input type="button" onclick="removeCart(${cart.id})" value="X"/></td>
    </tr>
</c:forEach>
</table>


<input type="hidden" id="paramName" value="${_csrf.parameterName}"/>
<input type="hidden" id="paramValue" value="${_csrf.token}" />
<input type="hidden" id="loginStatus" value="${loginStatus}" />
</body>
</html>