package azarenka.repository;

import azarenka.entity.fitting.oforder.HandleOfOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleOfOrderRepository extends JpaRepository<HandleOfOrder, Long> {

    HandleOfOrder getById(Long id);
}
