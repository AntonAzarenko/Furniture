package azarenka.web;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import azarenka.dto.ModuleDTO;
import azarenka.entity.Module;
import azarenka.service.ModuleService;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = URL + "/module")
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
