package azarenko.repository.logic;

import azarenko.entity.Detail;
import azarenko.repository.DetailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testdata.DataOrder;
import testdata.DetailsData;

import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class DetailRepositoryImplTest {
    private final static Logger log = LoggerFactory.getLogger(DetailRepositoryImplTest.class);

    @Autowired
    private DetailRepository repository;

    @Test
    public void getByName() {
        Detail detail = repository.getByName("facade");
    }

    @Test(expected = NullPointerException.class)
    public void getByNameExep() {
        Detail detail = repository.getByName("sidewalls");
        log.info(detail.toString());
    }

    @Test
    public void save() {
        Detail detail = DetailsData.detail;
        repository.save(detail);
    }

    @Test
    public void read() {
    }

    @Test
    public void readAll() {
    }

    @Test
    public void update() {
        Detail detail = DetailsData.detailList.get(2);
        repository.update(detail);
    }

    @Test
    public void delete() {
    }
}