package azarenka.repository;

import azarenka.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail getById(Long id);

    void deleteById(Long id);
}
