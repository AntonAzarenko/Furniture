package azarenka.util;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.fitting.Handle;
import azarenka.exceptions.NotUniqueElementException;
import azarenka.repository.HandleRepository;

@Component("checkUniqueElementHandle")
public class CheckUniqueElementHandle {

    @Resource
    private HandleRepository repository;

    public boolean check(HandleCreateDTO handleCreateDTO) throws NotUniqueElementException {
        Handle handle = handleCreateDTO.asHandle();
        if (repository.getByArticle(handle.getArticle()) != null) {
            throw new NotUniqueElementException("Ручка с таким артиклем уже существует, воспользуйтесь поиском");
        } else {
            return true;
        }
    }
}
