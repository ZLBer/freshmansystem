<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/30 0024
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>查询学生</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<br><br><br>
<form method="post" name="manual">
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <label class="weui_label">学生的学号:</label>
            </div>
            <div class="weui-cell__bd weui_cell_primary">
                <input class="weui-input" type="number" name="fieldValue" pattern="[0-9]*" placeholder="在此输入学号"/>
            </div>
        </div>
    </div>
    <br><br><br>
    <a href="javascript:document.manual.action='ManualBaodao?fieldName=sno';document.manual.submit();" class="weui-btn weui-btn_primary">确定</a>
    <br><br><br>
</form>
</body>
</html>
