package servlet.college;

import po.CollegeEntity;
import util.HibernateUtil;
import util.RegisterRateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Created by Minister on 2017/5/19.
 */
public class GotoMajorDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String collegeId = request.getParameter("collegeId");
        System.out.println("老师所属学院是："+collegeId);
        List<List<String>> infoList = RegisterRateUtil.getMajorRegisterRate(Integer.parseInt(collegeId));

        CollegeEntity college = (CollegeEntity) HibernateUtil.get(CollegeEntity.class, Integer.parseInt(collegeId));
        String collegename = college.getCollegename();
        String hql = "where  college='" + collegename + "'";
        String hql1 = "where spotRegister='已报到' and college='" + collegename + "'";
        double count = (double) HibernateUtil.recordCount("RegisterinfoEntity", hql1) / (double) HibernateUtil.recordCount("RegisterinfoEntity", hql);

        request.setAttribute("count", count);

        request.setAttribute("infoList", infoList);

        if (session.getAttribute("userid") != null) {
            request.getRequestDispatcher("/WEUI/admin/showCollegeBaodao").forward(request, response);
        } else {
            request.getRequestDispatcher("majorRate.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
