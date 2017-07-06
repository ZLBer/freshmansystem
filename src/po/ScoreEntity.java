package po;

/**
 * Created by john on 2017/6/13.
 */
public class ScoreEntity {
    private String sno;
    private Integer score;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreEntity that = (ScoreEntity) o;

        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sno != null ? sno.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
