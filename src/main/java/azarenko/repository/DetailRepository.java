package azarenko.repository;

import azarenko.entity.Detail;

public interface DetailRepository extends CrudRepository<Long, Detail> {
    Detail getByName(String name);


}
