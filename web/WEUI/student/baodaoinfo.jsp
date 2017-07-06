<%--
  Created by IntelliJ IDEA.
  User: ThinkPad/WEUI
  Date: 2017/6/2 0002
  Time: 下午 7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>学生信息</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<form method="post" name="baodaoinfo">
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>照片</p>
            </div>
            <div class="weui-cell__ft">
                <img src="${pageContext.request.contextPath }/images/photo/<%=session.getAttribute("sid")%>.jpg" width="200px" height="300px"/>
            </div>
        </div>
    </div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>姓名：</p>
            </div>
            <div class="weui-cell__ft">${stu[1]}</div>
        </div>
    </div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>学号：</p>
            </div>
            <div class="weui-cell__ft">${stu[0]}</div>
        </div>
    </div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>学院：</p>
            </div>
            <div class="weui-cell__ft">${stu[6]}</div>
        </div>
    </div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <p>专业：</p>
            </div>
            <div class="weui-cell__ft">${stu[7]}</div>
        </div>
    </div>
    <br>
    <a href="javascript:document.baodaoinfo.action='ManualBaodao';document.baodaoinfo.submit();" class="weui-btn weui-btn_primary">点击报道</a>
</form>
</body>
</html>
