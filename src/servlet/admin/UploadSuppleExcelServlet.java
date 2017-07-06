package servlet.admin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import po.BasicinfoEntity;
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
 * Created by Minister on 2017/7/3.
 */
public class UploadSuppleExcelServlet extends HttpServlet {
    private final int NOT_FOUND = 0;
    private final int UPDATA = 1;
    private final int FIELD_NUM = 9;
    private final int START_ROW = 1;
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
                    List<List<String>> tableList = helper.importXlsx(item.getInputStream(), FIELD_NUM, START_ROW);
                    System.out.println(tableList.size());
                    System.out.println(tableList.get(0).size());
                    int[] result = addListToDatabase(tableList);
                    System.out.println("未找到：" + result[NOT_FOUND]);
                    System.out.println("更新：" + result[UPDATA]);
                    out.print("<h1>文件导入成功！</h1>");
                    out.print("本次操作 更新记录：" + result[UPDATA] + "条, 有"+result[NOT_FOUND]+"条记录未找到。");
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
            BasicinfoEntity stu = null;
            if ((stu = (BasicinfoEntity) HibernateUtil.get(BasicinfoEntity.class, row.get(0))) != null) {
                HibernateUtil.update(updateInfo(stu,info));
                result[UPDATA]++;
            }else {
                result[NOT_FOUND]++;
            }
        }
        return result;
    }

    private BasicinfoEntity updateInfo(BasicinfoEntity stu,Object[] info){
        stu.setClassNum(isValidatedString(info[1])? (String) info[1] :stu.getClassNum());
        stu.setDormNum(isValidatedString(info[2])? (String) info[2] :stu.getDormNum());
        stu.setMasterName(isValidatedString(info[3])? (String) info[3] :stu.getMasterName());
        stu.setMasterTel(isValidatedString(info[4])? (String) info[4] :stu.getMasterTel());
        stu.setBrother(isValidatedString(info[5])? (String) info[5] :stu.getBrother());
        stu.setBrothertel(isValidatedString(info[6])? (String) info[6] :stu.getBrothertel());
        stu.setHelper(isValidatedString(info[7])? (String) info[7] :stu.getHelper());
        stu.setHelpertel(isValidatedString(info[8])? (String) info[8] :stu.getHelpertel());
        return stu;
    }

    private boolean isValidatedString(Object object){
        if (object==null||object.toString().trim().equals("")){
            return false;
        }
        return true;
    }
}
