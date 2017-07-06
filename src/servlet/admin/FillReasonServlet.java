package servlet.admin;

import po.RegisterinfoEntity;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Minister on 2017/5/20.
 */
public class FillReasonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String servername=request.getServerName();
        String sno;
        try{

            sno = request.getParameter("sno");
            String reason = request.getParameter("reason");

            System.out.println(sno);
            System.out.println(reason);

            RegisterinfoEntity r = (RegisterinfoEntity) HibernateUtil.get(RegisterinfoEntity.class,sno);
            r.setReason(reason);
            HibernateUtil.update(r);

            if(session.getAttribute("userid")!=null){

                request.setAttribute("msg","备注成功!");
                request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);

            }
            else{
                out.print("<h1>提交成功</h1>");
            }

        }catch (Exception e){
            e.printStackTrace();
            if(session.getAttribute("userid")!=null){

                request.setAttribute("msg","备注失败!");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);

            }
            else{
                out.print("<h1>提交失败</h1>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
