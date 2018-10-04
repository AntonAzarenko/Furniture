package azarenko.repository;

import azarenko.entity.Angle;
import azarenko.entity.Country;
import azarenko.entity.furnitures.Loops;
import azarenko.entity.furnitures.TypeLoop;

import java.util.List;

public interface LoopRepository extends CrudRepository<String, Loops> {
    List<Loops> getByNameManufature(String name);

    List<Loops> getByManufatureCountry(Country country);

    List<Loops> getByAngle(String angle);

    List<Loops> getByTypeLoop(TypeLoop tLoop);

}
