package servlet.admin;

import po.BasicinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by john on 2017/5/17.
 */
public class DeleteStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno=request.getParameter("sno");
        HibernateUtil.delete(BasicinfoEntity.class, sno);
        response.sendRedirect("queryByAdmin?pageNo=1");
    }
}
