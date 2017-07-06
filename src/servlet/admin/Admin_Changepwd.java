package servlet.admin;

import po.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell on 2017/6/6.
 */
public class Admin_Changepwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");

        String studentid=request.getParameter("sid");
        try {
            UserEntity student = (UserEntity) HibernateUtil.get(UserEntity.class, studentid);

            student.setPassword("123456");
            HibernateUtil.update(student);
            request.setAttribute("message","修改成功");
        }catch (NullPointerException e)
        {
            request.setAttribute("message","该学生不存在！");
        }
        request.getRequestDispatcher("/admin/changepwd.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
