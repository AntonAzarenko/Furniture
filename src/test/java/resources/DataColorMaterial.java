package resources;

import azarenka.entity.ColorMaterial;
import azarenka.entity.Country;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DataColorMaterial {
    public static ColorMaterial colorMaterialOne = new ColorMaterial(null, "Аляска", "Swisspan", Country.UKRAINE, new BigDecimal(8.3));
    public static ColorMaterial colorMaterialTwo = new ColorMaterial(null, "Пепел", "Swisspan", Country.UKRAINE, new BigDecimal(6));
    public static ColorMaterial colorMaterialThree = new ColorMaterial(null, "Крем", "Swisspan", Country.UKRAINE, new BigDecimal(6));
    public static ColorMaterial colorMaterialFour = new ColorMaterial(null, "Орех", "Swisspan", Country.UKRAINE, new BigDecimal(8.5));
    public static ColorMaterial colorMaterialFive = new ColorMaterial(null, "Кантри", "Swisspan", Country.UKRAINE, new BigDecimal(9.2));
    public static ColorMaterial colorMaterialSix = new ColorMaterial(null, "Белый", "Swisspan", Country.UKRAINE, new BigDecimal(6));

    public static List<ColorMaterial> colorMaterials = Arrays.asList(colorMaterialOne, colorMaterialTwo,
            colorMaterialThree, colorMaterialFour, colorMaterialFive, colorMaterialSix);
}
