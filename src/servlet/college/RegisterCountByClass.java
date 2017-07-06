package servlet.college;

import po.CollegeEntity;
import po.MajorEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.HibernateUtil.recordCount;

/**
 * Created by john on 2017/5/19.
 */
public class RegisterCountByClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String majorid=request.getParameter("majorid");

        String majorname="";
        int collegeid=0;
        String collegename="";
        String condition="where major.majorid="+majorid;
        List<MajorEntity> userList=new ArrayList<MajorEntity>();
        userList= HibernateUtil.query("MajorEntity major", condition);
        if(userList.size()>0) {
            majorname = userList.get(0).getMajorname();
            collegeid=userList.get(0).getCollegeid();
        }

        String con="where college.collegeid="+collegeid;
        List<CollegeEntity> colleges=new ArrayList<CollegeEntity>();
        colleges= HibernateUtil.query("CollegeEntity college", con);
        if(colleges.size()>0) {
            collegename=colleges.get(0).getCollegename();
        }


        String ClassName="BasicinfoEntity";

        String[] fields= {"distinct classNum"};

        String condi="where major='"+majorname+"'";
        List<Object[]> classlist=new ArrayList<>();
        classlist= HibernateUtil.selectFields(ClassName, fields,condi);
        float[] l=new float[20];
        //另一种
        List li = new ArrayList<>();
        List<String> cl = new ArrayList<String>();
        List all = new ArrayList<>();
        List part = new ArrayList<>();
        int i=0;
        for(Object a:classlist){

            String classes=a.toString();
            cl.add(classes);
            String tableAlias = "BasicinfoEntity as b, RegisterinfoEntity as r";
            final String CONDITION = "WHERE b.classNum='"+classes+"' and b.major='"+majorname
                    +"' and b.college='"+collegename+"' and b.sno=r.sno";
            float mcount = recordCount(tableAlias,CONDITION);

            final String CONDI = "WHERE b.classNum='"+classes+"' and b.major='"+majorname
                    +"' and b.college='"+collegename+"' and b.sno=r.sno and r.spotRegister='已报到'";
            float zcount = recordCount(tableAlias,CONDI);

           String register=Math.round(zcount/mcount*100)+"%";
            li.add(register);
            all.add((int)mcount); part.add((int)zcount);
            /*l[i]=register;
            i++;*/
        }
        request.setAttribute("part",part);
        request.setAttribute("all",all);
        request.setAttribute("li",li);
        request.setAttribute("classlist",cl);
        request.getRequestDispatcher("/admin/registerCountByClass.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
