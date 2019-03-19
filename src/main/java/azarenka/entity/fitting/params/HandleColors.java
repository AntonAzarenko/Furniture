package azarenka.entity.fitting.params;

import azarenka.entity.BaseEntity;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.HandleColor;

import javax.persistence.*;

@Entity
@Table(name = "handle_colors")
public class HandleColors extends BaseEntity {

    @Column(name = "handle_article")
    private String article;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private HandleColor color;

    @ManyToOne
    @JoinColumn(name = "id_handle", nullable = false)
    private Handle handle;

    @Column(name = "other_color")
    private String otherColor;

    public HandleColors() {
    }

    public String getOtherColor() {
        return otherColor;
    }

    public void setOtherColor(String otherColor) {
        this.otherColor = otherColor;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public HandleColor getColor() {
        return color;
    }

    public void setColor(HandleColor color) {
        this.color = color;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }
}
