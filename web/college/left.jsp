<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head><title>菜单页面</title></head>
<body>
<br><br><br><br><br><br>
<p><a href="query.jsp" target="right">查询新生</a></p>
<p><a href="motifypwd.jsp" target="right">修改密码</a></p>
<p><a href="college_checkBaodao.jsp" target="right">查看学院报到率</a></p>
<p><a href="college_checkNoRegister?collegeid=${user.college}&page_current=1" target="right">查看未报到学生</a></p>
</body>
</html>
