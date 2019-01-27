package azarenka.service.logic;

import azarenka.dto.BookerDTO;
import azarenka.service.BookerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookerServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(BookerServiceImplTest.class);


    @Autowired
    private BookerService service;

    @Test
    public void getCalculationOfOrder() {

    }
}