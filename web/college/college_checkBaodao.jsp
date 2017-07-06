<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/20
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学院报到率</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/college/gotoMajorDetailServlet?collegeId=${user.college}">
    <input type="submit" value="查看学院报到率">
</form>
</body>
</html>
