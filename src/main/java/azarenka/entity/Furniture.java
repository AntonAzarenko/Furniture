package azarenka.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Furniture<T> extends BaseEntity {

    private T furnitures;

    private int count;

    private BigDecimal price;

    public Furniture() {
    }

    public Furniture(String id, T furnitures, int count, BigDecimal price) {
        super(id);
        this.furnitures = furnitures;
        this.count = count;
        this.price = price;
    }

    public T getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(T furnitures) {
        this.furnitures = furnitures;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Furniture<?> furniture = (Furniture<?>) o;
        return count == furniture.count &&
                Objects.equals(furnitures, furniture.furnitures) &&
                Objects.equals(price, furniture.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(furnitures, count, price);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitures=" + furnitures +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
