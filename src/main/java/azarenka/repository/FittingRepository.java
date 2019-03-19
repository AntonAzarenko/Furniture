package azarenka.repository;

import azarenka.entity.Fittings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FittingRepository extends JpaRepository<Fittings, Long> {

    Fittings save(Fittings fittings);

    List<Fittings> getAllByModule_Id(Long id);
}
