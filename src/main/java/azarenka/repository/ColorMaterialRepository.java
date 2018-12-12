package azarenka.repository;

import azarenka.entity.DetailsColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorMaterialRepository  extends JpaRepository<DetailsColor, Long> {

    DetailsColor getById(Long id);

    @Modifying
    @Query("delete from DetailsColor where id = :id")
    void delete (Long id);
}
