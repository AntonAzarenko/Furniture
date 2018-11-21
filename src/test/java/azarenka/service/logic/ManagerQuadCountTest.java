package azarenka.service.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.DataOrder;
import resources.DetailsData;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ManagerQuadCountTest {

    private final static Logger log = LoggerFactory.getLogger(ManagerQuadCountTest.class);

    @InjectMocks
    private ManagerQuadCount managerQuadCount;

    @Test
    public void getCountSquareDetail() {
      /*  double q = managerQuadCount.getCountSquareDetail(458, 598, 2);
        assertThat(0.547768).isEqualTo(q);*/
    }

    @Test
    public void getCountSquareDetailsList() {
        /*Map<BigDecimal, Double> map = managerQuadCount.getCountSquareDetailsList(DetailsData.detailList);
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(String.valueOf(pair.getKey()) + " " + String.valueOf(pair.getValue()));
        }*/
    }

    @Test
    public void getCountSquareDetailsForModule() {
       /* Map<BigDecimal, Double> map = managerQuadCount.getCountSquareDetailsForModuleList(DataOrder.ORDER_TEST2.getModuleList());
        log.info(String.valueOf(map));*/
    }

    @Test
    public void getCountSquareForOrder() {
       /* Map<BigDecimal, Double> map = managerQuadCount.getCountSquareForOrder(DataOrder.ORDER_TEST2);
        log.info(String.valueOf(map));*/
    }
}
