package azarenko.model;



import java.util.Objects;
import java.util.Set;

public class Detail extends BaseEntity {
    //заказ
    private long orderBy;
    //материал кромки
    private Set<EdgeMaterial> edgeMaterial;

    //имя
    private String name;

    //толщина
    private int thickness;

    //размер по Х
    private int x;

    //размр по У
    private int y;

    //по каким сторонам кромим
    private Set<ButtClose> buttCloses;

    //количество
    private int count;

    //Основа
    private Material material;

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

    public Detail(Long id, long orderBy, Set<EdgeMaterial> edgeMaterial, String name, int thickness, int x, int y,
                  Set<ButtClose> buttCloses, int count, Material material, Color color) {
        super(id);
        this.orderBy = orderBy;
        this.edgeMaterial = edgeMaterial;
        this.name = name;
        this.thickness = thickness;
        this.x = x;
        this.y = y;
        this.buttCloses = buttCloses;
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

    public Set<EdgeMaterial> getEdgeMaterial() {
        return edgeMaterial;
    }

    public void setEdgeMaterial(Set<EdgeMaterial> edgeMaterial) {
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

    public Set<ButtClose> getButtCloses() {
        return buttCloses;
    }

    public void setButtCloses(Set<ButtClose> buttCloses) {
        this.buttCloses = buttCloses;
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
                Objects.equals(buttCloses, detail.buttCloses) &&
                material == detail.material;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderBy, edgeMaterial, name, thickness, x, y, buttCloses, count, material);
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
                ", buttCloses=" + buttCloses +
                ", count=" + count +
                ", material=" + material +
                '}';
    }
}
