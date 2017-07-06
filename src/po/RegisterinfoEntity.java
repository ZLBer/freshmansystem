package po;

/**
 * Created by john on 2017/5/15.
 */
public class RegisterinfoEntity {
    private String sno;
    private String college;
    private String spotRegister;
    private String netRegister;
    private String reservation;
    private String rTime;
    private String reason;
    private String registerTime;

    public RegisterinfoEntity(){}
    public RegisterinfoEntity(String sno,String college,String baodaoStates){
        this.setSno(sno);
        this.setCollege(college);
        this.setSpotRegister(baodaoStates);
        this.setNetRegister(baodaoStates);
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSpotRegister() {
        return spotRegister;
    }

    public void setSpotRegister(String spotRegister) {
        this.spotRegister = spotRegister;
    }

    public String getNetRegister() {
        return netRegister;
    }

    public void setNetRegister(String netRegister) {
        this.netRegister = netRegister;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterinfoEntity that = (RegisterinfoEntity) o;

        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (spotRegister != null ? !spotRegister.equals(that.spotRegister) : that.spotRegister != null) return false;
        if (netRegister != null ? !netRegister.equals(that.netRegister) : that.netRegister != null) return false;
        if (reservation != null ? !reservation.equals(that.reservation) : that.reservation != null) return false;
        if (rTime != null ? !rTime.equals(that.rTime) : that.rTime != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sno != null ? sno.hashCode() : 0;
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (spotRegister != null ? spotRegister.hashCode() : 0);
        result = 31 * result + (netRegister != null ? netRegister.hashCode() : 0);
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        result = 31 * result + (rTime != null ? rTime.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        return result;
    }
}
