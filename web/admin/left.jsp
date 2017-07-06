<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head><title>菜单页面</title></head>
<body>
<br><br><br><br><br><br>
<p><a href="${pageContext.request.contextPath }/admin/query.jsp" target="right">查询新生</a></p>
<p><a href="${pageContext.request.contextPath }/admin/gotoCheckServlet" target="right">查看学生报到信息</a></p>
<p><a href="${pageContext.request.contextPath }/admin/motifypwd.jsp" target="right">修改密码</a></p>
<p><a href="${pageContext.request.contextPath }/admin/uploadExcel.jsp" target="right">上传Excel文档至数据库</a></p>
<p><a href="${pageContext.request.contextPath }/admin/downloadStuInfoExcel.jsp" target="right">下载学生信息Excel表</a></p>
<p><a href="${pageContext.request.contextPath }/admin/admin_checkBaodao.jsp" target="right">查看报到率</a></p>
</body>
</html>
