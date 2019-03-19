package azarenka.web.fittings;

import azarenka.dto.fittingdto.LoopCreateDTO;
import azarenka.entity.fitting.Loops;
import azarenka.service.LoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static azarenka.web.DetailController.URL;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*")
@RequestMapping(value = URL  + "/fittings/loops")
public class LoopController {

    @Autowired
    private LoopService service;

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody LoopCreateDTO createDTO){
        Loops loops = this.service.save(createDTO.asLoops());
        createDTO.setLoops(loops);
        this.service.save(createDTO.asLoopsParam());

    }

}
