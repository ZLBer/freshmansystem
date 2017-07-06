package servlet.college;

import po.AdminEntity;
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
 * Created by john on 2017/5/18.
 */
public class CollegeLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String checkcode=request.getParameter("checkcode");
        String userid=request.getParameter("userid");
        String userpwd=request.getParameter("userpwd");
        String msg="";
        HttpSession session=request.getSession();
        String ck=(String) session.getAttribute("checkCode");
        if(checkcode.equalsIgnoreCase(ck))
        {
            AdminEntity user=null;
            String condition="where admin.adminname='"+userid+"'";
            List<AdminEntity> userList=new ArrayList<AdminEntity>();
            userList= HibernateUtil.query("AdminEntity admin", condition);
            if(userList.size()>0)
                user=userList.get(0);
            if(user==null){
                msg="id不存在";
            }
            else {
                if((userpwd).equals(user.getPassword()))
                {
                    session.setAttribute("user",user);
                    request.getRequestDispatcher("/college/index.jsp").forward(request,response);
                }
                else {msg="密码不正确";}
            }
        }
        else {msg="验证码不正确";}
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/college-login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
