package azarenka.service.logic;

import azarenka.entity.furnitures.Handle;
import azarenka.entity.furnitures.HandleColor;
import azarenka.entity.furnitures.params.HandleParams;
import azarenka.exceptions.NotUniqueElementException;
import azarenka.factories.AbstractFactory;
import azarenka.repository.HandleParamsRepository;
import azarenka.repository.HandleRepository;
import azarenka.service.HandleService;
import azarenka.util.CheckUniqueElementHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class HandleServiceImpl implements HandleService {

    @Autowired
    private AbstractFactory<CheckUniqueElementHandle> abstractFactory;

    @Autowired
    private HandleRepository repository;

    @Autowired
    private HandleParamsRepository paramsRepository;

    @Override
    public Handle save(Handle handle) throws NotUniqueElementException {
        CheckUniqueElementHandle checkUniqueElement = abstractFactory.create();
        checkUniqueElement.check(handle, repository);
        return repository.save(handle);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Handle getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Handle> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Handle> getByOrderId(Long id) {
        return null;
    }

    @Override
    public void addHandleParams(List<HandleParams> params) {
        for (HandleParams current : params) {
            save(current);
        }
    }

    @Override
    public List<HandleParams> getParamsById(Long id) {
        List<HandleParams> list = paramsRepository.getByHandle_Id(id);
        return paramsRepository.getByHandle_Id(id);
    }

    @Override
    public Set<HandleColor> getHandleColorsByHandleId(Long id) {
       List<HandleParams> hp = paramsRepository.getByHandle_Id(id);
       return hp.size() != 0 ? hp.get(0).getColor() : null;
    }

    private void save(HandleParams handleParams) {
        paramsRepository.save(handleParams);
    }
}
