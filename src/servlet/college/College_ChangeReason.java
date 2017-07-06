package servlet.college;

import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by libin on 2017/5/20.
 */
public class College_ChangeReason extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");

        String  sno=request.getParameter("sno");
        String collegeid=request.getParameter("collegeid");
        String reason=request.getParameter("reason");

        RegisterinfoEntity student= (RegisterinfoEntity) HibernateUtil.get(RegisterinfoEntity.class,sno);

        student.setReason(reason);
        HibernateUtil.update(student);

        request.setAttribute("page_current",1);
        request.setAttribute("collegeid",collegeid);

        request.getRequestDispatcher("college_checkNoRegister?page_current=1&collegeid="+collegeid).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
