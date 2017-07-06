package servlet.admin;

import po.CollegeEntity;
import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by john on 2017/6/18.
 */
public class Admin_checkNoRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int  page_current=Integer.parseInt(request.getParameter("page_current"));
        int page_size=10;
        String hql2 = "where spotRegister='未报到'";
        List<RegisterinfoEntity> students=HibernateUtil.query("RegisterinfoEntity",hql2);
        //设置分页相关信息
        if(page_current>(students.size()%page_size==0?students.size()/page_size:students.size()/page_size+1))
        {
            request.setAttribute("page_current",page_current-1);
        }
        else if(page_current<1)
            request.setAttribute("page_current",1);
        else
            request.setAttribute("page_current",page_current);//页码
        request.setAttribute("page_size",10);//页码
        request.setAttribute("length",students.size());//总长度
        request.setAttribute("page_count",students.size()%page_size==0?students.size()/page_size:students.size()/page_size+1);//总页码
        request.setAttribute("students",students); //遍历集合
        request.setAttribute("students",students);

        if(session.getAttribute("userid")!=null){

          //  request.getRequestDispatcher("/WEUI/admin/checkNoRegister.jsp").forward(request, response);

        }
        else{

            request.getRequestDispatcher("/admin/admin_checkNoRegister.jsp").forward(request,response);
        }

    }
}
