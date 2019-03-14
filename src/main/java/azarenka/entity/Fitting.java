package azarenka.entity;

import azarenka.entity.furnitures.Handle;

import java.math.BigDecimal;

public class Fitting extends BaseEntity {

    private Handle  handle;

    private int count;

    private BigDecimal price;

    private Module module;

    public Fitting() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
