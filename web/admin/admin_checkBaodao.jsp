<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/18
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查报到率</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/admin/admin_checkBaodao" method="post">
        <input type="submit" value="查询学校整体报到率">
    </form>
</body>
</html>
