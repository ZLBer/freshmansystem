package servlet.student;

import po.BasicinfoEntity;
import po.StcompleteinfoEntity;
import po.TrafficinfoEntity;
import po.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by libin on 2017/7/26.
 */
public class BeforeComplete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userid") != null) {//来自于微信
            String userid = session.getAttribute("userid").toString();
            UserEntity user = (UserEntity) HibernateUtil.get(UserEntity.class, userid);
            String son = user.getSno();
            StcompleteinfoEntity student = (StcompleteinfoEntity) HibernateUtil.get(StcompleteinfoEntity.class, son);
            TrafficinfoEntity traffic = (TrafficinfoEntity) HibernateUtil.get(TrafficinfoEntity.class, son);
            request.setAttribute("student", student);
            request.setAttribute("traffic", traffic);
            request.getRequestDispatcher("/WEUI/student/fillinfo.jsp").forward(request, response);
        } else { //电脑端
            UserEntity user = (UserEntity) session.getAttribute("user");
            String son = user.getSno();
            StcompleteinfoEntity student = (StcompleteinfoEntity) HibernateUtil.get(StcompleteinfoEntity.class, son);
            TrafficinfoEntity traffic = (TrafficinfoEntity) HibernateUtil.get(TrafficinfoEntity.class, son);
            request.setAttribute("student", student);
            request.setAttribute("traffic", traffic);
            request.getRequestDispatcher("/student/completeInfo.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
