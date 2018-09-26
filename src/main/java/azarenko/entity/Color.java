package azarenko.entity;

import java.util.Objects;

public class Color extends BaseEntity {
    private String title;

    private String nameManufacture;

    private Country countryManufacture;

    public Color() {
    }

    public Color(Long id, String title, String nameManufacture, Country countryManufacture) {
        super(id);
        this.title = title;
        this.nameManufacture = nameManufacture;
        this.countryManufacture = countryManufacture;
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                ", nameManufacture='" + nameManufacture + '\'' +
                ", countryManufacture=" + countryManufacture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(title, color.title) &&
                Objects.equals(nameManufacture, color.nameManufacture) &&
                countryManufacture == color.countryManufacture;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, nameManufacture, countryManufacture);
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public Country getCountryManufacture() {
        return countryManufacture;
    }

    public void setCountryManufacture(Country countryManufacture) {
        this.countryManufacture = countryManufacture;
    }
}
