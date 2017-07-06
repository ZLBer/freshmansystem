package weixin.test;

import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.HibernateUtil.multiTableSelect;

/**
 * Created by ThinkPad on 2017/6/4 0031.
 */
public class CollegeQueryBySno extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sno = request.getParameter("sno");       //学号

        String condi = " and basicinfo.sno=" + sno;


        int pageSize = 1;
        int pageNo = 1;

        final String PRIMARYKEY = "sno";
        final String BASICTABLE = "basicinfo";
        final String STCOMTABLE = "stcompleteinfo";

        String[] a = {"basicinfo.sno", "basicinfo.name", "basicinfo.sex",
                "basicinfo.examNum", "basicinfo.idNum", "basicinfo.campus",
                "basicinfo.college", "basicinfo.major", "basicinfo.classNum",
                "basicinfo.dormNum", "basicinfo.bankCardId", "basicinfo.paySta",
                "basicinfo.collegeTel", "basicinfo.schoolTel", "basicinfo.masterName",
                "basicinfo.masterTel", "basicinfo.brother", "basicinfo.brothertel",
                "basicinfo.helper", "basicinfo.helpertel", "stcompleteinfo.bedding",
                "stcompleteinfo.phoneNum", "stcompleteinfo.parentName", "stcompleteinfo.parentPhoneNum",
                "stcompleteinfo.homeAddr", "stcompleteinfo.militaryClothing", "stcompleteinfo.shoeNum",
                "stcompleteinfo.height", "stcompleteinfo.weight", "stcompleteinfo.loan"
                , "stcompleteinfo.rTime"};

        String[] tableAlias = {"BasicinfoEntity as " + BASICTABLE, "StcompleteinfoEntity as " + STCOMTABLE};

        final String CONDITION = "WHERE " + BASICTABLE + "." + PRIMARYKEY + "=" + STCOMTABLE + "." + PRIMARYKEY + condi;

        List<Object[]> studentlist = multiTableSelect(tableAlias, a, CONDITION, pageNo, pageSize);
        if (studentlist.size()>0) {

            request.setAttribute("stu", studentlist.get(0));
            request.getRequestDispatcher("/WEUI/college/studentinfo.jsp").forward(request, response);
        }
        else{
            request.setAttribute("msg","找不到该学生！");
            request.getRequestDispatcher("/WEUI/operation_fail.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
