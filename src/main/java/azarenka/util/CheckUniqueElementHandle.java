package azarenka.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import azarenka.entity.fitting.Handle;
import azarenka.exceptions.NotUniqueElementException;
import azarenka.repository.HandleRepository;

@Component("checkUniqueElemnt")
public class CheckUniqueElementHandle {

    @Autowired
    private HandleRepository repository;

    public boolean check(Handle handle) throws NotUniqueElementException {
        if (repository.getByArticle(handle.getArticle()) != null) {
            throw new NotUniqueElementException("Ручка с таким артиклем уже существует, воспользуйтесь поиском");
        } else {
            return true;
        }
    }
}
