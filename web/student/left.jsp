<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head><title>菜单页面</title></head>
<body>
<br><br><br><br><br><br>
<p><a href="${pageContext.request.contextPath}/student/queryByStudent?sno=${user.sno}" target="right">查询新生</a></p>
<p><a href="${pageContext.request.contextPath}/student/motifypwd.jsp" target="right">修改密码</a></p>
<p><a href="${pageContext.request.contextPath}/student/completeInfo.jsp" target="right">完善信息</a></p>
</body>
</html>
