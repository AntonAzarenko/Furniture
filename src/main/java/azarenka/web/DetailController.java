package azarenka.web;

import azarenka.dto.DetailDto;
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

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Detail save(@RequestBody DetailDto detailDto){

        return service.save(detailDto.asDetail());
    }

    @CrossOrigin
    @DeleteMapping(value = "/del/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAll(@RequestBody List<Detail> list){
        List<Detail> list1 = list;

        service.delete(list);
    }
}
