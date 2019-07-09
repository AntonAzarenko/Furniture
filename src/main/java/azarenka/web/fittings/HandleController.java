package azarenka.web.fittings;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import azarenka.dto.fittingdto.HandleAddDTO;
import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.Fittings;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.service.FittingsService;
import azarenka.service.HandleService;

/**
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/fittings/handle")
public class HandleController {

    @Autowired
    private HandleService service;

    @Autowired
    FittingsService fittingsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Handle save(@RequestBody HandleCreateDTO handleCreateDTO) {
        service.save(handleCreateDTO);
        return service.save(handleCreateDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HandleColors> getColors(@PathVariable("id") Long id) {
        return service.getHandleColorsByHandleId(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Fittings add(@RequestBody HandleAddDTO handleAddDTO) {
        Fittings fittings = handleAddDTO.asFitting();
        HandleOfOrder handleOfOrder = handleAddDTO.getHandleOfOrder();
        service.addHandleOfOrder(handleOfOrder);
        return fittingsService.addHandleToOrder(fittings);
    }
}
