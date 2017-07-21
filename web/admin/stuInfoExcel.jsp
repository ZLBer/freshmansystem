<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/17
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/vnd.ms-excel;charset=utf-8"%>
<% response.setHeader("Content-disposition","attachment; filename=student.xls"); %>
<html>
<meta charset="utf-8"/>
 <style type="text/css">
		th,td{
            border:2px solid gray;
            text-align:center;
            padding:3px 10px;
			font-family:楷体;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
			border-radius:15px;
			overflow:hidden;
			background:#E0ECFF;
        }
		td{
			 margin:0px;
			 border:0px;
			 /*cellspacing=0;
			 cellpadding=0;*/
			 height:40px;
			 }
</style>
<head>
    <title>infomation</title>
</head>
<body>
<center>
    <table border="1" align="center" style= "backgound-repeat:none " frame="void">
        <tr>
            <c:forEach var="fieldName" items="${fields}">
                <td>${fieldName}</td>
            </c:forEach>
        </tr>
        <c:forEach var="infoRow" items="${info}">
            <tr>
                <c:forEach var="infoCell" items="${infoRow}">
                    <td style="vnd.ms-excel.numberformat:@"> ${infoCell}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
	</center>
</body>
</html>
