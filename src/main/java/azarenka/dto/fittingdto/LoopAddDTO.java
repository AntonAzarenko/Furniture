package azarenka.dto.fittingdto;

import azarenka.entity.Fittings;
import azarenka.entity.Module;
import azarenka.entity.fitting.Loops;
import azarenka.service.LoopService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoopAddDTO {

    private Integer count;

    private BigDecimal price;

    private Long loopId;

    private Long moduleId;

    private LoopService service;

    public LoopAddDTO() {
    }

    public Fittings asFittings() {
        Fittings fittings = new Fittings();
        fittings.setModule(createModule());
        fittings.setCount(count);
        fittings.setLoops(createLoops());
        return fittings;
    }

    private Module createModule() {
        Module module = new Module();
        module.setId(moduleId);
        return module;
    }

    private Loops createLoops() {
        Loops loops = new Loops();
        loops.setId(loopId);
        return loops;
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

    public Long getLoopId() {
        return loopId;
    }

    public void setLoopId(Long loopId) {
        this.loopId = loopId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}

