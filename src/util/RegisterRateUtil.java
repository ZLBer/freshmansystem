package util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Minister on 2017/5/19.
 */
public class RegisterRateUtil {
    public static List getMajorRegisterRate(int collegeId){
        List<List<String>> rates = new ArrayList();
        String condition = "WHERE collegeid="+collegeId;
        String[] fields = {"DISTINCT majorname,majorid"};
        String clazz = "MajorEntity";
        String classes = "BasicinfoEntity as a,RegisterinfoEntity as b";
        String[] field = {"collegename"};
        Object collegeName = (HibernateUtil.selectFields("CollegeEntity",field,"WHERE collegeid="+collegeId)).get(0);
        List<Object[]> majorNames = HibernateUtil.selectFields(clazz,fields,condition);
        for (Object[] name:majorNames){
            String majorId = name[1]+"";
            String majorName = (String) name[0];
            int count = HibernateUtil.recordCount("BasicinfoEntity","WHERE major='"+majorName+"' AND college='"+collegeName+"'");
            int registeredNum = HibernateUtil.recordCount(classes,
                    "WHERE a.sno=b.sno " +
                    "AND a.major='"+majorName+"' " +
                    "AND b.spotRegister='已报到' " +
                    "AND a.college='"+collegeName+"'");
            float rate = (count==0?0:(float)registeredNum/(float)count);
            List temp = new ArrayList();
            temp.add(majorId);
            temp.add(majorName);
            temp.add(count);
            temp.add(registeredNum);
            temp.add(Math.round(rate*100)+"%");
            rates.add(temp);
        }
        return rates;
    }

}
