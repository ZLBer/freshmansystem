package servlet.admin;

import po.NewsEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by libin on 2017/7/5.
 */
public class SearchNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        String condition="order by id desc";
        List<NewsEntity> news= HibernateUtil.query("NewsEntity",condition);
        NewsEntity n=news.get(0);
        request.setAttribute("news",n);
        request.getRequestDispatcher("/admin/publishNews.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request,response);
    }
}
