package servlet.admin;

import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Minister on 2017/5/1.
 */
public class DownloadInfoServlet extends HttpServlet {
    private final String PRIMARYKEY = "sno";
    private final String BASICTABLEALIAS = "basicinfo";
    private final String STCOMTABLEALIAS = "stcompleteinfo";
    private final String TRAFFICTABLEALIAS = "trafficinfo";
    private final String CONDITION = "WHERE "+ BASICTABLEALIAS +"."+ PRIMARYKEY +"="+ STCOMTABLEALIAS +"."+ PRIMARYKEY +" and "
                                        + BASICTABLEALIAS +"."+ PRIMARYKEY +"="+ TRAFFICTABLEALIAS +"."+ PRIMARYKEY;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //表数组
        String[] tables = {"BasicinfoEntity as "+ BASICTABLEALIAS,"StcompleteinfoEntity as "+ STCOMTABLEALIAS,"TrafficinfoEntity as "+ TRAFFICTABLEALIAS};
        //获取基础信息字段
        String[] basicinfo = request.getParameterValues("basic");
        String[] basicinfoFieldName = initArray(basicinfo);
        splitString(basicinfo,basicinfoFieldName);
        //填写信息字段
        String[] stcompleteinfo = request.getParameterValues("telephone");
        String[] stcompleteinfoFieldName = initArray(stcompleteinfo);
        splitString(stcompleteinfo,stcompleteinfoFieldName);
        //交通信息字段
        String[] trafficinfo = request.getParameterValues("traffic");
        String[] trafficinfoFieldName = initArray(trafficinfo);
        splitString(trafficinfo,trafficinfoFieldName);

        //将数组作存储在一个数组里
        String[][] temp = {basicinfo,stcompleteinfo,trafficinfo};
        //组合字段数组
        String[] fields = combinArray(temp);
        System.out.println(Arrays.toString(fields));
        //查询数据库获取结果集
        List<Object[]> info = HibernateUtil.multiTableSelect(tables,fields, CONDITION);
        System.out.println(info.size());

        fields = combinArray(new String[][]{basicinfoFieldName,stcompleteinfoFieldName,trafficinfoFieldName});
        request.setAttribute("fields",fields);
        request.setAttribute("info",info);
        request.getRequestDispatcher("stuInfoExcel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private String[] combinArray(String[][] arrays){
        int length = 0;
        int index = 0;
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]!=null)
                length+=arrays[i].length;
        }
        String[] temp = new String[length];
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]!=null) {
                for (int j = 0; j < arrays[i].length; j++) {
                    temp[index++] = arrays[i][j];
                }
            }
        }
        return temp;
    }
    private void splitString(String[] args1,String[] args2){
        if (args1!=null&&args2!=null){
            for (int i=0;i<args1.length;i++){
                System.out.println(args1[i]);
                String[] tmp = args1[i].split("-");
                args1[i] = tmp[0];
                args2[i] = tmp[1];
            }
        }
    }
    private String[] initArray(String[] args){
        if (args!=null){
            return new String[args.length];
        }
        return null;
    }
}
