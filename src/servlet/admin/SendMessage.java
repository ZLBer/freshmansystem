package servlet.admin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import po.MajorEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by libin on 2017/7/25.
 */
public class SendMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        String collegeid= request.getParameter("collegeid");
        String major=request.getParameter("major");
        String message=request.getParameter("message");

       // major= new String(major.getBytes("iso8859-1"), "utf-8");
        System.out.println(major);
        String condition="where collegeid="+collegeid+" and majorname='"+major+"'";

        java.util.List<MajorEntity> userList=new ArrayList<MajorEntity>();

        userList= HibernateUtil.query("MajorEntity", condition);
        MajorEntity m=userList.get(0);
        System.out.println(1);
        String   key=m.getMajorid()+"";

        //现在查询完毕，需要取majorid;

        JsonParser parser=new JsonParser();     //创建解析器
        String filePath = request.getServletContext().getRealPath("/WEB-INF");
        JsonObject object=(JsonObject)parser.parse(new FileReader(filePath + "/major.json"));//创建一个JsonObject对象，并调用解析器的parse方法进行读取文件，返回值的类型是JsonElement,
        // 但是赋值的对象是一个JsonObject所以要进行类型的强制转换。
        // 注意Json文件，如果json文件的格式有问题，可能就会导致出现json语法异常；
        //下一步就是比对，得到的键值输出
        int departmentid= object.get(key).getAsInt();
        String toparty=object.get(key).getAsString();
        System.out.println(1);
        System.out.println(departmentid);

        //拼接url
        String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN ";

        // 调取凭证
        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();

        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接接口url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        int agentid=ParamesAPI.AgentId_xinsheng;
        String postData=smsg.STextMsg(null,toparty,null,agentid,message);

        int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,postData);
        // 打印结果
        if (0 == result1) {
            request.setAttribute("msg","向专业"+major+"发送消息成功");
        } else {
            request.setAttribute("msg","向专业"+major+"发送消息失败");
        }

        request.getRequestDispatcher("/admin/sendMessage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
