package weixin.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import weixin.msg.Util.SMessage;

import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;

public class alterInfoServlet extends HttpServlet {

    public alterInfoServlet() {
        super();
    }
    public void destroy() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");

        HttpSession session=request.getSession();
        String userid;

        if(session.getAttribute("userid")!=null){

            userid=session.getAttribute("userid").toString();
        }
        else{
            //获取用户userid
             userid=session.getAttribute("user").toString();
        }
        //获取凭证
        String access_token=WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
        //开始修改用户信息
        //获取用户新手机号
        String newtel=request.getParameter("newtel");

        //获取用户姓名
        String name=session.getAttribute("stuxingming").toString();
        //创建成员对象
        MPerson mperson=new MPerson();
        //拼接url
        String posturl=mperson.UPDATA_URL.replace("ACCESS_TOKEN", access_token);

        String PostData=mperson.Updata(userid, name, newtel);
        System.out.println("修改之后的数据包"+PostData);
        int result = WeixinUtil.PostMessage(access_token, "POST", posturl, PostData);
        // 打印结果

        if(0==result){
            System.out.println("修改信息成功!");
            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接url
            String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //Post数据
            String stext="修改信息成功！\n"+"当前手机号为："+newtel;

            String PostData1=SMessage.STextMsg(userid,null,null,ParamesAPI.AgentId_xinsheng,stext);

            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData1);
            // 打印结果
            if (0 == result1) {
                System.out.println("发送消息成功");
            } else {
                System.out.println("发送消息失败");
                System.out.println(result1);
            }

            request.setAttribute("msg","修改手机号成功！");
            request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);
        }
        else {
            System.out.println("操作失败");

            request.setAttribute("msg","修改手机号失败！");
            request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);
        }
    }

    public void init() throws ServletException {
// Put your code here
    }

}