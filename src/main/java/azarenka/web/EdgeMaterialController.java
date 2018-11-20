package azarenka.web;

import azarenka.entity.EdgeMaterial;
import azarenka.service.EdgeMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "edge-material")
public class EdgeMaterialController {

    @Autowired
    private EdgeMaterialService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EdgeMaterial> getAll(){
        return service.getAll();
    }
}
