package azarenka.functional.service;

import azarenka.entity.ColorMaterial;
import azarenka.exceptions.NotFoundException;
import azarenka.service.ColorMaterialService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import resources.DataColorMaterial;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColorMaterialServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(ColorMaterialServiceImplTest.class);

    @Autowired
    private ColorMaterialService service;

    @Before
    public void before() {
        service.save(DataColorMaterial.colorMaterialOne);
        service.save(DataColorMaterial.colorMaterialTwo);
        service.save(DataColorMaterial.colorMaterialThree);
        service.save(DataColorMaterial.colorMaterialFour);
    }

    @After
    public void after() {
        List<ColorMaterial> list = service.getAll();
        List<String> listId = new ArrayList<>();
        list.forEach(el -> listId.add(el.getId()));
        listId.forEach(st -> service.delete(st));
    }

    @Test
    public void getByID() {
        List<ColorMaterial> list = service.getAll();
        List<String> listId = new ArrayList<>();
        list.forEach(el -> listId.add(el.getId()));
        ColorMaterial colorMaterial = service.getByID(listId.get(0));
        assertThat(colorMaterial).isEqualTo(DataColorMaterial.colorMaterialOne);
    }

    @Test
    public void getAll() {
        List<ColorMaterial> list = service.getAll();
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void getByName() throws NotFoundException {
        ColorMaterial colorMaterial = service.getByName("Орех");
        assertThat(colorMaterial).isEqualTo(DataColorMaterial.colorMaterialFour);
    }

    @Test
    public void save() {
        service.save(DataColorMaterial.colorMaterialSix);
        List<ColorMaterial> list = service.getAll();
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    public void delete() throws NotFoundException {
        String id =service.getByName("Орех").getId();
        service.delete(id);
        List<ColorMaterial> list = service.getAll();
        assertThat(list.size()).isEqualTo(3);
    }
}
