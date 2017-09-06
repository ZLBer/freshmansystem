<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/24 0024
  Time: 下午 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>完善信息</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<br><br>
<form  method="post" name="xinxi">

    <div class="weui-cells__title">是否需要卧具(点击选择)</div>
    <label class="weui_label">
        <input type="hidden" name="bedding" value="${student.bedding}">
        <c:choose>
            <c:when test="${student.bedding=='需要'}">需要</c:when>
            <c:when test="${student.bedding=='不需要'}">不需要</c:when>
            <c:otherwise> </c:otherwise>
        </c:choose>
    </label>
    <%--<div class="weui-cells weui-cells_radio">--%>
        <%--<label class="weui-cell weui-check_label" for="1">--%>
            <%--<div class="weui-cell_bd">--%>
                <%--<p>需要</p>--%>
            <%--</div>--%>
            <%--<div class="weui-cell_ft">--%>
                <%--<input type="radio" class="weui-check" name="bedding" value="需要" id="1"  <c:if test="${student.bedding=='需要'||student.bedding==''}"> checked </c:if>>--%>
                <%--<span class="weui-icon-checked"></span>--%>
            <%--</div>--%>
        <%--</label>--%>
        <%--<label class="weui-cell weui-check_label" for="2">--%>
                <%--<div class="weui-cell_bd">--%>
                <%--<p>不需要</p>--%>
            <%--</div>--%>
            <%--<div class="weui-cell_ft">--%>
                <%--<input type="radio" class="weui-check" name="bedding" value="不需要" id="2" <c:if test="${student.bedding=='不需要'}"> checked </c:if>>--%>
                <%--<span class="weui-icon-checked"></span>--%>
            <%--</div>--%>
        <%--</label>--%>
    <%--</div>--%>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <label class="weui_label">联系方式：</label>
            </div>
            <div class="weui-cell__bd weui_cell_primary">
                <input class="weui-input" type="number"  name="phoneNum" value="${student.phoneNum}" placeholder="在此输入联系方式" required/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <label class="weui_label">家长姓名：</label>
            </div>
            <div class="weui-cell__bd weui_cell_primary">
                <input class="weui-input" type="text"  name="parentName" value="${student.parentName}" placeholder="在此输入家长姓名" required/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <label class="weui_label">家长联系方式：</label>
            </div>
            <div class="weui-cell__bd weui_cell_primary">
                <input class="weui-input" type="number"  name="parentPhoneNum" value="${student.parentPhoneNum}" placeholder="在此输入家长联系方式" required/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <label class="weui_label">家庭详细地址：</label>
            </div>
            <div class="weui-cell__bd weui_cell_primary">
                <input class="weui-input" type="text"  name="homeAddr"  value="${student.homeAddr}" placeholder="在此输入家庭详细地址" required/>
            </div>
        </div>
    <div class="weui-cells__title">是否购买军训服(点击选择)</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check_label" for="3">
            <div class="weui-cell_bd">
                <p>购买</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="militaryClothing" value="购买" id="3" <c:if test="${student.militaryClothing=='购买'||student.militaryClothing==''}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="4">
            <div class="weui-cell_bd">
                <p>不购买</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="militaryClothing" value="不购买" id="4" <c:if test="${student.militaryClothing=='不购买'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <label class="weui_label">鞋号：</label>
        </div>
        <div class="weui-cell__bd weui_cell_primary">
            <input class="weui-input" type="number"  name="shoeNum" value="${student.shoeNum}" placeholder="不购买可不填" >
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <label class="weui_label">身高：</label>
        </div>
        <div class="weui-cell__bd weui_cell_primary">
            <input class="weui-input" type="number"  name="height" value="${student.height}" placeholder="不购买可不填（单位米）" >
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <label class="weui_label">体重：</label>
        </div>
        <div class="weui-cell__bd weui_cell_primary">
            <input class="weui-input" type="number"  name="weight" value="${student.weight}" placeholder="不购买可不填（单位公斤）" >
        </div>
    </div>
    <div class="weui-cells__title">是否办理生源基地贷款(点击选择)</div>
    <label class="weui_label">
    <input type="hidden" name="loan" value="${student.loan}">
        <c:choose>
            <c:when test="${student.loan=='办理'}">办理</c:when>
            <c:when test="${student.loan=='不办理'}">不办理</c:when>
            <c:otherwise> </c:otherwise>
        </c:choose>
    </label>
    <%--<div class="weui-cells weui-cells_radio">--%>
        <%--<label class="weui-cell weui-check_label" for="5">--%>
            <%--<div class="weui-cell_bd">--%>
                <%--<p>办理</p>--%>
            <%--</div>--%>
            <%--<div class="weui-cell_ft">--%>
                <%--<input type="radio" class="weui-check" name="loan" value="办理" id="5" <c:if test="${student.loan=='办理'}">checked</c:if>>--%>
                <%--<span class="weui-icon-checked"></span>--%>
            <%--</div>--%>
        <%--</label>--%>
        <%--<label class="weui-cell weui-check_label" for="6">--%>
            <%--<div class="weui-cell_bd">--%>
                <%--<p>不办理</p>--%>
            <%--</div>--%>
            <%--<div class="weui-cell_ft">--%>
                <%--<input type="radio" class="weui-check" name="loan" value="不办理" id="6"  <c:if test="${student.loan=='不办理'||student.loan==''}">checked</c:if>>--%>
                <%--<span class="weui-icon-checked"></span>--%>
            <%--</div>--%>
        <%--</label>--%>
    <%--</div>--%>

    <div class="weui-cells__title">是否迁移户口(点击选择)</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check_label" for="7">
            <div class="weui-cell_bd">
                <p>是</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="transfer" value="是" id="7" <c:if test="${student.rTime=='是'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="8" >
            <div class="weui-cell_bd">
                <p>否</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="transfer" value="否" id="8" <c:if test="${student.rTime=='否'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
    </div>

    <div class="weui-cells__title">到校方式(点击选择)</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check_label" for="9">
            <div class="weui-cell_bd">
                <p>火车</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="trafficWay" value="火车" id="9"  <c:if test="${traffic.trafficWay=='火车'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="10">
            <div class="weui-cell_bd">
                <p>动车或高铁</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="trafficWay" value="动车或高铁" id="10"  <c:if test="${traffic.trafficWay=='动车或高铁'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="11">
            <div class="weui-cell_bd">
                <p>公共汽车</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="trafficWay" value="公共汽车" id="11" <c:if test="${traffic.trafficWay=='公共汽车'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="12">
            <div class="weui-cell_bd">
                <p>自驾车</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="trafficWay" value="自驾车" id="12" <c:if test="${traffic.trafficWay=='自驾车'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="13">
            <div class="weui-cell_bd">
                <p>飞机</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="trafficWay" value="飞机" id="13" <c:if test="${traffic.trafficWay=='飞机'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="14">
            <div class="weui-cell_bd">
                <p>其他</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="trafficWay" value="其他" id="14" <c:if test="${traffic.trafficWay=='其他'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
            </div>
        </label>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <label class="weui_label">同行人数：</label>
        </div>
        <div class="weui-cell__bd weui_cell_primary">
            <input class="weui-input" type="number"  name="company" value="${traffic.company}" placeholder="在此填写同行人数" >
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <label class="weui_label">预计报到时间：</label>
        </div>
        <div class="weui-cell__bd weui_cell_primary">
            <input class="weui-input" type="text"  name="registerTime" value="${traffic.registerTime}" placeholder="在此填写报到时间" >
        </div>
    </div>
    <div class="weui-cells__tips">格式：YYYY-MM-DD</div>

<br>
    <a href="javascript:document.xinxi.action='${pageContext.request.contextPath}/student/completeInfoServlet';document.xinxi.submit();" class="weui-btn weui-btn_primary">提交信息</a>
</form>
</body>
</html>
