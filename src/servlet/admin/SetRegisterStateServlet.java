package servlet.admin;

import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Minister on 2017/5/20.
 */
public class SetRegisterStateServlet extends HttpServlet {
    private final String REGISTER = "已报到";
    private final String NOREGISTER = "未报到";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String isBatch = request.getParameter("batch");
        String state = request.getParameter("state");
        try{
            switch (isBatch){
                case "true":
                    String[] snos = request.getParameterValues("selectedNo");
                    for (String sno:snos){
                        setState(sno,state);
                        System.out.println("true");
                    }
                    break;
                case "false":
                    String sno = request.getParameter("sno");
                    setState(sno,state);
                    System.out.println("false");
                    break;
            }

            out.print("<h1>操作成功</h1>");
        }catch(Exception e){
            e.printStackTrace();
            out.print("<h1>操作失败</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void setState(String sno,String state){
        RegisterinfoEntity registerInfo = (RegisterinfoEntity) HibernateUtil.get(RegisterinfoEntity.class,sno);
        if (state.equals("yes")) {
            System.out.println("yes");
            registerInfo.setSpotRegister(REGISTER);
        }else {
            registerInfo.setSpotRegister(NOREGISTER);
            System.out.println("no");
        }
        HibernateUtil.update(registerInfo);
    }
}
