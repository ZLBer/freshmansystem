package weixin.servicet.util;
/**
 * @author Engineer-Jsp
 * @date 2014.09.23
 * 核心Service类*/
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Resp.TextMessage;
import weixin.msg.Util.MessageUtil;
import weixin.msg.Util.SMessage;
import servlet.college.check;
import java.util.Date;
import java.util.Map;


public class CoreService {

	/**
	 * 处理微信发来的请求
	 *
	 * @param request
	 * @return xml
	 */
	public static String processRequest(String request) {

		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		// xml格式的消息数据
		String respXml ="";
		// 默认返回的文本消息内容
		String respContent = "";
		try {
			// 调用parseXml方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			//从xml中获取studentid
			String fromUserName = requestMap.get("FromUserName");
			System.out.println("FromUserName为："+fromUserName);

			String toUserName = requestMap.get("ToUserName");
			System.out.println("ToUserName为："+toUserName);

			String creatTime = requestMap.get("CreateTime");
			System.out.println("CreateTime为："+creatTime);

			String msgType = requestMap.get("MsgType");
			System.out.println("MsgType为："+creatTime);

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				//respContent = "您发送的是文本消息！";
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				//respContent = "您发送的是图片消息！";
			}
			// 语音消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				//respContent = "您发送的是语音消息！";
			}
			// 视频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				//respContent = "您发送的是视频消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				//respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				//respContent = "您发送的是链接消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 关注
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
				}
				// 取消关注
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
				}

				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					// TODO
				}
//////////////// 扫描带参数二维码-----------------------------------------------------------------------
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCANCODE_WAITMSG)){
					// TODO 处理扫码推且弹出事件
					System.out.println("进入扫描参数二维码事件");
					//获取二维码里的参数
					String ScanResult =requestMap.get("ScanResult");

					String[] a=ScanResult.split("'|,");

					String stunum=a[1];			//获取学生学号
					String stuname=a[2];		//获取学生姓名
					String stucollege=a[3];		//获取学生所属学院
					String stumajor=a[4];		//获取学生专业
					String brother=a[5];		//获取学生的班主任姓名
					String brothertel=a[6];		//获取学生的班主任电话
					String helper=a[7];			//获取学生的班助姓名
					String helpertel=a[8];		//获取学生的班助电话
					String dormNum=a[9];		//获取学生的宿舍
					String classroom=a[10];		//获取学生的班级

					//定义check类对象
					check c1=new check();
					System.out.println("老师的工号为："+fromUserName);
					String p=c1.checkcollege(fromUserName,stunum);

					if(p.equals("true")) {								//如果学生和老师是一个学院
						//推送给学院的消息
						respContent="学号为："+stunum+"\n姓名:"+stuname+"\n专业:"+stumajor+"\n报到成功！"+"\n学生的宿舍为:"+dormNum+"\n学生的班级为："+classroom;
						//推送给新生的消息
						String stext="学号为："+stunum+"\n姓名:"+stuname+"\n学院:"+stucollege+"\n报到成功！欢迎来到山东农业大学！\n您的宿舍为:"+dormNum+"\n班主任姓名:"+brother+"  联系电话:"+brothertel+"\n班主任助理姓名:"+helper+"  联系电话:"+helpertel+"\n学生的班级为："+classroom;

						//创建发送消息对象
						SMessage smsg=new SMessage();

						//拼接url
						String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);

						String PostData=smsg.STextMsg(stunum,null,null,ParamesAPI.AgentId_xinsheng,stext);
						int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
						// 打印结果
						if (0 == result1) {
							System.out.println("发送消息成功");
						} else {
							System.out.println("发送消息失败");
						}
					}
					else if(p.equals("false")){											//如果老师学生不在一个学院
						//推送给学院的消息
						respContent="学号:"+stunum+"\n姓名："+stuname+"\n报到失败！ta不属于您的学院！";
						//推送给新生的消息
						String stext="学号:"+stunum+"\n姓名："+stuname+"\n报到失败，您不属于该学院！\n"+"请前往"+stucollege+"报到！";
						//创建发送消息对象
						SMessage smsg=new SMessage();
						//拼接url
						String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);

						String PostData=SMessage.STextMsg(stunum,null,null,ParamesAPI.AgentId_xinsheng,stext);

						int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
						// 打印结果
						if (0 == result1) {
							System.out.println("发送消息成功");
						} else {
							System.out.println("发送消息失败");
						}
					}
					else if(p.equals("yibaodao")){									//如果学生已经报道
						//推送给学院的消息
						respContent="学号:"+stunum+"\n姓名："+stuname+"\nta已经报到了,请勿重复报到";
						//推送给新生的消息
						String stext="学号:"+stunum+"\n姓名："+stuname+"\n您已经报到了,请勿重复报到";
						//创建发送消息对象
						SMessage smsg=new SMessage();

						//拼接url
						String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);

						String PostData=SMessage.STextMsg(stunum,null,null,ParamesAPI.AgentId_xinsheng,stext);

						int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
						// 打印结果
						if (0 == result1) {
							System.out.println("发送消息成功");
						} else {
							System.out.println("发送消息失败");
						}
					}

				}
				// 上报地理位置
				else if (eventType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
					// TODO 处理上报地理位置事件
				}
				// 自定义菜单7
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 处理菜单点击事件
					//事件KEY值，与创建自定义菜单时指定的KEY值对应
					String eventKey = requestMap.get("EventKey");
					System.out.println("EventKey="+eventKey);
					respContent = "点击的菜单KEY:"+eventKey;
				}
			}
			// 设置文本消息的内容
			textMessage.setContent(respContent);
			// 将文本消息对象转换成xml
			respXml = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}

}
