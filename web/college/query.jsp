<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <style>
        body{
            text-align:center;
        }

    </style>
    <script language="javascript">
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath }/college/queryByCollege" method="post" id="query">
    <select name="fieldName">
        <option value="" <c:if test="${param.fieldName==''}">selected</c:if>>全部</option>
        <option value="sno" <c:if test="${param.fieldName=='sno'}">selected</c:if>>学号</option>
        <option value="name" <c:if test="${param.fieldName=='name'}">selected</c:if>>姓名</option>
        <option value="sex" <c:if test="${param.fieldName=='sex'}">selected</c:if>>性别</option>
        <option value="examNum" <c:if test="${param.fieldName=='examNum'}">selected</c:if>>考生号</option>
        <option value="idNum" <c:if test="${param.fieldName=='idNum'}">selected</c:if>>身份证号</option>
        <option value="campus" <c:if test="${param.fieldName=='campus'}">selected</c:if>>校区</option>
        <option value="college" <c:if test="${param.fieldName=='college'}">selected</c:if>>学院</option>
        <option value="major" <c:if test="${param.fieldName=='major'}">selected</c:if>>录取专业</option>
        <option value="classNum" <c:if test="${param.fieldName=='classNum'}">selected</c:if>>班级</option>
        <option value="dormNum" <c:if test="${param.fieldName=='dormNum'}">selected</c:if>>宿舍</option>
    </select>
    <input type="text" name="fieldValue" value="${param.fieldValue}"/>
    <input type="hidden" name="pageNo" value="1"/>
    <input type="submit" value="查询"/>
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <table border="1" frame="void" class="easyui-datagrid" id="content"
           rownumbers="true"  width="100%">
        <thead>
        <th data-options="field:'1'">学号</th>				<th data-options="field:'2'">姓名</th>
        <th data-options="field:'3'">性别</th>				<th data-options="field:'4'">考生号</th>
        <th data-options="field:'5'">身份证号</th>			<th data-options="field:'6'">校区</th>
        <th data-options="field:'7'">学院</th>				<th data-options="field:'8'">录取专业</th>
        <th data-options="field:'9'">班级</th>				<th data-options="field:'10'">宿舍</th>
        <th data-options="field:'11'">银行卡号</th>			<th data-options="field:'12'">缴费情况</th>
        <th data-options="field:'13'">学院联系方式</th>		<th data-options="field:'14'">学校联系方式</th>
        <th data-options="field:'15'">辅导员</th>			<th data-options="field:'16'">辅导员联系方式</th>
        <th data-options="field:'17'">班主任</th>			<th data-options="field:'18'">班主任联系方式</th>
        <th data-options="field:'19'">班助</th>				<th data-options="field:'20'">班助联系方式</th>
        <th data-options="field:'21'">是否需要卧具</th>		<th data-options="field:'22'">学生联系方式</th>
        <th data-options="field:'23'">家长姓名</th>			<th data-options="field:'24'">家长联系方式</th>
        <th data-options="field:'25'">家庭详细住址</th>		<th data-options="field:'26'">是否购买军训服装</th>
        <th data-options="field:'27'">鞋号</th>				<th data-options="field:'28'">身高</th>
        <th data-options="field:'29'">体重</th>				<th data-options="field:'30'">是否办理生源地助学贷款</th>
        <th data-options="field:'31'">注册时间</th>          <th data-options="field:'31'">到校方式</th>
        <th data-options="field:'31'">同行人数</th>          <th data-options="field:'31'">预计报到时间</th>

        </thead>
        <tbody>
        <c:forEach items="${studentList}" var="stu">
            <tr>
                <c:forEach items="${stu}" var="student">
                    <td>${student}</td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    共有记录${recordCount}条， 第${pageNo}/${pageCount}页，
    <c:if test="${pageNo>1}">
        <a href="javascript:jump1('1')">首页</a>
        <a href="javascript:jump1('${pageNo-1}')">上页</a>
    </c:if>
    <c:if test="${pageNo==1}">
        首页  上页
    </c:if>
    <c:if test="${pageNo<pageCount}">
        <a href="javascript:jump1('${pageNo+1}')">下页</a>
        <a href="javascript:jump1('${pageCount}')">末页</a>
    </c:if>
    <c:if test="${pageNo==pageCount}">
        下页   末页
    </c:if>
</c:if>
</body>
</html>