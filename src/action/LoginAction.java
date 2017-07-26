package action;

import com.opensymphony.xwork2.ActionContext;
import po.AdminEntity;
import po.UserEntity;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class LoginAction {
	String userid;
	String userpwd;
	String checkcode;
	String type;
	String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String check(){
		String ck=(String)ActionContext.getContext().getSession().get("checkCode");
		if(checkcode.equalsIgnoreCase(ck)) {
			if (type.equals("admin")) {
				AdminEntity user = null;
				String condition = "where admin.adminname='" + userid + "'";
				List<AdminEntity> userList = new ArrayList<AdminEntity>();
				userList = HibernateUtil.query("AdminEntity admin", condition);
				if (userList.size() > 0)
					user = userList.get(0);
				if (user == null) {
					msg = "id不存在";
				} else {
					if ((userpwd).equals(user.getPassword())) {
						ActionContext.getContext().getSession().put("user", user);
						return "adminsuccess";
					} else {
						msg = "密码不正确";
					}
				}
			}
			if (type.equals("student")) {
				UserEntity user = null;
				String condition = "where user.sno='" + userid + "'";
				List<UserEntity> userList = new ArrayList<UserEntity>();
				userList = HibernateUtil.query("UserEntity user", condition);
				if (userList.size() > 0)
					user = userList.get(0);
				if (user == null) {

					msg = "id不存在";

				} else {
					if ((userpwd).equals(user.getPassword())) {
						ActionContext.getContext().getSession().put("user", user);
						return "studentsuccess";
					} else {

						msg = "密码不正确";

					}
				}
			}
			if (type.equals("college")) {
				AdminEntity user = null;
				String condition = "where admin.adminname='" + userid + "'";
				List<AdminEntity> userList = new ArrayList<AdminEntity>();
				userList = HibernateUtil.query("AdminEntity admin", condition);
				if (userList.size() > 0)
					user = userList.get(0);
				if (user == null) {
					msg = "id不存在";
				} else {
					if ((userpwd).equals(user.getPassword())) {
						ActionContext.getContext().getSession().put("user", user);
						return "collegesuccess";
					} else {
						msg = "密码不正确";
					}
				}
			}
		}
		else {
			msg="验证码不正确";}
		return "null";
	}
}
