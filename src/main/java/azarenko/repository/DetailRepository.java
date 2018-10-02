package azarenko.repository;

import azarenko.entity.Detail;

public interface DetailRepository extends CrudRepository<String, Detail> {
    Detail getByName(String name);


}
