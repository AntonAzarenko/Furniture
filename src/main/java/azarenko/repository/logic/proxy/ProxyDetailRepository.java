package azarenko.repository.logic.proxy;

import azarenko.entity.Detail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProxyDetailRepository extends MongoRepository<Detail, String> {

    Detail findByName(String name);

    Detail findById(Long id);

    void deleteById(Long id);


}
