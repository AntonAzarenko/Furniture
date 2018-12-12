package azarenka.repository.mybatis;

import azarenka.entity.DetailsColor;

import java.util.List;

public interface ColorDetailMapper extends CrudRepository<Long, DetailsColor>{
   List<DetailsColor> getAll();
}
