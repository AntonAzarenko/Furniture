package azarenka.functional.service;


import azarenka.service.ColorDetailService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColorDetailServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(ColorDetailServiceImplTest.class);

    @Autowired
    private ColorDetailService service;

    @Before
    public void before() {
       /* service.save(DataColorMaterial.colorDetailOne);
        service.save(DataColorMaterial.colorDetailTwo);
        service.save(DataColorMaterial.colorDetailThree);
        service.save(DataColorMaterial.colorDetailFour);*/
    }

    @After
    public void after() {
      /*  List<ColorDetail> list = service.getAll();
        List<Long> listId = new ArrayList<>();
        list.forEach(el -> listId.add(el.getId()));
        listId.forEach(st -> service.delete(st));*/
    }

    @Test
    public void getByID() {
       /* List<ColorDetail> list = service.getAll();
        List<Long> listId = new ArrayList<>();
        list.forEach(el -> listId.add(el.getId()));
        ColorDetail colorDetail = service.getByID(listId.get(0));
        assertThat(colorDetail).isEqualTo(DataColorMaterial.colorDetailOne);*/
    }
    @Test()
    public void getByIDisNull() {
       /* ColorDetail colorDetail = service.getByID(null);
        assertThat(colorDetail).isEqualTo(null);*/
    }

    @Test
    public void getByIDisEmpty() {
        /*ColorDetail colorDetail = service.getByID(null);
        assertThat(colorDetail).isEqualTo(null);*/
    }

    @Test
    public void getAll() {
       /* List<ColorDetail> list = service.getAll();
        assertThat(list.size()).isEqualTo(4);*/
    }

    @Test
    public void save() {
       /* service.save(DataColorMaterial.colorDetailSix);
        List<ColorDetail> list = service.getAll();
        assertThat(list.size()).isEqualTo(5);*/
    }
}
