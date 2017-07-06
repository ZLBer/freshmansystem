package servlet.admin;

import po.TrafficinfoEntity;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import static util.HibernateUtil.multiTableSelect;

/**
 * Created by john on 2017/5/15.
 */
public class QueryByAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();

        String fieldName=request.getParameter("fieldName");
        String fieldValue=request.getParameter("fieldValue");

        String condition="";
        String condi="";
        if(fieldName!=null && !"".equals(fieldName)){

            condition="where "+fieldName +" like '%"+fieldValue+"%'";
            condi=" and basicinfo."+fieldName +" like '%"+fieldValue+"%'";
        }
        int pageSize=15;
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));
        int recordCount= HibernateUtil.recordCount("BasicinfoEntity", condition);
        if(recordCount>0){

            final String BASICTABLE = "basicinfo";
            final String PRIMARYKEY = "sno";
            final String STCOMTABLE = "stcompleteinfo";
            final String TRAFFICTABLEALIAS = "trafficinfo";

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
                        ,"stcompleteinfo.rTime","trafficinfo.trafficWay","trafficinfo.company"
            ,"trafficinfo.registerTime"};
            String[] tableAlias = {"BasicinfoEntity as "+BASICTABLE, "StcompleteinfoEntity as "+STCOMTABLE,
                    "TrafficinfoEntity as "+TRAFFICTABLEALIAS};
            final String CONDITION = "WHERE "+BASICTABLE+"."+PRIMARYKEY +"="+STCOMTABLE+"."+PRIMARYKEY+" and "
                    + BASICTABLE +"."+ PRIMARYKEY +"="+ TRAFFICTABLEALIAS +"."+ PRIMARYKEY+condi;

            List<Object[]> studentlist = multiTableSelect(tableAlias,a,CONDITION,pageNo,pageSize);

            //HibernateUtil.query("BasicinfoEntity", condition, "", pageNo, pageSize);
            int t1=recordCount%pageSize;;
            int t2=recordCount/pageSize;
            int pageCount=(t1==0?t2:t2+1);
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("studentList", studentlist);
        }
        request.setAttribute("recordCount", recordCount);

        request.getRequestDispatcher("/admin/query.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
