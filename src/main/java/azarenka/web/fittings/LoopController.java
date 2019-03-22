package azarenka.web.fittings;

import azarenka.dto.fittingdto.LoopAddDTO;
import azarenka.dto.fittingdto.LoopCreateDTO;
import azarenka.entity.Fittings;
import azarenka.entity.fitting.Loops;
import azarenka.service.FittingsService;
import azarenka.service.LoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static azarenka.web.DetailController.URL;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*")
@RequestMapping(value = URL + "/fittings/loops")
public class LoopController {

    @Autowired
    private LoopService service;

    @Autowired
    FittingsService fittingsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody LoopCreateDTO createDTO) {
        Loops loops = this.service.save(createDTO.asLoops());
        createDTO.setLoops(loops);
        this.service.save(createDTO.asLoopsParam());
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Fittings add(@RequestBody LoopAddDTO dto) {
        Fittings fittings = dto.asFittings();
        LoopsOfOrder loopsOfOrder = dto.getOrder();
        service.save(loopsOfOrder);
        return fittingsService.save(fittings);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Loops> getAll(){
        return service.getAll();
    }

}
