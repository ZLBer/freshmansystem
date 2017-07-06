package servlet;

import net.sf.json.JSONObject;
import po.NewsEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by libin on 2017/7/5.
 */
public class RecruitNew extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        String condition="order by id desc";
        List<NewsEntity> news= HibernateUtil.query("NewsEntity",condition);
        NewsEntity n=news.get(0);
        String json="{\"title\":\""+n.getTitle()+"\",\"content\":\""+n.getContent()+"\",\"time1\":\""+n.getInputtime()+"\"}";
        PrintWriter out=response.getWriter();
        out.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
