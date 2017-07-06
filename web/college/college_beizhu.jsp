<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/20
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>备注未报道原因</title>
    <link rel="stylesheet" type="text/css" href="css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>


<form method="post" action="college_changeReason?sno=<%=request.getParameter("sno")%>&collegeid=<%=request.getParameter("collegeid")%>">
    <input class="easyui-textbox" data-options="multiline:true" style="width:300px;height:100px" name="reason">
    </br>
    <input type="submit" value="提交">
</form>
</body>
</html>
