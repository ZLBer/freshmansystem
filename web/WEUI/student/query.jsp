<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/23 0023
  Time: 下午 9:04
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
            <label class="weui_label">性别 :${student.sex}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">考生号 :${student.examNum}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">身份证号 :${student.idNum}</label>
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
            <label class="weui_label">录取专业 :${student.major}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">班级 :${student.classNum}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">宿舍 :${student.dormNum}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">银行卡号 :${student.bankCardId}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">缴费情况 :${student.paySta}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">学院联系方式 :${student.collegeTel}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">学校联系方式 :${student.schoolTel}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">辅导员 :${student.masterName}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">辅导员联系方式 :${student.masterTel}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">班主任 :${student.brother}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">班主任联系方式 :${student.brothertel}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">班级助理 :${student.helper}</label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">班级助理联系方式 :${student.helpertel}</label>
        </div>
    </div>

    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="WeixinJSBridge.call('closeWindow');">点击返回</a>
        </p>
    </div>

</body>
</html>
