package azarenka.service.logic.fittings;

import azarenka.entity.fitting.Loops;
import azarenka.repository.LoopParamsRepository;
import azarenka.repository.LoopRepository;
import azarenka.service.LoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoopServiceImpl implements LoopService {

    @Autowired
    private LoopRepository repository;

    @Autowired
    private LoopParamsRepository paramsRepository;

    @Override
    public List<Loops> getAllByModule(Long id) {
        return null;
    }

    @Override
    public List<Loops> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Loops> getAllByManufacturerName(String name) {
        return null;
    }

    @Override
    public Loops save(Loops loop) {
       return repository.save(loop);
    }

    @Override
    public void save(LoopParams params) {
        paramsRepository.save(params);
    }

    @Override
    public LoopParams getParamsById(Long id) {
        return paramsRepository.getById(id);
    }

    @Override
    public void save(LoopsOfOrder loopsOfOrder) {

    }
}
