package servlet.student;

import po.ProblemEntity;
import po.ScoreEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by john on 2017/6/13.
 */
public class CheckScore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        System.out.println("进入修改分数servlet");
        String sno=request.getParameter("sno");
        //得到问题的答案
        String condi="";
        java.util.List<ProblemEntity> problems=new ArrayList<ProblemEntity>();
        problems= HibernateUtil.query("ProblemEntity", condi);
        int score=0;
        for(int i=0;i<problems.size();i++) {

            String s = Integer.toString(problems.get(i).getProblemid());
            if(request.getParameter(s).equals(problems.get(i).getAnswer())) {
                System.out.println("问题答案是："+s);
                score += problems.get(i).getPrice();
            }
        }
        //更新
        ScoreEntity student=new ScoreEntity();
        String condition="where student.sno='"+sno+"'";
        java.util.List<ScoreEntity> userList=new ArrayList<ScoreEntity>();
        userList= HibernateUtil.query("ScoreEntity student", condition);

        if (userList.size()>0) {
            student = userList.get(0);
        }
        student.setScore(score);
        HibernateUtil.update(student);

        if(session.getAttribute("userid")!=null){
            if(score==100) {
                request.setAttribute("msg", "考试通过，现在您可以查看个人信息了！");
                request.getRequestDispatcher("/WEUI/testsuccess.jsp").forward(request, response);
            }else{
                request.setAttribute("msg", "试卷成绩满分才可使用此功能，请仔细学习后再次尝试！");
                request.getRequestDispatcher("/WEUI/testfail.jsp").forward(request, response);
            }
        }else{
            String msg;
            if(score==100)
                msg="答题成功，可以查看个人信息了！";
            else
                msg="答案有误，请重新作答！";
            out.println(msg);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
