package azarenka.service.logic;

import azarenka.entity.Module;
import azarenka.service.ModuleService;
import org.junit.After;
import org.junit.Before;
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
public class ModuleServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(ModuleServiceImplTest.class);

    @Autowired
    private ModuleService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void getByName() {
    }

    @Test
    public void getAll() {
        List<Module> list =  service.getAll();
        list.forEach(m -> log.info(m.toString()));
    }
}