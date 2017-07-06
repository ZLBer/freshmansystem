package servlet.admin;

import po.RegisterinfoEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Minister on 2017/5/20.
 */
public class GotoCheckServlet extends HttpServlet {
    private final int PAGE_SIZE = 5;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String condition = "";

        int count = HibernateUtil.recordCount("RegisterinfoEntity",condition+" order by sno");
        int pageCount = count/PAGE_SIZE+(count%PAGE_SIZE>0?1:0);//总页数
        int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));

        List<RegisterinfoEntity> registerInfo = HibernateUtil.query("RegisterinfoEntity",condition,"order by sno",currentPage,PAGE_SIZE);

        int temp[] = getStartAndEnd(currentPage,pageCount);

        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("startPage",temp[0]);
        request.setAttribute("endPage",temp[1]);
        request.setAttribute("registerInfo",registerInfo);
        request.getRequestDispatcher("checkNoRegistedStu.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private int[] getStartAndEnd(int currentPage,int pageCount){
        int[] temp = {0,0};
        if(pageCount<10){
            temp[0] = 1;
            temp[1] = pageCount;
        }else{
            if (currentPage<6){
                temp[0] = 1;
                temp[1] = 10;
            }else if (currentPage>pageCount-5){
                temp[0] = pageCount-9;
                temp[1] = pageCount;
            }else{
                temp[0] = currentPage-5;
                temp[1] = currentPage+4;
            }
        }
        return temp;
    }
}
