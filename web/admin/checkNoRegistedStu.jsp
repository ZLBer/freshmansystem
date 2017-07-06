<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/4/21
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="/js/ajax.js"></script>
    <script>
        function areYouSure(stuId){
            if(window.confirm("确定要修改学号为"+stuId+"的学生的报到信息吗？")){
                window.location.href="setRegisterStateServlet?batch=false&state=yes&sno="+stuId;
            }
        }
        function selectAll(){
            var state = $("#select_all").prop("checked");
            if(state==true){
                $("#select_all").prop("checked",false)
                $(".stuSelectId").prop("checked",false);
            }else{
                $("#select_all").prop("checked",true)
                $(".stuSelectId").prop("checked",true);
            }
        }
        $(document).ready(function(){
            $("#select_all").click(function () {
                var state = $("#select_all").prop("checked");
                $(".stuSelectId").prop("checked",state);
            });
        });
    </script>
    <title>审核学生信息</title>
</head>
<body>
<h1 style="font-size: 2em">审核学生信息</h1>
<div id="count" style="margin-top:20px; margin-bottom:20px;">共查到 ${count} 条记录</div>
<form action="" method="post" name="filter">
    <a href="javascript:document.filter.action='setRegisterStateServlet?batch=true&state=yes';document.filter.submit();">批量报到</a>
    <a href="javascript:document.filter.action='setRegisterStateServlet?batch=true&state=no';document.filter.submit();">批量未报到</a>
    <table border="1" id="info_table" frame="void">
        <tr>
            <td>
                <a id="select_all_a" href="javascript:selectAll()">全选</a>
                <input type="checkbox" id="select_all">
            </td>
            <th>学号</th>
            <th>专业</th>
            <th>报到状态</th>
            <th>原因</th>
            <th>操作</th>
        </tr>
        <c:forEach var="stu" items="${registerInfo}">
            <tr>
                <td><input class="stuSelectId" type="checkbox" name="selectedNo" value="${stu.sno}"></td>
                <td>${stu.sno}</td>
                <td>${stu.college}</td>
                <td>${stu.spotRegister}</td>
                <td>${stu.reason}</td>
                <td>
                    <a href="javascript:areYouSure(${stu.sno})">报到</a>&nbsp;丨&nbsp;
                    <a href="setRegisterStateServlet?batch=false&state=no&sno=${stu.sno}">未报到</a>&nbsp;丨&nbsp;
                    <a href="fillReason.jsp?reason=${stu.reason}&sno=${stu.sno}">填写或修改未报到原因</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<div id="page_box">
    <%for (int i=(Integer) request.getAttribute("startPage")-1; i<(Integer) request.getAttribute("endPage");i++){
        out.print("<a href=javascript:document.filter.action='gotoCheckServlet?page="+(i+1)+"';document.filter.submit();>["+(i+1)+"]<a>&nbsp;");
    }%>
    &nbsp;&nbsp;当前第[${currentPage}]页
    &nbsp;&nbsp;共有[${pageCount}]页
</div>
<a href="right.jsp">返回主页</a>
<br>
<br>
<br>
<br>
</body>
</html>
