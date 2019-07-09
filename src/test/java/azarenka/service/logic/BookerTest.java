package azarenka.service.logic;

import azarenka.entity.*;
import azarenka.service.logic.bookers.Booker;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookerTest {

    private final static Long MODULE_ID = 256895L;
    private final static String MODULE_NAME = "Cutting";
    private final static int LENGTH_TO_Y = 1000;
    private final static int LENGTH_TO_X = 564;
    private final static int COUNT_DETAIL = 5;
    private final static String NAME_MANUFACTURER = "swisspan";

    @Autowired
    private Booker booker;

    @Test
    public void testGetPriceModule() {
        BigDecimal expectedPrice = new BigDecimal("25");
        expectedPrice = expectedPrice.setScale(2, BigDecimal.ROUND_UP);
        BigDecimal price = new BigDecimal("21.02");

        expectedPrice = expectedPrice.add(price);
        expectedPrice = expectedPrice.setScale(2, BigDecimal.ROUND_UP);
        BigDecimal actualPrice = booker.getPriceModule(buildModule());
        actualPrice = actualPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetPriceDetailByType() {
        BigDecimal price = new BigDecimal("25.38");
        price = price.setScale(2, BigDecimal.ROUND_UP);

        BigDecimal actualPrice = booker.getPriceDetailByType(buildModule(), Material.DSP);
        actualPrice = actualPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(price, actualPrice);
    }

    @Test
    public void testGetPriceEdgeByModule() {
        BigDecimal expectedPrice = new BigDecimal("20.64");
        expectedPrice = expectedPrice.setScale(2, BigDecimal.ROUND_UP);

        BigDecimal actualPrice = booker.getPriceEdgeByModule(buildModule());
        actualPrice = actualPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetPriceOrder() {
        BigDecimal expectedPrice = new BigDecimal("46.02");
        expectedPrice = expectedPrice.setScale(2, BigDecimal.ROUND_UP);

        BigDecimal actualPrice = booker.getPriceOrder(buildOrder());
        actualPrice = actualPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(expectedPrice, actualPrice);
    }

    private Order buildOrder() {
        Order order = new Order();
        order.setModuleList(Arrays.asList(buildModule()));
        return order;
    }

    private Module buildModule() {
        Module module = new Module();
        module.setId(MODULE_ID);
        module.setModuleType(ModuleType.CUTTING);
        module.setName(MODULE_NAME);
        module.setDetailList(createDetailList());
        return module;
    }

    private List<Detail> createDetailList() {
        List<Detail> details = new ArrayList<>();
        details.add(buildDetail());
        return details;
    }

    private Detail buildDetail() {
        Detail detail = new Detail();
        detail.setY(LENGTH_TO_Y);
        detail.setX(LENGTH_TO_X);
        detail.setCount(COUNT_DETAIL);
        detail.setMaterial(Material.DSP);
        detail.setDetailsColor(buildDetailsColor());
        detail.setEdgeMaterial(buildSetEdgeMaterial());
        return detail;
    }

    private DetailsColor buildDetailsColor() {
        DetailsColor color = new DetailsColor();
        color.setCountryManufacturer(Country.BELARUS);
        color.setNameManufacturer(NAME_MANUFACTURER);
        color.setTitle(StringUtils.EMPTY);
        color.setPrice(new BigDecimal(9));
        return color;
    }

    private Set<EdgeMaterial> buildSetEdgeMaterial() {
        Set<EdgeMaterial> edgeMaterials = new HashSet<>();
        edgeMaterials.add(buildEdgeMaterial());

        return edgeMaterials;
    }

    private EdgeMaterial buildEdgeMaterial() {
        EdgeMaterial material = new EdgeMaterial();
        material.setEdgeSide(EdgeSide.SIDE_AROUND);
        material.setEdge(buildEdge());
        return material;
    }

    private Edge buildEdge() {
        Edge edge = new Edge();
        edge.setEdgeType(EdgeType.ABC);
        edge.setPrice(new BigDecimal(1.2));
        return edge;
    }
}