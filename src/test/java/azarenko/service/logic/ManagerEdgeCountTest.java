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

import java.util.HashMap;
import java.util.Map;

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
        Map<EdgeType, Double> map = managerEdgeCount.getLengthEdgeMaterialForOrder(DataOrder.ORDER_TEST2);
        for (Map.Entry<EdgeType, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getLengthEdgeMaterialForModule() {
        Map<EdgeType, Double> map = managerEdgeCount.getLengthEdgeMaterialForModule(DataModule.getModule().get(0));
        for (Map.Entry<EdgeType, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getLengthEdgeMaterialForDetailList() {
        Map<EdgeType, Double> map = managerEdgeCount.getLengthEdgeMaterialForDetailList(DetailsData.detailList);
        for (Map.Entry<EdgeType, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getLengthEdgeMaterialForDetail() {
        Map<EdgeType, Double> map = managerEdgeCount.getLengthEdgeMaterialForDetail(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialCounterTop, " table top", 18,
                410, 1000, 1, Material.DSP, colorMaterial));
        for (Map.Entry<EdgeType, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + "-" + String.valueOf(pair.getValue()));
        }
    }
}