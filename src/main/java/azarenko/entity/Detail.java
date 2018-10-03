package azarenko.entity;


import java.util.List;
import java.util.Objects;

public class Detail extends BaseEntity {
    //заказ
    private long orderBy;
    //материал кромки
    private List<EdgeMaterial> edgeMaterial;

    //имя
    private String name;

    //толщина
    private int thickness;

    //размер по Х
    private int x;

    //размр по У
    private int y;

    //количество
    private int count;

    //Основа
    private Material material;

    //цвет
    private Color color;

    //цвет
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Detail() {
    }

    public Detail(String id, long orderBy, List<EdgeMaterial> edgeMaterial, String name, int thickness, int x, int y,
                  int count, Material material, Color color) {
        super(id);
        this.orderBy = orderBy;
        this.edgeMaterial = edgeMaterial;
        this.name = name;
        this.thickness = thickness;
        this.x = x;
        this.y = y;

        this.count = count;
        this.material = material;
        this.color = color;
    }

    public long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(long orderBy) {
        this.orderBy = orderBy;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EdgeMaterial> getEdgeMaterial() {
        return edgeMaterial;
    }

    public void setEdgeMaterial(List<EdgeMaterial> edgeMaterial) {
        this.edgeMaterial = edgeMaterial;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return orderBy == detail.orderBy &&
                thickness == detail.thickness &&
                Double.compare(detail.x, x) == 0 &&
                Double.compare(detail.y, y) == 0 &&
                count == detail.count &&
                Objects.equals(edgeMaterial, detail.edgeMaterial) &&
                Objects.equals(name, detail.name) &&
                material == detail.material;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderBy, edgeMaterial, name, thickness, x, y, count, material);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "orderBy=" + orderBy +
                ", edgeMaterial=" + edgeMaterial +
                ", name='" + name + '\'' +
                ", thickness=" + thickness +
                ", x=" + x +
                ", y=" + y +
                ", count=" + count +
                ", material=" + material +
                '}';
    }
}
