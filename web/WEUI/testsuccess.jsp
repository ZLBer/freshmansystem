<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/6/19 0019
  Time: 下午 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>试卷考核</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title"><%=request.getAttribute("msg")%></h2>
        <p class="weui-msg__desc"></p>
    </div>
    <br><br>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="WeixinJSBridge.call('closeWindow');">点击返回</a>
        </p>
    </div>
</div>
</body>
</html>
