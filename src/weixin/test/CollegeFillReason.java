package weixin.test;

import po.AdminEntity;
import po.BasicinfoEntity;
import po.CollegeEntity;
import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */
public class CollegeFillReason extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String   adminname=(String)  session.getAttribute("userid");
        String sno;
        try{
            sno = request.getParameter("sno");
            String reason = request.getParameter("reason");

            String condition="where adminname="+adminname;
            List<AdminEntity> admins=HibernateUtil.query("AdminEntity",condition);
            int collegeid=Integer.parseInt(admins.get(0).getCollege());
            CollegeEntity college=(CollegeEntity) HibernateUtil.get(CollegeEntity.class,collegeid);
            String collegename=college.getCollegename();
            BasicinfoEntity student=(BasicinfoEntity) HibernateUtil.get(BasicinfoEntity.class,sno);
            String scollegename=student.getCollege();

            if(collegename.equals(scollegename)) {

                RegisterinfoEntity r = (RegisterinfoEntity) HibernateUtil.get(RegisterinfoEntity.class, sno);
                r.setReason(reason);
                HibernateUtil.update(r);

                request.setAttribute("msg", "备注成功!");
                request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);
            }
            else{
                request.setAttribute("msg", "备注失败!该学生不在您的学院。");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();

            request.setAttribute("msg","备注失败，找不到该学生!");
            request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

