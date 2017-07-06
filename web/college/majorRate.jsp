<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/20
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>专业报道率</title>
</head>
<body>
<div>学院整体报到率:${count}</div>
    <table border="1" frame="void" class="easyui-datagrid"
					data-options="method:'get',border:false,singleSelect:true,fit:true,fitColumns:true" style="table-layout:fixed;">
       <thead>
        <tr>
            <th data-options="field:'number'">专业编号</th>
            <th data-options="field:'major'">专业名称</th>
            <th data-options="field:'renshu'">总人数</th>
            <th data-options="field:'baodaorenshu'">已报到人数</th>
            <th data-options="field:'baodaolv'">报到率</th>
            <th data-options="field:'mingxi'">查看班级明细</th>
        </tr>
        <c:forEach items="${infoList}" var="infoRow">
        <tbody>
            <tr>
                <td>${infoRow[0]}</td>
                <td>${infoRow[1]}</td>
                <td>${infoRow[2]}</td>
                <td>${infoRow[3]}</td>
                <td>${infoRow[4]}</td>
                <td><a href="registerCountByClass?majorid=${infoRow[0]}" >查看</a></td>
            </tr>
            </tbody>
        </c:forEach>
        </thead>
    </table>
</body>
</html>
