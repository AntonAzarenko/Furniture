package azarenka.entity.stillunused;

import azarenka.entity.BaseEntity;

import java.math.BigDecimal;

public class Fitting<T> extends BaseEntity {

    private T fitting;

    private int count;

    private BigDecimal price;

    public Fitting() {
    }

    public Fitting(Long id, T fitting, int count, BigDecimal price) {
        super(id);
        this.fitting = fitting;
        this.count = count;
        this.price = price;
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
}
