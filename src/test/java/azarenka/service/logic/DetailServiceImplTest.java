package azarenka.service.logic;

import azarenka.service.DetailService;
import azarenka.service.EdgeMaterialService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DetailServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(DetailServiceImplTest.class);

    @Autowired
    private DetailService service;

    @Autowired
    private EdgeMaterialService edgeMaterialService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getByModuleId() {
    }
}