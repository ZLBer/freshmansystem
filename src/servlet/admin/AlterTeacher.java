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
public class AlterTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        Integer teacherid=Integer.parseInt(request.getParameter("teacherid"));
        AdminEntity adminEntity=(AdminEntity)HibernateUtil.get(AdminEntity.class,teacherid);

        request.setAttribute("teacher",adminEntity);

        request.getRequestDispatcher("/admin/alterteacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
