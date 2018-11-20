package resources;

import azarenka.entity.ColorDetail;
import azarenka.entity.Country;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DataColorMaterial {
    public static ColorDetail colorDetailOne = new ColorDetail(null, "Аляска", "Swisspan", Country.UKRAINE, new BigDecimal(8.3));
    public static ColorDetail colorDetailTwo = new ColorDetail(null, "Пепел", "Swisspan", Country.UKRAINE, new BigDecimal(6));
    public static ColorDetail colorDetailThree = new ColorDetail(null, "Крем", "Swisspan", Country.UKRAINE, new BigDecimal(6));
    public static ColorDetail colorDetailFour = new ColorDetail(null, "Орех", "Swisspan", Country.UKRAINE, new BigDecimal(8.5));
    public static ColorDetail colorDetailFive = new ColorDetail(null, "Кантри", "Swisspan", Country.UKRAINE, new BigDecimal(9.2));
    public static ColorDetail colorDetailSix = new ColorDetail(null, "Белый", "Swisspan", Country.UKRAINE, new BigDecimal(6));

    public static List<ColorDetail> colorDetails = Arrays.asList(colorDetailOne, colorDetailTwo,
            colorDetailThree, colorDetailFour, colorDetailFive, colorDetailSix);
}
