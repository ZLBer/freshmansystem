package po;

/**
 * Created by john on 2017/5/15.
 */
public class SysSetEntity {
    private int id;
    private String sMtitle;
    private String sUtitle;
    private String sNhref;
    private Integer sNblank;
    private String sMhref;
    private Integer sMblank;
    private String sFooter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsMtitle() {
        return sMtitle;
    }

    public void setsMtitle(String sMtitle) {
        this.sMtitle = sMtitle;
    }

    public String getsUtitle() {
        return sUtitle;
    }

    public void setsUtitle(String sUtitle) {
        this.sUtitle = sUtitle;
    }

    public String getsNhref() {
        return sNhref;
    }

    public void setsNhref(String sNhref) {
        this.sNhref = sNhref;
    }

    public Integer getsNblank() {
        return sNblank;
    }

    public void setsNblank(Integer sNblank) {
        this.sNblank = sNblank;
    }

    public String getsMhref() {
        return sMhref;
    }

    public void setsMhref(String sMhref) {
        this.sMhref = sMhref;
    }

    public Integer getsMblank() {
        return sMblank;
    }

    public void setsMblank(Integer sMblank) {
        this.sMblank = sMblank;
    }

    public String getsFooter() {
        return sFooter;
    }

    public void setsFooter(String sFooter) {
        this.sFooter = sFooter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysSetEntity that = (SysSetEntity) o;

        if (id != that.id) return false;
        if (sMtitle != null ? !sMtitle.equals(that.sMtitle) : that.sMtitle != null) return false;
        if (sUtitle != null ? !sUtitle.equals(that.sUtitle) : that.sUtitle != null) return false;
        if (sNhref != null ? !sNhref.equals(that.sNhref) : that.sNhref != null) return false;
        if (sNblank != null ? !sNblank.equals(that.sNblank) : that.sNblank != null) return false;
        if (sMhref != null ? !sMhref.equals(that.sMhref) : that.sMhref != null) return false;
        if (sMblank != null ? !sMblank.equals(that.sMblank) : that.sMblank != null) return false;
        if (sFooter != null ? !sFooter.equals(that.sFooter) : that.sFooter != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sMtitle != null ? sMtitle.hashCode() : 0);
        result = 31 * result + (sUtitle != null ? sUtitle.hashCode() : 0);
        result = 31 * result + (sNhref != null ? sNhref.hashCode() : 0);
        result = 31 * result + (sNblank != null ? sNblank.hashCode() : 0);
        result = 31 * result + (sMhref != null ? sMhref.hashCode() : 0);
        result = 31 * result + (sMblank != null ? sMblank.hashCode() : 0);
        result = 31 * result + (sFooter != null ? sFooter.hashCode() : 0);
        return result;
    }
}
