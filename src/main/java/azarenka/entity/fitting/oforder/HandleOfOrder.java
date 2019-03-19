package azarenka.entity.fitting.oforder;

import azarenka.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "handles_order")
public class HandleOfOrder extends BaseEntity {

    @Column(name = "handle_id")
    private Long handleId;

    @Column(name = "handle_param_id")
    private Long handleParamId;


    @Column(name = "handle_color_id")
    private Long handleColorId;


    public HandleOfOrder() {
    }

    public Long getHandleId() {
        return handleId;
    }

    public void setHandleId(Long handleId) {
        this.handleId = handleId;
    }

    public Long getHandleParamId() {
        return handleParamId;
    }

    public void setHandleParamId(Long handleParamId) {
        this.handleParamId = handleParamId;
    }

    public Long getHandleColorId() {
        return handleColorId;
    }

    public void setHandleColorId(Long handleColorId) {
        this.handleColorId = handleColorId;
    }
}
