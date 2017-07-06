package servlet.admin;

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
        HttpSession session=request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String collegeId = request.getParameter("collegeId");
        List<List<String>> infoList = RegisterRateUtil.getMajorRegisterRate(Integer.parseInt(collegeId));

        request.setAttribute("infoList",infoList);

        if(session.getAttribute("userid")!=null){

            request.getRequestDispatcher("/WEUI/admin/showCollegeBaodao.jsp").forward(request, response);
        }else {

            request.getRequestDispatcher("majorRate.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
