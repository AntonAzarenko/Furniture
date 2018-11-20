package azarenka.repository;

import azarenka.entity.ColorDetail;
import azarenka.exceptions.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorMaterialRepository  extends JpaRepository<ColorDetail, Long> {

    ColorDetail getById(Long id);

    @Modifying
    @Query("delete from ColorDetail where id = :id")
    void delete (Long id);
}
