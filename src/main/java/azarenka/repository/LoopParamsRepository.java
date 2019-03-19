package azarenka.repository;

import azarenka.entity.fitting.params.LoopParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoopParamsRepository extends JpaRepository<LoopParams, Long> {
}
