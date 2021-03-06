<%@ page pageEncoding="UTF-8"%>

<html>
<meta charset="utf-8">
<head>
    <title>后台管理系统V1.0</title>
    <link rel="stylesheet" type="text/css" href="css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script>
        function addTab(title, url){
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);
                var currTab = $('#tt').tabs('getSelected'); //获得当前tab
                var url = currTab.panel('options').href;
                $('#tt').tabs('update', {
                    tab: currTab,
                    options: {
                        href: url
                    }
                })
            } else {
                var content = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }
    </script>
</head>
<body>
<div style="margin:0px 0;"></div>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'" style="height:80px; background:#E0ECFF"><img src="${pageContext.request.contextPath }/student/logo.png" height="60px" >
        <div align="right"> 当前用户：${user.adminname}
            <a href="${pageContext.request.contextPath }/logout" target="_top" >退出登录</a>
        </div>
    </div>
    <div data-options="region:'south',split:true" style="height:50px; position:absolute">
    <center>鲁ICP备05002369号 | 版权所有©山东农业大学 | 地址:山东省泰安市岱宗大街61号| 邮编:271018 |</center>
    </div>
    <!--<div data-options="region:'east',split:true" title="East" style="width:180px;">
        <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
    </div>-->
    <div data-options="region:'west',split:false,iconCls:'icon-application_home',collapsed:false,collapsible:false" title="主菜单" style="width:200px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="查询新生" style="padding:10px">
                <p><a class="easyui-linkbutton" onclick="addTab('查询新生','${pageContext.request.contextPath }/college/query.jsp')"  target="right">查询新生</a></p>
                <p><a class="easyui-linkbutton" onclick="addTab('查看未报到学生','${pageContext.request.contextPath }/college/college_checkNoRegister?collegeid=${user.college}&page_current=1')"  target="right">查看未报到学生</a></p>
            </div>
            <div title="查看学院报到率" style="padding:10px;">
                <p><a class="easyui-linkbutton" onclick="addTab('查看学院报到率','${pageContext.request.contextPath }/college/gotoMajorDetailServlet?collegeId=${user.college}')" target="right">查看学院报到率</a></p><br>
            </div>
            <div title="修改密码" style="padding:10px">
                <p><a class="easyui-linkbutton" onclick="addTab('修改密码','${pageContext.request.contextPath }/college/motifypwd.jsp')"  target="right">修改密码</a></p>
            </div>
        </div>
    </div>
    <div data-options="region:'center',title:'Welcome',iconCls:'icon-ok'" style=" padding:5px;overflow:hidden ">
        <div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true" style="overflow-x:hidden">
            <div id="right" title="温馨提示"  style="padding:10px">
                温馨提示
            </div>

            <!--<div title="DataGrid" style="padding:5px">
                <table class="easyui-datagrid"
                        data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
                    <thead>
                        <tr>
                            <th data-options="field:'itemid'" width="80">Item ID</th>
                            <th data-options="field:'productid'" width="100">Product ID</th>
                            <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                            <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                            <th data-options="field:'attr1'" width="150">Attribute</th>
                            <th data-options="field:'status',align:'center'" width="50">Status</th>
                        </tr>

                    </thead>
                </table>
            </div>-->
        </div>
    </div>
</div>
</body>
</html>






















