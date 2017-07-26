<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/12
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加专业和人数</title>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
    <script type="text/javascript">
        function refresh()
        {

            var c=document.getElementById("college").value;
            var major=document.getElementById("major");
            if(c=="")
            {
                major.length=0;
                major.options.add(new Option("--请选择专业--"));
            }
            else{
                var url="list";
                var params="coll="+c;
                sendRequest(url,params,'POST',show);
            }
        }
        function show()
        {
            var major=document.getElementById("major");
            if(httpRequest.readyState==4){
                if(httpRequest.status==200)
                {
                    var majorlist=httpRequest.responseText.split(",");
                    var majornum=majorlist.length;
                    major.length=0;
                    for(i=0;i<majornum;i++)
                        major.options.add(new Option(majorlist[i]));
                }
            }
        }


    </script>
    <style>
        body{
            text-align:center;
        }
        th,td{
            border:2px solid gray;
            text-align:center;
            padding:3px 10px;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
        }
    </style>
</head>

<form action="sendMessage" method="post">
    <table align="center">
        <tr>
            <select name="collegeid" id="college" onchange="refresh()">
                <option value="0">－－请选择学院－－</option>
                <option value="1">体育与艺术学院</option>
                <option value="2">国际交流学院</option>
                <option value="3">化学与材料科学学院</option>
                <option value="4">信息科学与工程学院</option>
                <option value="5">水利土木工程学院</option>
                <option value="6">文法学院</option>
                <option value="7">外国语学院</option>
                <option value="8">生命科学学院</option>
                <option value="9">食品科学与工程学院</option>
                <option value="10">经济管理学院</option>
                <option value="11">机械与电子工程学院</option>
                <option value="12">动物科技学院</option>
                <option value="13">园艺科学与工程学院</option>
                <option value="14">林学院</option>
                <option value="15">资源与环境学院</option>
                <option value="16">植物保护学院</option>
                <option value="17">农学院</option>
            </select>
        </tr>

        <tr>
            <select name="major" id="major" >
                <option>--请选择专业--</option>
            </select>
        </tr>
        <br/>
        <br/>
        <br/>
        <tr>
            <textarea class="easyui-textbox" name="message" data-options="multiline:true" style="height:200px;width:700px"></textarea>
        </tr>
        <br/>
        <br/>
        <tr>
           <input type="submit" value="提交">

        </tr>
    </table>
${msg}
</form>

</body>
</html>