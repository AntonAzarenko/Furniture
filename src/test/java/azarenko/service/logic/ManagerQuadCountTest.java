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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerQuadCountTest {

    private final static Logger log = LoggerFactory.getLogger(OrderRepositoryImplTest.class);

    @Autowired
    private ManagerQuadCount managerQuadCount;

    @Test
    public void getCountSquareDetail() {
        double q = managerQuadCount.getCountSquareDetail(458, 598);
        log.info(String.valueOf(q));
    }

    @Test
    public void getCountSquareDetailsList() {
        double q = managerQuadCount.getCountSquareDetailsList(DetailsData.detailList);
        log.info(String.valueOf(q));
    }

    @Test
    public void getCountSquareDetailsForModule() {
        double q = managerQuadCount.getCountSquareDetailsForModuleList(DataOrder.ORDER_TEST2.getModuleList());
        log.info(String.valueOf(q));
    }

    @Test
    public void getCountSquareForOrder() {
        double q = managerQuadCount.getCountSquareForOrder(DataOrder.ORDER_TEST2);
        log.info(String.valueOf(q));
    }
}