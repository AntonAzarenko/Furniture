package azarenka.repository.mybatis;

import azarenka.entity.ColorDetail;

import java.util.List;

public interface ColorDetailMapper extends CrudRepository<Long, ColorDetail>{
   List<ColorDetail> getAll();
}
