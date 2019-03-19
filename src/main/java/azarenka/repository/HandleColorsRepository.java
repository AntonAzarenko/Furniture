package azarenka.repository;

import azarenka.entity.fitting.params.HandleColors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandleColorsRepository extends JpaRepository<HandleColors, Long> {

    List<HandleColors> getByHandle_Id(Long id);

    HandleColors getById(Long id);
}
