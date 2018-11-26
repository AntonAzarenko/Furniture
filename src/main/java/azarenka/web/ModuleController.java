package azarenka.web;

import azarenka.entity.Module;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "module")
public class ModuleController {

    @Autowired
    private ModuleService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Module> get() {
        return service.getAll();
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(Module module) {
        service.save(module);
    }

}
