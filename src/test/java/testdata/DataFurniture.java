package testdata;

import azarenko.entity.Angle;
import azarenko.entity.Country;
import azarenko.entity.Furniture;
import azarenko.entity.furnitures.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataFurniture {
    public static Loops loops = new Loops(25456,
            "BLUM", Country.AUSTRIA, new Angle(null, "Stanadart 90", 90D), TypeLoop.OVERHEAD, false);

    public static Other other = new Other("Полкодержатели");

    public static Handle handle = new Handle(25648, HandleColor.CHROME_BRIGHT, 128);

    public static List<Furniture> getList() {
        List<Furniture> furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture(null, loops, 4, new BigDecimal(1.25)));
        furnitureList.add(new Furniture(null, other, 12, new BigDecimal(0.21)));
        furnitureList.add(new Furniture(null, handle, 2, new BigDecimal(1.5)));
        return furnitureList;
    }
}
