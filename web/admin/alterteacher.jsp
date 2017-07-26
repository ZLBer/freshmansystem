<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/7/23
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改老师信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/updateTeacher" method="post">
    <input hidden="hidden" type="text" name="id" value="${teacher.id}">
    <table>
        <input type="text" name="usertype" value="2" hidden="hidden">
        <tr>
            <td>
                要修改的老师工号（登录名）：
            </td>
            <td>
                ${teacher.adminname}
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>--%>
                <%--请选择老师所属学院：--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<select name="college" id="college"  style="width:150px">--%>
                    <%--<option value="0">－－请选择学院－－</option>--%>
                    <%--<option value="1">体育与艺术学院</option>--%>
                    <%--<option value="2">国际交流学院</option>--%>
                    <%--<option value="3">化学与材料科学学院</option>--%>
                    <%--<option value="4">信息科学与工程学院</option>--%>
                    <%--<option value="5">水利土木工程学院</option>--%>
                    <%--<option value="6">文法学院</option>--%>
                    <%--<option value="7">外国语学院</option>--%>
                    <%--<option value="8">生命科学学院</option>--%>
                    <%--<option value="9">食品科学与工程学院</option>--%>
                    <%--<option value="10">经济管理学院</option>--%>
                    <%--<option value="11">机械与电子工程学院</option>--%>
                    <%--<option value="12">动物科技学院</option>--%>
                    <%--<option value="13">园艺科学与工程学院</option>--%>
                    <%--<option value="14">林学院</option>--%>
                    <%--<option value="15">资源与环境学院</option>--%>
                    <%--<option value="16">植物保护学院</option>--%>
                    <%--<option value="17">农学院</option>--%>
                <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>
                请输入老师的登录密码：
            </td>
            <td>
                <input required="required" type="text" name="teacherpassword">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改">
            </td>
            <td>
                <%--<input type="reset" value="重置">--%>
            </td>
        </tr>
    </table>
    ${message}
</form>
</body>
</html>
