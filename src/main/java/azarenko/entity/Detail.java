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
    private ColorMaterial colorMaterial;

    //цвет
    public ColorMaterial getColorMaterial() {
        return colorMaterial;
    }

    public void setColorMaterial(ColorMaterial colorMaterial) {
        this.colorMaterial = colorMaterial;
    }

    public Detail() {
    }

    public Detail(String id, long orderBy, List<EdgeMaterial> edgeMaterial, String name, int thickness, int x, int y,
                  int count, Material material, ColorMaterial colorMaterial) {
        super(id);
        this.orderBy = orderBy;
        this.edgeMaterial = edgeMaterial;
        this.name = name;
        this.thickness = thickness;
        this.x = x;
        this.y = y;

        this.count = count;
        this.material = material;
        this.colorMaterial = colorMaterial;
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
