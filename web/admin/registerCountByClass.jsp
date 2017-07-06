<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/5/19
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
    <table>
        <tr><th>班级</th><th>报道率</th><th>班级总人数</th><th>已报到人数</th></tr>
        <td>
            <table>
                <c:forEach items="${classlist}" var="cla">
                    <tr><td>${cla}<td></tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table>
                <c:forEach items="${li}" var="l">
                    <tr><td>${l}</td></tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table>
                <c:forEach items="${all}" var="a">
                    <tr><td>${a}</td></tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table>
                <c:forEach items="${part}" var="p">
                    <tr><td>${p}</td></tr>
                </c:forEach>
            </table>
        </td>
    </table>
</body>
</html>
