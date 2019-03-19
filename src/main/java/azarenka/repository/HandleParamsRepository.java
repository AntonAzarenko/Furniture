package azarenka.repository;

import azarenka.entity.fitting.params.HandleParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandleParamsRepository extends JpaRepository<HandleParams, Long> {

    List<HandleParams> getByHandle_Id(long id);

    HandleParams getById(Long id);
}
