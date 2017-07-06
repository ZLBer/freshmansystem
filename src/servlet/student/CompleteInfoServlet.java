package servlet.student;

import po.StcompleteinfoEntity;
import po.TrafficinfoEntity;
import po.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Minister on 2017/5/18.
 */
public class CompleteInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String sno;
        try {

            if(session.getAttribute("userid")!=null){      //跳转微信端操作

                sno=session.getAttribute("userid").toString();
            }
            else{          //跳转电脑端操作
                sno = ((UserEntity) request.getSession().getAttribute("user")).getSno();
            }

            //获取实体类
            StcompleteinfoEntity completeInfo = (StcompleteinfoEntity) HibernateUtil.get(StcompleteinfoEntity.class, sno);
            TrafficinfoEntity trafficIinfo = (TrafficinfoEntity) HibernateUtil.get(TrafficinfoEntity.class, sno);
            //为实体类补充信息
            getParamAndFillEntity(request, completeInfo, trafficIinfo);
            //保存实体类
            HibernateUtil.update(completeInfo);
            HibernateUtil.update(trafficIinfo);
            if(session.getAttribute("userid")!=null){            //跳转微信端操作
                request.setAttribute("msg","完善信息成功！");
                request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);
            }
            else{                                                  //跳转电脑端操作
                out.print("<h1>信息提交成功!</h1>");
            }

        }catch (Exception e){
            e.printStackTrace();
            if(session.getAttribute("userid")!=null){            //跳转微信端操作
                request.setAttribute("msg","完善信息失败！");
                request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);
            }
            else{                                                  //跳转电脑端操作
                out.print("<h1>信息提交失败，请确认填写的信息！</h1>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void getParamAndFillEntity(HttpServletRequest request,StcompleteinfoEntity sEntity,TrafficinfoEntity tEntity){
        //后去完善信息参数
        String  phoneNum=request.getParameter("phoneNum");

        String  parentName=request.getParameter("parentName");
        String  parentPhoneNum=request.getParameter("parentPhoneNum");
        String  homeAddr=request.getParameter("homeAddr");
        String  militaryClothing=request.getParameter("militaryClothing");
        String  shoeNum=request.getParameter("shoeNum");
        String  height=request.getParameter("height");
        String  weight=request.getParameter("weight");
        String  loan=request.getParameter("loan");
        //获取交通信息参数
        String  trafficWay=request.getParameter("trafficWay");
        String  company=request.getParameter("company");
        String  registerTime=request.getParameter("registerTime");

        System.out.println("时间为1"+phoneNum);
        System.out.println("时间为2"+parentName);
        System.out.println("时间为3"+parentPhoneNum);
        System.out.println("时间为4"+homeAddr);
        System.out.println("时间为5"+militaryClothing);
        System.out.println("时间为6"+shoeNum);
        System.out.println("时间为7"+height);
        System.out.println("时间为8"+weight);
        System.out.println("时间为9"+loan);
        System.out.println("时间为10"+trafficWay);
        System.out.println("时间为11"+company);
        System.out.println("时间为12"+registerTime);



        //为实体类设值
        sEntity.setPhoneNum(phoneNum);
        sEntity.setParentName(parentName);
        sEntity.setParentPhoneNum(parentPhoneNum);
        sEntity.setHomeAddr(homeAddr);
        sEntity.setMilitaryClothing(militaryClothing);
        sEntity.setShoeNum(safeString(shoeNum));
        sEntity.setHeight(safeString(height));
        sEntity.setWeight(safeString(weight));
        sEntity.setLoan(loan);

        tEntity.setTrafficWay(trafficWay);
        tEntity.setCompany(safeString(company));
        tEntity.setRegisterTime(registerTime);

    }
    private int safeString(String string){
        try{
            int temp =  Integer.parseInt(string);
            return temp;
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
