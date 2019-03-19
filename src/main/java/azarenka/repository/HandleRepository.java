package azarenka.repository;

import azarenka.entity.fitting.Handle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleRepository extends JpaRepository<Handle, Long> {

    Handle getByArticle(String id);

    Handle getById(Long id);
}
