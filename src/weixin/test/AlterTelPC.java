package weixin.test;

import po.BasicinfoEntity;
import po.UserEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ThinkPad on 2017/7/3 0003.
 */
public class AlterTelPC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入修改手机号servlet");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");

        HttpSession session=request.getSession();
        String userid,name,newtel;
        System.out.println("开始获取学号");
        UserEntity user=(UserEntity)session.getAttribute("user");
        //获取学号
        userid=user.getSno();
        System.out.println("学号为："+userid);
        BasicinfoEntity basic = (BasicinfoEntity) HibernateUtil.get(BasicinfoEntity.class,userid);
        //获取姓名
        name=basic.getName();
        System.out.println("姓名为："+name);
        //获取新手机号
        newtel=request.getParameter("newtel");
        System.out.println("新手机号为："+newtel);
        //获取凭证
        String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();

        System.out.println("凭证为："+access_token);
        //创建成员对象
        MPerson mperson=new MPerson();
        //拼接url
        String posturl=mperson.UPDATA_URL.replace("ACCESS_TOKEN", access_token);
        //打包json
        String PostData=mperson.Updata(userid, name, newtel);
        System.out.println("修改之后的数据包"+PostData);
        //返回结果
        int result = WeixinUtil.PostMessage(access_token, "POST", posturl, PostData);
        if(0==result){
            System.out.println("修改信息成功!");
            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接发送消息url
            String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //Post数据
            String stext="修改手机号成功！\n"+"当前手机号为："+newtel;

            String PostData1=SMessage.STextMsg(userid,null,null,ParamesAPI.AgentId_xinsheng,stext);

            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData1);
            // 打印结果
            if (0 == result1) {
                System.out.println("发送消息成功");
            } else {
                System.out.println("发送消息失败");
            }

            request.setAttribute("msg","修改手机号成功！");
            request.getRequestDispatcher("/student/alterTel.jsp").forward(request,response);
        }
        else {
            System.out.println("操作失败");
            request.setAttribute("msg","修改手机号失败！");
            request.getRequestDispatcher("/student/alterTel.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
