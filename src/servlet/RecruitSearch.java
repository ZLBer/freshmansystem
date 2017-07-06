package servlet;

import util.HibernateUtil;
import po.BasicinfoEntity;
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
public class RecruitSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        String examid=request.getParameter("examid");
        String name=request.getParameter("name");
        String conditinon="where examNum="+examid+" and name='"+name+"'";
        try {
            List<BasicinfoEntity> s = HibernateUtil.query("BasicinfoEntity", conditinon);
            String message;
            String json;
            if (s.size() == 0) {
                message = "未查询到该生信息";
                json = "{\"msg\":\"" + message + "\",\"name\":\"" + "" + "\",\"examid\":\"" + "" + "\",\"sno\":\"" + "" + "\",\"college\":\"" + "" + "\",\"major\":\"" + "" + "\"}";
            } else {
                BasicinfoEntity n = s.get(0);
                message = "查询成功";
                json = "{\"msg\":\"" + message + "\",\"name\":\"" + n.getName() + "\",\"examid\":\"" + n.getExamNum() + "\",\"sno\":\"" + n.getSno() + "\",\"college\":\"" + n.getCollege() + "\",\"major\":\"" + n.getMajor() + "\"}";
            }

            PrintWriter out = response.getWriter();
            out.print(json);
        }catch (Exception e)
        {
            String message = "查询失败，请正确输入";
           String json = "{\"msg\":\"" + message + "\",\"name\":\"" + "" + "\",\"examid\":\"" + "" + "\",\"sno\":\"" + "" + "\",\"college\":\"" + "" + "\",\"major\":\"" + "" + "\"}";

            PrintWriter out = response.getWriter();
            out.print(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
