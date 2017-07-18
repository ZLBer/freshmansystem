<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/17
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>download</title>
    <script typet="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
//        多选功能
        function selectAll(obj) {
            $x = $(obj);
            var name = $x.attr("group");
            var state = $x.prop("checked");
            $div = $x.parents(".pageFormContent");
            var items = $div.find("[name='"+name+"']");
            for(var i=0;i<items.length;i++){
                $(items[i]).prop("checked",state);
            }
        };
    </script>
</head>
<body>
<div class="pageHeader">
    <div class="searchBar">
        <table class="searchContent">
            <tr>
                <td rowspan="3" style="text-align: right;"><label style="color: black; font-size: 14px; font-family: '黑体'">说明</label></td>
                <td><label style="color: red; font-family: '黑体'; font-size: 12px">1、请选择对应的导出信息，谨慎操作!</label></td>
            </tr>
            <tr>
                <td><label style="color: red; font-family: '黑体'; font-size: 12px">2、基本信息中的考生号为必选项!</label></td>
            </tr>
        </table>
    </div>
</div>
<div class="pageContent">
    <form action="${pageContext.request.contextPath}/admin/downloadInfoServlet" method="post">
        <div class="pageFormContent" layoutH="420">
            <input type="hidden" value="basicinfo.sno-学号" name="basic">
            <label><input type="checkbox" class="checkboxCtrl" group="basic" onclick="selectAll(this)"/>全选</label>
            <label><input type="checkbox" name="basic" value="basicinfo.name-姓名" />姓名</label>
            <label><input type="checkbox" name="basic" value="basicinfo.sex-性别" />性别</label>
            <label><input type="checkbox" name="basic" value="basicinfo.examNum-考生号" checked/>考生号</label>
            <label><input type="checkbox" name="basic" value="basicinfo.idNum-身份证号"	 />身份证号</label>
            <label><input type="checkbox" name="basic" value="basicinfo.bankCardId-银行卡号" />银行卡号</label>
            <label><input type="checkbox" name="basic" value="basicinfo.campus-校区" />校区</label>
            <label><input type="checkbox" name="basic" value="basicinfo.college-学院"	  />学院</label>
            <label><input type="checkbox" name="basic" value="basicinfo.major-专业" />专业</label>
            <label><input type="checkbox" name="basic" value="basicinfo.classNum-班级" />班级</label>
            <label><input type="checkbox" name="basic" value="basicinfo.dormNum-宿舍" />宿舍</label>
            <label><input type="checkbox" name="basic" value="basicinfo.paySta-缴费状态" />缴费状态</label>
            <label><input type="checkbox" name="basic" value="basicinfo.collegeTel-学院电话" />学院电话</label>
            <label><input type="checkbox" name="basic" value="basicinfo.schoolTel-学校电话" />学校电话</label>
            <label><input type="checkbox" name="basic" value="basicinfo.masterName-辅导员" />辅导员</label>
            <label><input type="checkbox" name="basic" value="basicinfo.masterTel-辅导员电话" />辅导员电话</label>
            <label><input type="checkbox" name="basic" value="basicinfo.brother-班主任" />班主任</label>
            <label><input type="checkbox" name="basic" value="basicinfo.brothertel-班主任电话" />班主任电话</label>
            <label><input type="checkbox" name="basic" value="basicinfo.helper-班助姓名" />班助姓名</label>
            <label><input type="checkbox" name="basic" value="basicinfo.helpertel-班助电话" />班助电话</label>
        </div>
        <div class="divider"></div>
        <div class="pageFormContent" layoutH="600">
            <label><input type="checkbox" class="checkboxCtrl" group="telephone" onclick="selectAll(this)"/>全选</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.phoneNum-本人电话" />本人电话</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.bedding-卧具" />卧具</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.homeAddr-详细地址" />详细地址</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.parentName-家长姓名" />家长姓名</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.parentPhoneNum-家长电话" />家长电话</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.militaryClothing-军训服装" />军训服装</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.shoeNum-鞋号" />鞋号</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.height-身高" />身高</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.weight-体重" />体重</label>
            <label><input type="checkbox" name="telephone" value="stcompleteinfo.loan-生源地贷款" />是否办理生源地贷款</label>
        </div>
        <div class="divider"></div>
        <div class="pageFormContent" layoutH="600">
            <label><input type="checkbox" class="checkboxCtrl" group="traffic" onclick="selectAll(this)"/>全选</label>
            <label><input type="checkbox" name="traffic" value="trafficinfo.trafficWay-学生到校方式" />学生到校方式</label>
            <label><input type="checkbox" name="traffic" value="trafficinfo.company-同行人数" />同行人数</label>
            <label><input type="checkbox" name="traffic" value="trafficinfo.registerTime-预计报到时间" />预计报到时间</label>
        </div>
        <div class="divider"></div>
        <div class="formBar">
            <ul style="float: left; margin-left: 3px">
                <li><input class="buttonActive" type="submit" value="导出信息" /></li>
            </ul>
        </div>
    </form>
</div>
</body>
</html>
