package po;

/**
 * Created by john on 2017/5/15.
 */
public class TrafficinfoEntity {
    private String sno;
    private String trafficWay;
    private Integer company;
    private String registerTime;
    private String campus;
    private String tTime;
    public TrafficinfoEntity(){}
    public TrafficinfoEntity(String sno){
        this.setSno(sno);
        this.setTrafficWay("");
        this.setRegisterTime("");
        this.setCampus("");
        this.settTime("");
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getTrafficWay() {
        return trafficWay;
    }

    public void setTrafficWay(String trafficWay) {
        this.trafficWay = trafficWay;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String gettTime() {
        return tTime;
    }

    public void settTime(String tTime) {
        this.tTime = tTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrafficinfoEntity that = (TrafficinfoEntity) o;

        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (trafficWay != null ? !trafficWay.equals(that.trafficWay) : that.trafficWay != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (tTime != null ? !tTime.equals(that.tTime) : that.tTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sno != null ? sno.hashCode() : 0;
        result = 31 * result + (trafficWay != null ? trafficWay.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (tTime != null ? tTime.hashCode() : 0);
        return result;
    }
}
