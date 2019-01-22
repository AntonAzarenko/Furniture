package azarenka.repository;

import azarenka.entity.EdgeMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EdgeMaterialRepository extends JpaRepository<EdgeMaterial, Long> {

    void deleteById(Long id);

    EdgeMaterial getById(Long id);

    //Set<EdgeMaterial> getAllByDetail_Id(Long id);
}
