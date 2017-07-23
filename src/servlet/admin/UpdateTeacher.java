package servlet.admin;

import po.AdminEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell on 2017/7/23.
 */
public class UpdateTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");

        //接收数据
        Integer id=Integer.parseInt(request.getParameter("id"));
        Integer usertype=Integer.parseInt(request.getParameter("usertype"));//用户类型
        //String teachername=request.getParameter("teachername");//登录名
        //String college=request.getParameter("college");//学院
        String teacherpassword=request.getParameter("teacherpassword");//老师登录密码

        AdminEntity adminEntity= (AdminEntity) HibernateUtil.get(AdminEntity.class,id);



        adminEntity.setPassword(teacherpassword);

        try{
            HibernateUtil.update(adminEntity);
            request.setAttribute("message","更新成功");
        }catch(Exception e){
            request.setAttribute("message","更新失败");
        }
        request.setAttribute("teacher",adminEntity);
        request.getRequestDispatcher("/admin/alterteacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
