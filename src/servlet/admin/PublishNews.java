package servlet.admin;

import util.HibernateUtil;
import po.NewsEntity;

import javax.persistence.Convert;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by libin on 2017/7/5.
 */
public class PublishNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");
       String news=request.getParameter("news");
//       System.out.println(news);
//        news = news.replaceAll("\n","<br>");
//        System.out.println(news);
        Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
        Matcher m = CRLF.matcher(news);
        if (m.find()) {
            news = m.replaceAll("<br>");
        }
        news=news.replace(" ","&nbsp");
        //   String news=new String(request.getParameter("news").getBytes("ISO-8859-1"),"utf-8");
        String title=request.getParameter("title");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
       NewsEntity  n=new NewsEntity();
       n.setType("1");
       n.setContent(news);
       n.setTitle(title);
       n.setInputtime(time);
        HibernateUtil.add(n);
        request.setAttribute("message","发布消息成功");
        request.getRequestDispatcher("/admin/publishNews.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
