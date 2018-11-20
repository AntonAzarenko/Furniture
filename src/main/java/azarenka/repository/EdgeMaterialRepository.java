package azarenka.repository;

import azarenka.entity.EdgeMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeMaterialRepository extends JpaRepository<EdgeMaterial, Long>{

    void deleteById(Long id);

    EdgeMaterial getById(long id);
}
