function loginCheck() {
	var sno = $("#sno_input").val();
	var password = $("#password_input").val();

	var code = $("#checkcode").val();
	if (sno == null || sno == "") {
		showMessage("学号不能为空！");
		return false;
	}
	if (password == null | password == "") {
		showMessage("密码不能为空！");
		return false;
	}
	if (code == null | code == "") {
		showMessage("验证码不能为空！");
		return false;
	}
	return true;
}