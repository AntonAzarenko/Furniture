package azarenko.repository;

import azarenko.entity.Detail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DetailRepository extends MongoRepository<Detail, String> {
     List<Detail> findByOrderBy(Long id);
}
