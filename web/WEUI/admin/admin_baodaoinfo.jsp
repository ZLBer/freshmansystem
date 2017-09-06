<%--
  Created by IntelliJ IDEA.
  User: ThinkPad/WEUI
  Date: 2017/5/29 0029
  Time: 下午 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>学院报到情况</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-cells">
    学校整体报到率：${school},报到总人数：${schoolYes}。
</div>
<div class="weui-cells">
    <c:forEach var="college"  items="${all}">
        <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath }/admin/gotoMajorDetailServlet?collegeId=${college[0]}">
            <div class="weui-cell__hd">※&nbsp;&nbsp;</div>
            <div class="weui-cell__bd">
                <p> ${college[1]}</p>
            </div>
            <div class="weui-cell__ft">
                    ${college[5]}
            </div>
        </a>
    </c:forEach>
</div>

</body>
</html>
