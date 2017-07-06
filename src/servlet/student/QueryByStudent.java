package servlet.student;

import po.BasicinfoEntity;
import po.ScoreEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by john on 2017/5/17.
 */
public class QueryByStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String sno;
        if(session.getAttribute("userid")!=null){
            sno=session.getAttribute("userid").toString();
        }
        else{
            sno=request.getParameter("sno");
        }
        ScoreEntity stu=new ScoreEntity();
        String condi="where student.sno='"+sno+"'";
        java.util.List<ScoreEntity> userList=new ArrayList<ScoreEntity>();
        userList= HibernateUtil.query("ScoreEntity student", condi);
        if (userList.size()>0)
        {
            stu=userList.get(0);
        }
        if(stu.getScore()>90) {                      //判断学生的答题成绩
            System.out.println("开始跳转到1111");

            String msg = "";
            BasicinfoEntity student = new BasicinfoEntity();
            String condition = "where student.sno='" + sno + "'";
            java.util.List<BasicinfoEntity> users = new ArrayList<BasicinfoEntity>();
            users = HibernateUtil.query("BasicinfoEntity student", condition);
            if (users.size() > 0) {
                student = users.get(0);
            } else {
                msg = "未查询到您的信息，请联系管理员";
            }

            request.setAttribute("student", student);
            request.setAttribute("msg", msg);

            if (session.getAttribute("userid") != null) {

                System.out.println("开始跳转到/WEUI/student/query.jsp");
                request.getRequestDispatcher("/WEUI/student/query.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("/student/query.jsp").forward(request, response);
            }
        }
        else {
            if(session.getAttribute("userid")!=null){

                System.out.println("微信开始跳转到queryproblem");
                response.sendRedirect("student/queryProblem");
            }
            else{
                System.out.println("电脑开始跳转到queryproblem");
                response.sendRedirect("queryProblem");
            }


        }
    }
}
