package po;

/**
 * Created by john on 2017/5/15.
 */
public class LoggerEntity {
    private int id;
    private String uIp;
    private String uName;
    private String uOperate;
    private String uTime;
    private String uParams;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuIp() {
        return uIp;
    }

    public void setuIp(String uIp) {
        this.uIp = uIp;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuOperate() {
        return uOperate;
    }

    public void setuOperate(String uOperate) {
        this.uOperate = uOperate;
    }

    public String getuTime() {
        return uTime;
    }

    public void setuTime(String uTime) {
        this.uTime = uTime;
    }

    public String getuParams() {
        return uParams;
    }

    public void setuParams(String uParams) {
        this.uParams = uParams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggerEntity that = (LoggerEntity) o;

        if (id != that.id) return false;
        if (uIp != null ? !uIp.equals(that.uIp) : that.uIp != null) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (uOperate != null ? !uOperate.equals(that.uOperate) : that.uOperate != null) return false;
        if (uTime != null ? !uTime.equals(that.uTime) : that.uTime != null) return false;
        if (uParams != null ? !uParams.equals(that.uParams) : that.uParams != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uIp != null ? uIp.hashCode() : 0);
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (uOperate != null ? uOperate.hashCode() : 0);
        result = 31 * result + (uTime != null ? uTime.hashCode() : 0);
        result = 31 * result + (uParams != null ? uParams.hashCode() : 0);
        return result;
    }
}
