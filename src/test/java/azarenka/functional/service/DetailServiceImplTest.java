package azarenka.functional.service;

import azarenka.entity.ColorDetail;
import azarenka.entity.Detail;
import azarenka.entity.EdgeMaterial;
import azarenka.entity.Material;
import azarenka.service.ColorDetailService;
import azarenka.service.DetailService;
import azarenka.service.EdgeMaterialService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DetailServiceImplTest {

    @Autowired
    private EdgeMaterialService edgeMaterialService;

    @Autowired
    private ColorDetailService colorDetailService;

    @Autowired
    private DetailService service;


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
        Material material = Material.DSP;
        EdgeMaterial edgeMaterial = edgeMaterialService.getById(1L);
        Set<EdgeMaterial> materialSet = new HashSet<>();
        ColorDetail colorDetail = colorDetailService.getByID(1L);
        materialSet.add(edgeMaterial);
        Detail detail = new Detail();
        detail.setName("Столешница");
        detail.setCount(1);
        detail.setThickness(18);
        detail.setMaterial(Material.DSP);
        detail.setEdgeMaterial(materialSet);
        detail.setX(600);
        detail.setY(1000);
        detail.setColorDetail(colorDetail);
        service.save(detail);
    }

    @Test
    public void delete() {
    }
}