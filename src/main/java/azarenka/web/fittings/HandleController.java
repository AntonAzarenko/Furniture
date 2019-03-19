package azarenka.web.fittings;

import azarenka.dto.fittingdto.HandleAddDTO;
import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.Fittings;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.service.FittingsService;
import azarenka.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/fittings/handle")
public class HandleController {

    @Autowired
    private HandleService service;

    @Autowired
    FittingsService fittingsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HandleCreateDTO handleCreateDTO) {
        Handle handle = null;
        try {
            handle = service.save(handleCreateDTO.asHandle());
            handleCreateDTO.setHandle(handle);
            service.addHandleParams(handleCreateDTO.asHandleParams());
            service.addHandleColors(handleCreateDTO.asHandleColors());
        } catch (Exception e) {
            String error = e.getMessage();
            service.deleteById(handle.getId());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Ручка успешно добавлена");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HandleColors> getColors(@PathVariable("id") Long id) {
        return service.getHandleColorsByHandleId(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Fittings add(@RequestBody HandleAddDTO handleAddDTO) {
        Fittings fittings = handleAddDTO.asFitting();
        HandleOfOrder handleOfOrder = handleAddDTO.getHandleOfOrder();
        service.addHandleOfOrder(handleOfOrder);
        return fittingsService.addHandleToOrder(fittings);
    }
}
