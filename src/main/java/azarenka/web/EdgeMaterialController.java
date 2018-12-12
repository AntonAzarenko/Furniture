package azarenka.web;

import azarenka.entity.EdgeMaterial;
import azarenka.service.EdgeMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "edge")
public class EdgeMaterialController {

    @Autowired
    private EdgeMaterialService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EdgeMaterial> getAll(){
        return service.getAll();
    }
}
