package azarenka.web;

import azarenka.dto.ModuleDTO;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Module> getById(@PathVariable("id")Long id){
        return service.getAllByOrderId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Module save(@RequestBody ModuleDTO module) {
       return service.save(module.asModule());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
