package azarenka.web;

import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/catalog")
public class CatalogController {

    @Autowired
    private HandleService service;

    @GetMapping(value = "/handles",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Handle> getHandles(){
        List<Handle> list = service.getAll();
        return service.getAll();
    }

    @GetMapping(value = "/handles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HandleParams> getParam(@PathVariable("id") Long id){
        return service.getAllParamsById(id);
    }
}
