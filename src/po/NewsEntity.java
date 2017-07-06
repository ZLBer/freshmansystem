package po;

/**
 * Created by john on 2017/5/15.
 */
public class NewsEntity {
    private int id;
    private String title;
    private String description;
    private String url;
    private String inputtime;
    private Integer readpoint;
    private String type;
    private String content;
    private String urlonly;
    private String selected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInputtime() {
        return inputtime;
    }

    public void setInputtime(String inputtime) {
        this.inputtime = inputtime;
    }

    public Integer getReadpoint() {
        return readpoint;
    }

    public void setReadpoint(Integer readpoint) {
        this.readpoint = readpoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlonly() {
        return urlonly;
    }

    public void setUrlonly(String urlonly) {
        this.urlonly = urlonly;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (inputtime != null ? !inputtime.equals(that.inputtime) : that.inputtime != null) return false;
        if (readpoint != null ? !readpoint.equals(that.readpoint) : that.readpoint != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (urlonly != null ? !urlonly.equals(that.urlonly) : that.urlonly != null) return false;
        if (selected != null ? !selected.equals(that.selected) : that.selected != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (readpoint != null ? readpoint.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (urlonly != null ? urlonly.hashCode() : 0);
        result = 31 * result + (selected != null ? selected.hashCode() : 0);
        return result;
    }
}
