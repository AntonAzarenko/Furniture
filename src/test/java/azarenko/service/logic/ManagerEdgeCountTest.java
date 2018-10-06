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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerEdgeCountTest {

    private final static Logger log = LoggerFactory.getLogger(OrderRepositoryImplTest.class);

    @Autowired
    private ManagerEdgeCount managerEdgeCount;

    @Test
    public void getLengthEdgeMaterialForOrder() {
        double sum = managerEdgeCount.getLengthEdgeMaterialForOrder(DataOrder.ORDER_TEST2);
        log.info(String.valueOf(sum));
    }

    @Test
    public void getLengthEdgeMaterialForModule() {
        double sum = managerEdgeCount.getLengthEdgeMaterialForDetailList(DataOrder.ORDER_TEST2.getDetailList());
        log.info(String.valueOf(sum));
    }

    @Test
    public void getLengthEdgeMaterialForDetailList() {
    }

    @Test
    public void getLengthEdgeMaterialForDetail() {
    }
}