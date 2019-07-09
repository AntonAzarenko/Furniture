package azarenka.web.fittings;

import azarenka.dto.FittingsDTO;
import azarenka.service.FittingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/fittings")
public class FittingsController {

    @Autowired
    private FittingsService service;

    @GetMapping(value = "/module/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FittingsDTO> getAllFittingOfModule(@PathVariable("id") Long id) {
        //TODO
        return service.getAllFittingsOfModule(id);
    }


}
