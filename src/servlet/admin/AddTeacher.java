package servlet.admin;

import po.AdminEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dell on 2017/7/22.
 */
public class AddTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        //接收数据
        Integer usertype = Integer.parseInt(request.getParameter("usertype"));//用户类型
        String teachername = request.getParameter("teachername");//登录名
        String college = request.getParameter("college");//学院
        String teacherpassword = request.getParameter("teacherpassword");//老师登录密码

        List<AdminEntity> admins = HibernateUtil.query("AdminEntity", "");
        for (AdminEntity a : admins) {
            if (teachername.equals(a.getAdminname())) {
                request.setAttribute("message", "登录名重复！请重新添加");
                request.getRequestDispatcher("/admin/add_teacher.jsp").forward(request, response);
           return;
            }
        }

                AdminEntity adminEntity = new AdminEntity();
            adminEntity.setType(usertype);
            adminEntity.setAdminname(teachername);
            adminEntity.setCollege(college);
            adminEntity.setPassword(teacherpassword);

            try {
                HibernateUtil.add(adminEntity);
                request.setAttribute("message", "添加成功");
            } catch (Exception e) {
                request.setAttribute("message", "添加失败");
            }

            request.getRequestDispatcher("/admin/add_teacher.jsp").forward(request, response);
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
