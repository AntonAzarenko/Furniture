package azarenka.service;

import azarenka.entity.furnitures.Handle;
import azarenka.entity.furnitures.HandleColor;
import azarenka.entity.furnitures.params.HandleParams;
import azarenka.exceptions.NotUniqueElementException;

import java.util.List;
import java.util.Set;

public interface HandleService {

    Handle save(Handle handle) throws NotUniqueElementException;

    void deleteById(Long id);

    Handle getById(Long id);

    List<Handle> getAll();

    List<Handle> getByOrderId(Long id);

    void addHandleParams(List<HandleParams> params);

    List<HandleParams> getParamsById(Long id);

    Set<HandleColor> getHandleColorsByHandleId(Long id);
}
