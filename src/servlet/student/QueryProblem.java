package servlet.student;

import po.ProblemEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by john on 2017/6/13.
 */
public class QueryProblem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String condition="";
        java.util.List<ProblemEntity> problems=new ArrayList<ProblemEntity>();
        problems= HibernateUtil.query("ProblemEntity", condition);
        request.setAttribute("plist",problems);

        if(session.getAttribute("userid")!=null){
            String msg="请先完成试卷，完成后方可查看自己的信息。";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/WEUI/student/stutest.jsp").forward(request,response);
        }else {
            String msg="请完成该试卷以查看你的信息！！！";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/student/problem.jsp").forward(request,response);
    }

    }
}
