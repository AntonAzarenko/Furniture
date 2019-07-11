package azarenka.service;

import java.util.List;

import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.exceptions.NotUniqueElementException;
import azarenka.exceptions.ResponseException;

public interface HandleService {

    Handle save(HandleCreateDTO handle);

    void deleteById(Long id) throws ResponseException;

    Handle getById(Long id);

    List<Handle> getAll();

    List<Handle> getByOrderId(Long id);

    void addHandleParams(List<HandleParams> params);

    List<HandleParams> getAllParamsById(Long id);

    List<HandleColors> getHandleColorsByHandleId(Long id);

    void addHandleColors(List<HandleColors> colors);

    HandleParams getParamsById(Long id);

    void addHandleOfOrder(HandleOfOrder handleOfOrder);

    HandleOfOrder getHandleOfOrderByModuleId(Long moduleId);

    HandleColors getHandleColorsById(Long id);
}
