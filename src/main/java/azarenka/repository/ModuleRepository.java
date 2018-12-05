package azarenka.repository;

import azarenka.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
     Module getById (Long id);

     Module save(Module module);

     List<Module> getAllByOrder_Id(Long id);
}
