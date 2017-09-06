package servlet.admin;

import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by libin on 2017/9/3.
 */
public class DownloadStuRegInfoServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<RegisterinfoEntity> list = HibernateUtil.query("RegisterinfoEntity","");
        request.setAttribute("infoList",list);
        request.getRequestDispatcher("registerInfoExcel.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
