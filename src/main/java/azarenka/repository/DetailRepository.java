package azarenka.repository;

import azarenka.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail getById(Long id);

    @Modifying
    @Query("delete from Detail where id = :id")
    void deleteById(Long id);

    List<Detail> getAllByModule_Id( Long id);

    Detail save(Detail detail);
}
