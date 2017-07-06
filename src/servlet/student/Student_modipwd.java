package servlet.student;

import po.AdminEntity;
import po.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by john on 2017/5/20.
 */
public class Student_modipwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user=(po.UserEntity)request.getSession().getAttribute("user");
        String pwd1=request.getParameter("pwd1");
        user.setPassword(pwd1);
        HibernateUtil.update(user);
        String msg="修改成功";
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/student/motifypwd.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
