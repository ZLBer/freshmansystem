package servlet.admin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import po.BasicinfoEntity;
import po.ScoreEntity;
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
 * Created by Minister on 2017/7/9.
 */
public class UploadPayStateExcelServlet extends HttpServlet {
    private final int NOT_FOUND = 0;
    private final int UPDATA = 1;
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
                if (item.getName().endsWith(".xls") || item.getName().endsWith(".xlsx")) {
                    List<List<String>> tableList = helper.importXlsx(item.getInputStream(), 2, 1);
                    System.out.println(tableList.size());
                    System.out.println(tableList.get(0).size());
                    int[] result = addListToDatabase(tableList);
                    System.out.println("忽略：" + result[NOT_FOUND]);
                    System.out.println("更新：" + result[UPDATA]);
                    out.print("<h1>文件导入成功！</h1>");
                    out.print("本次操作 忽略记录：" + result[NOT_FOUND] + "条，更新记录：" + result[UPDATA] + "条。");
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
            BasicinfoEntity entity = null;
            if ((entity = (BasicinfoEntity) HibernateUtil.get(BasicinfoEntity.class, row.get(0))) != null) {
                entity.setPaySta((String) info[1]);
                HibernateUtil.update(entity);
                result[UPDATA]++;
            }else{
                result[NOT_FOUND]++;
            }
        }
        return result;
    }
}
