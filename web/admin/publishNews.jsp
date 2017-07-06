<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/7/5
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布录取通知</title>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/publishNews" method="post">
    <H4 style="color:red">
        通知内容中回车符显示为&lt;br&gt;
    </H4>
    <table >
        <tr>
            <td>通知标题： </td>
            <td><input class="easyui-textbox" type="text" name="title" value="${news.title}" ><br></td>
        </tr>
        <tr>
            <td>通知内容：</td>
            <td><input  class="easyui-textbox"  name="news" data-options="multiline:true" value="${news.content}" style="width:300px;height:100px"><br></td>
        </tr>
        <tr><td><input type="submit" value="发布"></td></tr>
        ${message}
    </table>
    </form>
</body>
</html>
