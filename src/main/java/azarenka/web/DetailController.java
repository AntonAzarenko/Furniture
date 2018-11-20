package azarenka.web;

import azarenka.entity.Detail;
import azarenka.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "detail")
public class DetailController {

    @Autowired
    private DetailService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Detail> getAll(){
        return service.getAll();
    }
}
