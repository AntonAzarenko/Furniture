package resources;

import azarenka.entity.DetailsColor;
import azarenka.entity.Country;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DataColorMaterial {
    public static DetailsColor detailsColorOne = new DetailsColor(null, "Аляска", "Swisspan", Country.UKRAINE, new BigDecimal(8.3));
    public static DetailsColor detailsColorTwo = new DetailsColor(null, "Пепел", "Swisspan", Country.UKRAINE, new BigDecimal(6));
    public static DetailsColor detailsColorThree = new DetailsColor(null, "Крем", "Swisspan", Country.UKRAINE, new BigDecimal(6));
    public static DetailsColor detailsColorFour = new DetailsColor(null, "Орех", "Swisspan", Country.UKRAINE, new BigDecimal(8.5));
    public static DetailsColor detailsColorFive = new DetailsColor(null, "Кантри", "Swisspan", Country.UKRAINE, new BigDecimal(9.2));
    public static DetailsColor detailsColorSix = new DetailsColor(null, "Белый", "Swisspan", Country.UKRAINE, new BigDecimal(6));

    public static List<DetailsColor> detailsColors = Arrays.asList(detailsColorOne, detailsColorTwo,
            detailsColorThree, detailsColorFour, detailsColorFive, detailsColorSix);
}
