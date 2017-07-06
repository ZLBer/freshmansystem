var formCheck={
	tip:function(str){
		alert(str);
	},
	
	modifyPassword:function(){
		if(isEmpty($("#old-password").val())){
			this.tip("旧密码不能为空！");
			return false;
		}
		if(isEmpty($("#new-password").val())){
			this.tip("新密码不能为空！");
			return false;
		}
		if(isEmpty($("#confirm-password").val())){
			this.tip("确认密码不能为空！");
			return false;
		}
		if($("#confirm-password").val()!=$("#new-password").val()){
			this.tip("两次密码不一致！");
			return false;
		}
		return true;
	},
	modifyDelayInfo:function(){
//		if(isEmpty($("#baodaozige").val())){
//			this.tip("是否保留报道资格不能为空！");
//			return false;
//		}
		if(isEmpty($("#yuanyin").val())){
			this.tip("不能报到原因不能为空！");
			return false;
		}
		if(isEmpty($("#time").val())){
			this.tip("预计报到时间不能为空！");
			return false;
		}
		return true;
	},
	modifyDelayInfo:function(){
//		if(isEmpty($("#baodaozige").val())){
//			this.tip("是否保留报道资格不能为空！");
//			return false;
//		}
		if(isEmpty($("#yuanyin").val())){
			this.tip("不能报到原因不能为空！");
			return false;
		}
		if(isEmpty($("#time").val())){
			this.tip("预计报到时间不能为空！");
			return false;
		}
		return true;
	},
	completeTrafficInfo:function(){
		if(isEmpty($("#company").val())){
			this.tip("同行人数不能为空！");
			return false;
		}
		return true;
	},
	modifyStudentInfo:function(){
		if(isEmpty($("#lianxifangshi").val())){
			this.tip("联系方式不能为空！");
			return false;
		}
		if(isEmpty($("#homeAddr").val())){
			this.tip("家庭详细地主不能为空！");
			return false;
		}
		if(isEmpty($("#parentName").val())){
			this.tip("家长姓名不能为空！");
			return false;
		}
		if(isEmpty($("#parentPhoneNum").val())){
			this.tip("家长联系方式不能为空！");
			return false;
		}
		if($("#junxunfuzhuang").val()=="是"){
			if(isEmpty($("#sg").val())){
				this.tip("身高不能为空！");
				return false;
			}
			if(isEmpty($("#tz").val())){
				this.tip("体重不能为空！");
				return false;
			}
			if(isEmpty($("#xh").val())){
				this.tip("鞋号不能为空！");
				return false;
			}
			
		}
		return true;
	}
};