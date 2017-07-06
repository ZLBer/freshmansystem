<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/6/18
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        body{
            text-align:center;
        }
    </style>
</head>

<body>
<img src="${pageContext.request.contextPath }/images/photo/${param.sno}.jpg"/>
</body>
</html>