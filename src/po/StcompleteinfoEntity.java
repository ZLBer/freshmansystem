package po;

/**
 * Created by john on 2017/5/15.
 */
public class StcompleteinfoEntity {
    private String sno;
    private String bedding;
    private String phoneNum;
    private String parentName;
    private String parentPhoneNum;
    private String homeAddr;
    private String militaryClothing;
    private Integer shoeNum;
    private Integer height;
    private Integer weight;
    private String loan;
    private String rTime;

    public StcompleteinfoEntity(){}
    public StcompleteinfoEntity(String sno){
        this.setSno(sno);
        this.setBedding("");
        this.setPhoneNum("");
        this.setParentPhoneNum("");
        this.setParentName("");
        this.setHomeAddr("");
        this.setMilitaryClothing("");
        this.setLoan("");
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getBedding() {
        return bedding;
    }

    public void setBedding(String bedding) {
        this.bedding = bedding;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhoneNum() {
        return parentPhoneNum;
    }

    public void setParentPhoneNum(String parentPhoneNum) {
        this.parentPhoneNum = parentPhoneNum;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getMilitaryClothing() {
        return militaryClothing;
    }

    public void setMilitaryClothing(String militaryClothing) {
        this.militaryClothing = militaryClothing;
    }

    public Integer getShoeNum() {
        return shoeNum;
    }

    public void setShoeNum(Integer shoeNum) {
        this.shoeNum = shoeNum;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StcompleteinfoEntity that = (StcompleteinfoEntity) o;

        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (bedding != null ? !bedding.equals(that.bedding) : that.bedding != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;
        if (parentName != null ? !parentName.equals(that.parentName) : that.parentName != null) return false;
        if (parentPhoneNum != null ? !parentPhoneNum.equals(that.parentPhoneNum) : that.parentPhoneNum != null)
            return false;
        if (homeAddr != null ? !homeAddr.equals(that.homeAddr) : that.homeAddr != null) return false;
        if (militaryClothing != null ? !militaryClothing.equals(that.militaryClothing) : that.militaryClothing != null)
            return false;
        if (shoeNum != null ? !shoeNum.equals(that.shoeNum) : that.shoeNum != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (loan != null ? !loan.equals(that.loan) : that.loan != null) return false;
        if (rTime != null ? !rTime.equals(that.rTime) : that.rTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sno != null ? sno.hashCode() : 0;
        result = 31 * result + (bedding != null ? bedding.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (parentName != null ? parentName.hashCode() : 0);
        result = 31 * result + (parentPhoneNum != null ? parentPhoneNum.hashCode() : 0);
        result = 31 * result + (homeAddr != null ? homeAddr.hashCode() : 0);
        result = 31 * result + (militaryClothing != null ? militaryClothing.hashCode() : 0);
        result = 31 * result + (shoeNum != null ? shoeNum.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (loan != null ? loan.hashCode() : 0);
        result = 31 * result + (rTime != null ? rTime.hashCode() : 0);
        return result;
    }
}
