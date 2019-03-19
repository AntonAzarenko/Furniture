package azarenka.repository;

import azarenka.entity.Country;
import azarenka.entity.fitting.Loops;
import azarenka.entity.fitting.TypeLoop;
import azarenka.repository.mybatis.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface LoopRepository extends JpaRepository<Loops, Long> {

    Loops save(Loops loops);
}
