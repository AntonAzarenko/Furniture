package azarenko.service.logic;

import azarenko.entity.ButtClose;
import azarenko.entity.Detail;
import azarenko.entity.EdgeType;
import azarenko.entity.Material;
import azarenko.repository.logic.OrderRepositoryImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testdata.DataEdgeMaterial;
import testdata.DataModule;
import testdata.DataOrder;
import testdata.DetailsData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;
import static testdata.DetailsData.colorMaterial;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerEdgeCountTest {

    private final static Logger log = LoggerFactory.getLogger(OrderRepositoryImplTest.class);


    @Autowired
    private ManagerEdgeCount managerEdgeCount;

    @Test
    public void getLengthEdgeMaterialForOrder() {
        ConcurrentHashMap<BigDecimal, Double> map = managerEdgeCount.getLengthEdgeMaterialForOrder(DataOrder.ORDER_TEST2);
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getLengthEdgeMaterialForModule() {
        Map<BigDecimal, Double> map = managerEdgeCount.getLengthEdgeMaterialForModule(DataModule.getModule().get(0));
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getLengthEdgeMaterialForDetailList() {
        Map<BigDecimal, Double> map = managerEdgeCount.getLengthEdgeMaterialForDetailList(DetailsData.detailList);
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getLengthEdgeMaterialForDetail() {
        Map<BigDecimal, Double> map = managerEdgeCount.getLengthEdgeMaterialForDetail(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialCounterTop, " table top", 18,
                410, 1000, 1, Material.DSP, colorMaterial));
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " - " + String.valueOf(pair.getValue()));
        }
    }
}