package po;

/**
 * Created by john on 2017/5/15.
 */
public class RegisterdateEntity {
    private int id;
    private String rDate;
    private String rEnabled;
    private String rCampus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getrEnabled() {
        return rEnabled;
    }

    public void setrEnabled(String rEnabled) {
        this.rEnabled = rEnabled;
    }

    public String getrCampus() {
        return rCampus;
    }

    public void setrCampus(String rCampus) {
        this.rCampus = rCampus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterdateEntity that = (RegisterdateEntity) o;

        if (id != that.id) return false;
        if (rDate != null ? !rDate.equals(that.rDate) : that.rDate != null) return false;
        if (rEnabled != null ? !rEnabled.equals(that.rEnabled) : that.rEnabled != null) return false;
        if (rCampus != null ? !rCampus.equals(that.rCampus) : that.rCampus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rDate != null ? rDate.hashCode() : 0);
        result = 31 * result + (rEnabled != null ? rEnabled.hashCode() : 0);
        result = 31 * result + (rCampus != null ? rCampus.hashCode() : 0);
        return result;
    }
}
