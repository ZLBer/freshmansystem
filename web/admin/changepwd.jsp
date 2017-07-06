<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/6
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改学生密码</title>
    <link rel="stylesheet" type="text/css" href="css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/admin_changepwd" method="post">

    <table>
        <tr>
            <td>
                请输入学生学号：
            </td>
            <td>
                <input class="easyui-textbox" type="text" name="sid">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
            <td>
                <input type="reset" value="重填">
            </td>
        </tr>
    </table>
    ${message}
</form>
</body>
</html>
