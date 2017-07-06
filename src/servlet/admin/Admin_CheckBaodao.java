package servlet.admin;

import po.CollegeEntity;
import po.MajorEntity;
import po.RegisterinfoEntity;
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
 * Created by libin on 2017/5/19.
 */
public class Admin_CheckBaodao extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入查看学校报到率的servlet");
        List<String []> all=new ArrayList<>();
        HttpSession session=request.getSession();
        for(int collegeid=1;collegeid<18;collegeid++) {

            String []colleges=new String[6];
            CollegeEntity college = (CollegeEntity) HibernateUtil.get(CollegeEntity.class, collegeid);
            String collegename = college.getCollegename();
            System.out.print(collegename);
            String hql2 = "where spotRegister='未报到' and college=" + "'"+ collegename+"'";
            String hql3 = "where spotRegister='已报到' and college=" +"'"+ collegename+"'";
            String hql4 = "where college=" + "'"+ collegename+"'";
            List<RegisterinfoEntity> collegeweibaodao = HibernateUtil.query("RegisterinfoEntity", hql2);
            List<RegisterinfoEntity> collegeyibaodao = HibernateUtil.query("RegisterinfoEntity", hql3);
            List<RegisterinfoEntity> collegecount = HibernateUtil.query("RegisterinfoEntity", hql4);
            String collegepercent;
            if(collegecount.size()==0) {

                collegepercent = "0";
            }
            else {

                collegepercent = Math.round(((double) collegeyibaodao.size() / (double) collegecount.size()) * 100) + "%";
            }

            colleges[0]=collegeid+"";
            colleges[1]=collegename;
            colleges[2]=collegeyibaodao.size()+"";
            colleges[3]=collegeweibaodao.size()+"";
            colleges[4]=collegecount.size()+"";
            colleges[5]=collegepercent+"";

            all.add(colleges);
            colleges=null;

        }
        String hql="where spotRegister='已报到'";
        double schoolYes= HibernateUtil.recordCount("RegisterinfoEntity",hql);
        double schoolcount=HibernateUtil.recordCount("RegisterinfoEntity","");

        request.setAttribute("school",schoolYes/schoolcount);
        request.setAttribute("all",all);

        if(session.getAttribute("userid")!=null){
            request.getRequestDispatcher("/WEUI/admin/admin_baodaoinfo.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("admin_showCollegeBaodao.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
