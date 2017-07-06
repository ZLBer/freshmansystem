<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/20
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");response.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>填写或修改未报到原因</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/fillReasonServlet" method="post">
    <textarea name="reason" cols="50" rows="10">${param['reason']}</textarea>
    <input type="hidden" value="${param['sno']}" name="sno">
    <input type="submit" value="提交修改">
</form>
</body>
</html>
