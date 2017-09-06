<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/9/3
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/vnd.ms-excel;charset=utf-8"%>
<% response.setHeader("Content-disposition","attachment; filename=register-info.xls"); %>
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
                    <td>学号</td>
                    <td>学院</td>
                    <td>报到状态</td>
                    <td>未报到理由</td>
                </tr>
                <c:forEach var="infoRow" items="${infoList}">
                    <tr>
                        <td>${infoRow.sno}</td>
                        <td>${infoRow.college}</td>
                        <td>${infoRow.spotRegister}</td>
                        <td>${infoRow.reason}</td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
