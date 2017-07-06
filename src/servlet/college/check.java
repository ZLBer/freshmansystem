package servlet.college;

import po.AdminEntity;
import po.CollegeEntity;
import po.RegisterinfoEntity;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by libin on 2017/5/20.
 */
public class check {
    public static String checkcollege(String teacherid, String studentid) {

        String condition = "where adminname=" + teacherid;
        List<AdminEntity> teachers = HibernateUtil.query("AdminEntity", condition);
        AdminEntity teacher = new AdminEntity();
        if (teachers.size() > 0) {

            teacher = teachers.get(0);

        }
        String college = teacher.getCollege();
        String condi = "where collegeid=" + college;
        List<CollegeEntity> colleges = HibernateUtil.query("CollegeEntity", condi);
        CollegeEntity coll = new CollegeEntity();
        if (colleges.size() > 0) {
            coll = colleges.get(0);
        }
        RegisterinfoEntity student = (RegisterinfoEntity) HibernateUtil.get(RegisterinfoEntity.class, studentid);
        System.out.println("学生所属学院：" + student.getCollege());
        System.out.println("老师所属学院" + coll.getCollegename());
        if (coll.getCollegename().equals(student.getCollege())) {
            if (student.getSpotRegister().equals("已报到")) {
                return "yibaodao";
            }
            else {
                student.setSpotRegister("已报到");
                HibernateUtil.update(student);
                return "true";
            }
        }
        return "false";
    }
}
