package po;

/**
 * Created by john on 2017/6/13.
 */
public class ProblemEntity {
    private int problemid;
    private String problemtext;
    private String answer;
    private Integer price;
    private String a;
    private String b;
    private String c;
    private String d;

    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    public String getProblemtext() {
        return problemtext;
    }

    public void setProblemtext(String problemtext) {
        this.problemtext = problemtext;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemEntity that = (ProblemEntity) o;

        if (problemid != that.problemid) return false;
        if (problemtext != null ? !problemtext.equals(that.problemtext) : that.problemtext != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (b != null ? !b.equals(that.b) : that.b != null) return false;
        if (c != null ? !c.equals(that.c) : that.c != null) return false;
        if (d != null ? !d.equals(that.d) : that.d != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problemid;
        result = 31 * result + (problemtext != null ? problemtext.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        return result;
    }
}
