package azarenko.service.logic;

import azarenko.repository.logic.OrderRepositoryImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testdata.DataModule;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookerTest {

    private final static Logger log = LoggerFactory.getLogger(OrderRepositoryImplTest.class);


    @Autowired
    private Booker booker;

    @Test
    public void getPriceModule() {
        log.info(String.valueOf(booker.getPriceModule(DataModule.getModule().get(0))));
    }

    @Test
    public void getPriceOrder() {
    }
}