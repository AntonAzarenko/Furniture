package azarenka.repository.mybatis;

import java.util.List;

import azarenka.entity.DetailsColor;

public interface ColorDetailMapper extends CrudRepository<Long, DetailsColor>{

   List<DetailsColor> getAll();
}
