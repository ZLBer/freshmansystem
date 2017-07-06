package weixin.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import po.BasicinfoEntity;
import servlet.college.check;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;

/**
 * Created by ThinkPad on 2017/5/24 0024.
 */
public class ManualBaodao extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
        SMessage smsg=new SMessage();

        HttpSession session=request.getSession();
        String lid=session.getAttribute("userid").toString();               //老师工号
        //从session里取出学生的学号
        String sid=session.getAttribute("sid").toString();
        //根据学生的学号查找学生的详细信息
        BasicinfoEntity student = new BasicinfoEntity();
        String condition = "where student.sno='" + sid + "'";
        java.util.List<BasicinfoEntity> users = new ArrayList<BasicinfoEntity>();
        users = HibernateUtil.query("BasicinfoEntity student", condition);
        if (users.size() > 0) {
            student = users.get(0);
        }
        String stuname=student.getName();                 //学生姓名
        String stuxueyuan=student.getCollege();           //学生学院
        String stumajor=student.getMajor();               //学生专业
        String brother=student.getBankCardId();           //班主任
        String brothertel=student.getBrothertel();        //班主任电话
        String helper=student.getHelper();                //班助
        String helpertel=student.getHelpertel();          //班助电话
        String dormnum=student.getDormNum();              //宿舍号

        //调用check方法判断老师学生是否是一个学院?是:返回true，报道/否：返回false
        check check1=new check();
        String p=check1.checkcollege(lid,sid);

        String Scontent="";
        String Lcontent="";
        if(p.equals("true")){                                        //如果是一个学院，并且报到成功

            //推送给学生的消息
            Scontent="学生:"+stuname+"\n学号:"+sid+"\n报道成功！\n 欢迎来到山东农业大学！\n"+"您的宿舍为"+dormnum+"\n班主任:"+brother+"  联系电话:"+brothertel+"\n班主任助理:"+helper+"  联系电话"+helpertel;
            //推送给学院的消息
            Lcontent="学生:"+stuname+"\n学号:"+sid+"\n专业:"+stumajor+"\n报道成功！\n"+"学生的宿舍为:"+dormnum;
            //拼接url
            String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //给学生发送消息
            String PostData=SMessage.STextMsg(sid,null,null,ParamesAPI.AgentId_xinsheng,Scontent);
            //给学院发送消息
            String PostData1=SMessage.STextMsg(lid,null,null,ParamesAPI.AgentId_xinxi,Lcontent);

            int result = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData1);
            // 打印结果
            if (0 == result && 0 == result1) {
                request.setAttribute("msg","报道成功！");
                request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);
            } else {
                request.setAttribute("msg","报道失败！");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
                System.out.println("发送消息失败");
            }
        }else if(p.equals("false")){                                    //不是一个学院，报到失败
            Scontent="学生:"+stuname+"\n学号:"+sid+"\n您不属于该学院！请前往"+stuxueyuan+"报道！";
            Lcontent="学生:"+stuname+"\n学号:"+sid+"\n报道失败,ta不属于您的学院！";
            //拼接url
            String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //给学生发送消息
            String PostData=SMessage.STextMsg(sid,null,null,ParamesAPI.AgentId_xinsheng,Scontent);
            //给学院发送消息
            String PostData1=SMessage.STextMsg(lid,null,null,ParamesAPI.AgentId_xinxi,Lcontent);
            int result = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData1);
            // 打印结果
            if (0 == result && 0 == result1) {
                request.setAttribute("msg","报道失败！\nta不属于您的学院！");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
                System.out.println("发送消息");

            } else {
                request.setAttribute("msg","出错啦！");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
                System.out.println("发送消息失败");
            }
        }
        else if(p.equals("yibaodao")){                                          //防止重复报道
            Scontent="您已经报道！请勿重复报道！";
            Lcontent="学生:"+stuname+"\n学号:"+sid+"\n报道失败,ta已经报道了！";
            //拼接url
            String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //给学生发送消息
            String PostData=SMessage.STextMsg(sid,null,null,ParamesAPI.AgentId_xinsheng,Scontent);
            //给学院发送消息
            String PostData1=SMessage.STextMsg(lid,null,null,ParamesAPI.AgentId_xinxi,Lcontent);
            int result = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData1);
            // 打印结果
            if (0 == result && 0 == result1) {
                request.setAttribute("msg","ta已经报道了！\n请勿重复报道！");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
            } else {
                request.setAttribute("msg","报道失败！");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
