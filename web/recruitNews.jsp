<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>山东农业大学新生网上报到系统</title>
    <link href="${pageContext.request.contextPath}/css/style_1.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script>
        $(document).ready(function(){
            $('#tb').hide();
            $.ajax({url:"${pageContext.request.contextPath}/recruitNew",
                data:{
                },
                type:'post',dataType:'json',success:function(result){
                    $("#title").html(result.title);
                    $("#time").html(result.time1);
                    $("#content").html(result.content);
                }});
            $("button").click(function(){
                var examid=$("#examid1").val();
                var name=$("#name1").val();
                $.ajax({url:"${pageContext.request.contextPath}/recruitSearch",
                    data:{
                        examid:examid,
                        name:name

                    },
                    type:'post',dataType:'json',success:function(result){
                        $('#ta').hide();
                        $('#tb').show();
                        $("#message").html(result.msg);
                        $("#name").html(result.name);
                        $("#number").html(result.sno);
                        $("#college").html(result.college);
                        $("#examid").html(result.examid);
                        $("#major").html(result.major);
                    }});
            });
        });

    </script>
</head>

<body>
<div class="top">
    <img src="${pageContext.request.contextPath}/images/logo.png" height="56px" width="300px"
         style="float: left; padding: 2px 0px">
    <ul>
        <li><a href="#none">&nbsp;</a>
        </li>
        <li><a href="#none">&nbsp;</a>
        </li>
        <li><a href="http://www.sdau.edu.cn" class="hover"
               target="_blank">|&nbsp;学校主页&nbsp;|</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/college-login.jsp">|&nbsp;学院入口&nbsp;|</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/admin-login.jsp">|&nbsp;管理入口&nbsp;|</a>
        </li>
        <li><a href="http://zhaosheng.sdau.edu.cn/" target="_blank">|&nbsp;通知公告&nbsp;|</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/recruitNews.jsp">|&nbsp;录取查询&nbsp;|</a>
        </li>
    </ul>
</div>
<div class="main">
    <div class="denglu" >
        <div class="text" style="font-size: 14px;width:530px;height:300px;background-color:rgba(255,255,255,0.52);;position: absolute; bottom: 0;left: 150px;border-radius:8px">
            <div  id="title" style="color:#000000;text-align: center;font-size:25px;opacity: 1"></div>
            <div  id="time" style="color:#000000;text-align: center;opacity: 1"></div>
            <div  id="content" style="width:530px;color:#000000;opacity: 1"></div>
        </div>
        <div class="dlk">

            <table id="ta" width="292" border="0" align="center" cellpadding="0"
                   style="margin-left: 30px;text-align: left;" cellspacing="0">
                <tr>
                    <td height="76" colspan="3"></td>
                </tr>
                <tr>
                    <td width="65" style="font-size: 14px; color: black;">考生号</td>
                    <td colspan="2"><input class="dlinput"  type="text" id="examid1"/>
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>
                <tr>
                    <td style="color: black;"> 姓名</td>
                    <td colspan="2"><input class="dlinput"  type="text" id="name1"/>
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <button class="loginbtn" type="button">查询</button>
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>

            </table>

            <table id="tb" width="500" border="0" align="center" cellpadding="0"
                   style="margin-left: 30px;text-align: left;" cellspacing="0">
                <tr>
                    <td height="76" colspan="3"></td>
                </tr>
                <tr>
                    <td style="color: black;">提示</td>
                    <td width="320"><div  style="color: black;" id="message"></div>
                    </td>
                    <td width="127">
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>
                <tr>
                    <td style="color: black;">姓名</td>
                    <td width="120"><div  style="color: black;" id="name"></div>
                    </td>
                    <td width="127">
                   </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>
                <tr>
                    <td style="color: black;">考生号</td>
                    <td width="120"><div style="color: black;" id="examid"></div>
                    </td>
                    <td width="127">
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>
                <%--<tr>--%>
                    <%--<td style="color: black;">学号</td>--%>
                    <%--<td width="120"><div  style="color: black;" id="number"></div>--%>
                    <%--</td>--%>
                    <%--<td width="127">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td height="16" colspan="3"></td>--%>
                <%--</tr>--%>
                <tr>
                    <td style="color: black;">学院</td>
                    <td width="120"><div  style="color: black;" id="college"></div>
                    </td>
                    <td width="127">
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>
                <tr>
                    <td style="color: black;">专业</td>
                    <td width="120"><div  style="color: black;" id="major"></div>
                    </td>
                    <td width="127">
                    </td>
                </tr>
                <tr>
                    <td height="16" colspan="3"></td>
                </tr>

            </table>


        </div>
    </div>
</div>

<%@ include file="/footer.jsp"%>
</body>
</html>
