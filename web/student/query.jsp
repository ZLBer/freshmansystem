<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
 <style type="text/css">
		th,td{
            border:2px solid gray;
            text-align:left;
            padding:3px 10px;
			/*font-family:楷体;*/
        }
		td{
			 margin:0px;
			 border:0px;
			 /*cellspacing=0;
			 cellpadding=0;*/
			 height:40px;
			 }
        table{
            border-collapse:collapse;
            margin:0 auto;
			border-radius:15px;
			overflow:hidden;
			background:#E0ECFF;
        	}
		
</style>
</head>
<body>
<div style="padding-right:200px">
    <table align="center"  rownumbers="true" style= "table-layout:fixed;backgound-repeat:none " frame="void" width="800px">
                    <tr>
                        <td>学号</td><td>${student.sno}</td>
                        <td>姓名</td><td>${student.name}</td>
                        <!--<img src="${pageContext.request.contextPath }/images/photo/${user.sno}.jpg"/>-->
                    </tr>
                    <tr>
                        <td>性别</td><td>${student.sex}</td>
                        <td>考生号</td><td>${student.examNum}</td>
                     </tr>
                     <tr>
                        <td>身份证号</td><td>${student.idNum}</td>
                        <td>校区</td> <td>${student.campus}</td>
                     </tr>
                     <tr>
                        <td>学院</td> <td>${student.college}</td>
                        <td>录取专业</td> <td>${student.major}</td> 
                     </tr>
                     <tr>
                        <td>班级</td><td>${student.classNum}</td>
                        <td>宿舍</td><td>${student.dormNum}</td>
                    </tr>
                     <tr>
                        <td>银行卡号</td> <td>${student.bankCardId}</td>
                        <td>缴费情况</td><td>${student.paySta}</td>
                     </tr>
                     <tr>
                        <td>学院联系方式</td> <td>${student.collegeTel}</td>
                        <td>学校联系方式</td> <td>${student.schoolTel}</td>
                     </tr>
                     <tr>
                        <td>辅导员</td><td>${student.masterName}</td>
                        <td>辅导员联系方式</td> <td>${student.masterTel}</td>
                     </tr>
                     <tr>
                        <td>班主任</td> <td>${student.brother}</td>
                        <td>班主任联系方式</td><td>${student.brothertel}</td>
                     </tr>
                     <tr>
                        <td>班助</td><td>${student.helper}</td>
                        <td>班助联系方式</td><td>${student.helpertel}</td>
                    </tr>
    </table>
    </div>
${msg}
</body>
</html>