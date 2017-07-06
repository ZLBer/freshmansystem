package po;

/**
 * Created by john on 2017/5/15.
 */
public class RegistercountEntity {
    private int id;
    private Integer tcount;
    private Integer scount;
    private Integer rcount;
    private String ctime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public Integer getRcount() {
        return rcount;
    }

    public void setRcount(Integer rcount) {
        this.rcount = rcount;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistercountEntity that = (RegistercountEntity) o;

        if (id != that.id) return false;
        if (tcount != null ? !tcount.equals(that.tcount) : that.tcount != null) return false;
        if (scount != null ? !scount.equals(that.scount) : that.scount != null) return false;
        if (rcount != null ? !rcount.equals(that.rcount) : that.rcount != null) return false;
        if (ctime != null ? !ctime.equals(that.ctime) : that.ctime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tcount != null ? tcount.hashCode() : 0);
        result = 31 * result + (scount != null ? scount.hashCode() : 0);
        result = 31 * result + (rcount != null ? rcount.hashCode() : 0);
        result = 31 * result + (ctime != null ? ctime.hashCode() : 0);
        return result;
    }
}
