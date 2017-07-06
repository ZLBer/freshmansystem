<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/6/13
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>问卷</title>
    <style type="text/css">
        th,td{
            border:2px solid gray;
            text-align:left;
            padding:3px 10px;
            /*font-family:楷体;*/
        }
        td{
            margin:0px;
            border:0px;
            /*cellspacing=0;
            cellpadding=0;*/
            height:40px;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
            border-radius:15px;
            overflow:hidden;
            background:#E0ECFF;
        }

    </style>
</head>
<body>
<center>
    ${msg}<br><br>
    <form action="${pageContext.request.contextPath}/student/checkScore" method="post">
        <table>
        <c:forEach items="${plist}" var="pro">
            <tr><td>${pro.problemtext}</td></tr>

            <tr> <td><input type="radio" name="${pro.problemid}" value="A" checked>${pro.a}</td></tr>
            <tr><td><input type="radio" name="${pro.problemid}" value="B">${pro.b}</td></tr>
            <tr> <td><input type="radio" name="${pro.problemid}" value="C">${pro.c}</td></tr>
            <tr><td><input type="radio" name="${pro.problemid}" value="D">${pro.d}</td></tr>

        </c:forEach>
        <tr><td><input type="submit" value="提交"/>
            <input type="reset" value="重置"/>
            </td>
        </tr>
        </table>
        <input type="hidden" value="${user.sno}" name="sno">
    </form>
</center>
</body>
</html>
