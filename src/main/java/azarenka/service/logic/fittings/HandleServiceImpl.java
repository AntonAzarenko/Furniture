package azarenka.service.logic.fittings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.exceptions.ResponseException;
import azarenka.repository.HandleColorsRepository;
import azarenka.repository.HandleOfOrderRepository;
import azarenka.repository.HandleParamsRepository;
import azarenka.repository.HandleRepository;
import azarenka.service.HandleService;

@Service
public class HandleServiceImpl implements HandleService {

    private final static Logger LOG = LoggerFactory.getLogger(HandleServiceImpl.class);

    @Autowired
    private HandleOfOrderRepository handleOfOrderRepository;
    @Autowired
    private HandleRepository repository;
    @Autowired
    private HandleParamsRepository paramsRepository;
    @Autowired
    private HandleColorsRepository handleColorsRepository;

    /**
     * Received  DTO object. Converting it to Handle{@link Handle}.
     * Saves handle and received from repository it with ID.
     * After that builds handle params ans saves it and handle color and saves it.
     *
     * @param handleCreateDTO
     * @return
     */
    @Override
    @Transactional
    public Handle save(HandleCreateDTO handleCreateDTO)  {
        Handle handle = handleCreateDTO.asHandle();
        LOG.debug("Starting save is handle... {}", handle.getArticle());
        repository.save(handle);
        handleCreateDTO.setHandle(handle);
        LOG.debug("Starting save is handle params of handle... {}", handle.getArticle());
        addHandleParams(handleCreateDTO.asHandleParams());
        LOG.debug("Starting save is handle colors of handle... {}", handle.getArticle());
        addHandleColors(handleCreateDTO.asHandleColors());
        LOG.debug("Handle has been saved... {}", handle.getArticle());
        return handle;
    }

    @Override
    public void deleteById(Long id) throws ResponseException {
        if (Objects.nonNull(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public Handle getById(Long id) {
        if (Objects.nonNull(id)) {
            return repository.getById(id);
        }
        throw new ResponseException("Handle can not be found without id");
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
        if (params.isEmpty()) {
            throw new ResponseException("Handle can not be save because  params is empty");
        }
        params.forEach(element -> paramsRepository.save(element));
    }

    @Override
    public List<HandleParams> getAllParamsById(Long id) {
        return paramsRepository.getByHandle_Id(id);
    }

    @Override
    public List<HandleColors> getHandleColorsByHandleId(Long id) {
        return Objects.nonNull(id)
                ? handleColorsRepository.getByHandle_Id(id)
                : Collections.emptyList();
    }

    @Override
    public void addHandleColors(List<HandleColors> colors) {
        if (colors.isEmpty()) {
            throw new ResponseException("Handle Colors is empty");
        }
        colors.forEach(element -> handleColorsRepository.save(element));
    }

    @Override
    public HandleParams getParamsById(Long id) {
        return paramsRepository.getById(id);
    }

    @Override
    public void addHandleOfOrder(HandleOfOrder handleOfOrder) {
        if (Objects.nonNull(handleOfOrder)) {
            handleOfOrderRepository.save(handleOfOrder);
        }
        throw new ResponseException("Handle can not be added to order because \"handleOrder\" is empty");
    }

    @Override
    public HandleOfOrder getHandleOfOrderByModuleId(Long moduleId) {
        if (Objects.nonNull(moduleId)) {
            return handleOfOrderRepository.getById(moduleId);
        }
        throw new ResponseException("HandleOfOrder can not be found without id");
    }

    @Override
    public HandleColors getHandleColorsById(Long id) {
        if (Objects.nonNull(id)) {
            return handleColorsRepository.getById(id);
        }
        throw new ResponseException("HandleColors can not be found without id");
    }
}