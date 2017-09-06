<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/20
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>学院报到率</title>
</head>
<body>
<center>
<div>学校整体报到率：${school},报到总人数：${schoolYes}。</div>
<table border="4" align="center" style= "backgound-repeat:none " frame="void"
			class="easyui-datagrid" id="content" rownumbers="true"  width="100%">
<thead>        
<tr>
    <th data-options="field:'1'">学院代码</th>
    <th data-options="field:'2'">学院名称</th>
    <th data-options="field:'3'">已报到人数</th>
    <th data-options="field:'4'">未报到人数</th>
    <th data-options="field:'5'">学院新生总人数</th>
    <th data-options="field:'6'">学院报到率</th>
    <th data-options="field:'7'">查看学院报到率</th>
</tr>
</thead>
<tbody>
    <c:forEach var="college"  items="${all}">
    <tr>
        <td>${college[0]}</td>
        <td>${college[1]}</td>
        <td>${college[2]}</td>
        <td>${college[3]}</td>
        <td>${college[4]}</td>
        <td>${college[5]}</td>
        <td><a href="gotoMajorDetailServlet?collegeId=${college[0]}">查看</a></td>
    </tr>
    </c:forEach>
</tbody>
</table>
</center>
</body>
</html>
