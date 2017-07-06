<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="renderer" content="webkit|ie-comp|ie-stand" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>山东农业大学新生网上报到系统</title>
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
	<script>
        function f()
        {
            document.getElementById("ck").src="${pageContext.request.contextPath}/checkcode?a="+Math.random();
        }
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
		<li><a href="${pageContext.request.contextPath}/recruitNews.jsp" >|&nbsp;录取查询&nbsp;|</a>
		</li>
	</ul>
</div>
<div class="main">
	<div class="denglu">
		<div class="text" style="font-size: 13px;">
			<font color="white"><b> <strong>重要提示：</strong><br />一、首次登录请使用学号和身份证后六位登录。<br />
				二、学生首次登陆用户请及时修改密码，以免他人盗取。<br /> 三、学生登录本系统可查看录取和分班信息，请仔细核对信息。<br />
				四、若遇到异常问题，请更换较高版本浏览器，如IE10+，任何浏览器极速模式，谷歌浏览器! </b> </font>
		</div>
		<div class="dlk">
			<form action="${pageContext.request.contextPath}/login_check.action" method="post">
				<table width="292" border="0" align="center" cellpadding="0"
					   style="margin-left: 30px;text-align: left;" cellspacing="0">
					<tr>
						<td height="76" colspan="3"></td>
					</tr>
					<tr>
						<td width="65" style="font-size: 14px; color: black;">学&nbsp;&nbsp;&nbsp;号</td>
						<td colspan="2"><input name="userid" type="text"
											   id="sno_input" class="dlinput" />
						</td>
					</tr>
					<tr>
						<td height="16" colspan="3"></td>
					</tr>
					<tr>
						<td style="color: black;">密&nbsp;&nbsp;&nbsp;码</td>
						<td colspan="2"><input type="password" name="userpwd"
											   id="password_input" class="dlinput" />
						</td>
					</tr>
					<tr>
						<td height="16" colspan="3"></td>
					</tr>
					<tr>
						<td style="color: black;">验证码</td>
						<td width="120"><input name="checkcode" type="text"
											   id="checkcode" class="dlinput" style="width: 100px;"
											   maxlength="4" />
						</td>
						<td width="127"><img src="${pageContext.request.contextPath}/checkcode" id="ck" onclick="f()"
											 alt="" width="100" height="35" />
						</td>
					</tr>
					<tr>
						<td height="16" colspan="3"></td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td colspan="2"><input type="submit" value="登 录"
											   id="userlogin" class="loginbtn" />
						</td>
					</tr>
					<tr>
						<td height="16" colspan="3"></td>
					</tr>
				</table>
				<div style="font-size: 14px; color: black;" align="center">
					${msg}
				</div>
				<input type="hidden" name="type" value="student"/>
			</form>
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>
</body>
</html>
