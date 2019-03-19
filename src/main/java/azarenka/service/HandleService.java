package azarenka.service;

import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.exceptions.NotUniqueElementException;

import java.util.List;

public interface HandleService {

    Handle save(Handle handle) throws NotUniqueElementException;

    void deleteById(Long id);

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
