package azarenka.dto.fittingdto;

import azarenka.entity.Fittings;
import azarenka.entity.Module;
import azarenka.entity.fitting.oforder.HandleOfOrder;

import java.math.BigDecimal;

public class HandleAddDTO {

    private Integer count;

    private BigDecimal price;

    private Long handleId;

    private Long handleParamsId;

    private Long handleColorsId;

    private HandleOfOrder handleOfOrder;

    private String type;

    private Long moduleId;

    public Fittings asFitting() {
        Fittings fittings = new Fittings();
        fittings.setModule(createModule());
        fittings.setCount(count);
        createTypeOfFitting(fittings);
        return fittings;
    }

    private void createTypeOfFitting(Fittings fittings) {
        HandleOfOrder handle = new HandleOfOrder();
        handle.setHandleId(handleId);
        handle.setHandleColorId(handleColorsId);
        handle.setHandleParamId(handleParamsId);
        fittings.setHandle(handle);
        this.handleOfOrder = handle;
    }

    private Module createModule() {
        Module module = new Module();
        module.setId(moduleId);
        return module;
    }

    public HandleOfOrder getHandleOfOrder() {
        return handleOfOrder;
    }

    public void setHandleOfOrder(HandleOfOrder handleOfOrder) {
        this.handleOfOrder = handleOfOrder;
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

    public Long getHandleParamsId() {
        return handleParamsId;
    }

    public void setHandleParamsId(Long handleParamsId) {
        this.handleParamsId = handleParamsId;
    }

    public Long getHandleColorsId() {
        return handleColorsId;
    }

    public void setHandleColorsId(Long handleColorsId) {
        this.handleColorsId = handleColorsId;
    }
}
