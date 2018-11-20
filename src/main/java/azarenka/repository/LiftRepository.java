package azarenka.repository;

import azarenka.entity.furnitures.Lifts;
import azarenka.repository.mybatis.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiftRepository extends CrudRepository<String, Lifts> {
}
