package azarenka.repository;

import azarenka.entity.Country;
import azarenka.entity.furnitures.Loops;
import azarenka.entity.furnitures.TypeLoop;

import java.util.List;

public interface LoopRepository extends CrudRepository<String, Loops> {
    List<Loops> getByNameManufature(String name);

    List<Loops> getByManufatureCountry(Country country);

    List<Loops> getByAngle(String angle);

    List<Loops> getByTypeLoop(TypeLoop tLoop);

}
