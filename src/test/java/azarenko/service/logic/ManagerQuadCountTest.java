package azarenko.service.logic;

import azarenko.repository.logic.OrderRepositoryImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testdata.DataOrder;
import testdata.DetailsData;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerQuadCountTest {

    private final static Logger log = LoggerFactory.getLogger(ManagerQuadCountTest.class);

    @Autowired
    private ManagerQuadCount managerQuadCount;

    @Test
    public void getCountSquareDetail() {
        double q = managerQuadCount.getCountSquareDetail(458, 598, 2);
        log.info(String.valueOf(q));
    }

    @Test
    public void getCountSquareDetailsList() {
        Map<BigDecimal, Double> map = managerQuadCount.getCountSquareDetailsList(DetailsData.detailList);
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }
    }

    @Test
    public void getCountSquareDetailsForModule() {
        Map<BigDecimal, Double> map = managerQuadCount.getCountSquareDetailsForModuleList(DataOrder.ORDER_TEST2.getModuleList());
        log.info(String.valueOf(map));
    }

    @Test
    public void getCountSquareForOrder() {
        Map<BigDecimal, Double> map = managerQuadCount.getCountSquareForOrder(DataOrder.ORDER_TEST2);
        log.info(String.valueOf(map));
    }
}