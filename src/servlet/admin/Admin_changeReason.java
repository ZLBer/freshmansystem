package servlet.admin;

import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by john on 2017/6/18.
 */
public class Admin_changeReason extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        String  sno=request.getParameter("sno");
        String reason=request.getParameter("reason");

        RegisterinfoEntity student= (RegisterinfoEntity) HibernateUtil.get(RegisterinfoEntity.class,sno);

        student.setReason(reason);
        HibernateUtil.update(student);

        request.setAttribute("page_current",1);
        request.getRequestDispatcher("/admin/admin_checkNoRegister?page_current=1").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
