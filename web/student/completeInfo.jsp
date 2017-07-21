<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/18
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
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
        text-align:left;
    }
    td{
        margin:0px;
        border:0px;
        /*cellspacing=0;
        cellpadding=0;*/
        height:40px;
    }

    #prat2{
        width:400px;
        height: 470px;

        float: left;
    }
    #prat3{
        width: 430px;
        height: 470px;

        float: left;
    }
    #prat4{
        width:200px;
        height:400px;

        float: left;}
    #prat5{
        width:350px;
        height:30px;

    }

</style>

<head>
    <title>完善信息</title>
</head>
<body>
<div style="margin-left: 50px;" >

    <h1><font size="+3" color="#000066" face="楷体">填写信息</font></h1>
    <form action="${pageContext.request.contextPath}/student/completeInfoServlet" method="post" >

        <div id="prat2">
            <table width="400px" align="center" style= "backgound-repeat:none ; text-align:left" frame="void">
                <tr>
                    <td style="text-align:left;">
                        <label for="phoneNum">联系方式</label>
                    </td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="phoneNum" type="text" name="phoneNum">
                    </td>
                </tr>
                <tr>
                    <td style="text-align:left">是否需要卧具<br>&nbsp;&nbsp;&nbsp;</td>
                    <td style="text-align:left">
                        <label for="yesb">需要</label><input id="yesb" type="radio" name="bedding" value="需要" checked>
                        <label for="nob">不需要</label><input id="nob" type="radio" name="bedding" value="不需要">
                    </td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        是否购买军训服<br>&nbsp;&nbsp;&nbsp;
                    </td>
                    <td style="text-align:left">
                        <label for="yesm">购买</label><input id="yesm" type="radio" name="militaryClothing" value="购买" checked>
                        <label for="nom">不购买</label><input id="nom" type="radio" name="militaryClothing" value="不购买">
                    </td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        <label for="shoeNum">鞋号(不购买可不填)</label></td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="shoeNum" type="text" name="shoeNum">
                    </td>
                <tr>
                    <td style="text-align:left">
                        <label for="height">身高(不购买可不填)</label></td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="height" type="text" name="height"></td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        <label for="weight">体重(不购买可不填)</label></td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="weight" type="text" name="weight"></td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        到校方式<br>&nbsp;&nbsp;&nbsp;</td>
                    <td style="text-align:left">
                        <label for="train">火车</label><input id="train" type="radio" name="trafficWay" value="火车" checked>
                        <label for="highRail">动车或高铁</label><input id="highRail" type="radio" name="trafficWay" value="动车或高铁">
                        <label for="bus">公共汽车</label><input id="bus" type="radio" name="trafficWay" value="公共汽车">
                        <label for="selfDrive">自驾车</label><input id="selfDrive" type="radio" name="trafficWay" value="自驾车">
                        <label for="plane">飞机</label><input id="plane" type="radio" name="trafficWay" value="飞机">
                        <label for="other">其他</label><input id="other" type="radio" name="trafficWay" value="其他">
                    </td>
                </tr>
          
            </table>
        </div>
        <div id="prat3">
            <table width="400px" height="360px" align="center" style= "backgound-repeat:none ; text-align:left" frame="void">
                <tr>
                    <td style="text-align:left">
                        <label for="parentName">家长姓名</label>
                    </td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="parentName" type="text" name="parentName">
                    </td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        <label for="parentPhoneNum">家长联系方式</label>
                    </td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="parentPhoneNum" type="text" name="parentPhoneNum">
                    </td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        <label for="homeAddr">家庭详细地址</label>
                    </td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="homeAddr">
                    </td>

                </tr>
                <tr>

                    <td style="text-align:left">
                        是否办理生源基地贷款<br>&nbsp;&nbsp;&nbsp;</td>
                    <td style="text-align:left">
                        <label for="yesl">办理</label><input id="yesl" type="radio" name="loan" value="办理" checked>
                        <label for="nol">不办理</label><input id="nol" type="radio" name="loan" value="不办理"></td>
                </tr>
                <tr>

                    <td style="text-align:left">
                        是否迁移户口<br>&nbsp;&nbsp;&nbsp;</td>
                    <td style="text-align:left">
                        <label for="yest">是</label><input id="yest" type="radio" name="transfer" value="是" checked>
                        <label for="not">否</label><input id="not" type="radio" name="transfer" value="否"></td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        <label for="company">同行人数</label></td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="company" type="text" name="company"></td>
                </tr>
                <tr>
                    <td style="text-align:left">
                        <label for="registerTime">预计报道时间(格式:YYYY-MM-DD)</label></td>
                    <td style="text-align:left">
                        <input class="easyui-textbox" id="registerTime" type="text" name="registerTime"></td>
                </tr>
            </table>
        </div>
        <div id="prat4">
            <font face="楷体" size="+1">学生照片</font><br>
            <img src="${pageContext.request.contextPath }/images/photo/${user.sno}.jpg" width="200px" height="300px"/>
        </div>

        <!--<table align="center" style= "backgound-repeat:none ; text-align:left" frame="void" width="800px">-->
        <div id="prat5">
            <input type="submit" value="提交"/>

            <input type="reset" value="重填">
        </div>
    </form>
</div>
</body>
</html>
