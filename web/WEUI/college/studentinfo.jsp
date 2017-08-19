<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/4
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生信息</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学号 :${stu[0]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">姓名 :${stu[1]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">性别 :${stu[2]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">考生号 :${stu[3]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">身份证号 :${stu[4]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">校区 :${stu[5]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学院 :${stu[6]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">录取专业 :${stu[7]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">班级 :${stu[8]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">宿舍 :${stu[9]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">银行卡号 :${stu[10]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">缴费情况 :${stu[11]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学院联系方式 :${stu[12]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学校联系方式 :${stu[13]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">辅导员 :${stu[14]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">辅导员联系方式 :${stu[15]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">班主任 :${stu[16]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">班主任联系方式 :${stu[17]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">班级助理 :${stu[18]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">班级助理联系方式 :${stu[19]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">是否需要卧具：${stu[20]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">学生联系方式：${stu[21]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">家长姓名：${stu[22]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">家长联系方式：${stu[23]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">家庭详细住址：${stu[24]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">是否购买军训服装：${stu[25]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">鞋号：${stu[26]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">身高：${stu[27]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">体重：${stu[28]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">是否办理生源地助学贷款：${stu[29]}</label>
    </div>
</div>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">是否迁移户口：${stu[30]}</label>
    </div>
</div>
<div class="weui-msg__opr-area">
    <p class="weui-btn-area">
        <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="WeixinJSBridge.call('closeWindow');">点击返回</a>
    </p>
</div>
</body>
</html>

