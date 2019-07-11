package azarenka.service.logic.fittings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.factories.AbstractFactory;
import azarenka.repository.HandleColorsRepository;
import azarenka.repository.HandleOfOrderRepository;
import azarenka.repository.HandleParamsRepository;
import azarenka.repository.HandleRepository;
import azarenka.service.HandleService;
import azarenka.util.CheckUniqueElementHandle;

@Service
public class HandleServiceImpl implements HandleService {

    @Autowired
    private HandleOfOrderRepository handleOfOrderRepository;

    @Autowired
    private AbstractFactory<CheckUniqueElementHandle> abstractFactory;

    @Autowired
    private HandleRepository repository;

    @Autowired
    private HandleParamsRepository paramsRepository;

    @Autowired
    private HandleColorsRepository handleColorsRepository;

    @Override
    @Transactional
    public Handle save(HandleCreateDTO handleCreateDTO)  {
        Handle handle = handleCreateDTO.asHandle();
        repository.save(handle);
        handleCreateDTO.setHandle(handle);
        addHandleParams(handleCreateDTO.asHandleParams());
        addHandleColors(handleCreateDTO.asHandleColors());
        return handle;
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
        params.forEach(this::save);
    }

    @Override
    public List<HandleParams> getAllParamsById(Long id) {
        List<HandleParams> list = paramsRepository.getByHandle_Id(id);
        return paramsRepository.getByHandle_Id(id);
    }

    @Override
    public List<HandleColors> getHandleColorsByHandleId(Long id) {
        return handleColorsRepository.getByHandle_Id(id);
    }

    @Override
    public void addHandleColors(List<HandleColors> colors) {
        for (HandleColors current : colors) {
            save(current);
        }
    }

    @Override
    public HandleParams getParamsById(Long id) {
        return paramsRepository.getById(id);
    }

    @Override
    public void addHandleOfOrder(HandleOfOrder handleOfOrder) {
        save(handleOfOrder);
    }

    @Override
    public HandleOfOrder getHandleOfOrderByModuleId(Long moduleId) {
        return handleOfOrderRepository.getById(moduleId);
    }

    @Override
    public HandleColors getHandleColorsById(Long id) {
        return handleColorsRepository.getById(id);
    }

<<<<<<< HEAD
    private Handle save(Handle handle) throws NotUniqueElementException {
        CheckUniqueElementHandle checkUniqueElement = abstractFactory.create();
        checkUniqueElement.check(handle);
        return repository.save(handle);
    }

=======
>>>>>>> ef61efed94f8892a669cd929ce03de98d4bdeca9
    private void save(HandleOfOrder handleOfOrder) {
        handleOfOrderRepository.save(handleOfOrder);
    }

    private void save(HandleColors color) {
        handleColorsRepository.save(color);
    }

    private void save(HandleParams handleParams) {
        paramsRepository.save(handleParams);
    }

    public void setRepository(HandleRepository repository) {
        this.repository = repository;
    }
}
