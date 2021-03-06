package weixin.contacts.util;

import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;

/**
 * 通讯录标签管理类
 * @author Engineer.Jsp
 * @date 2014.10.10*/
public class MTag {
	//创建标签地址
	public static String CREATE_TAG_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN";
	//更新标签地址
	public static String UPDATA_TAG_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN";
	//删除标签地址
	public static String DELETE_TAG_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=ID";
	//获取标签成员地址
	public static String GET_TAG_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=ID";
	//增加标签成员地址
	public static String ADD_TAG_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN";
	//删除标签成员地址
	public static String DELETE_TAG_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN";


	/**
	 * 创建标签
	 * @param tagname 标签名称。长度为1~64个字符，标签不可与其他同组的标签重名，也不可与全局标签重名
	 * */
	public static String Create_Tag(String tagname){
		String PostData = "{\"tagname\": %s}";
		String tagnam="\""+tagname+"\"";
		return String.format(PostData, tagnam);
	}

	/**
	 * 更新标签名字
	 * @param tagid 标签ID
	 * @param tagname 标签名称。最长64个字符
	 * */
	public static String Updata_Tag(String tagid , String tagname){
		String PostData = "{\"tagid\": %s,\"tagname\": %s}";
		return String.format(PostData, tagid,tagname);
	}

	/**
	 * 删除标签
	 * @param tagid 标签ID
	 * */
	public static String Delete_Tag(String tagid){
		String delete_url = DELETE_TAG_URL.replace("ID", tagid);
		return delete_url;
	}

	/**
	 * 获取标签成员
	 * @param tagid 标签ID
	 * */
	public static String Get_Tag_Person(String tagid){
		String get_tagperson_url = GET_TAG_PERSON.replace("ID", tagid);
		return get_tagperson_url;
	}

	/**
	 * 增加标签成员
	 * @param tagid 标签ID
	 * @param userlist 企业员工ID列表 格式："userlist":[ "user1","user2"]
	 * */
	public static String Add_Tag_Person(String tagid,String userlist){
		String PostData = "{\"tagid\": %s,\"userlist\":%s}";
		String userid="[\""+userlist+"\"]";
		return String.format(PostData, tagid,userid);
	}

	/**
	 * 删除标签成员
	 * @param tagid 标签ID
	 * @param userlist 企业员工ID列表 格式："userlist":[ "user1","user2"]
	 * */
	public static String Delete_Tag_Person(String tagid,String userlist){
		String PostData = "{\"tagid\": %s,\"userlist\":%s}";
		String userid="[\""+userlist+"\"]";
		return String.format(PostData, tagid,userid);
	}
	//示例
	public static void main(String[] args) {
		/**
		 * 创建标签示例
		 * */
		// 调取凭证
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		// 拼装数据
		String PostData = Create_Tag("新建标签");
		// 提交数据，获取结果
		int result = WeixinUtil.PostMessage(access_token, "POST", CREATE_TAG_URL, PostData);
		// 打印结果
		if(0==result){
			System.out.println("操作成功");
		}
		else {
			System.out.println("操作失败");
		}
	}

}
