package azarenka.service.logic.fittings;

import azarenka.dto.FittingsDTO;
import azarenka.entity.Fittings;
import azarenka.repository.FittingRepository;
import azarenka.service.FittingsService;
import azarenka.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FittingsServiceImpl implements FittingsService {

    @Autowired
    HandleService handleService;

    @Autowired
    private FittingsBindingServiceImpl bindingService;

    @Autowired
    private FittingRepository repository;

    @Override
    public Fittings addHandleToOrder(Fittings fittings) {
        fittings.setPrice(handleService.getParamsById(fittings.getHandle().getHandleParamId()).getPrice());
        return save(fittings);
    }

    @Override
    public Fittings save(Fittings fittings) {
        return repository.save(fittings);
    }

    @Override
    public List<FittingsDTO> getAllFittingsOfModule(Long moduleId) {
        List<Fittings> fittings = getFittingsOfModule(moduleId);
        return bindingService.get(fittings);
    }

    @Override
    public List<Fittings> getFittingsOfModule(Long moduleId) {
        return repository.getAllByModule_Id(moduleId);
    }
}
