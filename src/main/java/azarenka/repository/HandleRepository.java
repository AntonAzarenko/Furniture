package azarenka.repository;

import azarenka.entity.furnitures.Handle;
import azarenka.repository.mybatis.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleRepository extends CrudRepository<String, Handle> {
}
