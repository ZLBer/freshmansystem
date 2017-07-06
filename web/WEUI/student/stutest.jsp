<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/6/18 0018
  Time: 下午 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>学生考核</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-cells">${msg}</div>
<form name="stutest" method="post">
    <input type="hidden" value="<%=session.getAttribute("userid")%>" name="sno">
    <%int i=1;%>
    <c:forEach items="${plist}" var="pro">

        <div class="weui-cells">
                ${pro.problemtext}<br>
            <div class="weui-cells weui-cells_radio">

                <label class="weui-cell weui-check__label" for="<%=4*i+1%>">
                    <div class="weui-cell__bd">
                        <p>&nbsp;&nbsp;&nbsp;${pro.a}</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="${pro.problemid}" value="A" id="<%=4*i+1%>" checked>
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>

                <label class="weui-cell weui-check__label" for="<%=4*i+2%>">
                    <div class="weui-cell__bd">
                        <p>&nbsp;&nbsp;&nbsp;${pro.b}</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="${pro.problemid}" id="<%=4*i+2%>" value="B">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>

                <label class="weui-cell weui-check__label" for="<%=4*i+3%>">
                    <div class="weui-cell__bd">
                        <p>&nbsp;&nbsp;&nbsp;${pro.c}</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="${pro.problemid}" id="<%=4*i+3%>" value="C">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>

                <label class="weui-cell weui-check__label" for="<%=4*i+4%>">
                    <div class="weui-cell__bd">
                        <p>&nbsp;&nbsp;&nbsp;${pro.d}</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="${pro.problemid}" id="<%=4*i+4%>" value="D">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>

            </div>
        </div>
        <%i++;%>
    </c:forEach>
    <br>

    <a href="javascript:document.stutest.action='checkScore';document.stutest.submit();" class="weui-btn weui-btn_primary">交卷</a>

    <br>
</form>
</body>
</html>
