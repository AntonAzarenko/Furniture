package azarenka.service.logic;

import azarenka.entity.Detail;
import azarenka.entity.Material;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import resources.DataEdgeMaterial;
import resources.DataModule;
import resources.DataOrder;
import resources.DetailsData;

import java.math.BigDecimal;
import java.util.Map;

import static resources.DetailsData.colorDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerEdgeCountTest {

    private final static Logger log = LoggerFactory.getLogger(ManagerEdgeCountTest.class);

    @Autowired
    private ManagerEdgeCount managerEdgeCount;

    @Test
    public void getLengthEdgeMaterialForOrder() {
        Map<BigDecimal, Double> map = managerEdgeCount.getLengthEdgeMaterialForOrder(DataOrder.ORDER_TEST2);
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
                410, 1000, 1, Material.DSP, colorDetail));
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " - " + String.valueOf(pair.getValue()));
        }
    }
}
