<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/30
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>班级报到率</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<br>
<body>
<!--<div class="weui-cells">
    <div class="weui-cell">
        <div class="weui-cell__ft">
            <p>班级</p>
        </div>&nbsp;&nbsp;&nbsp;
        <div class="weui-cell__ft">
            <p>班级报到率</p>
        </div>&nbsp;&nbsp;&nbsp;
        <div class="weui-cell__ft">
            <p>总人数</p>
        </div>&nbsp;&nbsp;&nbsp;
        <div class="weui-cell__ft">
            <p>已报到人数</p>
        </div>
    </div>
</div>-->
<table>
<tr>
        <td><div class="weui-cell__ft">
            班级&nbsp;&nbsp;&nbsp;
        </div></td>
        <td><div class="weui-cell__ft">
            已报到人数&nbsp;&nbsp;&nbsp;
        </div></td>
        <td><div class="weui-cell__ft">
            总人数&nbsp;&nbsp;&nbsp;
        </div></td>
        <td><div class="weui-cell__ft">
            班级报到率
        </div></td>
</tr>
<tr>
    <td>
        <table>
        <div class="weui-cell__bd">
            <c:forEach items="${classlist}" var="cla"><!--班级-->
                <tr><td>${cla}<td></tr>
            </c:forEach>
        </div>
        </table>
    </td>
	
    <td>
        <table>
        <div class="weui-cell__bd">
            <c:forEach items="${part}" var="p"><!--已报到人数-->
                <tr><td>${p}</td></tr>
            </c:forEach>
        </div>
        </table>
    </td>
    <td>
        <table>
            <div class="weui-cell__bd">
                <c:forEach items="${all}" var="a"><!--总人数-->
                    <tr><td>${a}</td></tr>
                </c:forEach>
            </div>
        </table>
    </td>
    <td>
        <table>
            <div class="weui-cell__bd">
                <c:forEach items="${li}" var="l"><!--报到率-->
                    <tr><td>${l}</td></tr>
                </c:forEach>
            </div>
        </table>
    </td>
	</tr>
</table>
</body>
</html>
