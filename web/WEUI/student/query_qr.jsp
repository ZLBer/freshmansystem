<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/2
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>个人信息</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">
            <img src="${pageContext.request.contextPath }/images/photo/${student.sno}.jpg" width="200px" height="300px"/>
        </label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学号 :${student.sno}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">姓名 :${student.name}</label>
</div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">校区 :${student.campus}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学院 :${student.college}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">专业 :${student.major}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">班级 :${student.classNum}</label>
    </div>
</div>


<div class="weui-msg__opr-area">
    <p class="weui-btn-area">
        <a href="http://pan.baidu.com/share/qrcode?w=350&h=350&url='${student.sno},${student.name},${student.college},${student.major},${student.brother},${student.brothertel},${student.helper},${student.helpertel},${student.dormNum}'" class="weui-btn weui-btn_primary" >生成二维码</a>
    </p>
</div>

</body>
</html>
