package azarenka.service.logic;

import azarenka.entity.Detail;
import azarenka.service.DetailService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerQuadCountTest {

    private final static Logger log = LoggerFactory.getLogger(ManagerQuadCountTest.class);

    @Autowired
    private DetailService service;

    @Autowired
    private ManagerQuadCount managerQuadCount;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetCountSquareDetail() {
    }

    @Test
    public void testGetCountSquareDetailsList() {
        List<Detail> details = service.getByModuleId(1L);
        for (Detail d : details) {
            log.info(d.getX()+ " " + d.getY()+" " + d.getCount() + " = " + String.valueOf(managerQuadCount.getCountSquareDetail(d.getX(), d.getY(), d.getCount())));
        }
        Map<BigDecimal, Double> map = managerQuadCount.getCountSquareDetailsList(details);
        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            log.info(pair.toString());
        }

    }

    @Test
    public void testGetCountSquareDetailsForModule() {
    }

    @Test
    public void testGetCountSquareForOrder() {
    }

    @Test
    public void testGetCountSquareDetailsForModuleList() {
    }
}