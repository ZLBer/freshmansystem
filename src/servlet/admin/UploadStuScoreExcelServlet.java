package servlet.admin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import po.*;
import util.ExcelHelper;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Minister on 2017/5/3.
 */
public class UploadStuScoreExcelServlet extends HttpServlet {
    private final int ADD = 0;
    private final int UPDATA = 1;
    //是否更新
    private boolean isUpdate = false;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding(request.getCharacterEncoding());
        ExcelHelper helper = new ExcelHelper();
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (int i = 0; i < list.size(); i++) {
                FileItem item = list.get(i);
                if (item.isFormField()){
                    if (item.getFieldName().equals("isUpdate")&&item.getString().equals("true")){
                        isUpdate = true;
                    }
                }else if (item.getName().endsWith(".xls") || item.getName().endsWith(".xlsx")) {
                    List<List<String>> tableList = helper.importXlsx(item.getInputStream(), 20, 1);
                    System.out.println(tableList.size());
                    System.out.println(tableList.get(0).size());
                    int[] result = addListToDatabase(tableList);
                    System.out.println("添加：" + result[ADD]);
                    System.out.println("更新：" + result[UPDATA]);
                    out.print("<h1>文件导入成功！</h1>");
                    out.print("本次操作 添加新纪录记录：" + result[ADD] + "条，更新记录：" + result[UPDATA] + "条。");
                } else {
                    out.print("<h1>文件格式错误!</h1>");
                    out.print("请确认是.xlsx文件");
                }
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h1>文件上传失败!</h1>");
            out.print("请仔细阅读注意事项");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private int[] addListToDatabase(List<List<String>> list){
        Object[] info = null;
        int[] result = {0,0};
        for (List<String> row:list) {
            info = row.toArray();
            ScoreEntity scoreEntity = null;
            if ((scoreEntity = (ScoreEntity) HibernateUtil.get(ScoreEntity.class, row.get(0))) != null) {
                if (isUpdate) {
                    scoreEntity.setScore(Integer.valueOf((String)info[1]));
                    HibernateUtil.update(scoreEntity);
                    result[UPDATA]++;
                }
            }else{
                scoreEntity = new ScoreEntity();
                scoreEntity.setSno((String) info[0]);
                scoreEntity.setScore(Integer.valueOf((String)info[1]));
                HibernateUtil.add(scoreEntity);
                result[ADD]++;
            }
        }
        return result;
    }
}
