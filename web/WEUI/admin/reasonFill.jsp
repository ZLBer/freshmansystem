<%--
  Created by IntelliJ IDEA.
  User: Administrator/WEUI
  Date: 2017/5/29
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");response.setCharacterEncoding("utf-8");%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>备注报到原因</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <script language="javascript">

        function countChar(status,counter)
        {
            document.getElementById(counter).innerHTML = 100 - document.getElementById(status).value.length;
        }
    </script>
</head>
<body ontouchstart>
   
    <form method="post" name="note">

        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <label class="weui_label">学生的学号:</label>
                </div>
                <div class="weui-cell__bd weui_cell_primary">
                    <input class="weui-input" type="number" name="sno" pattern="[0-9]*" placeholder="在此输入学号"/>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea class="weui-textarea" placeholder="输入未报到原因" id="status" rows="15" name="reason" onkeydown='countChar("status","counter");' onkeyup='countChar("status","counter");'maxlength="100" onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 20)" >${param['reason']}</textarea>
                    <div class="weui-textarea-counter">还可以输入<span id="counter">100</span>字</div>
                </div>
            </div>
            <a href="javascript:document.note.action='${pageContext.request.contextPath}/admin/fillReasonServlet';document.note.submit();" class="weui-btn weui-btn_primary" >备注</a>
        </div>
    </form>



<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

</body>
</html>
