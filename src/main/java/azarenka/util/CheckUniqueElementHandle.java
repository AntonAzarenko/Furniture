package azarenka.util;

import azarenka.entity.fitting.Handle;
import azarenka.exceptions.NotUniqueElementException;
import azarenka.repository.HandleRepository;

public class CheckUniqueElementHandle {

    public boolean check(Handle handle, HandleRepository repository) throws NotUniqueElementException {

        if (repository.getByArticle(handle.getArticle()) != null) {
            throw new NotUniqueElementException("Ручка с таким артиклем уже существует, воспользуйтесь поиском");
        } else {
            return true;
        }
    }
}
