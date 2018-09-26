package testdata;

import azarenko.entity.Angle;
import azarenko.entity.Country;
import azarenko.entity.Furniture;
import azarenko.entity.furnitures.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataFurniture {
    public static Loops loops = new Loops(
            "BLUM", Country.AUSTRIA, new Angle(1L, "Stanadart 90", 90D), TypeLoop.OVERHEAD);

    public static Other other = new Other("Полкодержатели");

    public static Handle handle = new Handle("h2345", HandleColor.CHROME_BRIGHT, 128);

    public static List<Furniture> getList() {
        List<Furniture> furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture(1L, loops, 4, new BigDecimal(1.25)));
        furnitureList.add(new Furniture(2L, other, 12, new BigDecimal(0.21)));
        furnitureList.add(new Furniture(3L, handle, 2, new BigDecimal(1.5)));
        return furnitureList;
    }
}
