<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/30
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>专业报到情况</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-cells">
    <c:forEach items="${infoList}" var="infoRow">
        <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath }/admin/registerCountByClass?majorid=${infoRow[0]}">
            <div class="weui-cell__hd">◎&nbsp;&nbsp;</div>
            <div class="weui-cell__bd">
                <p> ${infoRow[1]}&nbsp;&nbsp;</p>
            </div>
            <div class="weui-cell__bd">
                <p> 已报到：${infoRow[3]}人</p>
            </div>
            <div class="weui-cell__ft">
                    ${infoRow[4]}
            </div>
        </a>
    </c:forEach>
</div>
</body>
</html>
