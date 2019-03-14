package azarenka.entity.furnitures.params;

import azarenka.entity.BaseEntity;
import azarenka.entity.Fitting;

public class FittingOrderParams<T> extends BaseEntity  {

    private T param;

    private Fitting fitting;

    public FittingOrderParams() {

    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public Fitting getFitting() {
        return fitting;
    }

    public void setFitting(Fitting fitting) {
        this.fitting = fitting;
    }
}
