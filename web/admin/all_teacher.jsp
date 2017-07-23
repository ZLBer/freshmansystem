<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/7/23
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <title>教师列表</title>
</head>
<body>

    <table border="1" frame="void" class="easyui-datagrid" id="content"
           rownumbers="true"  width="100%">
        <thead>
        <th data-options="field:'1'">教师序号</th>
        <th data-options="field:'2'">教师登录名</th>
        <th data-options="field:'3'">教师所属学院</th>
        <th data-options="field:'4'">操作</th>
        </thead>
        <c:forEach items="${teacherlist}" var="teacherlist">
        <tbody>
        <tr>
            <td>
                ${teacherlist.id}
            </td>
            <td>
                ${teacherlist.adminname}
            </td>
            <td>
                ${teacherlist.college}
            </td>
            <td>
                <a href="${pageContext.request.contextPath }/admin/deleteTeacher?teacherid=${teacherlist.id}">删除</a>
                <a href="${pageContext.request.contextPath }/admin/alterTeacher?teacherid=${teacherlist.id}">修改密码</a>
            </td>
        </tr>
        </tbody>
        </c:forEach>
    </table>

</body>
</html>
