package azarenka.entity.furnitures;

import azarenka.entity.BaseEntity;
import azarenka.entity.furnitures.params.HandleParams;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "handle_catalog")
public class Handle extends BaseEntity {

    @Column(name = "article")
    private String article;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<HandleParams> params;

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

    public List<HandleParams> getParams() {
        return params;
    }

    public void setParams(List<HandleParams> params) {
        this.params = params;
    }

}
