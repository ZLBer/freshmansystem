
<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/20
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>查看未报到学生</title>
</head>
<body style="text-align:center">
<table border="1" frame="void" class="easyui-datagrid" id="content"
       rownumbers="true"  width="100%">
   <thead>
    <tr>
        <th data-options="field:'id'">学号</th>
        <th data-options="field:'reason'">未报到原因</th>
        <th data-options="field:'ide'">备注</th>
    </tr>
    <c:forEach var="student" begin="${(page_current-1)*page_size}" end="${page_current*page_size-1}" items="${students}">
        <tbody>
        <tr>
            <td>${student.sno}</td>
            <td>${student.reason}</td>
            <td><a href="${pageContext.request.contextPath }/admin/admin_beizhu.jsp?sno=${student.sno}">备注未报到原因</a></td>
        </tr>
        </tbody>
    </c:forEach>
    </thead>
</table>

        <a href = "${pageContext.request.contextPath }/admin/admin_checkNoRegister?page_current=1&collegeid=${user.college}" >首页</a>&nbsp;
        <a href = "${pageContext.request.contextPath }/admin/admin_checkNoRegister?page_current=${page_current-1}&collegeid=${user.college}" >上一页</a>&nbsp;
        <a href = "${pageContext.request.contextPath }/admin/admin_checkNoRegister?page_current=${page_current+1}&collegeid=${user.college}" >下一页</a>&nbsp;
        <a href = "${pageContext.request.contextPath }/admin/admin_checkNoRegister?page_current=${page_count}&collegeid=${user.college}" >尾页</a>&nbsp;
        第${page_current}页/共${page_count}页

</body>
</html>
