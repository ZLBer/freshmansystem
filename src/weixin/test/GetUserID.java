package weixin.test;

import net.sf.json.JSONObject;
import po.AdminEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;
import weixin.oauth2.util.GOauth2Core;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by Administrator on 2017/5/13.
 */
public class GetUserID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        System.out.println("开始获取code");
        String code = request.getParameter("code");
        System.out.println("开始获取state");
        String state=request.getParameter("state");
        System.out.println("跳转的地址是："+state);

        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();

        String UserID;
        String servername=request.getServerName();
        //-----------------------------------------//

        if(request.getSession().getAttribute("userid")==null){        //如果session值为空
            System.out.println("Session值为空");

            UserID = GOauth2Core.GetUserID(access_token, code, ParamesAPI.AgentId_qiye);

            System.out.println("当前用户的Id是"+UserID);
            if(UserID!=null){
                System.out.println("UserID不为空，，开始转发");
                session.setAttribute("userid",UserID);
                session.setAttribute("user",UserID);

            }else{
                System.out.println("调用接口UserId获取失败！！！");
                request.getRequestDispatcher("WEUI/operate_fail.jsp").forward(request, response);
            }
        }

        else{              //session值不为空
            System.out.println("Session值为不为空");
            //从session中获取UserID

            UserID=request.getSession().getAttribute("userid").toString();
            System.out.println("当前用户的Id是"+UserID);
            if(UserID!=null){
                System.out.println("UserID不为空，，开始转发");


            }else{
                System.out.println("从session中获取UserId获取失败！！！");
                request.getRequestDispatcher("WEUI/operate_fail.jsp").forward(request, response);
            }
        }


        /////////////////////////////////////////////////////////////////判断state值，跳转到不同的地址

        if(state.equals("qr")){                             //二维码报道

            //跳转到获取学生信息的servlet
            request.getRequestDispatcher("QueryStudent").forward(request,response);
        }
        else if(state.equals("sc")){                        //学生查看自己的信息

            request.getRequestDispatcher("student/queryByStudent").forward(request, response);
        }
        else if(state.equals("ws")){                        //学生完善自己的信息--未完成

            request.getRequestDispatcher("student/beforeComplete").forward(request, response);
        }
        else if(state.equals("lcx")){                             //学院查看新生信息
            System.out.println("学院开始查看新生信息");
            request.getRequestDispatcher("/WEUI/college/querybysno.jsp").forward(request, response);
        }

        else if(state.equals("sdbd")){                      //学院手动报到新生

            request.getRequestDispatcher("WEUI/college/baodao.jsp").forward(request, response);

        }
        else if(state.equals("zsck")){                      //招生办查看学生
            request.getRequestDispatcher("WEUI/admin/searchstu.jsp").forward(request, response);

        }
        else if(state.equals("zsreason")){                  //招生办对未报到学生进行备注

            request.getRequestDispatcher("WEUI/admin/reasonFill.jsp").forward(request, response);

        }
        else if(state.equals("zsbdl")){                     //招生办查看报到

            request.getRequestDispatcher("admin/admin_checkBaodao").forward(request,response);

        }
        else if(state.equals("at")){                        //新生修改手机号
            MPerson mper=new MPerson();
            String getpersonURL=mper.GET_PERSON_URL.replace("ACCESS_TOKEN", access_token).replace("ID", UserID);

            String xuehao=request.getSession().getAttribute("userid").toString();

            JSONObject jsonobject = WeixinUtil.HttpRequest(getpersonURL, "GET", null);


            String name=jsonobject.getString("name");
            String mobile=jsonobject.getString("mobile");

            session.setAttribute("stuxingming",name);       //将学生姓名存入session,以便之后修改手机号使用

            request.setAttribute("stuxingming", name);
            request.setAttribute("shouji", mobile);
            request.setAttribute("stuxuehao", xuehao);

            request.getRequestDispatcher("/WEUI/student/altertel.jsp").forward(request,response);
        }

        else if(state.equals("xckbd")){                       //学院查看专业报到率
            System.out.println("学院开始查看报到率");
            String condition = "where adminname =" + UserID;
            List<AdminEntity> teachers = HibernateUtil.query("AdminEntity", condition);
            AdminEntity teacher = new AdminEntity();
            if (teachers.size() > 0) {

                teacher = teachers.get(0);

            }
            String collegeid=teacher.getCollege();
            System.out.println("GetUserrID-老师所属学院是："+collegeid);
            request.getRequestDispatcher("admin/gotoMajorDetailServlet?collegeId="+collegeid).forward(request,response);

        }
        else if(state.equals("xywbd")){                      //学院查看所有未报到学生&备注未报到原因

            String condition = "where adminname =" + UserID;
            List<AdminEntity> teachers = HibernateUtil.query("AdminEntity", condition);
            AdminEntity teacher = new AdminEntity();
            if (teachers.size() > 0) {
                teacher = teachers.get(0);
            }
            String collegeid=teacher.getCollege();
            session.setAttribute("collegeid",collegeid);
            System.out.println("GetUserrID-老师所属学院是："+collegeid);
            request.getRequestDispatcher("/college/college_checkNoRegister?collegeid="+collegeid+"&page_current=1").forward(request, response);

        }

        else if(state.equals("xyreason")){                        //学院对未报到学生进行备注

            request.getRequestDispatcher("/WEUI/college/beizhu.jsp").forward(request, response);
        }

        else{
            System.out.println("经过GetUserID时转发出错啦");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
