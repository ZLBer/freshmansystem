package weixin.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static util.HibernateUtil.multiTableSelect;

/**
 * Created by ThinkPad on 2017/6/2 0002.
 */
public class SearchStuInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        //获取jsp的学号
        String studentID=request.getParameter("studentID");
        //将表单中的学生ID放到session里，便于之后的servlet使用
        session.setAttribute("sid",studentID);

        String condi=" and basicinfo.sno="+studentID;

        int pageSize=1;
        int pageNo=1;

        final String PRIMARYKEY = "sno";
        final String BASICTABLE = "basicinfo";
        final String STCOMTABLE = "stcompleteinfo";

        String[] a = {"basicinfo.sno", "basicinfo.name","basicinfo.sex",
                "basicinfo.examNum","basicinfo.idNum","basicinfo.campus",
                "basicinfo.college","basicinfo.major","basicinfo.classNum",
                "basicinfo.dormNum","basicinfo.bankCardId","basicinfo.paySta",
                "basicinfo.collegeTel","basicinfo.schoolTel","basicinfo.masterName",
                "basicinfo.masterTel","basicinfo.brother","basicinfo.brothertel",
                "basicinfo.helper","basicinfo.helpertel","stcompleteinfo.bedding",
                "stcompleteinfo.phoneNum","stcompleteinfo.parentName","stcompleteinfo.parentPhoneNum",
                "stcompleteinfo.homeAddr","stcompleteinfo.militaryClothing","stcompleteinfo.shoeNum",
                "stcompleteinfo.height","stcompleteinfo.weight","stcompleteinfo.loan"
                ,"stcompleteinfo.rTime"
        };

        String[] tableAlias = {"BasicinfoEntity as "+BASICTABLE, "StcompleteinfoEntity as "+STCOMTABLE};

        final String CONDITION = "WHERE "+BASICTABLE+"."+PRIMARYKEY +"="+STCOMTABLE+"."+PRIMARYKEY+condi;

        List<Object[]> studentlist = multiTableSelect(tableAlias,a,CONDITION,pageNo,pageSize);
        if(studentlist.size()>0){
            request.setAttribute("stu", studentlist.get(0));

            request.getRequestDispatcher("/WEUI/student/baodaoinfo.jsp").forward(request, response);
        }
        else{
            request.setAttribute("msg","找不到该学生！");
            request.getRequestDispatcher("/WEUI/operation_fail.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
