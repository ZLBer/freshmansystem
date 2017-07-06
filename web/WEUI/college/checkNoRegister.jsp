<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/7
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>查看未报道学生</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>

<c:forEach var="student" begin="${(page_current-1)*page_size}" end="${page_current*page_size-1}" items="${students}">
    <a class="weui-cell weui-cell_access" href="WEUI/college/reasonfill.jsp?sno=${student.sno}&collegeid=<%=session.getAttribute("collegeid")%>">
        <div class="weui-cell__hd">&nbsp;※</div>
        <div class="weui-cell__bd">
            <p>${student.sno}</p>
        </div>
        <div class="weui-cell__bd">
            <p>${student.reason}</p>
        </div>
        <div class="weui-cell__ft">
            <p>点击备注未报到原因</p>
        </div>
    </a>
</c:forEach>
<br>
<div class="page__hd">
    <div class="page__title">
        <a href = "${pageContext.request.contextPath }/college/college_checkNoRegister?page_current=1&collegeid=<%=session.getAttribute("collegeid")%>" >首页</a>&nbsp;
        <a href = "${pageContext.request.contextPath }/college/college_checkNoRegister?page_current=${page_current-1}&collegeid=<%=session.getAttribute("collegeid")%>" >上一页</a>&nbsp;
        <a href = "${pageContext.request.contextPath }/college/college_checkNoRegister?page_current=${page_current+1}&collegeid=<%=session.getAttribute("collegeid")%>" >下一页</a>&nbsp;
        <a href = "${pageContext.request.contextPath }/college/college_checkNoRegister?page_current=${page_count}&collegeid=<%=session.getAttribute("collegeid")%>" >尾页</a>&nbsp;
        第${page_current}页/共${page_count}页
    </div>
</div>
<br>
</body>
</html>
