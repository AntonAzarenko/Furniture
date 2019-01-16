package azarenka.repository;

import azarenka.entity.Country;
import azarenka.entity.furnitures.Loops;
import azarenka.entity.furnitures.TypeLoop;
import azarenka.repository.mybatis.CrudRepository;

import java.util.List;

public interface LoopRepository extends CrudRepository<String, Loops> {

    List<Loops> getByNameManufacture(String name);

    List<Loops> getByManufactureCountry(Country country);

    List<Loops> getByAngle(String angle);

    List<Loops> getByTypeLoop(TypeLoop tLoop);

}
