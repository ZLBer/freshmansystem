package servlet;

import po.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/5/16.
 */
public class StudentLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String checkcode=request.getParameter("checkcode");
        String userid=request.getParameter("userid");
        String userpwd=request.getParameter("userpwd");
        String path=request.getContextPath();
        String p=path+"/student/index.jsp";
        String msg="";
        HttpSession session=request.getSession();
        String ck=(String) session.getAttribute("checkCode");
        if(checkcode.equalsIgnoreCase(ck))
        {
            UserEntity user=null;
            String condition="where user.sno='"+userid+"'";
            List<UserEntity> userList=new ArrayList<UserEntity>();
            userList= HibernateUtil.query("UserEntity user", condition);
            if(userList.size()>0)
                user=userList.get(0);
            if(user==null){
                msg="id不存在";
            }
            else {
                if((userpwd).equals(user.getPassword()))
                {
                    session.setAttribute("user",user);

                    request.getRequestDispatcher(p).forward(request,response);
                }
                else {msg="密码不正确";}
            }
        }
        else {msg="验证码不正确";}
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
