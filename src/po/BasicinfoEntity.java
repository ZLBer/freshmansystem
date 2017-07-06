package po;

/**
 * Created by john on 2017/5/15.
 */
public class BasicinfoEntity {
    private String sno;
    private String name;
    private String sex;
    private String examNum;
    private String idNum;
    private String campus;
    private String college;
    private String major;
    private String classNum;
    private String dormNum;
    private String bankCardId;
    private String paySta;
    private String collegeTel;
    private String schoolTel;
    private String masterName;
    private String masterTel;
    private String brother;
    private String brothertel;
    private String helper;
    private String helpertel;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getExamNum() {
        return examNum;
    }

    public void setExamNum(String examNum) {
        this.examNum = examNum;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    public String getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(String bankCardId) {
        this.bankCardId = bankCardId;
    }

    public String getPaySta() {
        return paySta;
    }

    public void setPaySta(String paySta) {
        this.paySta = paySta;
    }

    public String getCollegeTel() {
        return collegeTel;
    }

    public void setCollegeTel(String collegeTel) {
        this.collegeTel = collegeTel;
    }

    public String getSchoolTel() {
        return schoolTel;
    }

    public void setSchoolTel(String schoolTel) {
        this.schoolTel = schoolTel;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterTel() {
        return masterTel;
    }

    public void setMasterTel(String masterTel) {
        this.masterTel = masterTel;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getBrothertel() {
        return brothertel;
    }

    public void setBrothertel(String brothertel) {
        this.brothertel = brothertel;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public String getHelpertel() {
        return helpertel;
    }

    public void setHelpertel(String helpertel) {
        this.helpertel = helpertel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicinfoEntity that = (BasicinfoEntity) o;

        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (examNum != null ? !examNum.equals(that.examNum) : that.examNum != null) return false;
        if (idNum != null ? !idNum.equals(that.idNum) : that.idNum != null) return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (classNum != null ? !classNum.equals(that.classNum) : that.classNum != null) return false;
        if (dormNum != null ? !dormNum.equals(that.dormNum) : that.dormNum != null) return false;
        if (bankCardId != null ? !bankCardId.equals(that.bankCardId) : that.bankCardId != null) return false;
        if (paySta != null ? !paySta.equals(that.paySta) : that.paySta != null) return false;
        if (collegeTel != null ? !collegeTel.equals(that.collegeTel) : that.collegeTel != null) return false;
        if (schoolTel != null ? !schoolTel.equals(that.schoolTel) : that.schoolTel != null) return false;
        if (masterName != null ? !masterName.equals(that.masterName) : that.masterName != null) return false;
        if (masterTel != null ? !masterTel.equals(that.masterTel) : that.masterTel != null) return false;
        if (brother != null ? !brother.equals(that.brother) : that.brother != null) return false;
        if (brothertel != null ? !brothertel.equals(that.brothertel) : that.brothertel != null) return false;
        if (helper != null ? !helper.equals(that.helper) : that.helper != null) return false;
        if (helpertel != null ? !helpertel.equals(that.helpertel) : that.helpertel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sno != null ? sno.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (examNum != null ? examNum.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (classNum != null ? classNum.hashCode() : 0);
        result = 31 * result + (dormNum != null ? dormNum.hashCode() : 0);
        result = 31 * result + (bankCardId != null ? bankCardId.hashCode() : 0);
        result = 31 * result + (paySta != null ? paySta.hashCode() : 0);
        result = 31 * result + (collegeTel != null ? collegeTel.hashCode() : 0);
        result = 31 * result + (schoolTel != null ? schoolTel.hashCode() : 0);
        result = 31 * result + (masterName != null ? masterName.hashCode() : 0);
        result = 31 * result + (masterTel != null ? masterTel.hashCode() : 0);
        result = 31 * result + (brother != null ? brother.hashCode() : 0);
        result = 31 * result + (brothertel != null ? brothertel.hashCode() : 0);
        result = 31 * result + (helper != null ? helper.hashCode() : 0);
        result = 31 * result + (helpertel != null ? helpertel.hashCode() : 0);
        return result;
    }
    public BasicinfoEntity(){}
    public BasicinfoEntity(Object[] array){
        this.setSno((String) array[0]);
        this.setName((String) array[1]);
        this.setSex((String) array[2]);
        this.setExamNum((String) array[3]);
        this.setIdNum((String) array[4]);
        this.setCampus((String) array[5]);
        this.setCollege((String) array[6]);
        this.setMajor((String) array[7]);
        this.setClassNum((String) array[8]);
        this.setDormNum((String) array[9]);
        this.setBankCardId((String) array[10]);
        this.setPaySta((String) array[11]);
        this.setCollegeTel((String) array[12]);
        this.setSchoolTel((String) array[13]);
        this.setMasterName((String) array[14]);
        this.setMasterTel((String) array[15]);
        this.setBrother((String) array[16]);
        this.setBrothertel((String) array[17]);
        this.setHelper((String) array[18]);
        this.setHelpertel((String) array[19]);
    }
    public void update(Object[] array){
        this.setName((String) array[1]);
        this.setSex((String) array[2]);
        this.setExamNum((String) array[3]);
        this.setIdNum((String) array[4]);
        this.setCampus((String) array[5]);
        this.setCollege((String) array[6]);
        this.setMajor((String) array[7]);
        this.setClassNum((String) array[8]);
        this.setDormNum((String) array[9]);
        this.setBankCardId((String) array[10]);
        this.setPaySta((String) array[11]);
        this.setCollegeTel((String) array[12]);
        this.setSchoolTel((String) array[13]);
        this.setMasterName((String) array[14]);
        this.setMasterTel((String) array[15]);
        this.setBrother((String) array[16]);
        this.setBrothertel((String) array[17]);
        this.setHelper((String) array[18]);
        this.setHelpertel((String) array[19]);
    }
}
