package azarenka.web;

import azarenka.entity.Detail;
import azarenka.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "detail")
public class DetailController {

    @Autowired
    private DetailService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Detail> getAll(){
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Detail> getAllByModuleId(@PathVariable("id") Long id){
       return service.getByModuleId(id);
    }
}
