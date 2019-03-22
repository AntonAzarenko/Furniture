package azarenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoopParamsRepository extends JpaRepository<LoopParams, Long> {

    LoopParams getById(long id);
}
