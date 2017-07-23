package servlet.admin;

import po.AdminEntity;
import po.CollegeEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/7/23.
 */
@WebServlet(name = "TeacherList")
public class TeacherList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");

        List<AdminEntity> adminEntities =new ArrayList<AdminEntity>();
        String college;

        String cond="where type=2";
        adminEntities= HibernateUtil.query("AdminEntity ",cond);

        if(adminEntities.size()>0){
            for(int i=0;i<adminEntities.size();i++) {
                college = adminEntities.get(i).getCollege();
                List<CollegeEntity> collegeEntities = new ArrayList<CollegeEntity>();
                String condi = "where collegeid=" + college;
                collegeEntities = HibernateUtil.query("CollegeEntity", condi);
                if (collegeEntities.size() > 0) {
                    college = collegeEntities.get(0).getCollegename();
                }
                adminEntities.get(i).setCollege(college);
            }
        }
        request.setAttribute("teacherlist",adminEntities);
        request.getRequestDispatcher("/admin/all_teacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
