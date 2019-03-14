package azarenka.dto.fittingdto;

import azarenka.entity.BaseEntity;
import azarenka.entity.Fitting;
import azarenka.entity.Module;
import azarenka.entity.furnitures.Handle;

import java.math.BigDecimal;

public class FittingDTO {
    //params of handle
    private Integer count;

    private BigDecimal price;

    private Long handleId;

    private String type;

    private String article;

    private Integer centerDistance;

    private String color;

    private Long moduleId;

    public Fitting asFitting(){
        Fitting fitting = new Fitting();
        fitting.setModule(createModule());
        fitting.setCount(count);
        createTypeOfFitting(fitting);
        return  fitting;
    }

    private void createTypeOfFitting(Fitting fitting){
        switch(type){
            case "Handle":
                Handle handle = new Handle();
                handle.setId(handleId);
                fitting.setHandle(handle);
                break;
        }
    }

    private Module createModule(){
        Module module = new Module();
        module.setId(moduleId);
        return module;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getHandleId() {
        return handleId;
    }

    public void setHandleId(Long handleId) {
        this.handleId = handleId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Integer getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(Integer centerDistance) {
        this.centerDistance = centerDistance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
