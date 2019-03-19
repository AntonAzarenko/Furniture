package azarenka.entity.fitting;

import azarenka.entity.BaseEntity;
import azarenka.entity.Country;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.entity.fitting.params.HandleParams;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "handle")
public class Handle extends BaseEntity {

    @Column(name = "article")
    private String article;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<HandleParams> param;

    @OneToMany(fetch = FetchType.LAZY)
    private List<HandleColors> color;

    @Column(name="country")
    @Enumerated(EnumType.STRING)
    private Country country;

    public Handle(Long id, String article, String fileName) {
        super(id);
        this.article = article;
        this.fileName = fileName;
    }

    public Handle() {
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<HandleParams> getParam() {
        return param;
    }

    public void setParam(List<HandleParams> param) {
        this.param = param;
    }

    public List<HandleColors> getColor() {
        return color;
    }

    public void setColor(List<HandleColors> color) {
        this.color = color;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
