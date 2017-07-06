package weixin.test;

import po.BasicinfoEntity;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ThinkPad on 2017/6/3 0003.
 */
public class QueryStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String sno= session.getAttribute("userid").toString();


        String msg="";
        BasicinfoEntity student=new BasicinfoEntity();
        String condition="where student.sno='"+sno+"'";
        java.util.List<BasicinfoEntity> userList=new ArrayList<BasicinfoEntity>();
        userList= HibernateUtil.query("BasicinfoEntity student", condition);
        if (userList.size()>0)
        {

            student=userList.get(0);
            request.setAttribute("student",student);

            request.getRequestDispatcher("/WEUI/student/query_qr.jsp").forward(request,response);
        }
        else{

            msg="未查询到您的信息，请联系管理员";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);

        }
    }
}
